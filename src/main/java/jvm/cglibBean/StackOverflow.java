package jvm.cglibBean;

public class StackOverflow {
    private static int count = 0;
    public static void recursion(long a, long b, long c) {
        long e = 1, f = 2, g = 3, h = 4, i = 5, j = 6, k = 7, l = 8, m = 9;
        count ++;
        recursion(a, b, c);
    }

    public static void main(String[] args) {
        try {
            recursion(1, 2, 3);
        } catch (Throwable e) {
            System.out.println("deep of calling = " + count);
            e.printStackTrace();
        }
    }
}
