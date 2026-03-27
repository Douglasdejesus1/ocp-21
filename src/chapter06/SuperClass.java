package chapter06;

public class SuperClass {
}

class Insect {
    protected int numberOfLegs = 4;
    String label = "buggy";
}

class Beetle extends Insect {
    protected int numberOfLegs = 6;
    short age = 3;
    String label = "buggys";

    public void printData() {
        System.out.println(this.label);
        System.out.println(super.label);
        System.out.println(this.age);
        // System.out.println(super.age);
        System.out.println(numberOfLegs);
    }

    public static void main(String[] n) {
        new Beetle().printData();
    }
}

class Veicule {
    public Veicule(String color) {
        System.out.println("Veicule constructor");
        System.out.println(color);
    }

    int years = 5;

    static {
        System.out.println("Veicule static block");
    }
}

class Car extends Veicule {

    int years = 10;

    public Car() {
        this(5);
        System.out.println("Car constructor");

    }

    public Car(int a) {
        super("Red");
        System.out.println("Car constructor" + a);

    }

    public Car(int a, int b) {
        super("Red");
        System.out.println("Car constructor" + a);

    }

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.years);
        // para imprimir os years da classe Veicule a partir da instância,
        // devemos acessar o campo através de uma referência com tipo da superclasse
        System.out.println(((Veicule) car).years);

    }
}

class Animal {
     static {
        System.out.print("A");
    }
}

class Hippo extends Animal {
    public static void main(String[] grass) {
        System.out.print("C");
        new Hippo();
        new Hippo();
        new Hippo();
    }

     static {
        System.out.print("B");
    }
}
class HippoFriend {
    public static void main(String[] grass) {
        System.out.print("C");
        new Hippo();
        new Hippo();
    }
}
