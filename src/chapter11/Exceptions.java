package chapter11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exceptions {
    public static void main(String[] args) throws IOException {

        try {
            var connection = new MyConnection();
            var resource = new MyResource();
            //  try (var resource = new MyResource(); var connection2 = new MyConnection()) {
            try (resource; connection) {
                resource.teste();
                System.out.println("2 - Usando recurso");
                throw new IOException("Erro durante o uso do recurso");
            } catch (FileNotFoundException | RuntimeException e) {
                System.out.println("Exceção capturada: " + e.getMessage());
                Throwable[] suppressed = e.getSuppressed();
                for (Throwable t : suppressed) {
                    System.out.println("Exceção suprimida: " + t.getMessage());
                }
            } finally {
                System.out.println("4 - Bloco finally executado");
                // throw new CharConversionException("Erro no finally");

            }
        } catch (Exception e) {
            System.out.println("Exceção capturada main: " + e.getMessage());
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable t : suppressed) {
                System.out.println("Exceção suprimida main: " + t.getMessage());
            }
        }
    }

}

class MyResource implements AutoCloseable {
    // MyResource resource = new MyResource();
    int value;

    public MyResource() {
        System.out.println("1 - Recurso criado MyResource");
    }

    @Override
    public void close() throws RuntimeException {
        System.out.println("3 - Fechando recurso  MyResource");
        throw new RuntimeException("Erro ao fechar recurso  MyResource");
    }

    void teste() {
        throw new ArithmeticException("Erro durante o teste do recurso");

    }
}

class MyConnection implements AutoCloseable {
    // MyResource resource = new MyResource();
    int value;

    public MyConnection() {
        System.out.println("1 - Recurso criado no MyConnection");
    }

    @Override
    public void close() throws FileNotFoundException {
        System.out.println("3 - Fechando recurso no MyConnection");
        throw new FileNotFoundException("Erro ao fechar recurso no MyConnection");
    }
}

class Teste2 {
    public static void main(String[] args) throws IOException {


        try (
                FileInputStream fis = new FileInputStream("dados.txt")) {
            // Erro 1: Acontece aqui
            throw new IOException("Erro ao processar o arquivo");

        } catch (IOException e) {
            // Neste ponto, o try-with-resources tenta FECHAR o arquivo
            // Erro 2: Se o close() também falhar, este erro é SUPRIMIDO

            System.out.println("Erro principal: " + e.getMessage());
            //System.out.println("Suprised: " + e.getSuppressed());

            // Para ver os erros suprimidos:
            for (Throwable suprimida : e.getSuppressed()) {
                System.out.println("Erro suprimido: " + suprimida.getMessage());
            }
        }

    }
}