package chapter04;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MathClass {
}

class MinMax {
    public static void main(String[] args) {
        System.out.println(Math.min(10, 20));
        System.out.println(Math.max(10, 20));
    }
}

class Rounding {
    public static void main(String[] args) {
        System.out.println(Math.round(3.5));
        System.out.println(Math.round(3.49));
        System.out.println(Math.round(-3.51));
        System.out.println(Math.round(-3.5));
    }
}

class CeilingAndFloor {
    public static void main(String[] args) {
        System.out.println(Math.ceil(3.5));
        System.out.println(Math.floor(3.5));
    }
}

class MathPow {
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 3));
        System.out.println(Math.pow(5, 2));
    }
}

class MathRandom {
    public static void main(String[] args) {
        System.out.println(Math.random());
        System.out.println(Math.random());
        System.out.println(Math.ceil(Math.random() * 100));
    }
}

class BigIntegerBigDecimal {
    public static void main(String[] args) {

        double amountInCents1 = 64.1 * 100;
        System.out.println(amountInCents1);  //6409.999999999999

        //BigInteger e BigDecimal são classes imutáveis que permitem trabalhar com números inteiros e decimais de precisão arbitrária, respectivamente.
        // Elas são úteis para cálculos que exigem alta precisão ou para lidar com números muito grandes ou muito pequenos que não podem ser representados adequadamente pelos tipos primitivos.
        var bigInt = BigInteger.valueOf(123456789089567890L);
        var bigInt2 = new BigInteger("1233434343456789089567890");
        var bigInt3 = new BigInteger("123456789012345678901234567890");

        var bigDecimal = new BigDecimal("1234567890.12345678901234567890");
    }
}