package chapter13;

import java.util.List;
import java.util.concurrent.*;

public class ConcurrencyApiClass {
    public static void main(String[] args) throws Exception {
        Runnable printInventory =
                () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++)
                System.out.println("Printing record: " + i);
        };
        Runnable returnTen = () -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Returning temp");
        };

        try (ExecutorService service =
                     Executors.newSingleThreadExecutor()) {
            System.out.println("begin");
            service.execute(printInventory);
            service.execute(printRecords);
            service.execute(printInventory);
            service.submit(printRecords);
            Future<?> submit = service.submit(returnTen);
            Object o = submit.get(130, TimeUnit.MILLISECONDS);
            System.out.println("submit.get() = " + o);
            System.out.println("end");
        }
        try (ExecutorService ex = Executors.newVirtualThreadPerTaskExecutor()){

            List<Callable<Integer>> tasks = List.of(
                    () -> {
                        Thread.sleep(200);
                        return 1;
                    },
                    () -> {
                        Thread.sleep(100);
                        return 2;
                    },
                    () -> {
                        Thread.sleep(150);
                        return 3;
                    }
            );

            List<Future<Integer>> futures = ex.invokeAll(tasks); // espera todas
            Integer future = ex.invokeAny(tasks); // espera todas
            System.out.println("invokeAny = " + future); //pega o resultado da primeira task que terminar

            for (Future<Integer> f : futures) {
                System.out.println(f.get()); // 1,2,3 (ordem das tasks)
            }
        } finally {
            System.out.println("finally block");
        }
    }
}class FutureIsDoneRunnable {
    public static void main(String[] args) throws Exception {
        ExecutorService ex = Executors.newVirtualThreadPerTaskExecutor();

        Future<?> f = ex.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Terminou o trabalho");
            } catch (InterruptedException e) {
                System.out.println("Fui interrompida (cancelada)");

                Thread.currentThread().interrupt();
            }
        });

        System.out.println("Logo após submit: done=" + f.isDone() + " cancelled=" + f.isCancelled());

        Thread.sleep(200);
        System.out.println("200ms depois: done=" + f.isDone() + " cancelled=" + f.isCancelled());

        // Cancela (true = tenta interromper a thread)
        List<Runnable> runnables = ex.shutdownNow();//interrompe as threads ativas, nao permite novas execucoes  usa o Thread.interrupt() para interromper as threads ativas
        System.out.println(runnables);
        boolean cancelou = f.cancel(true);
        System.out.println("cancel() retornou: " + cancelou);

        System.out.println("Após cancelar: done=" + f.isDone() + " cancelled=" + f.isCancelled());

        ex.shutdown(); //nao entram novas execucoes, permite terminar as atuais
        ex.close(); //interrompe as threads ativas, nao permite novas execucoes  usa o Thread.interrupt() para interromper as threads ativas
    }
}
class ExecutorShutdownNow {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            try {
                Thread.sleep(5000); // simula trabalho longo
                System.out.println("Tarefa longa finalizada."); // pode ser interrompida
            } catch (InterruptedException e) {
                System.out.println("Tarefa longa foi interrompida.");
                Thread.currentThread().interrupt();
            }
        });

        executor.submit(() -> System.out.println("Tarefa curta concluída."));

        List<Runnable> pendentes = executor.shutdownNow(); // tenta interromper tudo
        System.out.println("Tarefas não iniciadas: " + pendentes.size());
        System.out.println("ShutdownNow chamado.");
    }
}
class ScheduledExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        // 1. Tarefa com atraso (uma execução, depois de 3 segundos)
        scheduler.schedule(() -> System.out.println("Tarefa única com atraso!"), 3, TimeUnit.SECONDS);

        // 2. Tarefa repetitiva com intervalo fixo (a cada 5 segundos)
        scheduler.scheduleAtFixedRate(() -> System.out.println("Intervalo fixo!"), 1, 5, TimeUnit.SECONDS);

        // 3. Tarefa repetitiva com atraso fixo após cada execução
        scheduler.scheduleWithFixedDelay(() -> System.out.println("Atraso após execução anterior!"), 2, 4, TimeUnit.SECONDS);

        // Deixe rodar por 15 segundos
        Thread.sleep(15000);

        // Encerrar o executor
        scheduler.shutdown();
        if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Forçando parada do executor!");
            scheduler.shutdownNow();
        }

        System.out.println("Executor encerrado.");
    }
}