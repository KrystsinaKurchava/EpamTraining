package thread.option;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Airport {
    public Airport(int countFreeStrip) {
        this.countFreeStrip = countFreeStrip;
    }

    private int countFreeStrip;
    private ReentrantLock lockStrip = new ReentrantLock(true);
    private Condition freeSignal = lockStrip.newCondition();

    public void increaseCountFreeStrip() {
        lockStrip.lock();
        try {
            System.out.println("Полоса " + countFreeStrip + "  освободилась");
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
                System.out.println("Ожидание пустого места");
                freeSignal.await();
            }
            System.out.println("Полоса " + countFreeStrip + " приняла самолет " + airplane.getName());
            countFreeStrip--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lockStrip.unlock();
        }
    }
}