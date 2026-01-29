package chapter02;

public class TernaryClass {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;
        // expressão ternária: condição ? valor_se_verdadeiro : valor_se_falso
        int max = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
        int max2 = a > b ? a > c ? a : c : b > c ? b : c;
        System.out.println("O maior valor é: " + max);

    }
}
