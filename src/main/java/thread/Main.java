package thread;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        ParkingPlace parking = new ParkingPlace();
        Car toyota = new Car("Toyota");
        Car honda = new Car("Honda");
        Car bmw = new Car("BMW");
        Car mazda = new Car("Mazda");
        new Thread(() -> {
            if (toyota.doPark(parking) == false) {
                return;
            }
            try {
                Thread.sleep(1300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            toyota.goOut(parking);
        }).start();

        new Thread(() -> {
            if (honda.doPark(parking) == false) {
                return;
            }
            try {
                Thread.sleep(1400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            honda.goOut(parking);
        }).start();

        new Thread(() -> {
            if (bmw.doPark(parking) == false) {
                return;
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bmw.goOut(parking);
        }).start();
        Thread.sleep(1400);
        new Thread(() -> {
            if (mazda.doPark(parking) == false) {
                return;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mazda.goOut(parking);
        }).start();
    }
}
