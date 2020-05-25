package thread.concurrent2020.abc;

import java.util.concurrent.locks.LockSupport;

public class Printabc2 {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {

        char[] aa = "ABCDEFG".toCharArray();
        char[] bb = "1234567".toCharArray();

        t1 = new Thread(() -> {
            try {
                for (char a : aa) {
                    System.out.print(a);
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        t2 = new Thread(() -> {
            try {
                for (char b : bb) {
                    LockSupport.park();
                    System.out.print(b);
                    LockSupport.unpark(t1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
