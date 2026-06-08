package chapter13;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadSafeClass {
    private int sheepCount = 0;
    Set<Integer> set = new HashSet<>();

    // private void incrementAndReport() {
    private synchronized void incrementAndReport() {

        ++sheepCount;
        boolean add = set.add(sheepCount);
        if (!add)
            System.out.println("Valor repetido: " + sheepCount);
    }

    public static void main(String[] args) {
        try (var service = Executors.newFixedThreadPool(20)) {
            ThreadSafeClass manager = new ThreadSafeClass();
            for (int i = 0; i < 1000; i++)
                service.submit(manager::incrementAndReport);
        }
    }
}

class SheepManager {
    private AtomicInteger sheepCount = new AtomicInteger(0);
    private AtomicBoolean sheepBoolean = new AtomicBoolean(false);
    private AtomicLong sheepCountLong = new AtomicLong(100L);

    private void incrementAndReport() {
        System.out.print((sheepCount.incrementAndGet()) + " ");
    }

    public static void main(String[] args) {
        try (var service = Executors.newFixedThreadPool(200)) {
            SheepManager manager = new SheepManager();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        }
    }
}

class SemVolatile {
    private boolean stop = false;
    static int count = 0;

    public void runTask() {
        while (!stop) {  // A thread pode "cachear" o valor e rodar para sempre
            count++;
            System.out.println("Thread rodando...");
        }
        System.out.println("Contagem final: " + count);
        System.out.println("Thread parou.");
    }

    public static void main(String[] args) throws InterruptedException {
        SemVolatile exemplo = new SemVolatile();
        new Thread(exemplo::runTask).start();

        Thread.sleep(100); // Dá tempo de a outra thread iniciar
        exemplo.stop = true;// Tenta parar (mas pode falhar!)
        System.out.println("Flag de parada setada para true.");
    }
}

class ComVolatile {
    private volatile boolean stop = false;  // Agora é "volátil"
    static int count = 0;

    public void runTask() {
        while (!stop) {  // Agora ela sempre verifica o "caderno oficial"
            count++;
            System.out.println("Thread rodando...");
        }
        System.out.println("Contagem final: " + count);
        System.out.println("Thread parou.");
    }

    public static void main(String[] args) throws InterruptedException {
        ComVolatile exemplo = new ComVolatile();
        new Thread(exemplo::runTask).start();

        Thread.sleep(100); // Dá tempo de a outra thread iniciar
        exemplo.stop = true; // Agora a thread vai parar corretamente
        System.out.println("Flag de parada setada para true.");
    }
}

class SheepManager2 {
    static void dance() {
        synchronized(SheepManager.class) {
            System.out.print("Time to dance!");
        }
    }
    static synchronized void danceS() {
        System.out.print("Time to dance!");
    }

    private int sheepCount = 0;

    private void incrementAndReport() {
        System.out.print((++sheepCount) + " ");
    }

    public static void main(String[] args) {

        try (var service = Executors.newFixedThreadPool(20)) {
            var manager = new SheepManager2();
            //synchronized block
            synchronized (manager) {
                for (int i = 0; i < 100; i++)
                    service.submit(manager::incrementAndReport);
                // Work to be completed by one thread at a time
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Bird {
    void sing() {
        synchronized (this) {
            System.out.print("La la la!");
        }
    }

    synchronized void singS() {
        System.out.print("La la la!");
    }
}