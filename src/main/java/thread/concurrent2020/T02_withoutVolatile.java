package thread.concurrent2020;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T02_withoutVolatile {

    volatile List list = new LinkedList();
//    volatile  List list = Collections.synchronizedList(new LinkedList());

    public  void add(Object o) {
        list.add(o);
    }

    public  int size(){
        return list.size();
    }

    public static void main(String[] args) {
        T02_withoutVolatile t01_withoutVolatile = new T02_withoutVolatile();

        Object obj = new Object();
        new Thread(()->{
            synchronized (obj) {
                    if (t01_withoutVolatile.size() != 5){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                System.out.println("线程二结束");
                obj.notify();
            }
        },"t2").start();

        new Thread(()->{
            synchronized (obj) {
                for (int i = 0; i < 10; i++) {
                    Object o = new Object();
                    t01_withoutVolatile.add(o);
                    System.out.println("add" + i);
                    if (t01_withoutVolatile.size() == 5) {
                        obj.notify();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();



    }
}
