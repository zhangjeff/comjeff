package thread.concurrent2020.other;

import java.util.concurrent.locks.ReentrantLock;

public class ReentertLock {
    private static int count = 0;
    static ReentrantLock  reentrantLock = new ReentrantLock(true);
    private  static  void add(){

        reentrantLock.lock();
        for (int i = 1; i <= 1000; i++) {
//
            count++;
//
        }
        reentrantLock.unlock();
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 100 ; i++) {
            new Thread(() -> add(),"线程" + i).start();
        }
        System.out.println(count);
    }
}
