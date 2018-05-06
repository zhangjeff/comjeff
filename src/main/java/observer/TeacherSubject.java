package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangying on 2017/11/26.
 */
public class TeacherSubject implements Subject {

    //用来保存观察者列表
    private List<Observer> observers = new ArrayList<Observer>();
    //记录状态的字符串
    private String info;



    public void addObserver(Observer obj) {
        observers.add(obj);
    }

    public void deleteObserver(Observer obj) {
        int index = observers.indexOf(obj);
        if (index > 0) {
            observers.remove(obj);
        }
    }

    public void notifyObserver() {
        for (Observer obj : observers) {
            obj.update(info);
        }
    }

    //布置作业的方法,在方法最后,需要调用notifyObserver()方法,通知所有观察者更新状态
    public void setHomework(String info){
        this.info=info;
        System.out.println("今天的作业是"+info);
        this.notifyObserver();
    }
}
