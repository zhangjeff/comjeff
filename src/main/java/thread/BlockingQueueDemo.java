package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception{
//        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
//        System.out.println("----------------------");
//
//        blockingQueue.take();
//        blockingQueue.put("d");
//        System.out.println("**********************");
        BlockingQueue<String>blockingQueue = new SynchronousQueue<>();
        blockingQueue.put("333");
        blockingQueue.put("444");

    }

}
