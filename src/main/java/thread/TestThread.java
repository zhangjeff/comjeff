package thread;

/**
 * Created by zhangying on 2017/5/21.
 */
public class TestThread {
    public static void main(String args[]) {

        Thread t = new Thread() {

            public void run() {
                pong();
            }
        };

        //t.start();
        t.run();
        System.out.print("ping");

    }

    static void pong() {

        System.out.print("pong");

    }
}
