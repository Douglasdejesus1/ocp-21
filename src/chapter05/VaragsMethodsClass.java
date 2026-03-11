package chapter05;

public class VaragsMethodsClass {
    public static void main(String[] args) {
        printNumbers(1, 2, 3, 4, 5);
        printNumbers(10, 20);
        printNumbers();
    }
    static void printNumbers(int... numbers) {
        System.out.println("Number of arguments: " + numbers.length);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
