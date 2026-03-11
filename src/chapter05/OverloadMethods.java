package chapter05;

public class OverloadMethods {
    public static void main(String[] args) {
        //short v =1;
        var value = (short)100; // por default var atribui um int, para usar short tem que ser explicitamente declarado
        Dove dove = new Dove();
        dove.fly(value);
            int[] ints = {1, 2, 3};
            Integer[] integers = {1, 2, 3};
            Dove.walk(ints);
            Dove.walk(integers);
            Dove.walk(10);
            Integer i = 10;
            Dove.walk(i);
    }
}
class Dove {
    public void
    fly(int numMiles) {
        System.out.println("int");
    }

    public void
    fly(short numFeet) {
        System.out.println("short");
    }
    /*public static void walk(int in) {
        System.out.println("int ");
    }*/
    public static void walk(Integer in) {
        System.out.println("Integer");
    }

    public static void walk(int[] ints) {
        System.out.println("int array");
    }

    public static void  walk(Integer[] integers) {
        System.out.println("Integer array");
    }
}