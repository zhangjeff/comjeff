package thread.concurrent2020.produceconsumer;

import java.util.LinkedList;
import java.util.List;

public class Produceconsumer {
    public static void main(String[] args) {
        Goods goods = new Goods();
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
            new Thread(()->{
               while(true) {
                   goods.putObj();
               } }, "生产者" + i).start();
        }
        for (int i = 0; i < 8; i++) {
            new Thread(()->{
                while(true) {
                    goods.getObj();
                } }, "消费者" + i).start();
        }
    }
}

class Goods{
    static volatile List goods = new LinkedList();
//    Object obj = new Object();
    public synchronized void putObj() {
        while (goods.size() >= 10){
            try {
                this.wait();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        goods.add(new Object());
        System.out.println(Thread.currentThread().getName() + "生产一个商品, 容器中有"+ goods.size()+"个商品");
        this.notifyAll();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public  synchronized void getObj(){
        while (goods.size() == 0) {
            try {
                this.wait();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        goods.remove(0);
        System.out.println(Thread.currentThread().getName() + "消费一个商品,容器中有" + goods.size()+"个商品");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        this.notifyAll();
    }

}
