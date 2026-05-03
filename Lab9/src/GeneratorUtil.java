import java.util.Random;

public class GeneratorUtil {
    private static Random random = new Random();  // random object shared by all methods

    private static char[] consonants = "bcdfghjklmnpqrstvwxyz".toCharArray();
    private static char[] vowels = "aeiou".toCharArray();
    private static String[] departments = {"IT", "HR", "Developer", "Stores", "Finance", "Non-IT", "Admin"};

    public static String randomName() {
        char c1 = consonants[random.nextInt(consonants.length)];
        char v  = vowels[random.nextInt(vowels.length)];
        char c2 = consonants[random.nextInt(consonants.length)];
        return Character.toUpperCase(c1) + "" + v + c2; // capitalize first letter, lowercase the rest
    }

    public static int randomId() {
        String id = "";
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                int[] odds = {1, 3, 5, 7, 9};
                id += odds[random.nextInt(odds.length)]; //even position become odd digit
            } else {
                int[] evens = {0, 2, 4, 6, 8};
                id += evens[random.nextInt(evens.length)]; // odd position become even digit
            }
        }
        return Integer.parseInt(id); // convert string to int
    }

    public static double randomSalary() {
        return 4000 + random.nextInt(6000);  // generate a random salary between 4000 and 9999
    }

    public static String randomDepartment() {
        return departments[random.nextInt(departments.length)]; // pick a random department
    }

    public static String randomPassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += chars.charAt(random.nextInt(chars.length())); // pick a random character
        }
        return password; // generate random 8 character password
    }
}