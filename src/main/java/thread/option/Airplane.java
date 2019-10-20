package thread.option;

public class Airplane {
    private String name;
    private final static int TIME_FOR_ACTION = 3000;
    private final static  String AIRPLANE_REPRESENTATION = "Airplane ";

    public Airplane(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void takeTarmac(Airport airport) {
        airport.decreaseCountFreeStrip(this);
        System.out.println(AIRPLANE_REPRESENTATION + this.getName() +
                " begins output on the strip");
    }

    private void freeTarmac(Airport airport) {
        airport.increaseCountFreeStrip();
        System.out.println(AIRPLANE_REPRESENTATION + this.getName() + " takes off");
    }

    public void fly(Airport airport) {
        new Thread(() -> {
            this.takeTarmac(airport);
            try {
                Thread.sleep(TIME_FOR_ACTION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.freeTarmac(airport);
        }
        ).start();
    }
}

