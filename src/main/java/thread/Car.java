package thread;

class Car {

    public boolean doPark(ParkingPlace parking) {
        if (parking.checkFreePlace(this)) {
            parking.reduceCountOfPlaceFree();
            System.out.println("машина припарковлась");
            return  true;
        } else {
            System.out.println("машина уехала");
            return false;
        }

    }

    public void goOut(ParkingPlace parking) {

        parking.increaseCountOfPlaceFree();
        System.out.println("машина брынь уехала");
    }
}



