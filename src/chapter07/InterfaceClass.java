package chapter07;

import java.io.IOException;

public interface InterfaceClass {
    int CONSTANT_VALUE = 20; // Variável constante, public static final por padrão

    /*public InterfaceClass(){
        // Interfaces não podem ter construtores
    }*/

    // nao podem ser private e protected
    default void defaultMethod() throws IOException {
        System.out.println("This is a default method de InterfaceClass the interface.");
        this.privateMethod();
    }

    //public e abstrac sao opcionais
    //proibido private e protected
    abstract void interfaceMethod();

    static void interFaceStatic(){
        System.out.println("Static method in interface public.");
        interFaceStaticPrivate();
    }
    private static void interFaceStaticPrivate(){
        System.out.println("Static method in interface private.");
        //privateMethod();
    }
    private void privateMethod(){
        System.out.println("Private method in interface.");
    }

}
interface InterfaceClassTho {
    //public e abstrac sao opcionais
    //proibido private e protected
    abstract void interfaceMethod() throws Exception;

    default void defaultMethod() throws IOException {
        System.out.println("This is a default method de InterfaceClassTho the interface.");
    }


}
class ConcreteClass implements InterfaceClassTho, InterfaceClass {

    //@Override
    //nao copila o throws Exception, pois a interface interfaceClass nao tem o throws Exception,
    // mesmo com a InterfaceTho tendo, pq a interfaceClass nao tem,
    // entao o metodo da classe concreta tem que ser compativel com a interfaceClass, ou seja, nao pode ter o throws Exception
    //public void interfaceMethod() throws Exception {
    public void interfaceMethod() {
        System.out.println("Implementing the interface method.");
    }
    //nao pode ser protected e private pois a interface tem o metodo public,
    // entao a classe concreta tem que ter o mesmo nivel de acesso ou mais permissivo, ou seja, public
    @Override
    public void defaultMethod() throws IOException {
        System.out.println("Overriding the default method in the concrete class.");
    }



    public static void main(String[] args) throws IOException {
        ConcreteClass obj = new ConcreteClass();
        obj.interfaceMethod();
        InterfaceClass.interFaceStatic();
        System.out.println("Constant value: " + InterfaceClass.CONSTANT_VALUE);
        obj.defaultMethod();
    }
}