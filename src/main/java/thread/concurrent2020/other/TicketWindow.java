package thread.concurrent2020.other;

public class TicketWindow extends Thread {
    private final String name;

    private static final int MAX = 50;

    private static int index = 1;


    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("当前柜台是："+name + ", 处理的是：" + (index++));
        }
    }

    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("窗口一");
        ticketWindow1.start();

        TicketWindow ticketWindow2 = new TicketWindow("窗口二");
        ticketWindow2.start();

        TicketWindow ticketWindow3 = new TicketWindow("窗口三");
        ticketWindow3.start();
    }
}
