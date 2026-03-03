package chapter04;

import java.util.ArrayList;

public class StringMethods {
}
class Length{
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(s.length());

        String array[] = {"Hello", "World"};
        System.out.println(array.length);

        ArrayList<String> list = new ArrayList<>();
        list.size();

    }
}
class GetChars{
    public static void main(String[] args) {
        String s = "Hello World";
       // System.out.println(s.charAt(0));

        //CodePoint
        //foi introduzido no java 5 para lidar com
        // caracteres Unicode que podem ser representados por mais de um char
        // (surrogate pairs).
        String unicodeString = "𐍈Weâ€™re";
        //imprime o código Unicode do primeiro caractere (𐍈)
        // que é representado por um surrogate pair
        System.out.println("CharAt: "+unicodeString.charAt(0));
        System.out.println("CodePontAt: " + unicodeString.codePointAt(0));
        //imprime o código Unicode do caractere anterior ao primeiro caractere ()
        System.out.println(unicodeString.codePointBefore(1));
        //imprime o número de caracteres
        System.out.println(unicodeString.codePointCount(0,1));

    }
}
class Substring{
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(s.substring(0,5));
        System.out.println(s.substring(6));
    }
}
class FindingIndex{
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(s.indexOf("o"));
        System.out.println(s.lastIndexOf("o"));
        System.out.println(s.indexOf("o",5));
        System.out.println(s.indexOf("o",5,10));
    }
}
class AjustingCase{
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
    }
}
class CheckingEquality{
    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = "Hello World";
        String s3 = new String("Hello WorlD");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equalsIgnoreCase(s3));
        System.out.println(s1==s2);
        System.out.println(s1==s3);
    }
}
class SearchingForSubstrings{
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(s.contains("World"));
        //toffset é o índice a partir do qual a busca deve começar
        System.out.println(s.startsWith("Hello",1));
        System.out.println(s.endsWith("World"));
    }
}
class ReplacingCharacters{
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(s.replace('o','x'));
        System.out.println(s.replace("World","Java"));
    }
}
class RemovingWhitespace{
    public static void main(String[] args) {
        String s = "   Hello World   ";
        System.out.println(s.trim());
        //a diferença entre trim() e strip() é que trim() remove apenas os caracteres de espaço em branco (U+0020) do início e do fim da string,
        // enquanto strip() remove todos os caracteres de espaço em branco Unicode, incluindo espaços, tabulações,
        // quebras de linha e outros caracteres de espaço em branco.
        System.out.println(s.strip());
        System.out.println(s.stripLeading());
        System.out.println(s.stripTrailing());
    }
}
class BlockingIdentation{
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(s.indent(4));
        System.out.println(s.indent(-4));
        //stripIndent() remove a indentação adicionada por indent() e
        // retorna a string original sem as quebras de linha e os espaços em branco adicionais.
        System.out.println(s.stripIndent());
    }
}
class CheckingEmptyOrBlank{
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "   ";
        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
        System.out.println(s1.isBlank());
        System.out.println(s2.isBlank());
    }
}
class FormattingStrings{
    public static void main(String[] args) {
        String name = "John";
        int age = 30;
        String formattedString = String.format("My name is %s and I am %d years old.", name, age);
        System.out.println(formattedString);
    }
}