package jvm.cglibBean;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
//        System.out.println("准备开始   :" + method);
        Object object = methodProxy.invokeSuper(obj, arg);
//        System.out.println("已经结束了  :" + method);
        return object;
    }

    public static void getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Programer.class);
        enhancer.setCallback(new MyMethodInterceptor());
        Programer programer = (Programer)enhancer.create();
        //开始调用
        programer.eat("代码级大餐");
//        System.out.println("------------------------------------------------------------------");
        programer.wear();
    }

    public static void main(String[] args) {
        MyMethodInterceptor.getProxy();
    }
}

class Programer {

    public void wear(){
//        System.out.println("穿衣服");
        byte[] b1 = new byte[1024*1024];
    }

    public void eat(String food) {
        byte[] b1 = new byte[1024*1024];
        // TODO Auto-generated method stub
//        System.out.println("程序猿大餐开吃，妈的");
    }
}

