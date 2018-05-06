package thread.lock;

/**
 * Created by zhangying on 2018/4/27.
 */
public class TestDeadThread implements Runnable {
    public static Object o1=new Object();

    public static Object o2=new Object();

    private boolean flag;



    public TestDeadThread(boolean flag){

        this.flag=flag;

    }


    public void run(){

        String threadName=Thread.currentThread().getName();

        if(flag){

            while(true){

                synchronized(o1){

                    try{

                        Thread.sleep(1000);

                    }catch(InterruptedException e){

                        e.printStackTrace();

                    }

                    System.out.println(threadName+"get o1 lock");

                    synchronized(o2){

                        System.out.println(threadName+"get o2 lock");

                    }

                }

            }

        }else{

            while(true){

                synchronized(o2){

                    try{

                        Thread.sleep(1000);

                    }catch(InterruptedException e){

                        e.printStackTrace();

                    }

                    System.out.println(threadName+"get o2 lock");

                    synchronized(o1){

                        System.out.println(threadName+"get o1 lock");

                    }

                }

            }

        }
    }



    public static void main(String[]args){

        TestDeadThread threada=new TestDeadThread(true);

        TestDeadThread threadb=new TestDeadThread(false);

        Thread a=new Thread(threada);

        Thread b=new Thread(threadb);

        a.start();

        b.start();

    }
}
