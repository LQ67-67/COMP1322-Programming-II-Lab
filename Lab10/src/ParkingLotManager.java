public class ParkingLotManager extends Thread {
    private ParkingLot parkingLot;
    private int totalCars;

    public ParkingLotManager(ParkingLot parkingLot, int totalCars) {
        this.parkingLot = parkingLot;
        this.totalCars = totalCars;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < totalCars; i++) {
                parkingLot.removeFirstCar(); // remove the first car when the lot is full
            }
        } catch (InterruptedException e) {
            System.out.println("Manager was interrupted.");
        }
    }
}