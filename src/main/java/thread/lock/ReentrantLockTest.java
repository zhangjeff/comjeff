package thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangying on 2017/11/22.
 */
public class ReentrantLockTest {

    static int  count = 0;


    public static void main(String[] args) {
        System.out.println("22222");
        Thread[] threads = new Thread[50000];

        ReentrantLock lock = new ReentrantLock();

        for (int i=0; i <50000; i++) {
             threads[i] = new Thread(new Runnable() {
                public void run() {
                    addCount(Thread.currentThread());
                }
            }, i+"");

             threads[i].start();
        }



        for (int i=0; i<50000; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("the result is =" + count);
    }

    public static void addCount(Thread thread){
        count++;
        System.out.println(thread.getName() + "count=" + count);
    }
}
