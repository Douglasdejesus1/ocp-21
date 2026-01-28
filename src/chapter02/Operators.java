package chapter02;

public class Operators {
    public static void main(String[] args) {
        System.out.println("Operators examples:");
        Precedencie.main(args);
        UnaryOperators.main(args);
        ShiftOperators.main(args);
        ArithmeticRelationalLogical.main(args);
        RelationalLogical.main(args);
        LogicalOperators.main(args);
        TernaryOperator.main(args);
        AssignmentOperators.main(args);
        ArrowOperator.main(args);
    }
}

class Precedencie {
    // Exemplos de precedência de operadores do mais fácil ao mais difícil (nível OCP 21):
    public static void main(String[] args) {
        // 1. Precedência entre multiplicação e adição
        int a = 2 + 3 * 4; // 3*4=12, 2+12=14
        System.out.println("1. 2 + 3 * 4 = " + a); // 14

        // 2. Uso de parênteses para alterar precedência
        int b = (2 + 3) * 4; // 2+3=5, 5*4=20
        System.out.println("2. (2 + 3) * 4 = " + b); // 20

        // 3. Precedência entre incremento e multiplicação
        int c = 2;
        int d = ++c * 3; // ++c=3, 3*3=9
        System.out.println("3. ++c * 3 = " + d); // 9

        // 4. Precedência entre operadores relacionais e lógicos
        boolean e = 2 + 2 == 4 && 3 > 1; // 2+2=4, 4==4=true, 3>1=true, true&&true=true
        System.out.println("4. 2 + 2 == 4 && 3 > 1 = " + e); // true

        // 5. Precedência entre operadores lógicos (&& vs ||)
        boolean f = false || true && false; // true&&false=false, false||false=false
        System.out.println("5. false || true && false = " + f); // false

        // 6. Precedência entre atribuição e operadores aritméticos
        int g = 5;
        g += 2 * 3; // 2*3=6, g+=6 -> g=11
        System.out.println("6. g += 2 * 3 = " + g); // 11

        // 7. Precedência entre operadores bit a bit e lógicos
        boolean h = true | false && false; // false&&false=false, true|false=true
        System.out.println("7. true | false && false = " + h); // true

        // 8. Precedência entre ternário e atribuição
        int i = 10;
        int j = (i > 5) ? 1 : 2 + 3; // i>5=true, resultado=1
        System.out.println("8. (i > 5) ? 1 : 2 + 3 = " + j); // 1

        // 9. Precedência entre operadores de shift e adição
        int k = 1 + 2 << 2; // 1+2=3, 3<<2=12
        System.out.println("9. 1 + 2 << 2 = " + k); // 12

        // 10. Exemplo complexo: mistura de vários operadores
        int m = 1;
        int n = 2;
        int o = 3;
        int resultado = m++ + --n * o >> 1 & 7 | 2;
        // m++=1 (m=2), --n=1, 1*3=3, 1+3=4, 4>>1=2, 2&7=2, 2|2=2
        System.out.println("10. m++ + --n * o >> 1 & 7 | 2 = " + resultado); // 2
    }
}

class UnaryOperators {
    public static void main(String[] args) {
        // O que a OCP 21 cobra sobre operadores unários e pegadinhas:
        // - Uso correto dos operadores: +, -, ++, --, !, ~
        // - Diferença entre pré-incremento (++a) e pós-incremento (a++)
        // - Efeitos colaterais em expressões complexas (ex: a++ + ++a)
        // - Operador ! só pode ser usado com boolean
        // - Operador ~ faz complemento de bits (bitwise NOT) em tipos inteiros
        // - Pegadinha: cuidado com overflow/underflow ao usar ++/-- em limites do tipo
        // - Não é permitido usar ++/-- com tipos boolean
        // - ++/-- não podem ser aplicados a literais ou resultados de expressões
        // - Ordem de avaliação pode afetar o resultado em expressões encadeadas
        // Fique atento a efeitos colaterais, tipos e precedência!

        int a = +10;
        int b = -20;
        boolean c = !true; // logical NOT operator -> Inversão de true para false
        byte d = ~8; // bitwise NOT operator -> Binário de 8:  00001000 -> Inversão: 11110111 -> Representação em complemento de 2: -9

        System.out.println("c :" + c);
        System.out.println("d :" + d);

        //byte em binario vai do 10000000 (-128) até 01111111 (127)
        String binario = "10000000";
        byte valor = (byte) Integer.parseInt(binario, 2);
        System.out.println(valor); // Saída: -9  /*
        //unary operator
        System.out.println("a: " + a++); // post-increment equal to a = a + 1
        System.out.println("a: " + a);
        System.out.println("a: " + ++a); // pre-increment equal to a = a + 1
        System.out.println("a: " + a);
        b--; // post-decrement equal to b = b - 1
        --b; // pre-decrement equal to b = b - 1

    }
}

class ShiftOperators {
    public static void main(String[] args) {
        // O que a OCP 21 cobra sobre operadores de shift (deslocamento) e pegadinhas:
        // - Uso correto dos operadores: << (shift à esquerda), >> (shift à direita aritmético), >>> (shift à direita lógico)
        // - Diferença entre >> e >>>, principalmente com números negativos
        // - Shift em tipos byte, short, int e long: promoção para int antes do shift
        // - Quantidade de bits deslocados: apenas os 5 bits menos significativos são usados para int (0-31), 6 para long (0-63)
        // - Pegadinha: shift em byte/short retorna int, precisa de cast para voltar ao tipo original
        // - Shift à esquerda multiplica por 2, shift à direita divide por 2 (com truncamento)
        // - Shift lógico (>>>) sempre preenche com 0 à esquerda, mesmo para negativos
        // - Shift aritmético (>>) preenche com o bit de sinal
        // - Shift pode causar overflow/underflow silencioso
        // Fique atento a tipos, promoção, quantidade de bits e diferenças entre >> e >>>!

        byte a = 3; // binário: 00000011 (3)
        byte b = -3; // binário: 11111101 (-3 em complemento de dois)

        byte leftShift = (byte) (a << 2); // 00000011 << 2 = 00001100 (12)
        System.out.println("Left Shift: " + leftShift); // Saída: 12
        byte leftShiftNeg = (byte) (b << 2); // 11111101 << 2 = 11110100 (-12)
        System.out.println("Left Shift Negative: " + leftShiftNeg); // Saída: -12

        byte rightShift = (byte) (a >> 1); // 00000011 >> 1 = 00000001 (1)
        System.out.println(a + " right shift 1 = " + rightShift);
        System.out.println("Right Shift: " + rightShift); // Saída: 1
        byte rightShiftNeg = (byte) (b >> 2); // 11111101 >> 2 = 11111111 (-1)
        System.out.println("Right Shift Negative: " + rightShiftNeg); // Saída: -1

        byte unsignedRightShift = (byte) (a >>> 2); // 00000011 >>> 2 = 00000000 (0, pois byte é promovido para int)
        System.out.println("Unsigned Right Shift: " + unsignedRightShift); // Saída: 0
        byte unsignedRightShiftNeg = (byte) (b >>> 2); // 11111101 >>> 2 = 00111111 (63, pois byte é promovido para int)
        System.out.println("Unsigned Right Shift Negative: " + unsignedRightShiftNeg); // Saída: 63

        int x = -8;
        int aritmetico = x >> 2; // Shift à direita aritmético: mantém o sinal (preenche com 1 à esquerda)
        int logico = x >>> 2;    // Shift à direita lógico: preenche com 0 à esquerda
        System.out.println("-8 >> 2 (aritmético): " + aritmetico); // Saída: -2
        System.out.println("-8 >>> 2 (lógico): " + logico); // Saída: 1073741822
        // Explicação:
        // -8 em binário (int, 32 bits): 11111111 11111111 11111111 11111000
        // -8 >> 2: 11111111 11111111 11111111 11111110 (-2)
        // -8 >>> 2: 00111111 11111111 11111111 11111110 (1073741822)

        byte xx = 8; // binário: 00001000
        byte resultadoAritmetico = (byte) (xx >> 2); // Shift à direita aritmético
        byte resultadoLogico = (byte) (xx >>> 2);    // Shift à direita lógico
        System.out.println("8 >> 2 (aritmético): " + resultadoAritmetico); // Saída: 2
        System.out.println("8 >>> 2 (lógico): " + resultadoLogico); // Saída: 2
        // Explicação:
        // 8 em binário (byte, 8 bits): 00001000
        // 8 >> 2: 00000010 (2)
        // 8 >>> 2: 00000010 (2)
    }
}

class ArithmeticRelationalLogical {
    public static void main(String[] args) {
        // O que a OCP 21 cobra sobre operadores aritméticos, relacionais e lógicos e pegadinhas:
        // - Uso correto dos operadores: +, -, *, /, %, >, <, >=, <=, ==, !=, &&, ||, !
        // - Precedência e associatividade dos operadores em expressões complexas
        // - Divisão inteira: cuidado com truncamento de resultados (ex: 5/2 == 2)
        // - Operações com tipos diferentes: pode haver promoção de tipos (ex: int + double)
        // - Comparação de objetos com == versus equals()
        // - Operadores lógicos avaliam curto-circuito (&&, ||)
        // - Pegadinha: cuidado ao comparar valores de referência (ex: Integer == Integer)
        // - Operadores relacionais só funcionam com tipos primitivos (exceto ==, !=)
        // - Não confundir atribuição (=) com comparação (==)
        // - Operadores lógicos só funcionam com boolean
        // Fique atento a precedência, tipos e efeitos colaterais!

        int a = 10;
        int b = 20;
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (b / a));
        System.out.println("Modulus: " + (b % a));
    }
}

class RelationalLogical {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        // Relational Operators
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));

        // Exemplo simples de instanceof
        String texto = "OCP";
        boolean resultado = texto instanceof String;
        System.out.println("texto instanceof String: " + resultado); // true
    }
}

class LogicalOperators {
    // Exemplos de operadores bit a bit e booleanos (&, |, ^) do mais simples ao mais complexo (nível OCP 21):
    public static void main(String[] args) {
        // 1. AND bit a bit simples
        int a = 5; // 0101
        int b = 3; // 0011
        System.out.println("1. 5 & 3 = " + (a & b)); // 0001 = 1

        // 2. OR bit a bit simples
        System.out.println("2. 5 | 3 = " + (a | b)); // 0111 = 7

        // 3. XOR bit a bit simples
        System.out.println("3. 5 ^ 3 = " + (a ^ b)); // 0110 = 6

        // 4. AND booleano
        boolean x = true, y = false;
        System.out.println("4. true & false = " + (x & y)); // false

        // 5. XOR booleano
        System.out.println("5. true ^ false = " + (x ^ y)); // true

        // 6. OR booleano
        System.out.println("6. true | false = " + (x | y)); // true

        // 7. Máscara de bits: checar se o 3º bit está ligado
        int valor = 0b1010; // 10 em decimal, 1010 em binário
        int mascara = 0b1000; // 8 em decimal, 1000 em binário
        boolean terceiroBitLigado = (valor & mascara) != 0;
        System.out.println("7. Terceiro bit ligado? " + terceiroBitLigado); // true

        // 8. Alternar bits com XOR
        int alternado = valor ^ mascara; // alterna o 3º bit
        System.out.println("8. Valor após alternar 3º bit: " + Integer.toBinaryString(alternado)); // 10 -> 2

        // 9. Limpar (zerar) um bit específico
        int limpar = valor & ~mascara; // limpa o 3º bit
        System.out.println("9. Valor após limpar 3º bit: " + Integer.toBinaryString(limpar)); // 10 -> 2

        // 10. Exemplo complexo: múltiplas máscaras e operadores
        int flags = 0b1101_0110; // 214 em decimal
        int mask1 = 0b0000_0010; // 2
        int mask2 = 0b0000_0100; // 4
        boolean cond = ((flags & mask1) != 0) ^ ((flags | mask2) == 0b1101_0110);
        System.out.println("10. Exemplo complexo: " + cond);
        // Explicação: (flags & mask1) != 0 verifica se o segundo bit está ligado
        // (flags | mask2) == 0b1101_0110 verifica se adicionar mask2 não muda flags
        // O resultado é true se apenas uma das condições for verdadeira (XOR)
    }

}

class TernaryOperator {
    public static void main(String[] args) {
        // O que a OCP 21 cobra sobre o operador ternário (?:) e pegadinhas:
        // - Sintaxe correta: condicao ? valorSeVerdadeiro : valorSeFalso
        // - O tipo do resultado deve ser compatível com a variável de destino
        // - Pode ser aninhado, mas cuidado com legibilidade
        // - Pegadinha: ambos os ramos devem ser compatíveis (ex: int e double pode causar cast implícito)
        // - Pode ser usado em expressões, não apenas em atribuições
        // - Não confundir com if-else tradicional
        // - O operador ternário avalia apenas um dos ramos (curto-circuito)
        // - Pode ser usado em inicialização de variáveis final
        // - Atenção a precedência: pode precisar de parênteses em expressões complexas
        // Fique atento a tipos, precedência e legibilidade!

        int a = 10;
        int b = 20;
        int max = (a > b) ? a : b;
        System.out.println("Max: " + max);
    }
}

class AssignmentOperators {

    public static void main(String[] args) {
        // O que a OCP 21 cobra sobre operadores de atribuição e pegadinhas:
        // - Uso correto dos operadores: =, +=, -=, *=, /=, %=
        // - Ordem de avaliação: a = a += 2; (pegadinha: resultado pode ser diferente do esperado)
        // - Compatibilidade de tipos: cuidado ao usar com tipos diferentes (ex: int e double)
        // - Operadores compostos fazem cast automático (ex: short s = 1; s += 1; é válido)
        // - Não confundir atribuição (=) com comparação (==)
        // - Operadores de atribuição podem ser encadeados: a = b = c = 5;
        // - Pegadinha: a += b retorna o novo valor de a, não de b
        // - Atenção a precedência dos operadores em expressões complexas
        // - Não é permitido usar operadores de atribuição com variáveis final
        // - Cuidado com overflow e underflow em tipos primitivos
        // Fique atento a conversões implícitas e efeitos colaterais!

        int a = 10;
        a += 5; // a = a + 5
        System.out.println("a after += 5: " + a);
        a -= 3; // a = a - 3
        System.out.println("a after -= 3: " + a);
        a *= 2; // a = a * 2
        System.out.println("a after *= 2: " + a);
        a /= 4; // a = a / 4
        System.out.println("a after /= 4: " + a);
        a %= 3; // a = a % 3
        System.out.println("a after %= 3: " + a);
    }
}

class ArrowOperator {

    public static void main(String[] args) {
        // O que a OCP 21 cobra sobre o operador -> (lambda):
        // - Sintaxe correta de expressões lambda (parênteses, tipos, corpo)
        // - Diferença entre Runnable r = () -> ... e outras interfaces funcionais
        // - Uso de variáveis locais (devem ser final ou efetivamente final)
        // - Pegadinhas: lambda não pode acessar variáveis locais que mudam após a declaração
        // - Lambda pode ser passado como argumento para métodos que esperam interfaces funcionais
        // - Diferença entre lambda e classes anônimas
        // - Não pode usar break/continue diretamente em lambda fora de loops
        // - Lambda não pode lançar checked exception sem declarar
        // - Lambda pode acessar campos e métodos da classe normalmente
        // - Lambda pode ser usada em streams, coleções, etc.
        // Fique atento a sintaxe, escopo de variáveis e tipos de retorno!

        Runnable r = () -> System.out.println("Hello from a lambda expression!");
        r.run();
    }
}