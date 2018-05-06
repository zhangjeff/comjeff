package thread;

/**
 * Created by zhangying on 2017/8/12.
 */
public class DeadLock {


    private String aa = "this is lock";

    private String bb = "this is lock 2";


    public  void asctest(){
         synchronized (aa) {
             System.out.println("point 1");
             synchronized (bb) {
                 System.out.println("point 2");
             }
         }
    }

    public  void desctest(){
        synchronized (bb) {
            System.out.println("point 3");
            synchronized (aa) {
                System.out.println("point 4");
            }
        }
    }


    public static void main(String[] args) {

        final DeadLock deadLock = new DeadLock();

        Thread thread1 = new Thread(
                new Runnable() {
                    public void run() {
                        deadLock.asctest();
                    }
                }
        );


        Thread thread2 = new Thread(
                new Runnable() {
                    public void run() {
                        deadLock.desctest();
                    }
                }
        );


        thread1.start();
        thread2.start();

       System.out.println("This is jeff!");
    }
}
