package interviewProgram;

/**
 * Created by zhangying on 2018/5/8.
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
