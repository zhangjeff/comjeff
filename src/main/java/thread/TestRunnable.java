package thread;

/**
 * Created by zhangying on 2017/11/16.
 */
public class TestRunnable {

    public static void main(String[] args) {
        System.out.println("hi");

        Runnable myRunnable = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };



    }
}
