package jvm.cglibBean;

import java.util.HashMap;

public class CglibBeanTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            MyMethodInterceptor.getProxy();
        }
    }
}
