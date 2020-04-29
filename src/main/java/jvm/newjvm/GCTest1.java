package jvm.newjvm;

public class GCTest1 {

    /*
     -verbose:gc 输出冗余的gc信息
     -Xms20M 堆初始化大最小容量
     -Xmx20M 堆初始化最大容量
     -Xmn10M 新生代容量
     -XX:+PrintGCDetails
     -XX:SurvivorRatio=8 配置新生代和survivor的大小比例为8：1：1
       */
    public static void main(String[] args) {
//        int size = 1024 * 1024;
        Byte[] byte1 = new Byte[1024 * 1024];
        Byte[] byte2 = new Byte[1024 * 1024];
        Byte[] byte3 = new Byte[1024 * 1024];
        Byte[] byte4 = new Byte[1024 * 1024];

//        try {
//            Thread.sleep(100000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("hello world!");
    }
}
