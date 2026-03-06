class Elephant {
    String name; // Instance variable to store elephant's name
}

public class ElephantTest {
    public static void main(String[] args) {
        Elephant a;                  // Declare reference variable a
        a = new Elephant();          // Create new Elephant object
        a.name = "Elephant1";        // Set name of first elephant

        Elephant b;                  // Declare reference variable b
        b = new Elephant();          // Create NEW Elephant object (different from a)
        b.name = "Elephant2";        // Set name of second elephant

        System.out.println("a is " + a.name + ", b is " + b.name);
    }
}