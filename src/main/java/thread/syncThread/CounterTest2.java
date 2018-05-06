package thread.syncThread;

/**
 * Created by zhangying on 2017/11/26.
 */
public class CounterTest2  {
    public static void main(String[] args) {
        Counter2 counter = new Counter2();
        Thread thread1 = new Thread(counter, "A");
        Thread thread2 = new Thread(counter, "B");
        thread1.start();
        thread2.start();
    }
}


class Counter2 implements Runnable{
    private Object lock = new Object();
    private int count;

    public Counter2() {
        count = 0;
    }

    public void countAdd() {
            for (int i = 0; i < 10; i ++) {
                synchronized(lock) {
                    try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    lock.notify();
                    lock.wait();
                   // Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
    public void printCount() {
            for (int i = 0; i < 10; i++) {
                synchronized(lock) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " count:" + count);
                        lock.notify();
                        lock.wait();
                   // Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("A")) {
            countAdd();
        } else if (threadName.equals("B")) {
            printCount();
        }
    }
}

