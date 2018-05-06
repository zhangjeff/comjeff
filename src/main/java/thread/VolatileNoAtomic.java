package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangying on 2017/4/23.
 */
public class VolatileNoAtomic extends Thread {
    //private static volatile int count;
    private  static AtomicInteger count= new AtomicInteger();

    private static void addCount() {
        for (int i = 0; i < 10000; i++) {
          //  count++;
            count.incrementAndGet();
        }
        /*try{
            Thread.sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(count);
    }

    public void run() {
        addCount();
    }

    public static void main(String[] args) {
        VolatileNoAtomic[] arr = new VolatileNoAtomic[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new VolatileNoAtomic();
        }

        for (int i = 0; i < 10; i++) {
            arr[i].start();
        }
    }
}
