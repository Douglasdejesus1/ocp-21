package chapter02;

public class LogicOperators {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        a = a & b; // AND
        b = a | b;  // OR
        a = !b;     // NOT
        a = a ^ b; // XOR

    }
}
class Bitwise {
    public static void main(String[] args) {
        byte a = 0b00001111; // 15 em decimal
        byte b = 0b00110011; // 51 em decimal
        byte c = (byte) (a & b); // AND(00001111 & 00110011): 00000011 (3 em decimal)
        byte d = (byte) (a | b); // OR(00001111 | 00110011): 00111111 (63 em decimal)
        byte e = (byte) (~a);    // NOT(00001111): 11110000 (240 em decimal, considerando byte como signed)
        byte f = (byte) (a ^ b); // XOR(00001111 ^ 00110011): 00111100 (60 em decimal)

    }
}
class ConditionalLogic {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        a = a && b; // AND condicional
        b = a || b;  // OR condicional
    }
}