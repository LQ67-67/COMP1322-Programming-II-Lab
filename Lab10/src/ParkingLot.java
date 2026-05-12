import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<String> parkedCars = new ArrayList<>();
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void parkCar(String plate) throws InterruptedException {
        while (parkedCars.size() >= capacity) {
            wait(); // if the lot is full, the car thread must wait until a spot is freed
        }

        parkedCars.add(plate); // add the car to the space
        System.out.println("Car " + plate + " parked.");

        notifyAll(); // wake up all waiting threads
    }

    public synchronized void removeFirstCar() throws InterruptedException {
        while (parkedCars.size() < capacity) {
            wait(); // if the lot is not full, the manager waits(no need to remove anyone
        }

        String removed = parkedCars.remove(0);
        System.out.println("Manager removed car: " + removed);

        notifyAll();
    }
}