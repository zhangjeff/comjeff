package thread;

/**
 * Created by zhangying on 2017/7/8.
 */
public class TestThread1 {

    public void getNum() {
        final int aa = 0;
        Thread t1 = new Thread(new Runnable() {
            public void run() {
//                aa++;
            }
        });
    }


    public static void main(String[] args) {
        int aa = 0;

        Thread t1 = new Thread(
                new Runnable() {
                    public void run() {
                        while(true){
//                            System.out.println("t1 a=" + aa);

                        }
                    }
                }
        );

        t1.start();

        Thread t2 = new Thread(
                new Runnable() {
                    public void run() {
                        while(true) {
                            System.out.println("22222");
                        }
                    }
                }
        );

        t2.start();


    }
}
