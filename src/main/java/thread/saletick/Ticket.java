package thread.saletick;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangying on 2017/11/24.
 */
public class Ticket implements Runnable {
    int num = 100;// 票数
    Object obj = new Object();

    public void run() {
        // 不停地卖票
        while (true) {
            sale();
        }
    }

    /**
     * 卖票，每调用一次，卖一张票
     */
    //同步方法，其实就是同步代码块的简写方式
    public  synchronized void sale() {
        // 同步代码块，同一时间只能有一个线程进行执行里面的代码
//               synchronized (this) {// 同步锁,每个对象都可以作为同步锁进行使用(可用任何对象)

        if (num > 0) {
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName()
                        +"...sale..." + num--);
            } catch(InterruptedException e) {
                //TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

//               }
    }
}
