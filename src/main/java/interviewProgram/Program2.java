package interviewProgram;

/**
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
