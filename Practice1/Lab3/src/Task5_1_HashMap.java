import java.util.HashMap; // HashMap

public class Task5_1_HashMap {

    public static void main(String[] args) {
        HashMap<String, Integer> ages = new HashMap<>();  // create a HashMap to stores pairs of (key, value)

        // Add key and value
        ages.put("Max", 20);
        ages.put("Lando", 25);
        ages.put("Charlies", 22);

        // Retrieve a value using the key
        int maxAge = ages.get("Max"); // get Max's age
        System.out.println("Max's age: " + maxAge);

        System.out.println("All entries:");
        for (String name : ages.keySet()) { // gives us all keys
            System.out.println(name + " is " + ages.get(name));
        }
    }
}
