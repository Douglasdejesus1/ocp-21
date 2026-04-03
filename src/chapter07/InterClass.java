package chapter07;

import static chapter07.Park.Ticket.print;

public class InterClass {
    //private String hi =
}

class Home {
    private String hello = "Hello World";
    private int x = 10;

    class Room {
        private int x = 20;

        public void printHello() {
            System.out.println(hello);
        }

        class Door {
            private int x = 30;

            private Door getStance() {
                return new Door();
            }

            public void printHello() {
                System.out.println(hello + " open de door");
                System.out.println(x);
                System.out.println(this.x);
                System.out.println(Home.this.x);
                System.out.println(Room.this.x);
            }
        }

        private Door getStance() {
            return new Door();
        }

        //nao pode ser referenciado em um static context
      /*  private static Door getStanceStatic() {
            return new Door();
        }/*
    }
  //nao compila pois Door esta dentro de Room
   /*private Door getStances() {
        return new Door();
    }*/
        public static void main(String[] args) {
            Home home = new Home();
            Home.Room room = home.new Room();
            Home.Room.Door door = room.new Door();
            door.printHello();
            room.printHello();
        }
    }
}

class Park {
    static String name = "Disney";

    //a inner static é usada quando desejo usar a classe interna sem precisar de uma instancia da classe externa, ou seja,
    // sem precisar de um objeto da classe externa
    static class Ride {
        private int price = 5;
    }

    record Ticket(int price) {
        static void print() {
            String name1 = Park.name;
            System.out.println(name1);
        }
        //nao compila pois o record é static por padrao, ou seja, nao tem acesso a Ride
        //private Ride ride = new Ride();

    }

    public static void main(String[] args) {
        Park.Ride ride = new Ride();
        System.out.println(ride.price);

        var ticket = new Ticket(10);
        print();
        System.out.println(ticket.price());
    }
}

class PrintNumbers {
    private int length = 5;

    public void calculate() {
        final int width = 20;

        class Calculator {
            public void multiply() {
                System.out.print(length * width);
            }
        }
        var calculator = new Calculator();
        calculator.multiply();
    }

    public void processData() {
        final int length = 5;
        int width = 10;
        int height = 2;
        class VolumeCalculator {
            public int multiply() {
                return length * width * height * 2; // DOES NOT COMPILE
            }
        }
        System.out.println(new VolumeCalculator().multiply());
        // width = 2;
    }

    public static void main(String[] args) {
        var printer = new PrintNumbers();
        printer.calculate();  // 100
        System.out.println();
        printer.processData();
    }
}

class Zoo {
    abstract class Animal {
        abstract void eat();
    }

    public void feed() {
        //é permitido instanciar pois o metodo eat é implementado, ou seja,
        // a classe anônima é criada e o metodo eat é implementado
        var animal = new Animal() {
            void eat() {
                System.out.println("Animal is eating");
            }
        };
        animal.eat();
    }

    public void feed2() {
        new Animal() {
            void eat() {
                System.out.println("Animal is eating");
            }
        }.eat();
    }

    interface Animal2 {
        void eat();
    }
    public void feed3() {
        Animal2 animal = () -> System.out.println("Animal is eating");
        animal.eat();
    }

    public static void main(String[] args) {
        var zoo = new Zoo();
        zoo.feed();
        zoo.feed2();
    }
}

class Gorilla {
    interface Climb {}
    Climb climbing = new Climb(){};
}