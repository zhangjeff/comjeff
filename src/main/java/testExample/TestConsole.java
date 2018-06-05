package testExample;

import java.io.Console;

/**
 * @author Youpeng.Zhang on 2018/6/5.
 */
public class TestConsole {
    public static void main(String[] args) {


        Console console=System.console();

        if(console!=null)
        {
            System.out.println("input data");
            String data=console.readLine();
            System.out.println("data="+data);
            char[] pwds=console.readPassword();
            System.out.println("pwds="+pwds);
            data=console.readLine("hello %s", "test");
            System.out.println(data);

            pwds=console.readPassword("hello password %s", "test");
            System.out.println(pwds);
            //输出
            console.format("fuck %s\n", "you");

            console.writer().println("finish");
            console.flush();


        }else{
            System.out.println("console==null");
        }
    }
}
