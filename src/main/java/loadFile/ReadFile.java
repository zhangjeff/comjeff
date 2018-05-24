package loadFile;

import org.apache.commons.io.FileUtils;

import java.io.*;

/**
 * @author Youpeng.Zhang on 2018/5/24.
 */
public class ReadFile {

    public static void main(String[] args) {
        try {
            FileOutputStream out = null;
            String filepath = "E:\\html";
            String newfilepath = "E:\\htmlnew";
            File file = new File(filepath);
            System.out.println("文件夹");
            String[] filelist = file.list();
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            for (int i = 0; i < filelist.length; i++) {
                File readfile = new File(filepath + "\\" + filelist[i]);

                if (!readfile.isDirectory()) {
                    System.out.println("path=" + readfile.getPath());
                    System.out.println("absolutepath="
                            + readfile.getAbsolutePath());
                    System.out.println("name=" + readfile.getName());
                }
                if (!readfile.getName().contains("_")) {
                    File writeFile = new File(newfilepath + "\\" + filelist[i]);
                    FileUtils.copyFile(readfile, writeFile);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
