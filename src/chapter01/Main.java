package chapter01;

public class Main {
    /*
    pode ser final, static, public, void, exceto o void podem mudar de posição
    nao pode ser private, abstract, synchronized, native, strictfp
    ... ou []
    */

    //valido
        //  public final static  void main(String[] args) {
    //valido
        //  static public void main(String[] args) {
    //valido
        //  public static  void main(String... args) {
    //INVALIDO,NAO COPILA
        //  public static  void main(String args...) {
    //INVALIDO,NAO COPILA, NAO SEPARE O RETORNO DO NOME DO METODO
        //  public   void static main(String[] args) {
    //INVALIDO, COPILA MAS NAO É ENTRYPOINT MAIN
        //  public  void main(String[] args) {
    //INVALIDO, COPILA MAS NAO É ENTRYPOINT MAIN
            static  void main(String[] args) {

        System.out.println("Hello, World!");
    }
}
