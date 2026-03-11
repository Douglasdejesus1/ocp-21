package chapter05;


import static java.util.Arrays.asList;
//import java.util.List;
import java.util.*;



public class StaticMethod {
    public static void main(String[] args) {
        List<String> list = asList("one", "two");
        staticMethod();
        var sm = new StaticMethod();
        sm.instanceMethod();

    }

    static void staticMethod() {
        System.out.println("This is another static method");
    }

    void instanceMethod() {
        System.out.println("This is an instance method");
    }
}

class StaticInicializer {
    static int staticValue = 10;
    int instanceValue = 20;
    {
        System.out.println("Instance initializer block is called");
        staticValue = 30;
        instanceValue = 30;
    }
    static {
        System.out.println("Static initializer block is called");
        staticValue = 20;
      //  instanceValue = 30; // This will cause a compilation error because instance variables cannot be accessed in static blocks.
    }


    public StaticInicializer(){
        System.out.println("Constructor is called");
        staticValue = 40;
        instanceValue = 40;
    }

    public static void main(String[] args) {
        System.out.println("Static Value: " + staticValue);
        StaticInicializer si = new StaticInicializer();
        System.out.println("Instance Value: " + si.instanceValue);
        System.out.println("Static Value after instance initialization: " + staticValue);
    }
}