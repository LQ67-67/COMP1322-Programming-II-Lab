public class Simulation {
    public static void main(String[] args) {
        Door researchLab = new Door("Research Labs");  // Create a Door object, the Door constructor also creates a default CardLock

        CardLock labLock = new CardLock(); // Constructs a new CardLock with allowStudents = false by default

        researchLab.attachLock(labLock); // Passes the labLock reference to the Door; Door and Simulation now share the SAME CardLock object

        SmartCard studentCard = new SmartCard("Student A"); // Constructor sets isStaff = false
        SmartCard staffCard   = new SmartCard("Staff B");   // Also starts as false; we must explicitly promote it to staff below

        staffCard.setStaff(true); // Sets isStaff field inside staffCard to true; this card can now unlock staff-only doors

        labLock.swipeCard(studentCard); // Registers studentCard as the lastCardSeen on the CardLock
        System.out.println("Door Open (Student)? " + researchLab.openDoor());
        // openDoor() to lock.isUnlocked() to studentCard.isStaff() returns false AND allowStudents is false so that it will return false

        labLock.swipeCard(staffCard); // Overwrites lastCardSeen with staffCard
        System.out.println("Door Open (Staff)? " + researchLab.openDoor());
        // openDoor() to lock.isUnlocked() to staffCard.isStaff() returns true so that overall returns true
    }
}
