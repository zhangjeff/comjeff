package testio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangying on 2017/7/8.
 */
public class CaCulate {

    public int getHappyNumber(int num) {
        int result = 0;
        while (num > 0) {
            int b = num%10;
            num = num/10;
            result = result + b * b;
        }
        return result;
    }

    public boolean ishappyNum(int parm){
        List<Integer> aa = new ArrayList<Integer>();
        int b = parm;
        b = getHappyNumber(b);
       // System.out.println("aaa=" + b);
        while (b != 1 && !aa.contains(b)) {
            aa.add(b);
            b = getHappyNumber(b);
         //  System.out.println("aaa=" + b);

        }

        if (b == 1) {
            return  true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CaCulate cal = new CaCulate();
//        boolean res = cal.ishappyNum(7);

        for (int i = 1; i< 1000; i++) {
            boolean res = cal.ishappyNum(i);
            if (res) {
                System.out.println("i = " + i);
            }
        }


    }
}
