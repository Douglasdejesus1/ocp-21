package chapter09.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Return {
    public static void main(String[] args) {

    }
    <T>T getT(T t){
        return t;
    }
    /*<T><T super Number> getT(T t){
        return t;
    }
    */
   /* <? super Number> getT(? t){
     /*
        return t;
    }*/
    List<? extends Number> getNumbersExtends(){
        List<? extends Number> list = new ArrayList<>();
        return list;
    }
    List<? super Number> getNumbersSuper(){
      var list = new ArrayList<>();
        return list;
    }
}
class Mammal{
   public List<CharSequence> play(){
       return null;
   }
}
class Monkey extends Mammal{
    @Override
    public ArrayList<CharSequence> play() {
        return null;
    }
}
class Goat extends Mammal{
   /* public ArrayList<String> play() {
        return null;
    }*/
}
