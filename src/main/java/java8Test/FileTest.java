package java8Test;

import java.io.File;
import java.net.URL;

import static com.apple.eio.FileManager.getResource;

/**
 * Created by zhangying on 2018/3/19.
 */
public class FileTest {

    public static void main(String[] args) {


        URL path = FileTest.class.getResource("/");
        System.out.println(path.getPath());

        File[] files = new File("/Users/zhangying/Documents/workspace/comjeff/src/main/java").listFiles();
        for (File file : files) {
//            System.out.println(file.getAbsolutePath());
            if (file.isFile()) {
                System.out.println(file.getName());
            }
//            System.out.println("-----------directory------------------");
            if (file.isDirectory()) {
                System.out.println("------------"+file.getName());
                File[] file1s = new File(file.getPath()).listFiles();
                for (File f : file1s){
                    System.out.println(f.getName());
                }
            }
        }
    }
}
