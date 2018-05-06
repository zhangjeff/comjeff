package stack;

/**
 * Created by zhangying on 2017/8/12.
 */
public class TestNative {

    static
    {
        System.loadLibrary("HelloNative");
    }

    public static native void sayHello();

    @SuppressWarnings("static-access")
    public static void main(String[] args)
    {
        new TestNative().sayHello();
    }
}
