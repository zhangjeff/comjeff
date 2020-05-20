package thread.concurrent2020.other;

public class TicketWindow2 implements Runnable {
    private final static int MAX = 50;

    private int index = 1;
    @Override
    public void run() {
        while (index < MAX) {
            System.out.println("当前窗口是："+Thread.currentThread().getName() + "，处理的是" + (index++));
        }
    }

    public static void main(String[] args) {
        final TicketWindow2 ticketWindow2 = new TicketWindow2();
        Thread t1 = new Thread(ticketWindow2, "窗口一");
        Thread t2 = new Thread(ticketWindow2, "窗口二");
        Thread t3 = new Thread(ticketWindow2, "窗口三");
        t1.start();
        t2.start();
        t3.start();

    }
}
