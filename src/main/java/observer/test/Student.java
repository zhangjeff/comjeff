package observer.test;

/**
 * Created by zhangying on 2017/11/26.
 */
public class Student {

    private String name;
    public Student(String name){
        this.name = name;
    }

    public void getMessage(String message){
        System.out.println("学生"+name + " -  " + message);
    }
}
