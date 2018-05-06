package observer.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangying on 2017/11/26.
 */
public class Teacher {
    private String message;

    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();

        Student student1 = new Student("张三");
        Student student2 = new Student("李四");
        students.add(student1);
        students.add(student2);

        for (Student student : students) {
            student.getMessage("今天不上课");
        }
    }



}
