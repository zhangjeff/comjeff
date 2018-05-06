package observer.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangying on 2017/11/26.
 */
public class TeacherSubject implements Subject {

    private String info;

    private List<Observe> observeList = new ArrayList<Observe>();


    public void addObserve(Observe obj) {
        observeList.add(obj);
    }

    public void deleteObserve(Observe obj) {
        int i = observeList.indexOf(obj);

        if (i > 0) {
            observeList.remove(obj);
        }

    }

    public void notieObserve(String info) {
        for (Observe obj : observeList) {
            obj.update(info);
        }
    }

    public void setHomeWork(String info){
        this.info = info;
        System.out.println("今天的作业是" + info);
        notieObserve(info);
    }
}
