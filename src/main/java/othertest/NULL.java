package othertest;

/**
 *
 * 输出为haha，因为null值可以强制转换为任何java类类型,(String)null也是合法的。但null强制转换后是无效对象，其返回值还是为null，而static方法的调用是和类名绑定的，
 * 不借助对象进行访问所以能正确输出。反过来，没有static修饰就只能用对象进行访问，使用null调用对象肯定会报空指针错了。这里和C++很类似。
 *
 * Created by zhangying on 2018/5/12.
 */
public class NULL {
    
    public static void haha(){
        System.out.println("haha");
    }
    public static void main(String[] args) {
        ((NULL)null).haha();
    }
}
