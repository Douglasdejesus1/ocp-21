package chapter03;

public class WhileClass {
    public static void main(String[] args) {
        int count = 0;
        while (count < 5) {
            System.out.println("Count: " + count);
            count++;
        }

        count = 10;
        do {
            System.out.println("Count: " + count);
            count++;
        } while (count < 5);


        while (true) System.out.println("Looping indefinitely. Press Ctrl+C to stop.");

    }
}
