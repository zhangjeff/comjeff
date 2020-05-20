package thread.concurrent2020.other;

/**
 * 三个售票窗口同时出售20张票
 */
public class SellTicket {

    public static void main(String[] args) {
        TicketWin ticketWin = new TicketWin();
        Thread t1 = new Thread(ticketWin, "窗口一");
        Thread t2 = new Thread(ticketWin, "窗口二");
        Thread t3 = new Thread(ticketWin, "窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketWin implements Runnable {
    private final static Integer maxCount = 200;
//    private Integer maxCount = 0;
    private static Integer curNum = 0;

    private Object object = new Object();

    @Override
    public void run() {
        while (curNum < maxCount) {
            synchronized (object) {
                if (curNum < maxCount) {
                    System.out.println("当前窗口" + Thread.currentThread().getName() + "卖票" + (curNum++));
//                    curNum++;
                }
            }
            try {
                Thread.sleep(100);//休息一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}