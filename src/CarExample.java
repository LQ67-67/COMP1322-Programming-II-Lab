class Car {
    String brand;
}

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.brand = "Honda";

        System.out.println("Car brand: " + myCar.brand);
    }
}
