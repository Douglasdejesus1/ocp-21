package chapter13;

public class CyclicBarrierClass {
    public static void main(String[] args) {
            var barrier = new java.util.concurrent.CyclicBarrier(3, () -> System.out.println("Todos chegaram!"));
            for (int i = 0; i < 3; i++) {
                final int id = i;
                new Thread(() -> {
                    try {
                        System.out.println("Thread " + id + " chegou.");
                        barrier.await(); // Espera as outras threads chegarem
                        System.out.println("Thread " + id + " passou o barrier.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
    }
}
