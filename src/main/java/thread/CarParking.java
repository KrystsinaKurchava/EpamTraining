package thread;

import thread.infrastructure.Car;
import thread.infrastructure.ParkingPlace;

public class CarParking {
   private final static long TIME_BETWEEN_NEXT_CAR = 1400;
    private final static long TIME_WAITING_FOR_TOYOTA = 1300;
    private final static long TIME_WAITING_FOR_HONDA = 1400;
    private final static long TIME_WAITING_FOR_BMW = 1500;
    private final static long TIME_WAITING_FOR_MAZDA = 2000;

    public static void main(String[] args) throws InterruptedException {
        ParkingPlace parking = new ParkingPlace();
        Car toyota = new Car("Toyota");
        Car honda = new Car("Honda");
        Car bmw = new Car("BMW");
        Car mazda = new Car("Mazda");

        toyota.drive(parking, TIME_WAITING_FOR_TOYOTA);
        honda.drive(parking, TIME_WAITING_FOR_HONDA);
        Thread.sleep(TIME_BETWEEN_NEXT_CAR);
        bmw.drive(parking, TIME_WAITING_FOR_BMW);
        mazda.drive(parking, TIME_WAITING_FOR_MAZDA);
    }
}