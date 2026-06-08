package chapter13;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParallelStreamClass {
    public static void main(String[] args) {
        var list = java.util.stream.IntStream.range(0, 1000)
                .boxed()
                .toList();

        // Processa os números em paralelo
        int sum = list.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Soma: " + sum);
    }
}
class OperacoesTerminais {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        // ✅ forEach - ORDEM NÃO GARANTIDA
        System.out.println("=== forEach ===");
        numeros.parallelStream()
                .forEach(n -> System.out.print(n + " "));
        // Saída: 3 1 7 5 2 8 4 6 (ordem aleatória)

        // ✅ forEachOrdered - ORDEM GARANTIDA
        System.out.println("\n\n=== forEachOrdered ===");
        numeros.parallelStream()
                .forEachOrdered(n -> System.out.print(n + " "));
        // Saída: 1 2 3 4 5 6 7 8 (ordem garantida, mas mais lento)

        // ✅ collect - Agrupa resultados
        System.out.println("\n\n=== collect ===");
        List<Integer> pares = numeros.parallelStream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(pares); // [2, 4, 6, 8]

        // ✅ reduce - Combina elementos
        System.out.println("\n=== reduce ===");
        int soma = numeros.parallelStream()
                .reduce(0, Integer::sum); // 0 é o acumulador
        System.out.println("Soma: " + soma); // 36

        // ✅ count
        System.out.println("\n=== count ===");
        long count = numeros.parallelStream()
                .filter(n -> n > 3)
                .count();
        System.out.println("Maiores que 3: " + count); // 5

        // ✅ findAny - Qualquer elemento (não garantido qual)
        System.out.println("\n=== findAny ===");
        Optional<Integer> any = numeros.parallelStream()
                .filter(n -> n > 5)
                .findAny();
        System.out.println("findAny: " + any); // Pode ser 6, 7 ou 8

        // ✅ findFirst - Primeiro elemento
        System.out.println("\n=== findFirst ===");
        Optional<Integer> first = numeros.parallelStream()
                .filter(n -> n > 5)
                .findFirst();
        System.out.println("findFirst: " + first); // 6 (sempre)
    }
}