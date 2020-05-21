package thread.concurrent2020;

public class TwoLockPrinter {

    public static void main(String[] args) throws Exception{
        TwoLockPrinter twoLockPrinter = new TwoLockPrinter();
        twoLockPrinter.test();
    }

    public void test() throws InterruptedException {
        // 打印A线程的锁
        Object lockA = new Object();
        // 打印B线程的锁
        Object lockB = new Object();
        // 打印C线程的锁
        Object lockC = new Object();
        ThreadGroup group = new ThreadGroup("xx");
        // 打印a的线程
        Thread threadA = new Thread(group, new Printer(lockC, lockA, 'A'));
        // 打印b的线程
        Thread threadB = new Thread(group, new Printer(lockA, lockB, 'B'));
        // 打印c的线程
        Thread threadC = new Thread(group, new Printer(lockB, lockC, 'C'));
        // 依次开启a b c线程
        threadA.start();
        Thread.sleep(100);
        threadB.start();
        Thread.sleep(100);
        threadC.start();
        // 主线程循环让出cpu使用权
        while (group.activeCount() > 0) {
            Thread.yield();
        }
    }

    // 打印线程
    private class Printer implements Runnable {
        // 打印次数
        private static final int PRINT_COUNT = 6;
        // 前一个线程的打印锁
        private final Object fontLock;
        // 本线程的打印锁
        private final Object thisLock;
        // 打印字符
        private final char printChar;

        public Printer(Object fontLock, Object thisLock, char printChar) {
            super();
            this.fontLock = fontLock;
            this.thisLock = thisLock;
            this.printChar = printChar;
        }
        @Override
        public void run() {
            // 连续打印PRINT_COUNT次
            for (int i = 0; i < PRINT_COUNT; i++) {
                // 获取前一个线程的打印锁
                synchronized (fontLock) {
                    // 获取本线程的打印锁
                    synchronized (thisLock) {
                        // 打印字符
                        System.out.print(printChar);
                        // 通过本线程的打印锁唤醒后面的线程 
                        // notify和notifyall均可,因为同一时刻只有一个线程在等待
                        thisLock.notify();
                        // 不是最后一次则通过fontLock等待被唤醒
                        // 必须要加判断，不然能够打印6次 但6次后就会直接死锁
                        if (i < PRINT_COUNT - 1) {
                            try {
                                // 通过fontLock等待被唤醒
                                fontLock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}