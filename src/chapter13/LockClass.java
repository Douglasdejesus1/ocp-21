package chapter13;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockClass {
    public static void main(String[] args) {
        var object = new Object();
        synchronized(object) {
// Protected code
        }
// Implementation #2 with a Lock
        var myLock = new ReentrantLock();
        try {
            myLock.lock();
// Protected code
        } finally {
            myLock.unlock();
        }
    }
}

class ContadorComLock {
    public static void main(String[] args)throws InterruptedException {
        var lock = new ContadorComLock();
        lock.incrementar();
        lock.incrementar();
        lock.incrementar();
    }
    private int contador = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void incrementar() throws InterruptedException {
        lock.lock();
        try {
            contador++;
            Thread.sleep(100);
            System.out.println("Contador: " + contador);
        } finally {
            lock.unlock(); // SEMPRE chamar no finally
        }
    }
}
class DemoDeadlock {
    private ReentrantLock lock = new ReentrantLock();

    // ❌ Primeira thread adquire o lock e NÃO libera
    public void threadUm() {
        System.out.println("[Thread 1] Tentando adquirir lock...");
        lock.lock();
        System.out.println("[Thread 1] Lock adquirido!");

        try {
            Thread.sleep(300); // Simula operação
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ❌ ERRO: Esqueceu unlock()
        System.out.println("[Thread 1] Liberando lock... NÃO!");

    }

    // ❌ Segunda thread fica bloqueada esperando o lock
    public void threadDois() {
        System.out.println("[Thread 2] Tentando adquirir lock...");
        try {
            boolean b = lock.tryLock(1, TimeUnit.SECONDS);
            System.out.println("[Thread 2] tryLock retornou: " + b);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock.lock(); // BLOQUEADA AQUI PARA SEMPRE!
        System.out.println("[Thread 2] Lock adquirido!"); // Nunca chega aqui
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        DemoDeadlock demo = new DemoDeadlock();

        Thread t1 = new Thread(demo::threadUm, "T1");
        Thread t2 = new Thread(demo::threadDois, "T2");

        t1.start();
        Thread.sleep(500); // T1 adquire o lock primeiro

        t2.start();
        Thread.sleep(1000);

        System.out.println("\n[Main] T2 está bloqueada esperando o lock...");
        System.out.println("[Main] Programa vai ficar assim para sempre!");

        // O programa nunca termina!
    }
}

class CacheComReadWriteLock {
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private Map<String, String> cache = new HashMap<>();

    // Múltiplas threads podem ler simultaneamente
    public String get(String chave) {
        rwLock.readLock().lock();
        try {
            System.out.println("[" + Thread.currentThread().getName() +
                    "] Lendo: " + chave);
            return cache.get(chave);
        } finally {
            rwLock.readLock().unlock();
        }
    }

    // Apenas uma thread pode escrever (e nenhuma pode ler)
    public void put(String chave, String valor) {
        rwLock.writeLock().lock();
        try {
            System.out.println("[" + Thread.currentThread().getName() +
                    "] Escrevendo: " + chave + " = " + valor);
            cache.put(chave, valor);
            try {
                Thread.sleep(1000); // Simula operação demorada
            } catch (InterruptedException e) {}
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CacheComReadWriteLock cache = new CacheComReadWriteLock();

        // Adiciona valores iniciais
        cache.put("user1", "João");
        cache.put("user2", "Maria");

        System.out.println("\n=== LEITURAS SIMULTÂNEAS ===\n");

        // 5 threads lendo ao mesmo tempo
        Thread[] leitores = new Thread[5];
        for (int i = 0; i < 5; i++) {
            leitores[i] = new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    cache.get("user1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {}
                }
            }, "Leitor-" + i);
            leitores[i].start();
        }

        for (Thread t : leitores) {
            t.join();
        }

        System.out.println("\n=== ESCRITA (EXCLUSIVA) ===\n");

        cache.put("user3", "Pedro");
        cache.put("user4", "Ana");
    }
}