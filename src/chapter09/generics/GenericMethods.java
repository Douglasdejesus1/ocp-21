package chapter09.generics;

import java.util.List;

public class GenericMethods {
}
class Hadler{
    <T> void prepere(T t){
        System.out.println("Prepere " + t);
    }
     Object devolveObject(Object o){
        System.out.println("Prepere " + o);
        return o;
    }
    <T> T devolveT(T t){
        System.out.println("Prepere " + t);
        return t;
    }
    <T extends  Number> T devolveTExtends(T t){
        System.out.println("Prepere " + t);
        return t;
    }
    /*<T super  Number> T devolveTSuper(T t){
        System.out.println("Prepere " + t);
        return t;
    }*/
    static <T> void postpere(T t){
        System.out.println("Postpere " + t);
    }
}
class Tester{
    public static void main(String[] args) {
        Hadler h = new Hadler();
        h.prepere("Teste");
        h.prepere(1);
        Object o1 = h.devolveObject("teste");
        Object o2 = h.devolveObject(1);
        Integer i1 = h.devolveT(1);
        Integer i2 = h.<Integer>devolveT(1);
        String s1 = h.devolveT("teste");
        String s2 = h.<String>devolveT("teste");


    }
}

class TrickyCrate<T> {
    public <I> I tricky(I t) {
        return t;
    }
}

class PassingArgs{
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c");
        String s = first(list);
        System.out.println(s);
        List<Integer> ints = List.of(1, 2, 3);
        Integer i = first(ints);
        System.out.println(i);

    }

    static <T>  T first(List<? extends T> list) {
        return list.get(0);
    }
/*static <T> <? extends T> second(List<? extends T> list) {
        return list.get(0);
    }*/

}