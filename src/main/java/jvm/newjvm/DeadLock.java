package jvm.newjvm;
public class DeadLock {
    public static void main(String[] args) {
       new Thread(A::getA,"ThreadA").start();

       new Thread(B::getB,"ThreadB").start();
    }
}

class A {

    public static synchronized void getA(){
        System.out.println("进入A");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        B.getB();
    }
}

class B {
    public static synchronized void getB(){
        System.out.println("进入B");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A.getA();
    }
}