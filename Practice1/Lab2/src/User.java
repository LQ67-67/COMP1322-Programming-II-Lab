public class User {

    private String username; // unique login identifier for this user
    private String userType; // "user", "editor", "admin"
    private String name; // human-readable display name of this user

    public User(String username, String userType, String name) {
        this.username = username; // Assigns the constructor parameter 'username' to the instance field 'this.username'
        this.userType = userType; // Assigns 'userType' parameter to the instance field; 'this.' distinguishes field from parameter
        this.name = name; // Assigns 'name' parameter to the instance field 'this.name'
    }

    public String getUsername() {

        return username; // Returns the stored username
    }

    public String getUserType() {

        return userType; // Returns the stored userType
    }

    public String getName() {
        return name; // Returns the stored name string
    }

    public void setUserType(String userType) {
        this.userType = userType; // Overwrites the current role; 'this.userType' = field, 'userType' = parameter
    }
}
