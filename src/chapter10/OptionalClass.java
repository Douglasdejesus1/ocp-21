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

        /*
        .map()              // Transforma o valor
        .flatMap()          // Transforma em outro Optional
        .filter()           // Filtra com condição
        .ifPresent()        // Executa se presente
        .ifPresentOrElse()  // Executa se presente OU se vazio
        .orElse()           // Retorna padrão se vazio
        .orElseGet()        // Executa função se vazio
        .orElseThrow()      // Lança exceção se vazio
         */
        optional
                .map(s -> s.length())
                .map(i -> i * 100)
                .filter(j -> j > 10)
                .ifPresent(System.out::println);

    }

}
