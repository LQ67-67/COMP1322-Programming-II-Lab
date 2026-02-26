public class SmartCard {
    private String ownerName; // stores the full name of the card owner
    private boolean isStaff; // true if the cardholder is staff, false if student

    public SmartCard(String ownerName) {
        this.ownerName = ownerName; // 'this.ownerName' refers to the field, 'ownerName' (right) is the parameter
        this.isStaff = false; // Every new card defaults to student status
    }

    public String getOwner() {
        return ownerName; // Returns the stored owner name string to the caller
    }

    public boolean isStaff() {
        return isStaff; // Returns the current boolean value of the isStaff field
    }

    public void setStaff(boolean isStaff) {
        this.isStaff = isStaff; // 'this.isStaff' is the field, 'isStaff' (right) is the method parameter, 'this' distinguishes them
    }
}
