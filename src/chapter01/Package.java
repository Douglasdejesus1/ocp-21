package chapter01;

import java.lang.*;
import java.util.Random;


/*
pode ter 0 ou 1 package, ver ClasseSemPackage.java
pode ter 0 ou mais imports
java.lang é importado automaticamente, mas se importar de novo não tem problema
* só serve para classes no package, se tiverem em pacotes mais internos precisa importar
 */
public class Package {
    public static void main(String[] args) {

        //full qualified name
        var atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(true);

        Random r = new Random();
        int value = r.nextInt(10);
    }

}
