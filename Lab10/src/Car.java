public class Car extends Thread {
    private String plate;
    private ParkingLot parkingLot;

    public Car(String plate, ParkingLot parkingLot) {
        this.plate = plate;
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        try {
            parkingLot.parkCar(plate); // parking
        } catch (InterruptedException e) {
            System.out.println("Car " + plate + " was interrupted.");
        }
    }
}