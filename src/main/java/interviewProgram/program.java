package interviewProgram;

/**
 * Created by zhangying on 2018/5/8.
 */
public class program {
    public static void main(String[] args) {
        String[] aa = new String[10];
        for (String bb : aa) {
            System.out.println(bb);
        }
        System.out.println(aa.length);
        System.out.println("------------------------");
        int[] cc = new int[10];
        for (int d : cc) {
            System.out.println(d);
        }
        System.out.println(cc.length);
    }
}
