package chapter10;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPipeLine {
    public static void main(String[] args) {
        //Create
        Stream<Object> empty = Stream.empty();
        Stream.of(1);
        Stream<Integer> stream = Stream.of(1, 2, 3);

        List<Integer> integers = List.of(1, 2, 3);
        Stream<Integer> stream1 = integers.stream();
        Stream<Integer> streamParallel = integers.parallelStream(); //chapter13

        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> offNumbers = Stream.iterate(1, n -> n + 2); //Stream.iterate(seed, next)
        Stream<Integer> offNumbersMaior = Stream.iterate(1, r -> r < 10, r -> r + 2); //Stream.iterate(seed, predicate, next)
        //System.out.println(randoms.limit(10).toList());
        // System.out.println(offNumbers.limit(10).toList());
        // System.out.println(offNumbersMaior.limit(10).toList());


        //TERMINAL OPERATORS
        // long count = offNumbers.count(); //java.lang.IllegalStateException
        long count2 = Stream.of(1, 2, 3, 4).count();
        // System.out.println(count2);
        Optional<Integer> min = Stream.of(1, 2, 3, 4).min(Integer::compare);
        Optional<Integer> max = Stream.of(1, 2, 3, 4).max(Integer::compare);
        //no primeiro que encontrar
        Optional<Integer> any = Stream.of(1, 2, 3, 4).findAny();
        //System.out.println("========== FINDANY COM OPERAÇÃO CARA ==========");
        for (int i = 0; i < 10; i++) {
            Optional<Integer> any1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                    .parallel()
                    .filter(n -> {
                        // Operação cara para forçar diferentes threads
                        try {
                            Thread.sleep(1);  // 1ms
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return true;
                    })
                    .findAny();
            //    System.out.println("Execução " + (i+1) + ": " + any1);
        }


        //importa a ordem
        Optional<Integer> first = Stream.of(1, 2, 3, 4).findFirst();

        boolean all = Stream.of(1, 2, 3, 4).allMatch(n -> n == 4);
        boolean all2 = Stream.of(1, 2, 3, 4).allMatch(n -> n <= 4);
        // System.out.println("All: " + all + ", All2: " + all2);
        boolean anyM = Stream.of(1, 2, 3, 4).anyMatch(n -> n == 4);
        // System.out.println("Any: " + anyM);
        boolean none = Stream.of(1, 2, 3, 4).noneMatch(n -> n == 5);
        // System.out.println("None: " + none);
        // Stream.of(1,2,3,4).forEach(System.out::println);
        // 1. reduce(BinaryOperator)
        //   Stream.of(1,2,3,4)
        //           .reduce(Integer::sum).ifPresent(System.out::println);
        // 2. reduce(T identity, BinaryOperator)
        Integer reduceIdendity = Stream.of(1, 2, 3, 4)
                .reduce(10, Integer::sum);
        // System.out.println(reduceIdendity);
        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> streamI = Stream.of(3, 5, 6);
        System.out.println(streamI.
                reduce(1, (a, b) -> a * b)); // 9

        // 3. reduce(U identity, BiFunction, BinaryOperator)
        Map<Character, Integer> resultado = Stream.of("gato", "galo", "gasa")
                .parallel()
                .reduce(
                        new HashMap<>(),                    // Identity: começa com map vazio

                        // BiFunction: processa CADA LETRA
                        (mapa, palavra) -> {
                            System.out.println("BiFunction processando: " + palavra);
                            for (char letra : palavra.toCharArray()) {
                                mapa.put(letra, mapa.getOrDefault(letra, 0) + 1);
                            }
                            return mapa;
                        },
                        // BinaryOperator: combina resultados de threads
                        (mapa1, mapa2) -> {
                            System.out.println("🔗 BinaryOperator combinando: " + mapa1 + " + " + mapa2);
                            mapa2.forEach((letra, count) ->
                                    mapa1.put(letra, mapa1.getOrDefault(letra, 0) + count)
                            );
                            return mapa1;
                        }
                );

        System.out.println("Resultado: " + resultado);

        Set<Integer> collect = Stream.of(1, 2, 3, 4).collect(Collectors.toSet());

    }

}

class IntermediateOperators {
    public static void main(String[] args) {
        //filtering
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7);
        stream.filter(n -> n > 5)
                .forEach(System.out::print);

        System.out.println();
        //distinct
        Stream<String> stringStream = Stream.of("duck", "duck", "duck", "goose");
        stringStream.distinct()
                .forEach(System.out::print);
        System.out.println();
        //limit
        stream = Stream.iterate(1, n -> n + 1);
        stream.limit(5)
                .forEach(System.out::print);
        System.out.println();
        //skip
        //pula N primeiros elementos
        stream = Stream.iterate(1, n -> n + 1);
        stream.skip(3).limit(5)
                .forEach(System.out::print);
        System.out.println();

        //map
        stringStream = Stream.of("duck", "duck", "duck", "goose");
        stringStream.map(String::length)
                .forEach(System.out::print);
        System.out.println();

        //flatMap
        stringStream = Stream.of("duck", "duck", "duck", "goose");
        stringStream.flatMap(s -> s.chars().boxed()).map(s ->  s+" ")
                .forEach(System.out::print);
        //concat
        var one = Stream.of("Bonobo");
        var two = Stream.of("Mama Gorilla", "Baby Gorilla");
        Stream.concat(one, two)
                .forEach(System.out::println);
        System.out.println();

        //exemplo2
        // Você tem uma lista de números
        List<Integer> numeros = Arrays.asList(1, 2, 3);

// FlatMap: para cada número, cria uma lista de múltiplos
        List<Integer> resultado = numeros.stream()
                .flatMap(n -> Arrays.stream(new Integer[]{n, n*2, n*3}))
                .collect(Collectors.toList());
        System.out.println(resultado); // [1, 2, 3, 2, 4, 6, 3, 6, 9]

        //sorting
        Stream.of("banana", "apple", "grape")
                .sorted()
                .forEach(System.out::print);
        System.out.println();

        //peek
        var streamPeek = Stream.of("black bear", "brown bear", "grizzly");
        long count = streamPeek.filter(s -> s.startsWith("g"))
                        .peek(System.out::println).count();              // grizzly
        System.out.println(count);                          // 1

    }
}