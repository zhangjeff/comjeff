package thread;

public class TestInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted");
                        break;
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted when sleep");
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }

                    Thread.yield();
                }
            }
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }
}
