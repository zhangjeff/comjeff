package thread.concurrent2020.abc;

public class Printabc {

    public static void main(String[] args) {

        Object o = new Object();

        String a1 = "ABCDEFG";
        String a2 = "1234567";
        char[] aa = a1.toCharArray();
        char[] bb = a2.toCharArray();

        Thread t1 = new Thread(()-> {
            try {
                synchronized (o) {
                    for (char a : aa) {
                        System.out.print(a);
                        o.notify();
                        o.wait();
                    }
                    o.notify();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        });


        Thread t2 = new Thread(()-> {
            try {
                synchronized (o) {
                    for (char b : bb) {
                        System.out.print(b);
                        o.notify();
                        o.wait();
                    }
                    o.notify();
                }

            } catch (Exception  e) {
                e.printStackTrace();
            }

        });
        t1.start();
        t2.start();
    }
}
