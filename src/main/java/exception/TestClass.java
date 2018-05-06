package exception;

/**
 * Created by zhangying on 2018/5/6.
 */
public class TestClass {
    public void testException() throws CustomerException {
//        try {
            throw new CustomerException("14000001", "String[] strs's length < 4");
//        }
    }
}
