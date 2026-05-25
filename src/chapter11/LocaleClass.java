package chapter11;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class LocaleClass {
    public static void main(String[] args) {
        Locale locale =
                Locale.getDefault();
        System.out.println(locale);

        Locale fr = Locale.of("fr");
        System.out.println(fr);
        Locale frEn = Locale.of("fr_EN");
        System.out.println(frEn);
        var locBilder = new Locale
                .Builder()
                .setLanguage("fr")
                .setRegion("EN")
                .build();
    }
}

class NumberLocaleFormat {
    public static void main(String[] args) throws ParseException {
        String format = NumberFormat
                .getInstance(Locale.US)
                .format(123456789);
        System.out.println(format);

        String formatInscance = NumberFormat
                .getNumberInstance(Locale.US)
                .format(123456789);
        System.out.println(formatInscance);

        var currency = NumberFormat
                .getCurrencyInstance(Locale.UK)
                .format(123456789.20);
        System.out.println(currency);

        var percent = NumberFormat
                .getPercentInstance(Locale.JAPAN)
                .format(0.75);
        System.out.println(percent);

        //compact e numberformat.Style
        var compactNumber = NumberFormat
                .getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.LONG)
                .format(123456789);
        System.out.println(compactNumber);

        var compactNumber2 = NumberFormat
                .getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.LONG);
        System.out.println(compactNumber2.format(123_456_789));
        // System.out.println(compactNumber2.parse("%13_456_789"));


    }
}
class SetLocaleClass{
    public static void main(String[] args) {
        System.out.println( NumberFormat
                .getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.LONG).format(123456789));

        Locale.setDefault(Locale.ITALIAN);
        System.out.println( NumberFormat
                .getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.LONG).format(123456789));
        Locale.setDefault(Locale.Category.FORMAT, Locale.US);
        System.out.println(Locale.getDefault());
        System.out.println( NumberFormat
                .getCompactNumberInstance(Locale.getDefault(), NumberFormat.Style.LONG).format(123456789));

    }
}