package chapter01;

public class TextBlocks {
    public static void main(String[] args) {
        String json = """
                {
                    "name": "John Doe",
                    "age": 30,
                    "city": "New York"
                }
                """;

        System.out.println("JSON Text Block:");
        System.out.println(json);

        String a = "linha1\nlinha2";
        String b = """
                linha1
                linha2
                """;
        System.out.println(a.equals(b)); // false (por causa dos espaços à esquerda em b)
        System.out.println(b.length()); // 14, because of the spaces

        String json2 = """
                {
                    \"nome\": \"Maria\"
                }
                """;
        System.out.println("JSON2 Text Block:");
        System.out.println(json2);

        String bloco = """
                A
                B
                """;
        String resultado = bloco + "C";
        System.out.println("Resultado");
        System.out.println(resultado);
    }
}
