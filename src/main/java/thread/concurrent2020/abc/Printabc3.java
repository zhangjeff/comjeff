package thread.concurrent2020.abc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Printabc3 {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {

        char[] aa = "ABCDEFG".toCharArray();
        char[] bb = "1234567".toCharArray();

        Lock lock = new ReentrantLock();
        Condition lockA = lock.newCondition();
        Condition lockB = lock.newCondition();

        t1 = new Thread(() -> {
            try {
                lock.lock();
                for (char a : aa) {
                    System.out.print(a);
                    lockB.signal();
                    lockA.await();
                }
                lockB.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });


        t2 = new Thread(() -> {
            try {
                lock.lock();
                for (char b : bb) {
                    System.out.print(b);
                    lockA.signal();
                    lockB.await();
                }
                lockA.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        t2.start();
    }
}
