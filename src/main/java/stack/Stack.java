package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangying on 2017/8/12.
 */
public class Stack {

    private List<Object> stackList = new ArrayList();

    public void push(Object ob){
        System.out.println(ob);
        stackList.add(ob);
    }

    public Object pop(){
        if (stackList.size() == 0 ) {
            System.out.println("there is no element!");
            return null;
        }
        Object object = stackList.get(stackList.size() -1);
        stackList.remove(stackList.size()-1);
        System.out.println(object);
        return object;
    }

    public static void main(String[] args) {
        Stack test1 = new Stack();
        test1.push("1111");
        test1.push("2222");
        test1.push("3333");
        test1.push("4444");
        test1.push("5555");

        System.out.println("---------------------------");

        test1.pop();
        test1.pop();
        test1.pop();
        test1.pop();
        test1.pop();
        test1.pop();
        test1.pop();
        test1.pop();
        test1.pop();
        test1.pop();


    }

}
