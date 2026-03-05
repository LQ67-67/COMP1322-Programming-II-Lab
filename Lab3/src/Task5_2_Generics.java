import java.util.ArrayList; // need ArrayList

public class Task5_2_Generics {

    public static void main(String[] args) {
        ArrayList listWithoutGenerics = new ArrayList(); // no type specified
        listWithoutGenerics.add("Hello"); // add a String
        listWithoutGenerics.add(123); // add an Integer
        listWithoutGenerics.add(3.14); // add a Double

        System.out.println("Without generics list: " + listWithoutGenerics);

        try {
            String s = (String) listWithoutGenerics.get(1); // get(1) is 123 (an Integer) but I try to cast it to String
        } catch (ClassCastException e) {
            System.out.println("Runtime error: " + e.getMessage()); // catch the crash
        }

        System.out.println("---");

        ArrayList<String> listWithGenerics = new ArrayList<>(); // only Strings allowed
        listWithGenerics.add("Hello");
        listWithGenerics.add("World");

        System.out.println("With generics list: " + listWithGenerics);

        // No casting needed due to it is always a String
        String s = listWithGenerics.get(0);
        System.out.println("First item: " + s);
    }
}
