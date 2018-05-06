package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zhangying on 2017/5/6.
 */
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        final ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
        final Lock readLock = rwlock.readLock();
        final Lock writeLock = rwlock.writeLock();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                readLock.lock();
                System.out.println("t1开始");
                try {

                    Thread.sleep(1000);
                    System.out.println("t1结束");
                } catch (Exception e) {

                    e.printStackTrace();
                } finally {
                    readLock.unlock();
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                readLock.lock();
                System.out.println("t2开始");
                try {

                    Thread.sleep(1000);
                    System.out.println("t2结束");
                } catch (Exception e) {

                    e.printStackTrace();
                } finally {
                    readLock.unlock();
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }

}