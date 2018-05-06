package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangying on 2017/11/17.
 */
public class ThreadPoolJeffTest {

    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<Runnable>(8);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, arrayBlockingQueue);

        for (int i = 0; i < 40; i++) {
          JeffThread jeffThread = new JeffThread(i);
          threadPoolExecutor.execute(jeffThread);
            System.out.println("线程池中现在的线程数目是"+ threadPoolExecutor.getPoolSize()+ ";   队列中等待执行的任务数是" + threadPoolExecutor.getQueue().size());
        }

        System.out.println("ii线程池中现在的线程数目是"+ threadPoolExecutor.getPoolSize()+ ";   队列中等待执行的任务数是" + threadPoolExecutor.getQueue().size());


        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        threadPoolExecutor.shutdownNow();
        System.out.println("uu线程池中现在的线程数目是"+ threadPoolExecutor.getPoolSize()+ ";   队列中等待执行的任务数是" + threadPoolExecutor.getQueue().size());
        threadPoolExecutor.shutdownNow();
        System.out.println("vv线程池中现在的线程数目是"+ threadPoolExecutor.getPoolSize()+ ";   队列中等待执行的任务数是" + threadPoolExecutor.getQueue().size());

    }
}
