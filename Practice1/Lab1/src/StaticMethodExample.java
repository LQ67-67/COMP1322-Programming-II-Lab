class Example {
    static void displayClassMessage() {

        System.out.println("This is a method belonging to the class.");
    }

    void displayInstanceMessage() {
        System.out.println("This is a method belonging to an instance.");
    }
}

public class StaticMethodExample {
    public static void main(String[] args) {
        Example.displayClassMessage();

        Example obj = new Example();

        obj.displayInstanceMessage();

    }
}
