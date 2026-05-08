package chapter09.generics;

import java.util.ArrayList;
import java.util.List;

public class UpperBound {
    public static void main(String[] args) {
        List<? extends Number> list = new ArrayList<>();
        //list.add(1);

        var listNumber = new ArrayList<Number>();
        listNumber.add(1);
        listNumber.add(1.0);
        listNumber.add(1.0f);
        listNumber.add(1L);
        print(listNumber);

        var listInt = new ArrayList<Integer>();
        listInt.add(1);
        listInt.add(2);
        listInt.add(3);
        //listInt.add(3.0);
        print(listInt);
        var listObject2 = new ArrayList<Object>();
        listObject2.add("java");
        listObject2.add(1);
        //print(listObject2);
    }

    static void print(List<? extends Number> list) {
        for (var o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
