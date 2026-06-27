package chapter14;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IoStreamsClass {
    //leitura de textos
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/tiger/data/stripes.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        }
        //leitura de objetos serializados
        try (var ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("/home/tiger/data/stripeshex2.txt")))) {
            System.out.print(ois.readObject());
        }
        try (PrintStream output =
                     new PrintStream(new FileOutputStream("/home/tiger/data/log.txt",true ),
                             true,
                                        StandardCharsets.UTF_8)) {

            output.println("Aplicação iniciada as: " + System.currentTimeMillis());
            output.printf("Usuário: %s%n", "Douglas");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/tiger/data/log.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        }
        try (FileWriter writer =
                     new FileWriter("/home/tiger/data/log2.txt", true)) {

            writer.write("Aplicação iniciada");
            writer.write(System.lineSeparator());
            writer.write("Usuário: Douglas");
            writer.write(System.lineSeparator());
        }
    }
}

