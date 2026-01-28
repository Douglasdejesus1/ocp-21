package chapter01;
/**
 * Javadoc multiple-line comment
 * @author Douglas
 */
class ClassStructure {
    //variables
    String name;
    int age;
    ///* */ */

    public static void main(String[] args) {
        ClassStructure classStructure = new ClassStructure();
        classStructure.name = "John";
        classStructure.age = 30;
        displayInfo(classStructure);

    }
    //method

    /**
     * Displays information about the class structure
     * @param classStructure
     */
    static void displayInfo(ClassStructure classStructure) {
        System.out.println("Age: "+classStructure.age + ", Name: " + classStructure.name);
    }
    static class Interna {
        // código da classe interna
    }
}
class SecundaryClassExample {
}
