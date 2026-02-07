package chapter03;

public class SwitchExpressions {
    public static void main(String[] args) {
        final int switchChoice = 3;
        String result = switch (switchChoice) {
            default -> {
                System.out.println("Executing default case block.");
                yield "No valid choice selected.";
            }
            case 1 -> "Choice 1 selected.";
            case 2 -> "Choice 2 selected.";
            case 3 -> "Choice 3 selected.";
        };
        System.out.println(result);

        String result2 = switch (switchChoice) {
            case 1 -> "Choice 1 selected.";
            case 2 -> "Choice 2 selected.";
            case 3 -> "Choice 3.1 selected.";
            default -> "No valid choice selected.";
        };
        System.out.println(result2);
        String switchChoiceDouble = null;

        String result3 = switch (switchChoiceDouble) {
            case "double1" -> "Choice 1 selected.";
            case "double2" -> "Choice 2 selected.";
            case "double3" -> "Choice 3 selected.";
            case null -> "Choice 4 selected.";
            default -> "No valid choice selected.";
        };
        System.out.println(result3);


    }
}

class SwitchPatterMatching {
    public static void main(String[] args) {
        Object obj = "Hello, World!";
        String result = switch (obj) {
            case Integer i -> "It's an Integer: " + i;
            case String s when s.equals("Hello") -> {
                yield "It's a String: " + s;
            }
            case String d -> "It's a String: " + d;
            default -> "Unknown type";
        };
        System.out.println(result);
    }
}
