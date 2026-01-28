package chapter01;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DestroyObjects {
    public static void main(String[] args) {

        ArrayList<Objects> objects = new ArrayList<>();
        for (int i=0; i < 1000000; i++) {
            Objects obj = new Objects("'Object" + i, i);
            objects.add(obj);
            if(i%1000 == 0){
                System.out.println("Created " + objects.size() + " objects");
              //  objects.clear();
                System.gc(); // Suggests the JVM to run garbage collection
                System.out.println("Created " + objects.size() + " objects");
            }
        }
    }
}
