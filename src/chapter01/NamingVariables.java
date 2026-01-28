package chapter01;

public class NamingVariables {
    public static void main(String[] args) {
        var number = 10;
        //var number2 = 20, number3 = 30; // Invalid: cannot declare multiple variables with var
        //var 2number; // Invalid: cannot start with a digit
        //var nuber2;
        int n1,n2,n3; // Valid declaration of multiple variables
        int n4,n5=5,n6; // Valid declaration of multiple variables
        //int n7 = n8 =7; // Invalid: cannot chain assignments in declaration
        //int n9, shot n10; // Invalid: multiple modifiers not allowed
        int n11; short n12; // Valid: separate declarations WITH ;
        String var = "JavaVar";
        double $price = 19.99;
        boolean _isActive = true;

        System.out.println("Number: " + number);
        System.out.println("varJava: " + var);
        System.out.println("Price: " + $price);
        System.out.println("Is Active: " + _isActive);
    }
}
