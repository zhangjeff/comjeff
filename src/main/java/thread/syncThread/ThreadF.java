package thread.syncThread;

/**
 * Created by zhangying on 2017/12/8.
 */
public class ThreadF {

    public static void main(String[] args) {
        final Object object = new Object();
        Thread t1 = new Thread() {
            public void run()
            {
                for (int i=0; i < 10; i++) {
                    synchronized (object) {
                        System.out.println("T1 start!");
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("T1 end!");
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            public void run()
            {
                   for (int i=0; i<10;i++) {
                       synchronized (object) {
                        System.out.println("T2 start!");
                              object.notify();
                           try {
                               object.wait();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                        System.out.println("T2 end!");
                    }
                }
            }
        };

        t1.start();
        t2.start();

    }
}
