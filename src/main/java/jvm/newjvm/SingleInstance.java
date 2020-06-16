package jvm.newjvm;

public class SingleInstance {

    private volatile SingleInstance singleInstance;

    private Object obj;

    private SingleInstance(){
    }
    public SingleInstance getInstance(){
        if (singleInstance == null) {
            synchronized (obj) {
                if (singleInstance == null) {
                    singleInstance = new SingleInstance();
                    return singleInstance;
                }
            }
        }
        return singleInstance;
    }
}
