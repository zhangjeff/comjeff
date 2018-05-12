package observer;

import org.omg.CORBA.OBJ_ADAPTER;

/**
 * Created by zhangying on 2017/11/26.
 */
public class TestObserver {

    public static void main(String[] args) {

        TeacherSubject teacher=new TeacherSubject();
        StudentObserver zhangSan=new StudentObserver("张三", teacher);
        StudentObserver LiSi=new StudentObserver("李四", teacher);
        StudentObserver WangWu=new StudentObserver("王五", teacher);

        teacher.setHomework("第二页第六题");
        teacher.setHomework("第三页第七题");
        teacher.deleteObserver(WangWu);
        Observer zhaoLiu=new StudentObserver("赵六", teacher);
        //zhaoLiu.constant = 89;
        System.out.println(zhaoLiu.constant);
        teacher.setHomework("第五页第八题");
    }
}
