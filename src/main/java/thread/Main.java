package thread;

public class Main {
    final static long timeBetweenNextCar = 1400;
    final static long timeWaitingForToyota = 1300;
    final static long timeWaitingForHonda = 1400;
    final static long timeWaitingForBMW = 1500;
    final static long timeWaitingForMazda = 2000;

    public static void main(String args[]) throws InterruptedException {
        ParkingPlace parking = new ParkingPlace();
        Car toyota = new Car("Toyota");
        Car honda = new Car("Honda");
        Car bmw = new Car("BMW");
        Car mazda = new Car("Mazda");

        toyota.drive(parking, timeWaitingForToyota);
        honda.drive(parking, timeWaitingForHonda);
        Thread.sleep(timeBetweenNextCar);
        bmw.drive(parking, timeWaitingForBMW);
        mazda.drive(parking, timeWaitingForMazda);

    }
}