package chapter08;

public class FunctionalInterfaces {
}

@FunctionalInterface
interface Sprint {
    public void sprint(int speed);

    //public void sprints(int speed);

    default void sprints(int speed) {
        System.out.println("Animal is sprinting! " + speed);
    }
    static void sprintss(int speed) {
        System.out.println("Animal is sprinting! " + speed);
    }

    @Override
    abstract String toString();
    public boolean equals(Object obj);
    public int hashCode();
}

class Tiger implements Sprint {

    @Override
    public void sprint(int speed) {
        System.out.println("Animal is sprinting fast! " + speed);
    }
}