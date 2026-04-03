package chapter07;

public class PolimorfismoClass {
}

interface OverrideClas {
    void print();
}

class OverridedClass implements OverrideClas {
    @Override
    public void print() {
        System.out.println("Hello World");
    }
}

class PaiClassHiding {
    int i = 10;
    static int is = 20;

    static void print() {
        System.out.println("Hello World  Pai Hidden");
    }

    void printStringOverlod(String str) {
        System.out.println("Hello World String " + str);
    }
}

class FilhoClass extends PaiClassHiding {
    int i = 15;
    static int is = 25;

    //o nome disso é Hiding
    static void print() {
        System.out.println("Hello World Filho Hiding");
    }

    @Override
    void printStringOverlod(String str) {
        System.out.println("Hello World String filho " + str);
    }

    //Overload metodo
    void printStringOverlod(String str, int i) {
        System.out.println("Hello World String " + str + " " + i);
    }


    public static void main(String[] args) {
        PaiClassHiding pai = new PaiClassHiding();
        pai.printStringOverlod("Teste");
        PaiClassHiding filho0 = new FilhoClass();
        System.out.println(filho0.i + " " + filho0.is);
        ;
        FilhoClass filho = new FilhoClass();
        System.out.println(filho.i + " " + filho.is);
        ;
        System.out.println();
        filho.printStringOverlod("Teste", 10);
        filho.printStringOverlod("Teste filho");
        print();


    }
}

interface Canine {
}

interface Dogs {
}

class Wolf implements Canine {
}

class BadCasts {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        //Dogs dg = (Dogs) wolf; // throws ClassCastException at runtime
    }
}

abstract class Controle {
    abstract void liga();

    abstract void desliga();
}

class Tv extends Controle {

    @Override
    void liga() {
        System.out.println("Tv ligada");
    }

    @Override
    void desliga() {
        System.out.println("Tv desligada");
    }

    void mudaBrilho() {
        System.out.println("Brilho mudado");
    }
}

class Som extends Controle {

    @Override
    void liga() {
        System.out.println("Tv ligada");
    }

    @Override
    void desliga() {
        System.out.println("Tv desligada");
    }

    void equalizar() {
        System.out.println("Equalizador ativado");
    }
}

class Consumer {
    public static void main(String[] args) {
        Controle controleTv = new Tv();
        Controle controleSom = new Som();
        controleTv.liga();
        controleTv.desliga();
        controleSom.liga();
        controleSom.desliga();
        //controleSom.equaliza();
        if (controleTv instanceof Tv tv) {
            tv.mudaBrilho();
        }

        if (controleSom instanceof Som som) {
            //exemplo de uso do pattern matching for instanceof
            som.equalizar();
        }


    }
}

