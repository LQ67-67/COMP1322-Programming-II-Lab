public class MethodTypesExample {

    // TYPE 1: No Parameters, No Return Type
    public void greet() {
        // Simply prints a greeting message
        System.out.println("Hello!");
    }

    // TYPE 2: Has Parameters, No Return Type
    public void displayAge(int age) {
        // Takes an age parameter and displays it
        System.out.println("Age: " + age);
    }

    // TYPE 3: No Parameters, Has Return Type
    public int getRandom() {
        // Generates a random number between 0-99
        return (int)(Math.random() * 100);
    }

    // TYPE 4: Has Parameters, Has Return Type
    public int add(int a, int b) {
        int sum = a + b;
        return sum;
    }


    public static void main(String[] args) {
        MethodTypesExample obj = new MethodTypesExample();

        System.out.println("METHOD 1: No Parameters, No Return");
        obj.greet();

        System.out.println("\nMETHOD 2: Has Parameters, No Return");
        obj.displayAge(25);

        System.out.println("\nMETHOD 3: No Parameters, Has Return");
        int randomNum = obj.getRandom();
        System.out.println("Random number: " + randomNum);

        System.out.println("\nMETHOD 4: Has Parameters, Has Return");
        int result = obj.add(5, 3);
        System.out.println("Sum: " + result);

    }
}
