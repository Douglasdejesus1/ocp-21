package chapter09.generics;

import java.util.ArrayList;
import java.util.List;

public class Overloading {
    protected void chew(List<Object> input) {
    }

    // protected void chew(List<Double> input) {}
    protected void chew(ArrayList<Double> input) {
    }
}

class Utils {
    //void process(Number t) { }    // T vira seu upper bound (Number)
    <T extends Number> void process(T t) {
        System.out.println("Number: " + t);
    }

    //void process(String t) { }    // T vira seu upper bound (String)
    <T extends String> void process(T t) {
        System.out.println("String: " + t);
    }

    void process(List<String> list) {
    }

    void process(ArrayList<String> list) {
    }
    //void process(List<String> list) { }

    public static void main(String[] args) {

    }
}
