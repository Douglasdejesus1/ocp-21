package chapter08;

public class MethodReference {
}

interface Converter {
    long round(double num);
    //long raiz(double num);
}interface Exponenciar {
    double x(double num);
}

class MethodReferenceStaticMethods {

    Converter methodRef = Math::round;
    //Math:: exp iria para o metodo exp da classe Math, mas como o metodo exp tem um tipo de retorno diferente do esperado pela interface Converter,
    // não é possível usar essa referência de metodo.
    // Por isso, criamos a interface Exponenciar com um metodo x que tem o mesmo tipo de retorno do metodo exp, permitindo assim a referência de metodo.
    // o Math.exp() é usado para
    Exponenciar exp = Math::exp;

    public static void main(String[] args) throws InterruptedException {
        var instance = new MethodReferenceStaticMethods();
        System.out.println(instance.methodRef.round(3.14));
        System.out.println(instance.exp.x(3.14));
    }
}
interface StringStart{
    boolean beginningCheck(String prefix);
}
class MethodReferenceMethodsOnObjetct{
    public static void main(String[] args) {
        var java = "Java";
        StringStart stringStart = java::startsWith;
        System.out.println(stringStart.beginningCheck("Ja"));
    }
}
interface CheckEmpty{
    boolean isEmpty(String str);
}

class MethodReferenceMethodsOnParameter{
    public static void main(String[] args) {
        CheckEmpty cE = String::isEmpty;
        System.out.println(cE.isEmpty(""));
    }
}
interface CreaterString{
    String copy(String st);
}

class MethodReferenceConstructor{
    public static void main(String[] args) {
        CreaterString cS = String::new;
        System.out.println(cS.copy("Zebra"));
    }
}
