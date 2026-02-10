public class TypeCastingExamples {
    public static void main(String[] args) {
        // Example 1: int to double (from lecture)
        int myInt = 9;
        double myDouble = myInt;
        System.out.println("int: " + myInt);
        System.out.println("double: " + myDouble);

        System.out.println("\nCustom Example: byte - int - double");

        // Example 2: byte to int to double
        byte smallNumber = 10;
        int mediumNumber = smallNumber;
        double largeNumber = mediumNumber;

        System.out.println("byte: " + smallNumber);
        System.out.println("int: " + mediumNumber);
        System.out.println("double: " + largeNumber);

        System.out.println("\nNARROWING (EXPLICIT CASTING)");

        // Example 3: double to int (from lecture)
        double myDouble2 = 9.78;
        int myInt2 = (int) myDouble2;
        System.out.println("double: " + myDouble2);
        System.out.println("int: " + myInt2);

        System.out.println("\nCustom Example: double - int - byte");

        // Example 4: double to int to byte
        double decimalNumber = 125.99;
        int wholeNumber = (int) decimalNumber;
        byte tinyNumber = (byte) wholeNumber;

        System.out.println("double: " + decimalNumber);
        System.out.println("int: " + wholeNumber);
        System.out.println("byte: " + tinyNumber);

        System.out.println("\nExample showing DATA LOSS");

        // Example 5: Overflow when value is too large
        double largeValue = 300.75;
        byte smallValue = (byte) largeValue;
        System.out.println("double: " + largeValue);
        System.out.println("byte: " + smallValue);

        // Explanation of overflow
        System.out.println("\nWhy 44? Because 300 % 256 = 44 (byte wraps around)");

        System.out.println("\nNotes:");
        System.out.println("1. Widening: Safe, automatic (byte→short→int→long→float→double)");
        System.out.println("2. Narrowing: Requires explicit cast, may lose data");
        System.out.println("3. Float to int: Decimal part is TRUNCATED (not rounded)");
        System.out.println("4. Overflow: Value too large causes wrap-around");
    }
}
