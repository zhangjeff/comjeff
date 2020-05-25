package thread.concurrent2020.abc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Printabc4 {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {

        char[] aa = "ABCDEFG".toCharArray();
        char[] bb = "1234567".toCharArray();
        BlockingQueue q1 = new LinkedBlockingDeque(1);
        BlockingQueue q2 = new LinkedBlockingDeque(1);

        t1 = new Thread(() -> {
            try {
                for (char a : aa) {
                    System.out.print(a);
                    q2.add(1);
                    q1.take();

                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        });


        t2 = new Thread(() -> {
            try {
                for (char b : bb) {
                    q2.take();
                    System.out.print(b);
                    q1.add(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        });
        t1.start();
        t2.start();
    }
}
