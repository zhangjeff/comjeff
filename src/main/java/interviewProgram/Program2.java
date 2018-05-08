package interviewProgram;

/**
 *
 *题目：判断101-200之间有多少个素数，并输出所有素数。
 *程序分析：

 * 素数是：只能被1或本身整除的数，如：3,5,7,11,131...

 *判断素数的方法：用一个数分别去除2到sqrt(这个数)，

 *其实用这个数分别去除2到他本身少1的数也可以，但是运算时间增加了

 *如果能被整除，则表明此数不是素数，反之是素数。
 * Created by zhangying on 2018/5/8.
 */
public class Program2 {

    private static boolean isPrimeNumber(int num) {
        int i = 2;
        while (i < Math.sqrt(num)) {
            if (num % i == 0) {
                return  false;
            }
            i++;
        }
        return true;
    }


    public static void main(String[] args) {
        int j = 0;
        for (int i = 101; i < 200; i ++) {
            if (isPrimeNumber(i)) {
                if (j % 10 == 0) {
                    System.out.println();
                }
                System.out.print(i + " ");
                j++;
            }
        }
    }
}
