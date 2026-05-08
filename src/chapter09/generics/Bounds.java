package chapter09.generics;

import java.util.*;

public class Bounds {
    public static void main(String[] args) {
        List<?> umbonded = new ArrayList<String>();
        //a.add("1"); nao permite add
        List listRawUse = new ArrayList<>();
        List<String> listDubloString = new ArrayList<String>();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");list.add("3");list.add("4");
        print(list);
        System.out.println();
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);ints.add(3);ints.add(4);
        print(ints);

        }
    static void print(List<?> list) {
        for (var o : list) {
            System.out.print(o + " ");
        }
    }
}
