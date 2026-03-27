package chapter06;

public final class FinalClass {
}

 /*class SubClass extends FinalClass {
 }
  */

class MickeyMouse {
    static final String name;

    static {
        name = "Mickey Mouse House";
    }
}

class MouseHouse extends MickeyMouse {

    private
    final int volume;
    private final int type;

    {
        this.volume = 10;
    }

    public MouseHouse(int type) {
        this.type = type;
    }

    public MouseHouse() {  // DOES NOT COMPILE
        this(0);
    }

    public static void main(String[] args) {
        System.out.println(new MouseHouse(10).type);
        System.out.println();
    }
}

class Super {
    public Super() {
        System.out.println("5-Super constructor");
    }

    {
        System.out.println("4-Super instance block");
    }

    static {
        System.out.println("1-Super static block");
    }
}
class Sub extends Super {
    public Sub() {
        System.out.println("7-Sub constructor");
    }
    {
        System.out.println("6-Sub instance block");
    }
    static {
        System.out.println("2-Sub static block");
    }

    public static void main(String[] args) {
        System.out.println("3-Main method");
        new Sub();
        System.out.println("8-Main method end");
    }

}


