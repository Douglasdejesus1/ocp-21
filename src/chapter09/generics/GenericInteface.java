package chapter09.generics;

import java.awt.*;

public interface GenericInteface<T> {
    <T> void ship(T t);

    void ship2(T t);
}

class ShippbleAbstract<U> implements GenericInteface<U> {
    @Override
    public <T> void ship(T t) {
    }

    @Override
    public void ship2(U u) {
    }
}
class ShippableRobotCrate implements GenericInteface<Robot> {

    @Override
    public <T> void ship(T t) {

    }

    @Override
    public void ship2(Robot robot) {

    }
}
class ShippableRobot implements GenericInteface{
    @Override
    public  void ship(Object t) {

    }

    @Override
    public void ship2(Object o) {

    }

    public static void main(String[] args) {

    }
}