package chapter01;

public class ReferenceObjects {
    public static void main(String[] args) {
        Objects obj1 = new Objects("FirstObject", 1);
        Objects obj2 = obj1; // obj2 references the same object as obj1

        System.out.println("obj1 order: " + obj1.order);
        System.out.println("obj2 order: " + obj2.order);

        obj2.order = 10; // Modifying the order through obj2

        System.out.println("After modifying obj2:");
        System.out.println("obj1 order: " + obj1.order); // Reflects change
        System.out.println("obj2 order: " + obj2.order);
    }
}
