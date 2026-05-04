package chapter09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingDataClass {
}

class CustomComparable implements Comparable<CustomComparable> {
    String name;

    public CustomComparable(String name) {
        this.name = name;
    }
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(CustomComparable o) {
        return this.name.length()  - o.name.length();
    }

    public static void main(String[] args) {
        var list = new ArrayList<CustomComparable>();
        list.add(new CustomComparable("Charlie"));
        list.add(new CustomComparable("Hanna"));
        list.add(new CustomComparable("dog"));
        Collections.sort(list);
        System.out.println(list);
    }
}
class CustomComparator  {
    String name;
    public int age;
    public CustomComparator(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return this.name;
    }
    public static void main(String[] args) {
    Comparator<CustomComparator> comparator = new Comparator<CustomComparator>() {
        @Override
        public int compare(CustomComparator o1, CustomComparator o2) {
            return o1.age -o2.age;
        }
    };
        var list = new ArrayList<CustomComparator>();
        list.add(new CustomComparator("Charlie", 30));
        list.add(new CustomComparator("Hanna", 18));
        list.add(new CustomComparator("dog", 20));
       // Collections.sort(list, comparator);
        Collections.sort(list, ( o1,  o2) -> o1.age -o2.age);
        System.out.println(list);




    }
}