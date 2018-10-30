import java.io.IOException;
import java.io.UnsupportedEncodingException;


import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

/**
 * Created by zhangying on 2017/9/13.
 */

public class Demo1 {

    public static void main(String[] args) {
        try {
            String s = "Username";
            BASE64Encoder encoder = new BASE64Encoder();
            s = encoder.encode(s.getBytes("UTF-8"));
            System.out.println(s);

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer("VXNlcm5hbWU=");
            System.out.println(new String(bytes, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
