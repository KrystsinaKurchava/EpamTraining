package threads;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        ParkingPlace parking = new ParkingPlace();
        Car a = new Car();
        Car b = new Car();
        Car c = new Car();
        Car d = new Car();
        new Thread(() -> {
            if (a.doPark(parking) == false) {
                return;
            }
            ;
            try {
                Thread.sleep(1300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.goOut(parking);
        }).start();


        new Thread(() -> {
            if (b.doPark(parking) == false) {
                return;
            }
            ;
            try {
                Thread.sleep(1400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b.goOut(parking);
        }).start();

        new Thread(() -> {
            if (c.doPark(parking) == false) {
                return;
            }
            ;
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.goOut(parking);
        }).start();
        Thread.sleep(1400);
        new Thread(() -> {
            if (d.doPark(parking) == false) {
                return;
            }
            ;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            d.goOut(parking);
        }).start();
    }
}
