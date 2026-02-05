package chapter03;

public class SwitchStatement {
    public static void main(String[] args) {
        final int switchChoice = 2;
        switch (switchChoice) {
            case 1:
                System.out.println("Choice 1 selected.");
                break;
            case 2:
                System.out.println("Choice 2 selected.");
                break;
            case 3:
                System.out.println("Choice 3 selected.");
                break;
            default:
                System.out.println("No valid choice selected.");
        }
        SwitchPatterMatching switchPatterMatching =new SwitchPatterMatching();
        switchPatterMatching.main(args);

        final short case1 = 1;
        int switchChoice2 = 3;
        final int valor = Cases.CASE3.value;
        System.out.println(valor);
        switch (Cases.CASE3) {
            case Cases.CASE3:
                System.out.println("Choice 1 selected.");
                break;
            case Cases.CASE2:
                System.out.println("Choice 2 selected.");
                break;
            case Cases.CASE1:
                System.out.println("Choice 3 selected.");
                break;
            default:
                System.out.println("No valid choice selected.");
        }

        switch (6) {
             default ->
                System.out.println("No valid choice selected.");
            case case1->
                System.out.println("Choice 1 selected.");
            case 2 + 4 ->
                System.out.println("Choice 2 selected.");
            case 3->
                System.out.println("Choice 3 selected.");
        }
        switch ("teste") {

            case "case1"->
                    System.out.println("Choice 1 selected.");
            case "2 + 4" ->
                    System.out.println("Choice 2 selected.");
            default ->
                    System.out.println("No valid choice selected.");
          //  case null->
          //          System.out.println("Choice 3 selected.");

        }

    }
}

class FakeSwitchExpression {
    public static void main(String[] args) {
        final int switchChoice = 3;
        chamaSwithch(switchChoice);
    }

    static void chamaSwithch(int switchChoice) {
         switch (switchChoice) {
            case 1,2 ->
                System.out.println("Choice 1 selected.");
            case 3->
                System.out.println("Choice 2 selected.");
            default->
                System.out.println("Choice 1 selected.");
        };
    }
}
enum Cases{
    CASE1(1),
    CASE2(2),
    CASE3(3);
    Cases(int value){
        this.value = value;
    }
    public final int value;
}