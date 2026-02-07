package chapter03;

public class IfClass {
    public static void main(String[] args) {

        int a = 10;
        if (a > 5) {
            int b = 5;
            System.out.println("true" + b);
        }
            // System.out.println("false" + b);


    }

    class InstanceOfClas {
        public static void main(String[] args) {
            Number meuNumero = 20;
            if (!(meuNumero instanceof Number num)) {
                System.out.println("nao é Number");
                return;
            }
            //num pode ser usado aqui, pois o instanceof com pattern matching
            // já fez a verificação e a atribuição
            System.out.println(num);
            int b = num.intValue() + 10;
            System.out.println(b);
            if (b > 10)
                System.out.println("b é maior que 10");
        }
    }
}
