package testio;

/**
 * Created by zhangying on 2017/7/8.
 */
public class TestSplit {

    public static String convertString(String str) {
        StringBuffer aa = new StringBuffer();
        //StringBuffer aa = "";
        String[] bb = str.split(" ");
        for (int i = bb.length-1; i >= 0 ; i--) {
            aa.append(bb[i]);
            aa.append(" ");
        }

        return aa.toString();
    }


    public static void main(String[] args) {
        String bb = "I am a student";

        String cc = TestSplit.convertString(bb);
        System.out.println(cc);
    }
}
