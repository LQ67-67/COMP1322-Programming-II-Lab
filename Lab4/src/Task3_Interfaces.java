interface Vehicle {
    void start(); // every class implementing Vehicle MUST define start()
    void stop(); // same for stop()
}

class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }
}

class Hyundai implements Vehicle {
    @Override
    public void start() {
        System.out.println("Your Hyundai Elantra 1.8 cc Sports is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Your Hyundai Elantra 1.8 cc Sports is stopping...");
    }
}

class Truck implements Vehicle {
    @Override
    public void start() {
        System.out.println("Truck is starting...");
    }
    @Override
    public void stop() {
        System.out.println("Truck is stopping...");
    }
}

public class Task3_Interfaces {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car(),    // vehicle reference pointing to a Car object
            new Hyundai(), // pointing to my Hyundai object
            new Truck(),   // pointing to a Truck object
        };

        // loop through all vehicles and call their start and stop methods
        for (Vehicle v : vehicles) {
            v.start();
            v.stop();
            System.out.println("---");
        }
    }
}
