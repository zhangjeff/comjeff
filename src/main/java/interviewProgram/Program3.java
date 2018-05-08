package interviewProgram;

/**
 * Created by zhangying on 2018/5/8.
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
        for (int i = 0; i <= 1000; i++){
            if (isWaterFlower(i)) {
                System.out.println(i);
            }
        }
    }
}
