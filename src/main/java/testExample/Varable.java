package testExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Youpeng.Zhang on 2018/6/5.
 */
public class Varable {
    public static String readFirstLineFromFile(String path) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    public static void main(String [] args){
        System.out.println(add(2,3));
        System.out.println(add(2,3,5));


    }
    public static int add(int x,int ...args){
        int sum=x;
        for(int i=0;i<args.length;i++){
            sum+=args[i];
        }

        int num = 1234_5678_9;
        String aa = Integer.toString(num);
        System.out.println(num);
        System.out.println(aa);
        return sum;
    }
}
