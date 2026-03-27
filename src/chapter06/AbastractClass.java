package chapter06;

public abstract class AbastractClass {
    int i;
    static int j;

    static {
        System.out.println("Static block");
    }

    {
        System.out.println("Instance block");
    }

    public AbastractClass() {
        System.out.println("Constructor AbstractClass");
    }

    public abstract void method();
    //public static abstract void method();
    //public final abstract void method();
    //private final abstract void method();

    final static public int getI(int i) {
        return i;
    }
}

class ContrectClass extends AbastractClass {


    @Override
    public void method() {
        System.out.println("Implemented method");
    }

    public static void main(String[] args) {
        AbastractClass contractClass = new ContrectClass();
        contractClass.method();
    }
}