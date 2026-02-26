import java.util.ArrayList; // using ArrayList<>

public class UserGroup {

    private ArrayList<User> users; // Private dynamic list (ArrayList) that stores User objects

    public UserGroup() {
        users = new ArrayList<>(); // creating an empty list
    }

    public void addSampleData() {
        users.add(new User("fj3", "user",   "Francis")); // Creates a User object inline and adds it to the list, index 0
        users.add(new User("amn", "admin",  "Amna")); // Admin user, index 1
        users.add(new User("cm2", "admin",  "Cameron")); // Admin user, index 2
        users.add(new User("pm5", "editor", "Peter")); // Editor user, index 3
    }

    public User getUser(int index) {
        return users.get(index); // retrieving the element at the given index 0
    }

    public void printUsernames() {
        for (User u : users) {    // 'u' is a temporary variable referencing each User in turn
            System.out.println(u.getUsername() + " " + u.getUserType()); // Concatenates username and userType with a space
        }
    }

    public void removeUser(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
        // 'removeIf' goes through each element and removes it if the lambda (condition) returns true
        // 'user ->' declares a lambda parameter named 'user' (each element in the list)
        // '.equals()' performs a content comparison; '==' would compare object references, not string values
    }

    public ArrayList<User> getUsers() {
        return users; // Returns the reference to the internal ArrayList
    }
}
