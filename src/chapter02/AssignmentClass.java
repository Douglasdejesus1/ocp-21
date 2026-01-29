package chapter02;

public class AssignmentClass {
    public static void main(String[] args) {
        int integerVar = 50 + (int) 20.0; // cast necessário em float/double para int
        int intVar2 = (int) 20.0; // cast necessário em float/double para int

        // float floatVar = 20.0(float); // cast a direita nao funciona
        float floatVar = 10.0f + 5.0f;
        /*
        Processo de ajuste (OVERFLOW):
        1. Soma dos valores: 22000 + 15000 = 37000.
        2. 37000 em binário (32 bits): 0000 0000 0000 0000 1001 0000 0110 1000
        3. O tipo short usa apenas os 16 bits menos significativos: 1001 0000 0110 1000
           3.1. Os 16 bits menos significativos são os 16 últimos bits à direita, ou seja, os bits de menor valor numérico.
           Eles determinam o valor armazenado no tipo short, enquanto os bits mais à esquerda (mais significativos) são descartados.
        4. Esse valor, interpretado como short (com sinal), representa -28536.
        Ou seja, o ajuste ocorre porque apenas os 16 bits menos significativos são mantidos,
        e o valor é interpretado como negativo se o bit mais à esquerda for 1.
        */
        short shortVar = (short) (22000 + 15000); // = -28536 devido ao overflow de short
        System.out.println(shortVar);

        /*
        Processo de ajuste (UNDERFLOW):
        1. Subtração dos valores: -32768 - 1 = -32769.
        2. -32769 em binário (32 bits): 1111 1111 1111 1111 0111 1111 1111 1111
        3. O tipo short usa apenas os 16 bits menos significativos: 0111 1111 1111 1111
           3.1. Os 16 bits menos significativos são os 16 últimos bits à direita,
           ou seja, os bits de menor valor numérico.
           Eles determinam o valor armazenado no tipo short, enquanto os bits mais à esquerda
           (mais significativos) são descartados.
        4. Esse valor, interpretado como short (com sinal), representa 32767.
        O processo é idêntico ao do overflow: apenas os 16 bits menos significativos são mantidos,
        independentemente do valor ser maior ou menor que o intervalo do short.
        */
        short underflowVar = (short) (-32768 - 1); // = 32767 devido ao underflow
        System.out.println(underflowVar); // Saída: 32767

        short mouse = 10;
        short hamster = 3;
        short capybara = (short) (mouse * hamster);  // cast necessário em operações aritméticas, porque o resultado é promovido para int


    }
}

class CompoundAssignment {
    public static void main(String[] args) {
        short a = 10;
        short original = a;

       // int b += 5; // not valid syntax
        short b = 10;


        short c = 0;
        c = (short) (c + a);
        c+= a ;
        

        a += 5; // a = 10 + 5 -> 15
        System.out.println("a += 5 -> " + a);

        a = original;
        a -= 3; // a = 10 - 3 -> 7
        System.out.println("a -= 3 -> " + a);

        a = original;
        a *= 4; // a = 10 * 4 -> 40
        System.out.println("a *= 4 -> " + a);

        a = original;
        a /= 2; // a = 10 / 2 -> 5
        a %= 1;
        System.out.println("a /= 2 -> " + a);

        int d =10;
        d %= 3; // d = 10 % 3 -> 1
        System.out.println("d %= 3 -> " + d);

        // exemplo com tipo menor (promotion)
        short s = 10;
        s += 5; // equivalente a s = (short)(s + 5) -> cast implícito no operador composto
        System.out.println("short s após s += 5 -> " + s);
        // se fosse: s = s + 5; seria necessário cast: s = (short)(s + 5);
    }
}
class ModulusClass {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        int c = a % b; // c recebe o resto da divisão de a por b
        System.out.println("Resto da divisão de " + a + " por " + b + " é: " + c);

        int d = 14;
        int e = -4; // exemplo com divisor negativo, resultado deve ser positivo,
        // porque o dividendo é positivo -> 14 = (-4 * -3) + 2
        int f = d % e; // f recebe o resto da divisão de d por e
        System.out.println("Resto da divisão de " + d + " por " + e + " é: " + f);


    }
}

