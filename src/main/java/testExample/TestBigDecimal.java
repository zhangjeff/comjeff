package testExample;

import java.text.DecimalFormat;

/**
 * Created by zhangying on 2017/8/25.
 */
public class TestBigDecimal {

    public static void main(String[] args) {
        DecimalFormat aa = new DecimalFormat("00000");
        String bb = aa.format(12345678);
        System.out.println(bb);
    }
}
