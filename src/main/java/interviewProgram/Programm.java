package interviewProgram;

/**
 * Created by zhangying on 2018/5/8.
 * 【程序1】

 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少？

 程序分析：兔子的规律为数列1,1,2,3,5,8,13,21....

 做这种题目，最好的做法就是找出规律，跟高中的数列一样

 本题有：a[n]=a[n-1]+a[n-1],而第一第二项都知道了，后面的值也可以求得
 */
public class Programm {

    private int func(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return func(n-1) + func(n-2);
        }
    }

    public static void main(String[] args) {
        Programm programm = new Programm();
        int count = programm.func(7);
        System.out.println("the result is " + count);
    }
}
