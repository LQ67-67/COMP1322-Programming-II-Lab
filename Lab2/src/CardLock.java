public class CardLock { // Public class to be used by Door, Simulation

    private SmartCard lastCardSeen; // Private field to hold a reference to the most recently swiped SmartCard object
    private boolean allowStudents;  // students can unlock the door when true

    public CardLock() {
        this.allowStudents = false; // Only staff may unlock by default; students are blocked until toggleStudentAccess() is called
    }

    // Stores the reference to the passed SmartCard so isUnlocked() can check it later
    public void swipeCard(SmartCard card) {
        this.lastCardSeen = card; // Overwrites any previously swiped card; only the LAST card matters for unlock checks
    }

    public SmartCard getLastCardSeen() {
        return lastCardSeen; // Returns the reference to the last SmartCard
    }

    public void toggleStudentAccess() {
        allowStudents = !allowStudents; // inverts the current value
    }

    public boolean isUnlocked() {
        // First check: impossible to get a NullPointerException if no card was swiped yet
        // Second check (inside parentheses): uses || (OR) so EITHER condition being true is enough to unlock
        return lastCardSeen != null && (lastCardSeen.isStaff() || allowStudents);
        // guard against null / staff card grants access / student access mode also grants access
    }
}
