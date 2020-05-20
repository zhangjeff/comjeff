package thread.concurrent2020.other;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T01_withoutVolatile {

    volatile List list = new LinkedList();
//    volatile  List list = Collections.synchronizedList(new LinkedList());

    public  void add(Object o) {
        list.add(o);
    }

    public  int size(){
        return list.size();
    }

    public static void main(String[] args) {
        T01_withoutVolatile t01_withoutVolatile = new T01_withoutVolatile();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                Object o = new Object();
                t01_withoutVolatile.add(o);
                System.out.println("add" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }, "t1").start();

        new Thread(()->{
            while(true) {
                if (t01_withoutVolatile.size() == 5){
                    break;
                }
            }
            System.out.println("线程二结束");
        },"t2").start();

    }
}
