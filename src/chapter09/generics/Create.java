package chapter09.generics;
/*
Isso é muito usado em:
Spring Boot (Repository, ResponseEntity)
API REST
Caching
Collections
Event handling
 */
public class Create<T> {
    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}

class Toy {
    String nome;

    public Toy(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return nome;
    }

    public static void main(String[] args) {
        Create<Toy> create = new Create<>();
        create.setContent(new Toy("carrinho"));
        System.out.println(create.getContent());

        Create<Doll> createDoll = new Create<>();
        Doll doll = new Doll("barbie");
        createDoll.setContent(doll);
        System.out.println(create.getContent());
    }
}

class Doll {
    String nome;

    public Doll(String nome) {
        this.nome = nome;
    }
    public String toString() {
        return nome;
    }
}

class BoxExtend<T extends Number>{}
//class BoxSuper<T super Number>{} //nao existe