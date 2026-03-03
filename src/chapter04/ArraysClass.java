package chapter04;

import java.util.Arrays;
import java.util.Objects;

public class ArraysClass {
    public static void main(String[] args) {
        int[] array = {3, 5, 7, 4, 2};
        int[] arrays = {3, 5, 7, 4, 2};
        int[] arrays2 = array;
        System.out.println(array.equals(arrays));
        System.out.println(array.equals(arrays2));
        System.out.println(Arrays.toString(array));
        // System.out.println(array.toString());
        String[] strings = {"stringValue"};
        Object[] objects = strings;
        // Isso causará um ArrayStoreException em tempo de execução
        //porque estamos tentando armazenar um StringBuilder
        // em um array de Strings
        // o erro nao acontece em tempo de compilação porque o array de Strings
        // é um subtipo do array de Objects
        // objects[0]  = new StringBuilder();
        // System.out.println(objects[0]);

    }

}

class SortArrays {
    public static void main(String[] args) {
        String[] objArray = {"3", "Yo", "5", "car", "7"};
        Arrays.sort(objArray);
        System.out.println(Arrays.toString(objArray));
    }
}

class SearchingArrays {
    public static void main(String[] args) {
        int[] array = {0, 2, 3, 4, 5, 7};
        //Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int index4 = Arrays.binarySearch(array, 4);
        int index5 = Arrays.binarySearch(array, 5);
        int index7 = Arrays.binarySearch(array, 7);
        int index8 = Arrays.binarySearch(array, 8);
        int index6 = Arrays.binarySearch(array, 6);
        int index1 = Arrays.binarySearch(array, 1);
        System.out.println("Index of 4: " + index4);
        System.out.println("Index of 5: " + index5);
        System.out.println("Index of 7: " + index7);
        // O resultado =esperado é -6,
        // é exatamente o valor - (inserção ponto) - 1,
        // onde o ponto de inserção é o índice onde o elemento 8 seria inserido
        // para manter a ordem do array.
        //para ilustrar isso, o elemento 8 seria inserido na posição 5
        // (após o elemento 7),
        // nao é 5 mas sim -6 porque o resultado é negativo para indicar que o elemento nao foi encontrado
        System.out.println("Index of 8: " + index8);
        //Regra: elemento não encontrado → retorna -(índice onde seria inserido) - 1
        System.out.println("Index of 6: " + index6);// -5
        System.out.println("Index of 1: " + index1);
    }
}
class ComparingArrays {
    public static void main(String[] args) {
        int[] array1 = {3, 5, 7, 4, 2};
        int[] array2 = {3, 5, 7, 4, 2};
        int[] array3 = {2, 4, 5, 7, 3};
        int[] array4 = {5, 4, 5, 7, 3};
        System.out.println(Arrays.equals(array1, array2));
        System.out.println(Arrays.equals(array1, array3));
        System.out.println(Arrays.compare(array1, array2));
        System.out.println(Arrays.compare(array1, array3));
        System.out.println(Arrays.compare(array1, array4));
        System.out.println(Arrays.compare(array1, null));
    }
}
class MismatchedArrays {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3};
        int[] intArray2 = {1, 2, 3};
        int[] intArray3 = {1, 2, 4};

        System.out.println(Arrays.mismatch(intArray, intArray2));
        //vai retornar o índice do primeiro elemento diferente,
        // que é o índice 2 (o terceiro elemento)
        System.out.println(Arrays.mismatch(intArray, intArray3));

    }
}
class VarargsArrays {
    public static void main(String[] args) {
        printVarargs(1, 2, 3);
        printVarargs("Hello", "World");
        printVarargs("Hello");
    }
    //os modos de representar os varargs pode ser tanto com os três pontos (...) quanto com um array normal
    public static void printVarargs(int... numbers) {
        System.out.println("Numbers: " + Arrays.toString(numbers));
    }

    public static void printVarargs(String srg, String... strings) {
        System.out.println("Strings: " + Arrays.toString(strings));
    }
}

class ArrasofArrays {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.deepToString(array));
        System.out.println(Arrays.toString(array));
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}