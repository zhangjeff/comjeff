package thread;

/**
 * Created by zhangying on 2018/4/27.
 */
public class SynchronizedTest {
    public synchronized void method1(){
        System.out.println("-----method1 start----");
        try{
            Thread.sleep(1000);
            System.out.println("-------method1 execute------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-------method1 end------------");
    }

    public synchronized void method2(){
        System.out.println("-----method2 start----");
        try{
            Thread.sleep(1000);
            System.out.println("-------method2 execute------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-------method2 end------------");
    }

    public static void main(String[] args) {
        final SynchronizedTest test = new SynchronizedTest();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                test.method1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                test.method2();
            }
        });

        thread1.start();
        thread2.start();
    }
}
