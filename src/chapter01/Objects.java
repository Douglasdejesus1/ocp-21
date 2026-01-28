package chapter01;

public class Objects extends ObjectFather {
    // Can be private constructor, can call other constructors with this() ou the constructor of the superclass with super()
    // not can be abstract class, interface or enum, static, final or have return type
    private Objects(int order) {
        super(order);
        System.out.println("Object created");
    }

    public Objects(String name, int order) {
        this(order);
        System.out.println("Object created with name: " + name);
    }
    public static void main(String[] args) {
        // Create an object of the Objects class with new keyword
        Objects obNamed = new Objects("MyObjectWithName",100);
        System.out.println("obNamed order: " + obNamed.order);
        System.out.println("---");
        Objects obWithoutName = new Objects(50);
        System.out.println("obWithoutName order: " + obWithoutName.order);
    }
}
