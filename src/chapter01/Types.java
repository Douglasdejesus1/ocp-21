package chapter01;

public class Types {

    // byte: 8 bits (1 byte) - valores de -128 a 127
    byte byt = 127; // 01111111

    // short: 16 bits (2 bytes) - valores de -32.768 a 32.767
    short shorts = 128; // 00000000 10000000

    // char: 16 bits (2 bytes) - valores de 0 a 65.535
    char character = 128; // 00000000 10000000

    // int: 32 bits (4 bytes) - valores de -2.147.483.648 a 2.147.483.647
    int integer = 128; // 00000000 00000000 00000000 10000000

    // long: 64 bits (8 bytes) - valores de -2^63 a 2^63-1
    long longg = 128L; // 00000000 00000000 00000000 00000000 00000000 00000000 00000000 10000000

    // float: 32 bits (4 bytes) - precisão simples IEEE 754
    float floatt = 128.0F; // representação IEEE 754 (4 bytes)

    // double: 64 bits (8 bytes) - precisão dupla IEEE 754
    double doublee = 128.0; // representação IEEE 754 (8 bytes)

    // boolean: 1 bit (mas ocupa 1 byte na memória)
    boolean bool = true; // 00000001 (true) ou 00000000 (false)

    public static void main(String[] args) {
        var integerVar = 100;
        var stringVar = "Hello, World!";
        var type = new Types();

    }


}
