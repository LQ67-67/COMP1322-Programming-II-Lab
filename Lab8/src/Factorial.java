public class Factorial {
    public long factorialRecursive(int n) {
        if (n <= 1) {
            return 1; // factorial of 0 or 1 is 1
        }
        return n * factorialRecursive(n - 1); // n! = n × (n-1)!
    }

    public long factorialIterative(int n) {
        long result = 1; // start with 1
        for (int i = 2; i <= n; i++) {
            result *= i; // multiply result by each number from 2 up to n
        }
        return result;
    }

    public static void main(String[] args) {
        Factorial f = new Factorial();

        System.out.println("Recursive 10! = " + f.factorialRecursive(10));
        System.out.println("Iterative 10! = " + f.factorialIterative(10));
        System.out.println("Iterative 20! = " + f.factorialIterative(20));
    }
}