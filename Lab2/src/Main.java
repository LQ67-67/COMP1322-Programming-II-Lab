import java.util.ArrayList; // Import ArrayList to declare the 'administrators' list

public class Main {
    public static void main(String[] args) { // initialises an empty ArrayList UserGroup
        UserGroup group = new UserGroup(); // 'group' is a reference variable pointing to the new UserGroup object on the heap

        group.addSampleData(); // Calls addSampleData() on the 'group' object to populate and adds 4 User objects to internal list

        System.out.println("All Users:");

        group.printUsernames(); // Call printUsernames() to loop through every user and print "username userType"

        ArrayList<User> administrators = new ArrayList<>(); // Declares and initialises an empty list; <User> is the generic type parameter (type-safe)

        // Loop through every User in the group's list and check if they are an admin
        for (User user : group.getUsers()) {
            if (user.getUserType().equals("admin")) {  //compares the string content of userType
                administrators.add(user); // Adds the current admin User reference to admin list
            }
        }

        System.out.println("\nAdministrators:");

        // Loop through the filtered administrators list and print each admin's username and type
        for (User admin : administrators) {
            System.out.println(admin.getUsername() + " " + admin.getUserType()); // Prints "amn admin", then "cm2 admin"
        }
    }
}

