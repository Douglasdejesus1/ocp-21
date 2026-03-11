package chapter05;

import java.io.IOException;

class NamedMethodException {
    public static void main(String[] args) throws IOException {
        main2(); //Copilable, but throws a runtime exception when executed
        //sou obrigado a tratar a exceção se main2() fosse chamada dentro de um bloco try-catch ou
        // se main2() fosse declarada com throws RuntimeException
    }

    static void main2() throws IOException {
        try {
            if (true) {
                System.out.println("Inside main2 method");
                throw new RuntimeException("This is a runtime exception");
            }
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
            throw new IOException();
        }
        throw new ClassCastException("This is a runtime exception");

    }
}
