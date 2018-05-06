package observer.test;

/**
 * Created by zhangying on 2017/11/26.
 */
public class TestObserve {

    public static void main(String[] args) {
        TeacherSubject teacher = new TeacherSubject();
        StudentObserve studentObserve1 = new StudentObserve(teacher, "张三");
        StudentObserve studentObserve2 = new StudentObserve(teacher, "李四");
        StudentObserve studentObserve3 = new StudentObserve(teacher, "王五");

        teacher.setHomeWork("作业一");
        teacher.setHomeWork("作业二");
        teacher.setHomeWork("作业三");
    }
}
