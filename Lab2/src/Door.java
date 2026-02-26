public class Door { // Public class to access from Simulation and other classes

    private String roomName; // stores the label/name of the room
    private CardLock lock; //controls whether this door can be opened; composition relationship

    // Automatically creates a new CardLock and assigns it to this door so the door is always ready to use
    public Door(String roomName) {
        this.roomName = roomName; // Stores the provided room name in the field
        this.lock = new CardLock(); // Creates a default CardLock
    }

    public void attachLock(CardLock lock) { // replaces the door's current CardLock with an externally created one
        this.lock = lock; // 'this.lock' is the field; 'lock' on the right is the parameter; 'this.' is needed to distinguish them
    }

    // asks the CardLock whether the door should open and returns the result
    public boolean openDoor() {
        return lock.isUnlocked(); // returns true if last card grants access
    }
}
