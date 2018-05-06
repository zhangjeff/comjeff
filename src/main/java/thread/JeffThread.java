package thread;

/**
 * Created by zhangying on 2017/11/17.
 */
public class JeffThread implements Runnable{

    private int number;

    public JeffThread(int number){
        this.number = number;

    }
    public void run() {
        System.out.println("正在执行第" +number+"线程");
        try {
            Thread.currentThread().sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("第" +number+"个线程执行完毕！");
    }
}

