package java8Test;

import com.sun.tools.hat.internal.parser.ReadBuffer;

import java.io.*;

/**
 * Created by zhangying on 2018/3/19.
 */
public class FileReaderTest {

    public static void main(String[] args) {
        String filePath = "/Users/zhangying/Documents/workspace/comjeff/src/main/java/Demo1.java";
        File file = new File(filePath);
        try {
            if (file.isFile()) {
                System.out.println(file.getName());
                InputStream inputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

//                while (inputStreamReader.)

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String temp=null;
                while ((temp = bufferedReader.readLine()) != null){
                    System.out.println("--------------------------------");
                    System.out.println(temp);
                };
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
