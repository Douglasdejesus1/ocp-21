package chapter06;

import java.io.IOException;

public class OverridingClass {
    void method() {
        System.out.println("Super method");
    }

    final void method(int i) throws Exception {
        System.out.println("Super method with int parameter");
    }

    static final void method(String s) {
        System.out.println("Super method with String parameter");
    }

    //nao posso declarar um metodo abstrato em uma classe concreta
    //abstract void method(double d);
    public static void method(String... s) {
        System.out.println("Super method with String varargs parameter");
    }
}

class SubOverriding extends OverridingClass {
   /*    O java nao permite que um metodo seja declarado como static e final ao mesmo tempo,
    pois são modificadores mutuamente exclusivos.
    O modificador static indica que o metodo pertence à classe,
    enquanto o modificador final indica que o metodo não pode ser sobrescrito por subclasses.
        Portanto, um metodo não pode ser ambos static e final ao mesmo tempo.
    porque um metodo static pertence à classe
    e não pode ser sobrescrito, enquanto um
    metodo final não pode ser sobrescrito,
    mas pode ser instanciado. Portanto, a combinação de static
    e final não faz sentido e não e permitida em Java.*/

    /*private void method() {
        System.out.println("Sub method");
    }*/
    //para deixar de ser um override, o metodo deve ser declarado como static ou fina
    /*void method(int i) throws IOException {
        System.out.println("Sub method with int parameter");
    }*/
    //nao posso sobresver um metodo static, e causa erro se o pai tiver o metodo declarado como final
    /*static void method(String s) {
        System.out.println("Sub method with String parameter");
    }*/
   /* private static void method(String... s) {
        System.out.println("Super method with String varargs parameter");
    }*/

    public static void main(String[] args) throws Exception {

        //OverridingClass e a reference e SubOverriding e o objeto,
        // ou seja, o metodo da classe SubOverriding será chamado
        OverridingClass overridingClass = new SubOverriding();
        overridingClass.method(1);
        SubOverriding.method("string");
        OverridingClass.method("string");


    }
}

class InternoSobreCarga {
    static void method(long l, double d) {
        System.out.println("Method with long and double parameters");
    }
    static void method(int i, double d) {
        System.out.println("Method with int and double parameters");
    }
    static void method(double d, int i) {
        System.out.println("Method method with double and int parameter");
    }

    static void method(int i, float d) {
        System.out.println("Method with int and float parameter");
    }

    static void method(float f, int i) {
        System.out.println("Metodo com float e int");
    }

    public static void main(String[] args) {
        InternoSobreCarga.method(1, 1.0);
        InternoSobreCarga.method(10l, 1.0);

        InternoSobreCarga.method(1.0, 1);
        InternoSobreCarga.method(1.0f, 1);

        InternoSobreCarga.method(1, 1.0f);

        InternoSobreCarga.method(1.0f, 1);
        //ambiguidade ocorre porque o compilador não consegue determinar qual metodo chamar, já que ambos os metodos têm a mesma assinatura (int e float)
        // e os argumentos fornecidos (1 e 1) podem ser convertidos para ambos os tipos. Portanto, o compilador não sabe qual metodo escolher
        // e gera um erro de ambiguidade.
        //InternoSobreCarga.method(1, 1);
        
    }


}