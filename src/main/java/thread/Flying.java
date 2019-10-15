package thread;

import thread.option.Airplane;
import thread.option.Airport;

public class Flying {
    final static int countFreeStrip = 5;
    final static int countAirplane = 10;

    public static void main(String args[]) {
        Airport airport = new Airport(countFreeStrip);
        for (int i = 0; i <= countAirplane; i++) {
            new Airplane("Boeing-" + i).fly(airport);
        }
    }
}
