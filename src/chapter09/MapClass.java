package chapter09;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapClass {
    public static void main(String[] args) {
        Map<Integer, String> map = Map.of(1, "Douglas", 2, "Hanna");
        var copyMap = Map.copyOf(map);
       // System.out.println(map);
       // System.out.println(copyMap);

        var ofEntries = Map.ofEntries(
                Map.entry(1, "Douglas"),
                Map.entry(2, "Hanna"),
                Map.entry(3, "Douglas")
        );
        //System.out.println(ofEntries);
        Set<Map.Entry<Integer, String>> entriesSet = ofEntries.entrySet();
        //System.out.println(entriesSet);
     //   ofEntries.forEach((k, v) -> System.out.println(k + ": " + v));
        String s = ofEntries.get(4);
        String s1 = ofEntries.getOrDefault(4,
                "defaultValue");
       // System.out.println(s);
       // System.out.println(s1);
        var hashMap = new HashMap<Integer,String>();
        hashMap.put(1, null);
    hashMap.put(2,"Hanna");
        String smith = hashMap.merge(1, "Smith",
                (v1, v2) -> v1 + " " + v2
        );
       // System.out.println(smith);
        Set<Integer> integers = hashMap.keySet();
        Collection<String> strings = hashMap.values();
        //System.out.println(integers);
       // System.out.println(strings);
        String s2 = hashMap.putIfAbsent(2, "Smith");
        String s3 = hashMap.putIfAbsent(3, "Douglas");
        //System.out.println(s2);
       // System.out.println(s3);
        hashMap.replace(2, "Smith2"); // se já existir funciona igual ao put, mas se nao, nao adiciona e retorna null
        System.out.println(hashMap);


    }
}
