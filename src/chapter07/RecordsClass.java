package chapter07;

public class RecordsClass {
}

interface Super {

}

record Person(String name, int age) implements Super {
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    public Person() {
        this("Douglas", 35);
    }

    public static void main(String[] args) {
        var person1 = new Person("Alice", 30);
        var person2 = new Person("Alice", 30);
        var person3 = new Person("Alice", 30);
        //person1.age=20;
        System.out.println(person1.name()); // Output: Alice
        System.out.println(person1.age());  // Output: 30
        System.out.println(person1);
        System.out.println(person1.equals(person2)); // Output: true

        // This will throw an IllegalArgumentException
        // Person person2 = new Person("Bob", -5);
    }
}

record WithStatic(String name, int count) {
    static int totalCount;

    public WithStatic(String name) {
        this(name, totalCount++);
    }

}

class MyClassWithStatic {
    public static void main(String[] args) {
        var withStatic1 = new WithStatic("First");
        var withStatic2 = new WithStatic("Second");
        var withStatic3 = new WithStatic("Third");

        System.out.println(withStatic1); // Output: WithStatic[name=First, count=0]
        System.out.println(withStatic2); // Output: WithStatic[name=Second, count=1]
        System.out.println(withStatic3); // Output: WithStatic[name=Third, count=2]
    }
}

class RecordWithPatherMAtchers {
    public static void main(String[] args) {
        Object myRecord;
        if (false) {
            myRecord = new WithStatic("Example", 10);
        } else {
            myRecord = new Person("Example", 10);
        }

        if (myRecord instanceof WithStatic(String name, int count)) {
            System.out.println("Name: " + name);
            System.out.println("Count: " + count);

        } else {
            System.out.println("Not a WithStatic record");
        }

    }
}

record Snake(
        Object data) {


    long showData(Snake snake) {
        return switch (snake) {
            case Snake(Long hiss) -> hiss + 2;
            case Snake(Integer nagina) -> nagina + 10;
            case Snake(Number crowley) -> crowley.intValue() + 100;
            case Snake(Object kaa) -> -1;

        };
    }

    static void main() {

        var s = new Snake(123L);
        var s1 = new Snake("car");
        var s2 = new Snake(123);
        var s3 = new Snake(123);
        System.out.println(s.showData(s));  // Output: 125
        System.out.println(s.showData(s1));  // Output: 125
        System.out.println(s.showData(s2));  // Output: 125
        System.out.println(s.showData(s3));  // Output: 125
    }
}