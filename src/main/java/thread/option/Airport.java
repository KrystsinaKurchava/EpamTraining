package thread.option;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Airport {
    private int countFreeStrip;
    private ReentrantLock lockStrip = new ReentrantLock(true);
    private Condition freeSignal = lockStrip.newCondition();
    private final static String STRIP_REPRESENTATION = "Strip ";

    public Airport(int countFreeStrip) {
        this.countFreeStrip = countFreeStrip;
    }

    public void increaseCountFreeStrip() {
        lockStrip.lock();
        try {
            System.out.println(STRIP_REPRESENTATION + countFreeStrip + " became available");
            countFreeStrip++;
            freeSignal.signal();
        } finally {
            lockStrip.unlock();
        }
    }

    public void decreaseCountFreeStrip(Airplane airplane) {
        lockStrip.lock();
        try {
            while (this.countFreeStrip <= 0) {
                System.out.println("Waiting empty strip");
                freeSignal.await();
            }
            System.out.println(STRIP_REPRESENTATION + countFreeStrip + " was occupy by plane" +
                    airplane.getName());
            countFreeStrip--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockStrip.unlock();
        }
    }
}