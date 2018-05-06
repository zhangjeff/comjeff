package stack;

import java.util.*;
import java.util.Stack;

/**
 * Created by zhangying on 2017/8/12.
 */
public class TestStack {

    public static void main(String[] args) {
//        java.util.Stack aa = new Stack<String>();
//        for (int i = 1; i <=100000; i++) {
//            aa.push("aaa" + i);
//        }
//
//        System.out.println(aa.pop());


        Integer[] bb = new Integer[10];
        for (int i= 0; i<10; i++) {
            bb[i] = i;
        }

        Integer[] dd = new Integer[5];
        System.arraycopy(bb, 5,dd, 2,3);

        for (Integer cc : dd) {
            System.out.println(cc);
        }
    }
}
