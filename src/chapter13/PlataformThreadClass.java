package chapter13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class PlataformThreadClass {
    static void waitUp() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int maxPriority = Thread.MAX_PRIORITY;
        var threads = Stream.generate(() ->
                        //Thread.ofPlataform()
                        Thread.ofVirtual()
                                .unstarted(PlataformThreadClass::waitUp))
                .limit(1_000_000)
                .toList();

        threads.forEach(Thread::start);
        for (var t : threads)
            //   t.setPriority(10);
            t.join(); //


    }
}

class ExecutorComPrioridade {
    public static void main(String[] args) {
        ThreadFactory factoryAltaPrioridade = new ThreadFactory() {
            private int n = 1;

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("worker-alta-" + (n++));
                if (n < 50 || n > 100)
                    t.setPriority(Thread.MAX_PRIORITY); // 10
                else
                    t.setPriority((Thread.MIN_PRIORITY));
                t.setDaemon(false); // opcional
                return t;
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(200, factoryAltaPrioridade);

        for (int i = 1; i <= 5000; i++) {
            int taskId = i;
            pool.submit(() -> {
                Thread t = Thread.currentThread();
                System.out.printf("Task %d rodando em %s | prioridade=%d%n",
                        taskId, t.getName(), t.getPriority());

                // simula trabalho
                try {
                    Thread.sleep(300);
                    System.out.printf("Task %d interrompida em %s | prioridade=%d%n",
                            taskId, t.getName(), t.getPriority());
                } catch (InterruptedException e) {
                    System.out.printf("Task %d interrompida em %s | prioridade=%d%n",
                            taskId, t.getName(), t.getPriority());
                    Thread.currentThread().interrupt();
                }
            });
        }

        pool.shutdown();
    }
}

class DeferringClass {
    static void print() {
        System.out.println("Running in " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = Thread.ofVirtual().unstarted(() -> System.out.println("nao running"));
        Thread t = Thread.ofPlatform()
                .unstarted(DeferringClass::print);
        //  t.setName("Virtual Thread");
        t.setDaemon(false);
        System.out.println("Thread criada, mas ainda não iniciada: " + t.getName());
        t.start();
        //  t.join();
        // Thread.sleep(1);
        // System.out.println("fim");
    }
}

class RunVsStart {
    public static void main(String[] args) {
        Thread t1 = new Thread(() ->
                System.out.println("Executando em: " + Thread.currentThread().getName())
        );

        System.out.println("Main é: " + Thread.currentThread().getName());
        t1.setName("Minha thread");
        t1.run();   // NÃO cria thread nova
        t1.run();   // NÃO cria thread nova
        t1.start(); // cria thread nova
        // t1.start(); // cria thread nova
    }
}

class ImprimeEstado {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ignored) {
            }
        }, "trabalhadora");

        System.out.println("Antes do start: " + t.getState()); // NEW
        t.start();
        System.out.println("Logo após start: " + t.getState()); // RUNNABLE/TIMED_WAITING (depende do timing)

        t.join();
        System.out.println("Depois que terminou: " + t.getState()); // TERMINATED
    }
}
class SimpleVirtualExecutor {
    public static void main(String[] args) {
        // Criar Virtual Thread executor
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        // Submeter várias tarefas
        executor.submit(() -> System.out.println("Tarefa 1: Executada em " + Thread.currentThread()));
        executor.submit(() -> System.out.println("Tarefa 2: Executada em " + Thread.currentThread()));

        // Impedir novas submissões e esperar a conclusão
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Forçando interrupção das tarefas.");
                executor.shutdownNow(); // Força
            }
        } catch (InterruptedException e) {
            System.out.println("Thread principal interrompida.");
            executor.shutdownNow(); // Força e limpa
            Thread.currentThread().interrupt();
        }

        System.out.println("Executor finalizado.");
    }
}