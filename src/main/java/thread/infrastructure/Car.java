package thread.infrastructure;

public class Car {
    private String name;
    private final static  String CAR_REPRESENTATION = "car ";

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean doPark(ParkingPlace parking) {
        if (parking.checkFreePlace()) {
            parking.reduceCountOfPlaceFree();
            System.out.println(CAR_REPRESENTATION + this.getName() + " parked");
            return true;
        } else {
            System.out.println(CAR_REPRESENTATION + this.getName() + " has gone: " +
                    "timed out.");
            return false;
        }
    }

    private void goOut(ParkingPlace parking) {
        parking.increaseCountOfPlaceFree();
        System.out.println(CAR_REPRESENTATION + this.getName() + " has gone.");
    }

    public void drive(ParkingPlace parking, long timeWaiting) {
        new Thread(() -> {
            if (!doPark(parking)) {
                return;
            }
            try {
                Thread.sleep(timeWaiting);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.goOut(parking);
        }).start();
    }
}