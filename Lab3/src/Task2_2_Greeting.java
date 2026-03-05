public class Task2_2_Greeting {
    static void sayHello() {
        System.out.println("Hello, World!"); // static method can call it without creating an object
    }

    void personalizedGreeting(String name) {
        System.out.println("Hello, " + name + "!"); // non-static method need to create an object first
    }

    public static void main(String[] args) {
        Task2_2_Greeting.sayHello(); // call the static method

        Task2_2_Greeting greet = new Task2_2_Greeting(); // create the object
        greet.personalizedGreeting("Alice"); // now we can call the method
        greet.personalizedGreeting("Bob");   // call it again with a different name
    }
}
