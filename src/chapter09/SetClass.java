package chapter09;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetClass {
    public static void main(String[] args) {
        Set<Character> letters = Set.of('c', 'h', 'a', 'p', 't', 'e', 'r');
        Set<Character> copy = Set.copyOf(letters);
        System.out.println(copy);
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        boolean add = numbers.add(1);
        System.out.println(add);

        Set<Integer> numbersLinked = new LinkedHashSet<>();
        numbersLinked.add(1);
        numbersLinked.add(3);
        numbersLinked.add(2);
        numbersLinked.add(0);
        System.out.println(numbersLinked);
        Set<Integer> numbersTree = new TreeSet<>();
        numbersTree.add(1);
        numbersTree.add(3);
        numbersTree.add(2);
        numbersTree.add(0);
        System.out.println(numbersTree);


    }
}
