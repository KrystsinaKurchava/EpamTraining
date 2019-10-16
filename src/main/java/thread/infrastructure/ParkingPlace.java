package thread.infrastructure;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingPlace {
    private final static int timeForAwait = 1000;
    private int countOfPlaceFree;
    private Lock freeSpaceLocker = new ReentrantLock();
    private Condition free = freeSpaceLocker.newCondition();

    public ParkingPlace() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество пустых мест на парковке");
        this.countOfPlaceFree = in.nextInt();
    }

    public int getCountOfPlaceFree() {
        return countOfPlaceFree;
    }

    public void reduceCountOfPlaceFree() {
        freeSpaceLocker.lock();
        try {
            countOfPlaceFree = countOfPlaceFree - 1;
        } finally {
            freeSpaceLocker.unlock();
        }
    }

    public void increaseCountOfPlaceFree() {
        freeSpaceLocker.lock();
        try {
            countOfPlaceFree = countOfPlaceFree + 1;
            free.signal();
        } finally {
            freeSpaceLocker.unlock();
        }
    }

    public boolean checkFreePlace(Car car) {
        freeSpaceLocker.lock();
        try {
            if (this.getCountOfPlaceFree() > 0) {
                return true;
            }
            try {
                System.out.println("Ожидание пустого места");
                free.await(timeForAwait, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return getCountOfPlaceFree() > 0;
        } finally {
            freeSpaceLocker.unlock();
        }
    }
}
