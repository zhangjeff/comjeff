package synchronize;

/**
 * Created by zhangying on 2018/4/27.
 */
public class LoggingWidget extends Widget {

    public synchronized void doSomething() {

        System.out.println(toString() + ": calling doSomething");

        super.doSomething();//若内置锁是不可重入的，则发生死锁

    }

    public static void main(String[] args) {

        LoggingWidget loggingWidget = new LoggingWidget();
        loggingWidget.doSomething();
    }
}
