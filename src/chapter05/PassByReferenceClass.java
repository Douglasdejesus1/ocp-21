package chapter05;

public class PassByReferenceClass {
    public static void main(String[] args) {
        int i = 5;
        Integer i2 = 10;
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Before modification: " + i);
        modifyInt(i);
        System.out.println("After modification: " + i);
        System.out.println("Before modification: " + java.util.Arrays.toString(arr));
        modifyArray(arr);
        System.out.println("After modification: " + java.util.Arrays.toString(arr));
        System.out.println("Before modification: " + i2);
        modifyInteger(i2);
        System.out.println("After modification: " + i2);

    }
    static void modifyArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 10;
        }
    }
    static void modifyInt(int num) {
        num += 10;
    }
    static void modifyInteger(Integer num) {
        num.doubleValue(); // Integer é imutável, então não podemos modificar seu valor diretamente
    }
}

