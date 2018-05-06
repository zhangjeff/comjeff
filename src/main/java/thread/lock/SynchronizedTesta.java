package thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangying on 2017/11/24.
 */
public class SynchronizedTesta {
    public static void main(String[] args) {
        //线程数
        int threadNum = 5;
        final Synb syn = new Synb();
        Thread[] threads = new Thread[threadNum];
        //记录运行时间
        long l = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 10000000; j++) {
                        syn.increase();
                    }
                }
            });
            threads[i].start();
        }
        //等待所有线程结束
        try {
            for (int i = 0; i < threadNum; i++)
                threads[i].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(syn + " : " + (System.currentTimeMillis() - l) + "ms");
    }

}


class Synb {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    //利用synchronized
    public void increase() {
        synchronized (this) {
            count++;
        }
    }

    //利用ReentrantLock类同步
    public void increaseLock() {
//        lock.lock();
//        if (count == 5000000)
//            System.out.println(lock);
        count++;
//        lock.unlock();
    }

    public void increaseVolatile() {
        count = count + 1;
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}

