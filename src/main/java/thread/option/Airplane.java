package thread.option;

public class Airplane {
    private String name;

    public Airplane(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void takeTarmac(Airport airport) {
        airport.decreaseCountFreeStrip(this);
        System.out.println("Самолет " + this.getName() + " начал выход на полосу");
    }

    public void freeTarmac(Airport airport) {
        airport.increaseCountFreeStrip();
        System.out.println("Самолет " + this.getName() + " взлетел");
    }

    public void fly(Airport airport) {
        new Thread(() -> {
            this.takeTarmac(airport);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.freeTarmac(airport);
        }
        ).start();
    }
}
