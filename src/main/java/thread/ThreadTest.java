package thread;

public class ThreadTest {

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.testThread();
    }

    public void testThread(){
        Thread t = new Thread(() -> System.out.println(1 / 0));
        t.setUncaughtExceptionHandler(new LogUncaughtExceptionHandler());
        t.start();
    }

    class LogUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("-----------------------");

            System.out.println(e.getMessage());

            System.out.println("-----------------------");

            System.out.println(e.getStackTrace());
        }
    }
}




