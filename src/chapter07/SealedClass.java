package chapter07;

public class SealedClass {
}

sealed class SealeadAnimal permits Cat, Dog, Bird {

}

final class Cat extends SealeadAnimal {

}

sealed class Dog extends SealeadAnimal /* permits Golden*//*, Labrador */{

}

non-sealed class Bird extends SealeadAnimal {

}

 class Parot extends Bird {

}
final class Golden extends Dog {
    public static void main(String[] args) {

    }
}

sealed interface Vehicle permits Car, Truck {

}
non-sealed class Car implements Vehicle{}
final class Truck implements Vehicle{}