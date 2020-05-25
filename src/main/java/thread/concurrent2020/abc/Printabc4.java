package thread.concurrent2020.abc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Printabc4 {
    static Thread t1 = null;
    static Thread t2 = null;
    enum ReaytoRun {T1, T2}
    static volatile ReaytoRun r = ReaytoRun.T1;

    public static void main(String[] args) {

        char[] aa = "ABCDEFG".toCharArray();
        char[] bb = "1234567".toCharArray();


        t1 = new Thread(() -> {
            try {
                for (char a : aa) {
                    while (r !=  ReaytoRun.T1) { }
                    System.out.print(a);
                    r = ReaytoRun.T2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        });


        t2 = new Thread(() -> {
            try {
                for (char b : bb) {
                    while (r != ReaytoRun.T2) {}
                    System.out.print(b);
                    r = ReaytoRun.T1;
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
