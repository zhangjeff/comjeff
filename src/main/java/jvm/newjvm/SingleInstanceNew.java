package jvm.newjvm;

public class SingleInstanceNew {
    private SingleInstanceNew(){
    }

    static class  SubSingleInstanceNew {
        public static SingleInstanceNew instanceNew = new SingleInstanceNew();
    }

    public SingleInstanceNew  getNewSingleInstance(){
        return SubSingleInstanceNew.instanceNew;
    }
}
