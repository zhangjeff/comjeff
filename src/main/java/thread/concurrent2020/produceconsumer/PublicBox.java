package thread.concurrent2020.produceconsumer;

import java.util.concurrent.TimeUnit;

public class PublicBox {
    private int apple = 0;

    public synchronized void increace(){
        while(apple == 5){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        apple++;
        System.out.println(Thread.currentThread().getName()+"生产苹果成功！");
        notify();
    }

    public synchronized void decreace(){
        while (apple == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        apple--;
        System.out.println(Thread.currentThread().getName()+"消费苹果成功！");
        notify();
    }

    public static void main(String[] args) {
        PublicBox publicBox = new PublicBox();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                publicBox.increace();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                publicBox.decreace();

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者").start();
    }
}
