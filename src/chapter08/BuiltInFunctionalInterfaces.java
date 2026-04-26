package chapter08;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.*;

public  class BuiltInFunctionalInterfaces {
}
//Use Supplier<T> sempre que você precisar fornecer um valor sob demanda, especialmente
// quando a criação é custosa ou você quer reutilizar a lógica múltiplas vezes!
class SupplierClass {

    public  static void main(String[] args) {
        Supplier<ArrayList<String>> supplier = ArrayList::new;
        supplier.get().add("Hello"); // supplier.get() retorna uma nova instância de ArrayList, mas o metodo add() retorna um boolean, não a lista em si.
        ArrayList<String> strings = supplier.get(); // supplier.get() retorna uma nova instância de ArrayList, mas o metodo add() retorna um boolean, não a lista em si. Portanto, isso não compila.
        strings.add("Java");

        System.out.println(supplier.get());
        System.out.println(strings);
        System.out.println(supplier);
    }
}

//Consumer<T> é usada para consumir/processar um valor, geralmente causando
// efeitos colaterais. Ela recebe um argumento e não retorna nada:
class ConsumerClass{
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.print("This is: "+s);
        Consumer<String> consumer1 = s -> System.out.print("This is: ");
        Consumer<String> consumer2 = x -> System.out.println("Consumed: " + x);
        consumer.accept("Hello, World!");
        System.out.println();
        Consumer<String> stringConsumer = consumer1.andThen(consumer2);
        stringConsumer.accept("Hello, Java!");

        var map = new HashMap<String, Integer>();
        BiConsumer<String, Integer> biConsumer = map::put;
        biConsumer.accept("One", 1);
        biConsumer.accept("Two", 2);
        System.out.println(map);
    }
}
//Predicate<T> é usada para testar/validar condições booleanas.
// Ela recebe um argumento e retorna true ou false:
//metodos uteis and, or, negate, isEqual, not
class PredicateClass{
    class Panda{
        int age;
        static void check(Panda panda, Predicate<Panda> pred){
            String result = pred.test(panda) ? "match" : "not match";
            System.out.println(result);
        }
    }


    public static void main(String[] args) {
        Panda p = new PredicateClass().new Panda();
        p.age =1;
        Panda.check(p, panda -> panda.age > 0); // match



        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isEmptyLambida = (String str) -> str.isEmpty();
        System.out.println(isEmpty.test("")); // true
        System.out.println(isEmpty.test("Hello")); // false

        BiPredicate<String, String> startsWith = String::startsWith;
        BiPredicate<String, String> startsWithLambda = (String str, String prefix) -> str.startsWith(prefix);
        System.out.println(startsWith.test("Java", "Ja")); // true
        System.out.println(startsWith.test("Java", "va")); // false
    }
}
//Function<T, R> é usada para transformar/converter um valor de um tipo
// em outro tipo. Ela recebe um argumento do tipo T e
// retorna um resultado do tipo R:
//metodos uteis andThen, compose, identity
class FunctionClass{
    public static void main(String[] args) {
        Function<String, Integer> lengthFunction = String::length;
        Function<String, Integer> lengthFunctionLambda = (String str) -> str.length();
        System.out.println(lengthFunction.apply("Hello")); // 5

        BiFunction<String, String, String> concatFunction = String::concat;
        BiFunction<String, String, String> concatFunctionLambda = (String str1, String str2) -> str1.concat(str2);
        System.out.println(concatFunction.apply("Hello, ", "World!")); // "Hello, World!"


        Function<Integer, Integer> s = a -> a + 4;
        Function<Integer, Integer> t = a -> a * 3;
        //define a função composta c que primeiro aplica t e depois s
        Function<Integer, Integer> c = s.compose(t);
        //aplica a função composta c ao valor 3. Isso primeiro aplica t a 3,
        // resultando em 9, e depois aplica s a 9, resultando em 13
        System.out.print(c.apply(3));

    }
}
//UnaryOperator<T> é um caso especial de Function<T, T> usada para
// transformar um valor do mesmo tipo. Ela recebe um argumento do tipo T
// e retorna um resultado do tipo T
class UnaryOperatorClass{
    public static void main(String[] args) {
        UnaryOperator<Integer> increment = x -> x + 1;
        System.out.println(increment.apply(5)); // 6

        BinaryOperator<String> concat = (s1, s2) -> s1 + s2;
        System.out.println(concat.apply("Hello, ", "World!")); // "Hello,

        BinaryOperator<Integer> f = (x,y) -> x*x;
        System.out.println(f.apply(3, 4)); // 12
    }
}