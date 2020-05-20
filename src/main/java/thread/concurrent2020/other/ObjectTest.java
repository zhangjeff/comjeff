package thread.concurrent2020.other;

import org.openjdk.jol.info.ClassLayout;

public class ObjectTest {

    public static void main(String[] args) {
//        Object o = new Object();
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        User user = new User();
//        user.setId(1);
//        user.setName("3333");
        Student student = new Student();
        System.out.println(ClassLayout.parseInstance(student).toPrintable());
    }
}

class User {
    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public void  setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student extends User {
    private int studentId;
}
