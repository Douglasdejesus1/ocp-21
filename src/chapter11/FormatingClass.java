package chapter11;

import java.text.*;

public class FormatingClass {
}
class NumberFormatClass{
    public static void main(String[] args) {
        int number = 123456789;
        String formattedNumber = String.format("%,d", number);
        System.out.println(formattedNumber); // Output: 123,456,789
        NumberFormat nf = new DecimalFormat("#,###.00"); //0 a direta de #
        System.out.println(nf.format(number)); // Output: 123,456,789.00
        var nf2 = new DecimalFormat("R$ 000,000.000"); //., ou .. nao é valido; .. vai eliminar o dciomal; padrao é ,,inteiros.decima
        double valor = 10_000.006;
        System.out.println(nf2.format(valor)); // Output: R$ 10,000.01
    }
}
