package chapter10;

import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        //creating
        Optional<String> optional = Optional.of("Hello");
        Optional<? super Integer> optionalEmpty = Optional.empty();
        Optional<Object> optionalNull = Optional.ofNullable(null);
        System.out.println(optionalNull.isEmpty());
        //metodos de instancia
        System.out.println(optional.get());
        optional.ifPresent(System.out::println);
        System.out.println(optional.isEmpty());
        System.out.println(optional.orElse("Default"));
        Integer int1 = (Integer) optionalEmpty
                .orElse(Integer.valueOf("10"));
      /*  try{
            optionalEmpty.orElseThrow(() -> new RuntimeException("Valor não encontrado"));
        } catch(RuntimeException e){
            e.printStackTrace();
            optionalEmpty.orElseThrow();
        }*/
        optional
                .map(s -> s.length())
                .map(i ->i*100)
                .ifPresent(System.out::println);


    }

}
