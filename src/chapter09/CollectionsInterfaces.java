package chapter09;

import java.util.*;

public class CollectionsInterfaces {
     void print(List<String> list){}
     void print(Set<CharSequence> list){}


    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<>();
        Collection<String> collection2 = new ArrayList<>();
        boolean equals = collection.equals(collection2);
        boolean helloAdd = collection.add("Hello");
        boolean helloAdd1 = collection.add("Java");
        System.out.println(collection);
        boolean helloContain = collection.contains("Hello");
        collection.removeIf(s -> s.equals("Hello")); //Predicate
        collection.clear();
        System.out.println();
        boolean helloRemove = collection.remove("Hello");
        boolean empty = collection.isEmpty();
        int size = collection.size();
        collection.forEach(System.out::println); //Consumer

        //java21
        SequencedCollection sequencedCollection = new TreeSet<>();
        sequencedCollection.add("Java21");
       // sequencedCollection.addFirst("First");// UnsupportedOperationException
       // sequencedCollection.addLast("Last");// UnsupportedOperationException
        sequencedCollection.getFirst();
        sequencedCollection.reversed();

        Set hashset = new HashSet<>();
        SequencedSet linkedHashSet = new LinkedHashSet<>();
        SequencedSet treeSet = new TreeSet<>();
        treeSet.reversed();

        List arrayList = new ArrayList<>();


        LinkedList linkedList = new LinkedList<>();

        Queue queueArrayDeque = new ArrayDeque<>();
        Queue queueLinkedList = new LinkedList<>();

        Deque dequeArrayDeque = new ArrayDeque<>();
        Deque dequeLinkedList = new LinkedList<>();

        Map hashMap = new HashMap<>();
        SequencedMap linkedHashMap = new LinkedHashMap<>();
        SequencedMap treeMap = new TreeMap<>();


    }
}
class BasicGeneric{
    List list = new ArrayList<String>();

    public static void main(String[] args) {
        var list = new ArrayList<>();
        list.add(1);
        list.add("String");
    }

    List<String> list2 = new ArrayList<>();
    List<?> list3 = new ArrayList<String>();
    List list4 = new ArrayList<String>();

    void returnData(List<String> list){
        System.out.println(list);
    }
    void returnData2(List<?> list){
        System.out.println(list);
    }
    /*void returnData3(List<> list){
        System.out.println(list);
    }*/

}