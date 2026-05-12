import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter parking lot size (number of slots): ");
        int lotSize = scanner.nextInt();

        System.out.print("Enter number of incoming cars to simulate: ");
        int totalCars = scanner.nextInt();
        ParkingLot parkingLot = new ParkingLot(lotSize);
        ParkingLotManager manager = new ParkingLotManager(parkingLot, totalCars);
        manager.start(); // manager thread begins monitoring

        Random random = new Random();

        for (int i = 0; i < totalCars; i++) {
            String plate = generatePlate(random);
            Car car = new Car(plate, parkingLot);
            car.start(); // start parking
            Thread.sleep(random.nextInt(500)); // waiting 500ms
        }
        manager.join();
        scanner.close();

        System.out.println("Simulation complete.");
    }

    public static String generatePlate(Random random) {
        String letters = "";
        for (int i = 0; i < 3; i++) {
            char letter = (char) ('A' + random.nextInt(26));
            letters = letters + letter; // combine all the letters together
        }
        int number = 100 + random.nextInt(900);

        return letters + number;
    }
}