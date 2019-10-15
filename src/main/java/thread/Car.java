package thread;

class Car {
    private String name;

    Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean doPark(ParkingPlace parking) {
        if (parking.checkFreePlace(this)) {
            parking.reduceCountOfPlaceFree();
            System.out.println("машина " + this.getName() + " припарковлась");
            return true;
        } else {
            System.out.println("машина " + this.getName() + " уехала, не дождавшись места");
            return false;
        }
    }

    public void goOut(ParkingPlace parking) {
        parking.increaseCountOfPlaceFree();
        System.out.println("машина " + this.getName() + " уехала со стоянки");
    }

    public void drive(ParkingPlace parking, long timeWaiting) {
        new Thread(() -> {
            if (this.doPark(parking) == false) {
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



