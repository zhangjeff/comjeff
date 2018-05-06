package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhangying on 2017/5/4.
 */
public class BlockQueue {
    private  final BlockingQueue queue = null;

//    class Producer implements Runnable {
//        private final BlockingQueue queue;
//        Producer(BlockingQueue q) { queue = q; }
//        public void run() {
//            try {
//                while(true) { queue.put(produce()); }
//            } catch (InterruptedException ex) {
//                System.out.println("run");
//            }
//        }
//        Object produce() {
//            return new Object();
//        }
//    }
//
//    class Consumer implements Runnable {
//        private final BlockingQueue queue;
//        Consumer(BlockingQueue q) { queue = q; }
//        public void run() {
//            try {
//                while(true) { consume(queue.take()); }
//            } catch (InterruptedException ex) { ex.printStackTrace();}
//        }
//        void consume(Object x) {
//            System.out.println(x.toString());
//        }
//    }


    public static void main(String[] args) throws Exception{
        final BlockingQueue q = new ArrayBlockingQueue(20);
        q.add("aaaaaa");
        q.put("bbbb");
        q.add("cccc");
        q.add("ddddd");
        q.add("eeeee");

//        for (int i = 0; i <= 10; i++) {
//            new Thread(new Runnable() {
//                public void run() {
//                    q.add("aaaaa");
//                }
//             }
//            , "t"+i).start();
//        }


    }

}
