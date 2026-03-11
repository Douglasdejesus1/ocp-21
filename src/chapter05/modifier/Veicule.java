package chapter05.modifier;

public class Veicule {
    protected String color;
    public Veicule(String color) {
        this.color = color;
    }
     protected void start() {
        System.out.println("Veicule is starting");
    }

}
