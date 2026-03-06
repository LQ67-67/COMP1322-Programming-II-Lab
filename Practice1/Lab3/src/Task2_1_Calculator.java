public class Task2_1_Calculator {

    int add(int a, int b) {
        return a + b; // just add them and return the result
    }

    double add(double a, double b) {
        return a + b; // add them and return the result
    }

    String add(String a, String b) {
        return a + b; // joins strings together
    }

    public static void main(String[] args) {
        Task2_1_Calculator calc = new Task2_1_Calculator(); // create a Calculator object

        int result1 = calc.add(6, 7); // call the int version
        System.out.println("int add: " + result1);

        double result2 = calc.add(6.6, 7.7); // call the double version
        System.out.println("double add: " + result2);

        String result3 = calc.add("Hello!", " I am a Year 1 student at the University of Southampton"); // call the String version
        System.out.println("String add: " + result3);
    }
}
