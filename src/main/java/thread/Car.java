package thread;

class Car {
    private String name;
Car(String name){this.name=name;}

    public String getName() {
        return name;
    }

    public boolean doPark(ParkingPlace parking) {
        if (parking.checkFreePlace(this)) {
            parking.reduceCountOfPlaceFree();
            System.out.println("машина " + this.getName() +" припарковлась");
            return  true;
        } else {
            System.out.println("машина "+ this.getName() + " уехала, не дождавшись места");
            return false;
        }
    }

    public void goOut(ParkingPlace parking) {
        parking.increaseCountOfPlaceFree();
        System.out.println("машина "+ this.getName() +" уехала со стоянки");
    }
}



