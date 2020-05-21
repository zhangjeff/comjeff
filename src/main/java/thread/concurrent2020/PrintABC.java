package thread.concurrent2020;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实例化三个线程，一个线程打印a,一个打印b,一个打印c,三个线程同时执行，要求打印出6个连着的abc
 */
public class PrintABC {
    final ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void printA(){
        lock.lock();
        try{
            for (int i = 0; i < 6 ; i++) {
                System.out.print("A");
                conditionB.signal();
                conditionA.await();
            }
            conditionB.signal();
            conditionC.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void printB(){
        lock.lock();
        try{
            conditionB.await();
            for (int i = 0; i < 6 ; i++) {
                System.out.print("B");
                conditionC.signal();
                conditionB.await();
            }
            conditionC.signal();
            conditionA.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try{
            conditionC.await();
            for (int i = 0; i < 6 ; i++) {
                System.out.print("C");
                conditionA.signal();
                conditionC.await();
            }
            conditionA.signal();
            conditionB.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        PrintABC printABC = new PrintABC();
        Thread t1 = new Thread(printABC::printA);
        Thread t2 = new Thread(printABC::printB);
        Thread t3 = new Thread(printABC::printC);

        t2.start();
        t3.start();
        t1.start();


//        PrintA printA = new PrintA();
//        PrintB printB = new PrintB();
//        PrintC printC = new PrintC();
//
//
//        Thread t1 = new Thread(printA);
//        Thread t2 = new Thread(printB);
//        Thread t3 = new Thread(printC);
//        t1.start();
//        t2.start();
//        t3.start();
    }
}

//class PrintA implements Runnable{
//    @Override
//    public void run() {
//        for (int i = 0; i < 6 ; i++) {
//            System.out.print("A");
//        }
//    }
//}
//
//class PrintB implements Runnable{
//    @Override
//    public void run() {
//        for (int i = 0; i < 6; i++) {
//            System.out.print("B");
//        }
//    }
//}
//
//class PrintC implements Runnable{
//    @Override
//    public void run() {
//        for (int i = 0; i < 6; i++) {
//            System.out.print("C");
//        }
//    }
//}
