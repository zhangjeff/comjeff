package observer.test;

/**
 * Created by zhangying on 2017/11/26.
 */
public class StudentObserve implements  Observe {

    private String name;

    private Subject subject;

    public StudentObserve(Subject subject, String name){

        this.name = name;
        this.subject = subject;
        subject.addObserve(this);
    }

    public void update(String info) {
        System.out.println(name + "得到作业");
    }
}
