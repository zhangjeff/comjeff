package thread.lock;

/**
 * Created by zhangying on 2017/11/22.
 */
public class ThreadJoinTest {




    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("hi jeff1");
            }
        });



        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hi jeff2");

    }
}
