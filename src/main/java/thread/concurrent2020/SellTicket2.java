package thread.concurrent2020;

/**
 * 1.三个售票窗口同时出售20张票
 * 程序分析：
 *     (1)票数要使用同一个静态值
 *     (2)为保证不会出现卖出同一个票数，要java多线程同步锁。
 * 设计思路：
 *     (1)创建一个站台类Station，继承Thread，重写run方法，在run方法里面执行售票操作！售票要使用同步锁：即有一个站台卖这张票时，其他站台要等这张票卖完！
 *     (2)创建主方法调用类
 * ————————————————
 * 版权声明：本文为CSDN博主「延陵缥缈」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_34996727/article/details/80416277
 */
public class SellTicket2 {
    public static void main(String[] args) {
        Thread t1 = new Station("窗口一");
        Thread t2 = new Station("窗口二");
        Thread t3 = new Station("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Station extends Thread {
    public Station(String name) {
        super(name);
    }

    static int tick = 20;

    static Object ob = new Object();

    @Override
    public void run() {
        while (tick > 0) {
            synchronized (ob) {// 这个很重要，必须使用一个锁，
                // 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
                if (tick > 0) {
                    System.out.println(getName() + "卖出了第" + tick + "张票");
                    tick--;
                } else {
                    System.out.println("票卖完了");
                }
            }
            try {
                sleep(100);//休息一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
