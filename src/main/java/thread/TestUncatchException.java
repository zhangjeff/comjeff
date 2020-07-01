package thread;

public class TestUncatchException
{
    public static class TestRuntimeExceptionThread extends Thread
    {
        public TestRuntimeExceptionThread()
        {
            super.setName("thread-TestRuntimeExceptionThread");
        }
        
        @Override
        public void run()
        {
            throw new RuntimeException("run time exception");
        }
    }
 
    public static void main(String[] args)
    {
        try
        {
            Thread test = new TestRuntimeExceptionThread();
            // 设置线程默认的异常捕获方法
             test.setUncaughtExceptionHandler((Thread t, Throwable e) -> {System.out.println(t.getName() + ": " + e.getMessage());});
            test.start();
        }
        catch(Exception e)
        {
            System.out.println("catch thread exception");
        }
    }
}
