package thread.saletick;

/**
 * Created by zhangying on 2017/11/24.
 */
public class SaleTicketThread extends Thread {
    private int num = 50;

    public SaleTicketThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (num > 0) {
            System.out.println(getName()+ "......sale....." + num);
            num--;
        }
    }
}
