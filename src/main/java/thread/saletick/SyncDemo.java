package thread.saletick;


/**
 * Created by zhangying on 2017/11/24.
 */
public class SyncDemo {

    public static void main(String[] args) {

                   /*
                    * new SaleTicketThread("窗口1").start(); new
                    * SaleTicketThread("窗口2").start();
                    */

        // 创建票对象（内部封装了卖票的方法，并且具备运行在线程中的能力）
        Ticket tickt = new Ticket();
        // 让多个窗口同时卖票（让线程执行指定的任务对象）
//        new Thread(tickt, "窗口1").start();
//        new Thread(tickt, "窗口2").start();
//        new Thread(tickt, "窗口3").start();
//        new Thread(tickt, "窗口4").start();

        for (int i=1; i<10; i++) {
            new Thread(tickt, "窗口" + i).start();
        }


    }
}
