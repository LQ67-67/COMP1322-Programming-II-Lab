import java.util.Scanner;

public class ArrayManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input N with validation
        int n = 0;
        while (n < 1 || n > 10) {
            System.out.print("Enter size (1-10): ");
            n = scanner.nextInt();
        }
        scanner.nextLine(); // make sure to consume the newline after nextInt(), because first time program didn't run correctly due to this issue

        // read N integers from one line
        System.out.print("Enter " + n + " integers: ");
        String[] strings = scanner.nextLine().trim().split("\\s+");
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(strings[i]);
        }

        System.out.println("Length of A=" + n);

        // resize array
        A = resizeArray(A, n);
        System.out.println("Length of A=" + A.length);

        reverseAndPrint(A, n); // reverse first N elements and print

        scanner.close();
    }

    static int[] resizeArray(int[] A, int n) {
        int newSize = (n < 10) ? 10 : 15;
        int[] newA = new int[newSize];
        for (int i = 0; i < n; i++) {
            newA[i] = A[i];
        }
        return newA;
    }

    static void reverseAndPrint(int[] A, int n) {
        for (int i = 0; i < n / 2; i++) {
            int temp = A[i];
            A[i] = A[n - 1 - i];
            A[n - 1 - i] = temp;
        }

        System.out.print("Reversed Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(A[i]);
            if (i < n - 1) System.out.print(",");
        }
        System.out.println();
    }
}