package chapter09.generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class SuperBound {
    public static void main(String[] args) {
        SuperBound superBound = new SuperBound();
        //Significa: "A lista contém Number ou qualquer supertipo de Number"
        List<? super Number> list = new ArrayList<>();
        List<? super Number> listObject = new ArrayList<Object>();
        //listObject.add(new Object());
        List<? super Number> listNumber = new ArrayList<Number>();
        //? super number significa quea lista pode ser de Number
        // ou de qualquer supertipo de Number, como Object
        // o compilador sabe que no pior das hipóteses, é List<Number>
        listNumber.add(1);
        listNumber.add(1.0);
        listNumber.add(1.0f);
        listNumber.add(1L);
        print(listNumber);

        var listObject2 = new ArrayList<Object>();
        listObject2.add("java");
        listObject2.add(1);
        print(listObject2);

        var listObject3 = new ArrayList<Exception>();
        //print(listObject3);


        List<? super IOException> exceptions = new ArrayList<Exception>();
        //exceptions.add(new Exception()); //tem que se io ou filha dela
        exceptions.add(new IOException()); //oi
        exceptions.add(new FileNotFoundException()); //filha de io
    }

    static void print(List<? super Number> list) {
        for (var o : list) {
            System.out.print(o + " ");
        }
    }

    /*static void printT(List<T super Number> list) {
        for (var o : list) {
            System.out.print(o + " ");
        }
    }*/
}
