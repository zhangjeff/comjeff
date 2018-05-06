package java8Test;

/**
 * Created by zhangying on 2018/3/19.
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Enumeration;

public class EnumerationTester {
//
//    public static void main(String args[]) {
//        Enumeration<String> days;
//        Vector<String> dayNames = new Vector<String>();
////        ArrayList dayNames = new ArrayList();
//        dayNames.add("Sunday");
//        dayNames.add("Monday");
//        dayNames.add("Tuesday");
//        dayNames.add("Wednesday");
//        dayNames.add("Thursday");
//        dayNames.add("Friday");
//        dayNames.add("Saturday");
//        days = dayNames.elements();
//        while (days.hasMoreElements()){
//            System.out.println(days.nextElement());
//        }
//
//
//    }

    public static void main(String[] args) {
        Enumeration<String>[] tmp = (Enumeration<String>[]) new Enumeration<?>[2];
        tmp[0] = new Enumeration<String>() {
            public boolean hasMoreElements() {
                return true;
            }

            public String nextElement() {
                return "aaaaa";
            }
        };

        tmp[1] = new Enumeration<String>() {
            public boolean hasMoreElements() {
                return false;
            }

            public String nextElement() {
                return "bbb";
            }
        };

        while (tmp[0].hasMoreElements()){
            System.out.println("tmp=" + tmp[0].nextElement());
//            System.out.println(days.nextElement());
        }
    }
}