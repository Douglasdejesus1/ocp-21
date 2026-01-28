package chapter01;

public class InicializeVariables {
    //can be not initialized
    static int a;
    //must be initialized
    final int b = 0;


    public static void main(String[] args) {
        //local variables must be initialized before use
        int d;
        if(a==2){
            d=5;
        }
        //o compilador não consegue garantir que d foi inicializada
        //System.out.println("d: " + d); //ERRO DE COMPILAÇÃO, VARIAVEL NÃO INICIALIZADA

        System.out.println("a: " + a);

        while (true){
            //must be initialized before use
            int c =3;
            System.out.println("c: " + c); //AGORA COMPILA, VARIAVEL INICIALIZADA
            break;
        }
    }
}
