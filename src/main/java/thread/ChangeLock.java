package thread;

/**
 *
 * 待完成
 * Created by zhangying on 2017/4/23.
 */
public class ChangeLock {

    private String lock = "lock";

    private void method(){
        synchronized (lock) {
            try{
                System.out.println("当前线程：" + Thread.currentThread().getName() + "开始");
                lock = "change lock";
                Thread.sleep(2000);
                System.out.println("当前线程：" + Thread.currentThread().getName() + "开始");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final ChangeLock changeLock = new ChangeLock();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                changeLock.method();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                changeLock.method();
            }
        }, "t2");

        Thread t3 = new Thread(new Runnable() {
            public void run() {
                changeLock.method();
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
