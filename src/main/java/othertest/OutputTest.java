package othertest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by zhangying on 2018/5/18.
 */
public class OutputTest {

    public static void main(String[] args) {
        try {
            String aa = "hi jeff";
            OutputStream outputStream = new FileOutputStream(new File("src/main/java/file.txt")) ;
            outputStream.write(aa.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
