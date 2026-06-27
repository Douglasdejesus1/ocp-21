package chapter14;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class SerializingClass {
    public static void main(String[] args) throws Exception {
    Path path = Path.of("C:\\temp\\usuario.dat");

        Files.createDirectories(path.getParent());

    Usuario usuario = new Usuario(
            "Douglas",
            35,
            "senha-secreta"
    );

    boolean arquivoPossuiDados =
            Files.exists(path) && Files.size(path) > 0;

        try (
    FileOutputStream fileOutput =
            new FileOutputStream(path.toFile(), true);

    ObjectOutputStream objectOutput =
            arquivoPossuiDados
                    ? new AppendableObjectOutputStream(fileOutput)
                    : new ObjectOutputStream(fileOutput)
        ) {
        objectOutput.writeObject(usuario);
    }

    lerTodos(path);
}

private static void lerTodos(Path path)
        throws IOException, ClassNotFoundException {

    try (var input = new java.io.ObjectInputStream(
            new java.io.BufferedInputStream(
                    new java.io.FileInputStream(path.toFile())))) {

        while (true) {
            try {
                Usuario usuario =
                        (Usuario) input.readObject();

                System.out.println(usuario);
            } catch (java.io.EOFException exception) {
                break;
            }
        }
    }
}
}
class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private int idade;
    private LocalDateTime dataCriacao;

    private transient String senha;

    public Usuario(String nome, int idade, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.senha = senha;
        this.dataCriacao = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", senha='" + senha + '\'' +
                ", data criacao usuario=" + dataCriacao +
                '}';
    }
}
class AppendableObjectOutputStream extends ObjectOutputStream {

    public AppendableObjectOutputStream(OutputStream output)
            throws IOException {
        super(output);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}