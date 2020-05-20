package thread.concurrent2020.produceconsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Produceconsumer2 {
    public static void main(String[] args) {
        GoodsNew goods = new GoodsNew();
//        for (int i = 0; i < 2; i++) {
//            new Thread(() -> goods.putObj(), "生产者" + i).start();
//        }
//
//        for (int i = 0; i < 10 ; i++) {
//            new Thread(() -> goods.getObj(),"消费者" + i).start();
//        }
//        new Thread(() -> {
//            for (int i = 0; i < 25; i++) {
//                goods.putObj();
//            } }, "生产者" + 1).start();
//        new Thread(() -> {
//             for (int i = 0; i < 25 ; i++) {
//                goods.getObj();
//            } },"消费者" + 1).start();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true) {
                    goods.putObj();
                }
            }, "生产者" + i).start();
        }
        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                while (true) {
                    goods.getObj();
                }
            }, "消费者" + i).start();
        }
    }
}

class GoodsNew {
    static volatile List goods = new LinkedList();
    Lock reentrantLock = new ReentrantLock();
    Condition producer = reentrantLock.newCondition();
    Condition consumer = reentrantLock.newCondition();

    //    Object obj = new Object();
    public void putObj() {
        try {
            reentrantLock.lock();
            while (goods.size() >= 10) {

                producer.await();

            }
            goods.add(new Object());
            System.out.println(Thread.currentThread().getName() + "生产一个商品, 容器中有" + goods.size() + "个商品");
            Thread.yield();
            consumer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public synchronized void getObj() {
        try {
            reentrantLock.lock();
            while (goods.size() == 0) {
                consumer.await();
            }

            goods.remove(0);
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + "消费一个商品,容器中有" + goods.size() + "个商品");
            producer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }


}
