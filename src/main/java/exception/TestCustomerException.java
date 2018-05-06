package exception;

/**
 * Created by zhangying on 2018/5/6.
 */
public class TestCustomerException {
    public static void main(String[] args) {

        try {
            TestClass testClass = new TestClass();
            testClass.testException();
        } catch (CustomerException e) {
            e.printStackTrace();
            System.out.println("MsgDes\t"+e.getMsgDes());
            System.out.println("RetCd\t"+e.getRetCd());
        }
    }
}
