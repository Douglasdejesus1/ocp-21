package chapter10;

import java.io.IOException;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedConcepts {
    public static void main(String[] args) throws IOException {
        //checked exceptions em functional interfaces nao podem ser declaradas
        //Supplier<List<String>> s = ExceptionCaseStudy::create;
        //long count = ExceptionCaseStudy.create().stream().count();

        //collect
        List<String> collect = Stream.of("Java", "Python", "C++").toList();
        //collect.add("JavaScript");//UnsupportedOperationException
        Set<String> collectSet = Stream.of("Java", "Python", "C++").collect(Collectors.toSet());
        Double collectAvarege = Stream.of("Java", "Python", "C++").collect(Collectors.averagingDouble(String::length));
        System.out.println(collectAvarege);

        var ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.
                collect(Collectors.
                        joining(", "));
        System.out.println(result);

        //groupingBy
        var lions = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map = lions.collect(
                Collectors.groupingBy(String::length));
        System.out.println(map);

        //partitioningBy
        var partition = Stream.of("lions", "tigers", "bears");
        Map<Boolean,
                List<String>> mapPart = partition.collect(
                Collectors.
                        partitioningBy(
                                s -> s.length() <= 5));
        System.out.println(mapPart);

        //Spliterator
        var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-", "monkey-", "turtle-");

        Spliterator<String> originalBagOfFood = stream.spliterator();
        Spliterator<String> emmasBag = originalBagOfFood.trySplit();
        emmasBag.forEachRemaining(System.out::println);
        Spliterator<String> jillsBag = originalBagOfFood.trySplit();
        jillsBag.tryAdvance(System.out::print);
        jillsBag.forEachRemaining(System.out::print);
        originalBagOfFood.forEachRemaining(System.out::print);

        var originalBag = Stream.iterate(1, n -> ++n)
                .spliterator();
        Spliterator<Integer> newBag = originalBag.trySplit();
        newBag.tryAdvance(System.out::print); // 1
        newBag.tryAdvance(System.out::print); // 2
        newBag.tryAdvance(System.out::print); // 3
        System.out.println(0);
        Exception e;
        Error e1;
    }
}


class ExceptionCaseStudy {
    static List<String> create() throws IOException {
        throw new IOException();
    }
}