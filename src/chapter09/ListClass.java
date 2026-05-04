package chapter09;

import java.util.*;


public class ListClass {
    public static void main(String[] args) {

        Deque<String> dequeLinkedList = new LinkedList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> asList = Arrays.asList("Hello", "Java");
        asList.set(0, "Hi");
        //asList.add("!"); //UnsupportedOperationException
        //System.out.println(asList);
        List<String> ofList = List.of("Hello", "Java"); //aceita varags
        //ofList.add(0,"Hi");
        List<String> ls = new LinkedList<>();
        List<String> copyOfList = List.copyOf(ofList); //outra colection
        List<String> copyOfList2 = List.copyOf(ls); //outra colection
        System.out.println(copyOfList == ofList); //se nascer de uma lista imutavel compartilha a mesma referencia
        //System.out.println(ls ==  copyOfList2);
        //System.out.println();
        //copyOfList.add(0,"Hi");

        List<String> arrayList = new LinkedList<>();
        arrayList.add("Hello");
        arrayList.add(1, "Java"); //empurra os demais elementors
        arrayList.set(1, "Java"); //substitui o elemento na posição
        System.out.println(arrayList.set(0, "Hi java"));
        arrayList.add("Hello");
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.indexOf("Hell o"));
        System.out.println(arrayList.lastIndexOf("Hello"));
        //System.out.println(arrayList.remove(3)); IndexOutOfBoundsException
        System.out.println("Pos remove: " + arrayList);
        System.out.println(arrayList.remove("Hello"));
        System.out.println("Pos remove: " + arrayList);
        arrayList.replaceAll(s -> s.toLowerCase(Locale.ROOT)); //Unarry operator (T t) return T
        arrayList.sort((s, t) -> s.length() - t.length()); //Comparator (T t, T t) return int
        arrayList.sort(String::compareTo); //Unarry operator (T t) return
        arrayList.sort((s, t) -> t.compareTo(s)); //Unarry operator (T t) return
        System.out.println(arrayList);
        arrayList.add("Hello");
        arrayList.add("Hello");
        arrayList.add("Hello");
        Object[] array = arrayList.toArray();
        String[] stringArray = arrayList.toArray(new String[3]); //com 3 elementos, preenchendo com null ou o necessario
        String[] stringArray0 = arrayList.toArray(new String[0]); //tamanho necessario
        System.out.println(Arrays.toString(stringArray));
        System.out.println(Arrays.toString(stringArray0));

    }
}
