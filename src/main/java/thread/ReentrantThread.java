package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangying on 2017/5/4.
 */
public class ReentrantThread {

    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                lock.lock();
                try {
                    System.out.println("进入t1线程");
                    condition.await();
                    Thread.sleep(5000);
                    System.out.println("线程t1结束");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "t1"
        );

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                lock.lock();
                try {
                    System.out.println("进入t2线程");
                    condition.signal();
                    Thread.sleep(5000);
                    System.out.println("线程t2结束");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
         }, "t2"
        );

        t1.start();
        t2.start();
    }

}
