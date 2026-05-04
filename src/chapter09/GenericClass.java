package chapter09;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenericClass {
}

class Crate<T> {
    private T contents;

    public T lookInCrate() {
        return contents;
    }

    public void packContents(T contents) {
        this.contents = contents;
    }
}

class CrateObject {
    private Object contents;

    public Object lookInCrate() {
        return contents;
    }

    public void packContents(Object contents) {
        this.contents = contents;
    }
}

class Zebra {
    public String name;

    public Zebra(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}

class Elephant {
    String name;

    Elephant(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public static void main(String[] args) {
        Elephant elephant = new Elephant("Alfredo");

        Crate<Elephant> elephantCrate = new Crate<>();
        elephantCrate.packContents(elephant);
        Elephant inNewHome = elephantCrate.lookInCrate();
        System.out.println(inNewHome);

        CrateObject elephantCrateObj = new CrateObject();
        elephantCrateObj.packContents(elephant);
        Elephant inNewHomeObj = (Elephant) elephantCrateObj.lookInCrate();
        System.out.println(inNewHomeObj);

    }
}

class GenericOverload {
    void print(List<CharSequence> list) {

    }
}

class Test extends GenericOverload {


    void print(ArrayList<CharSequence> list) {
    }
    // void print(List<Character> list){}
    // void print(List<String> list){}
    void print(Map<CharSequence, Long> list) {
    }
    <T> T first(List<? extends T> list) {
        return list.get(0);
    }
     Object second(List<?> list) {
        return list.get(1);
    }
   /* <B> B getValue(List<B> list) {
        return new B();  // retorna A (supertipo concreto)
    }*/
    /*Object third(List<> list) {
        return list.get(1);
    }*/

    List<String> list = new ArrayList<String>();
    //List<> list2 = new ArrayList<String>();
    List list2 = new ArrayList<String>();
    //List<CharSequence> list3 = new ArrayList<String>();
    //List<String> list3 = new ArrayList<CharSequence>();

    List<? extends Number> listExtends = new ArrayList<Integer>();
    List<? super Number> listSuper = new ArrayList<Object>();
}

interface Shippable<T> {
    void ship(T t);
}

class Robot {

}

class ShippableAbstractCrate<U> implements Shippable<U> {
    @Override
    public void ship(U robot) {
        System.out.println("Shipping robot: " + robot);
    }
}

class ShippableRobotCrate implements Shippable<Robot> {
    @Override
    public void ship(Robot robot) {
        System.out.println("Shipping robot: " + robot);
    }
}

class Handler<T> {
    //T independente
    public static <T> void prepare(T t) {
        System.out.println("Preparing " + t);
    }

    public static <T> Crate
            <T> ship(T t) {
        System.out.println("Shipping " + t);
        return new Crate
                <T>();
    }

    public static void main(String[] args) {
        Handler<Robot> handler = new Handler<>();
        handler.prepare("new Robot()");
    }
}

record CrateRecord<T>(T contents) {
    public T lookInCrate() {
        if (contents == null) {
            throw new IllegalStateException("Crate is empty");
        }
        return contents;
    }
}


