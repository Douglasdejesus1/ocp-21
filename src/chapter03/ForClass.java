package chapter03;

import chapter01.Objects;

import java.sql.SQLOutput;
import java.util.Map;

public class ForClass {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0, k = 10; i < 3; i++) {
            for (j = 1; j < 3; j++) {
                System.out.println("i: " + i + ", j: " + j + ", k: " + k);
            }
        }
        // System.out.println("Final value of i: "+ i);// Unreachable code, pois a variável i foi declarada dentro do escopo do loop for e não pode ser acessada fora dele.


        for (; ; ) {
            System.out.println("Looping for vazio.");
            j++;
            if (j > 4) {
                break;
                //System.out.println("j: " + j); // Unreachable code, pois o break encerra o loop imediatamente
            }
            if (false) {
                System.out.println("This will never be printed because j will never be greater than 6 due to the previous break statement.");
            }

        }
        for (float i = 0; ++i < 9; ++i) System.out.print(getS((int) i));
        System.out.println();
        for (Integer k = 0; k++ < 9; ++k) System.out.print(getS(k));
    }

    private static String getS(int k) {
        //se começar com k == 1, retorna "i: 1",
        // caso contrário, retorna ", " seguido do valor de k
        return k == 1 ? "i: " + k : ", " + k;
    }

}
class ForEachClass {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};
        for (Object name : names) {
            System.out.println(name);
        }

        String nome = "Alice";
        for (char charValue : nome.toCharArray()) {
            System.out.print(charValue==nome.charAt(0) ? charValue : ", " + charValue);
        }
        System.out.println();

        int[] numeros = {1, 2, 3};
        for (Object numero : numeros) {
            System.out.println(numero);
        }
        Map<String, Integer> map = Map.of("Alice", 30, "Bob", 25, "Charlie", 35);
      /*  for (Map<String, Integer> entry : map) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
