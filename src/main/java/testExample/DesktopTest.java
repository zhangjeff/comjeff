package testExample;

import java.awt.*;
import java.io.File;
import java.net.URI;

/**
 * @author Youpeng.Zhang on 2018/6/5.
 */
public class DesktopTest {
    public static void main(String[] args) throws  Exception {
        // 先判断当前平台是否支持桌面
        if (Desktop.isDesktopSupported()) {
            // 获取当前平台桌面实例
            Desktop desktop = Desktop.getDesktop();

            // 使用默认浏览器打开链接
            desktop.browse(URI.create("http://www.sina.com"));

            // 打开指定文件/文件夹
            desktop.open(new File("D:\\aa"));


        } else {
            System.out.println("当前平台不支持 Desktop");
        }
    }
}
