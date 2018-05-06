package stack;

/**
 * Created by zhangying on 2017/8/12.
 */
public class StackArray {
    private Object[] arrayStack = new Object[10000];
    private int length = 0;

    private void push(Object object) {
        arrayStack[length] = object;
        length++;
        System.out.println(object);
    }

    private Object pop(){
        if(length == 0) {
            System.out.println("there is no element!");
            return null;
        }
        length--;
        Object object = arrayStack[length];
        System.out.println(object);
        return object;
    }

    public static void main(String[] args) {
        StackArray stackArray = new StackArray();
        stackArray.push("1111111");
        stackArray.push("2222222");
        stackArray.push("3333333");
        stackArray.push("4444444");

        System.out.println("-------------------------");

        stackArray.pop();
        stackArray.pop();
        stackArray.pop();
        stackArray.pop();
        stackArray.pop();


        System.out.println("hi jeff!");
    }
}
