package chapter08;

public class Lambdas {
}
record Animal(String species, boolean canHop, boolean canSuwin){}
interface CheckTrait{
    boolean test(Animal a);
}
class CheckIfHopper implements CheckTrait{
    @Override
    public boolean test(Animal a) {
        return a.canHop();
    }
}
class CheckIfSwimmer implements CheckTrait {
    @Override
    public boolean test(Animal a) {
        return a.canSuwin();
    }
}
class TraditionalSearch{
    public static void main(String[] args) {
        Animal[] animals = {
                new Animal("fish", false, true),
                new Animal("kangaroo", true, false),
                new Animal("rabbit", true, false),
                new Animal("turtle", false, true)
        };
        print(animals, new CheckIfHopper());
        print(animals, new CheckIfSwimmer());
        print(animals, a -> a.canSuwin());
        print(animals, (Animal a) -> a.canSuwin());
        print(animals, (a) -> {return a.canSuwin();});
    }
    private static void print(Animal[] animals, CheckTrait checker){
        for (Animal a: animals) {
            if (checker.test(a)){
                System.out.print(a.species() + " ");
            }
        }
        System.out.println();
    }
}

