package chapter05;

import chapter05.modifier.Veicule;

public class AccessModifierClass {
    //Public methods are accessible from any other class, regardless
    //Protected methods are accessible within the same package and by subclasses in other packages.
    //Default (package-private) methods are accessible only within the same package.
    //Private methods are accessible only within the same class.
}
class Car extends Veicule {
    int speed;
    public Car(String color, int speed) {
        super(color);
        this.speed = speed;
    }

    void accelerate() {
        System.out.println("Car is accelerating");
    }

    public static void main(String[] args) {
        Car car = new Car("Red", 100);
        System.out.println(car.color);
        System.out.println(car.speed);
        car.start();
        car.accelerate();
    }
}
