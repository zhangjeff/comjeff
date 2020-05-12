package thread.concurrent2020;

public class TicketWindow extends Thread {
    private final String name;

    private static final int max = 50;

    private static int index = 1;


    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= max) {
            System.out.println("当前柜台是："+name + ", 处理的是：" + (index++));
        }
    }
}
