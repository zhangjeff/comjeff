package observer.test;

/**
 * Created by zhangying on 2017/11/26.
 */
public interface Subject {

    public void addObserve(Observe obj);

    public void deleteObserve(Observe obj);

    public void notieObserve(String info);
}
