package chapter04;

public class ConcatenatingClass {
    int value = 10;
    public static void main(String[] args) {
        System.out.println(1+1+"1"+1+1);
        System.out.println("1"+null);
        ConcatenatingClass cc = null;
        System.out.println(cc);
      //  System.out.println(cc.value);

        String s = "Hello";
        s+= " World";
        System.out.println(s);
    }
}
