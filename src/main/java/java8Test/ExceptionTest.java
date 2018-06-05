package java8Test;

/**
 * @author Youpeng.Zhang on 2018/5/31.
 */
public class ExceptionTest {

    private int testaa(){
        return 1/0;
    }

    public static void main(String[] args) {
        try{
            ExceptionTest exceptionTest = new ExceptionTest();
            exceptionTest.testaa();
        } catch (Exception e) {
            System.out.println("this is an error");
        }

    }
}
