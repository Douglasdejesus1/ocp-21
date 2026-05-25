package chapter11;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleClass {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
            // Inglês
            ResourceBundle bundle_en = ResourceBundle.getBundle("Zoo", Locale.ENGLISH);
            System.out.println(bundle_en.getString("hello")); // Hello

            // Francês
            ResourceBundle bundle_fr = ResourceBundle.getBundle("Zoo", Locale.FRENCH);
            System.out.println(bundle_fr.getString("hello")); //
        ResourceBundle rb =
                ResourceBundle.getBundle("Zoo",
                        Locale.FRENCH);
        String greeting = rb.getString("helloGreeting");
        System.out.print(
                MessageFormat.format(greeting, "Tammy",
                        "Henry"));
    }
}
