package testExample;

import static testExample.Common.AGE;

/**
 * @author Youpeng.Zhang on 2018/6/5.
 */
public class StaticImportTest {
    public static void main(String[] args)
    {
        int a = AGE;
        System.out.println(a);

        Common.output();
    }
}
