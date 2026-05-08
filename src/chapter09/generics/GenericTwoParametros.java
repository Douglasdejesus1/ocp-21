package chapter09.generics;


public class GenericTwoParametros<T, U> {
    private T content;
    private U sizeLimite;

    public GenericTwoParametros(T content, U sizeLimite) {
        this.content = content;
        this.sizeLimite = sizeLimite;
    }
}

record Elefante(String nome) {
}

class Teste {
    public static void main(String[] args) {
        Elefante elefante = new Elefante("Elefante");
        GenericTwoParametros<Elefante, Integer> g2
                = new GenericTwoParametros<>(elefante, 200);
    }
}