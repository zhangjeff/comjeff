package thread.deadLock;


class DeadObject{
    public void lockAB(Object aa, Object bb){
        synchronized (aa) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (bb){
                System.out.println(Thread.currentThread().getName() + "锁住对象：" + aa + ":" + bb);
            }
        }
    }

}

public class DeadLockTest {

    public static void main(String[] args) {
        String a = "AA";
        String b = "BB";
        DeadObject deadObject = new DeadObject();
        Thread t1 = new Thread(()->{
            deadObject.lockAB(a,b);
        });
        Thread t2 = new Thread(()->{
            deadObject.lockAB(b,a);
        });
        t1.start();
        t2.start();
    }
}
