package interviewProgram;

/**
 * Created by zhangying on 2018/5/8.
 * 题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。

 程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。
 */
public class Program3 {

    private static boolean isWaterFlower(int num) {
        int i = num % 10;
        int temp = num;
        int sum = 0;
        while (i > 0) {
            sum = sum + i*i*i;
            temp = temp / 10;
            i = temp % 10;
        }
        if (sum == num) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 100000; i++){
            if (isWaterFlower(i)) {
                System.out.println(i);
            }
        }
    }
}
