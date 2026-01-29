package chapter02;

public class CompareClass {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        //equality operators: ==, !=
        System.out.println("a == b: " + (a == b)); // false
        System.out.println("a != b: " + (a != b)); // true

        CompareClass comp1 = new CompareClass();
        CompareClass comp2 = new CompareClass();
        var comp3 = comp1;
        System.out.println("comp1.equals(comp2): " + comp1.equals(comp2)); // false
        System.out.println("comp1.equals(comp3): " + comp1.equals(comp3));
        System.out.println("comp1 == comp2: " + (comp1 == comp2)); // false, different references
        System.out.println("comp1 == comp3: " + (comp1 == comp3)); // true, same reference
        System.out.println("comp2 == comp3: " + (comp2 == comp3)); // false, different references

        //relational operators: ==, !=, >, <, >=, <=
        System.out.println("a > b: " + (a > b));   // false
        System.out.println("a < b: " + (a < b));   // true
        System.out.println("a >= b: " + (a >= b)); // false
        System.out.println("a <= b: " + (a <= b)); // true



    }
}
class InstanceOfCompare extends CompareClass{
    public static void main(String[] args) {
            InstanceOfCompare instance = new InstanceOfCompare();
            CompareClass instance2 = new InstanceOfCompare();
            Number num = 10;
            Number num2 = 10;


            System.out.println("instance instanceof InstanceOfCompare: " + (instance instanceof InstanceOfCompare)); // true
            System.out.println("instance instanceof CompareClass: " + (instance instanceof CompareClass)); // true
            System.out.println("instance2 instanceof CompareClass: " + (instance2 instanceof CompareClass)); // true

        System.out.println("num instanceof Integer: " + (num instanceof Integer)); // true
        System.out.println("num instanceof Double: " + (num instanceof Double)); // false
        System.out.println("num instanceof Object: " + (num instanceof Object)); // true
        System.out.println("num instanceof Number: " + (num instanceof Number)); // ?

    }
}
