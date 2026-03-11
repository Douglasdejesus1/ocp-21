package chapter05;

public class FinalClassMethod {
}
class FinalMethod {
    public String value;
    //final nos métodos significa que eles não podem ser sobrescritos por subclasses. Isso é útil para garantir que
    // o comportamento de um méthodo permaneça consistente em todas as subclasses, evitando alterações indesejadas.
    public final void finalMethod() {
        System.out.println("This is a final method");
    }

    public static void main(String[] args) {
        final FinalMethod fm = new FinalMethod();
        fm.value = "Hello";
        //fm = new FinalMethod(); // DOES NOT COMPILE BECAUSE FINAL VARIABLE CANNOT BE REASSIGNED
    }
    public void NonfinalMethod() {
        System.out.println("This is a non final method");
    }
}
class FilhaFinalMethod extends FinalMethod {
    //public void finalMethod() {} // DOES NOT COMPILE BECAUSE FINAL METHOD CANNOT BE OVERRIDDEN

    @Override
    public void NonfinalMethod() {
        System.out.println("This is a non final method filha");

    }
}