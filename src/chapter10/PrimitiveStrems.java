package chapter10;

import java.util.IntSummaryStatistics;
import java.util.stream.*;

public class PrimitiveStrems {
    public static void main(String[] args) {
        //creating
        IntStream intStream = IntStream.of(1, 2, 3);
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);
        LongStream longStream = LongStream.of(1L, 2L, 3L);

        //metodos
        //summaryStatistics retorna um objeto com as estatisticas do stream
        //count, min, max, sum
        IntSummaryStatistics intSummaryStatistics = intStream.summaryStatistics();
        intSummaryStatistics.getCount();
        //boxed() --> Transformar DoubleStream em Stream<Double>
        Stream<Double> stream = doubleStream.boxed();
        //avarage
        System.out.println(longStream.average());
        //max
        LongStream.of(1L, 2L, 3L).max();
        //min
        LongStream.of(1L, 2L, 3L).min();
        //range 9 a 11
        LongStream.range(9L, 12L).forEach(System.out::println);
        //rangeClosed 9 a 12
        LongStream.rangeClosed(9L, 12L).forEach(System.out::println);
        //sum
        LongStream.of(1L, 2L, 3L).sum();

        Stream<Double> doubleStream1 = Stream.of(1.0, 2.0, 3.0);
         //mapToInt, mapToDouble, mapToLong
        IntStream intStream1 = doubleStream1.mapToInt(Double::intValue);



    }
}
