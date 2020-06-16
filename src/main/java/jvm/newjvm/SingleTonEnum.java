package jvm.newjvm;

public class SingleTonEnum {
    public enum SingletonEnum {
        INSTANCE;
        int value;// 这里我们可以自定义构造函数.
        private SingletonEnum() {
            value = 1;
            System.out.println("INSTANCE now created!");
        }
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        System.out.println("start get instance!");
        SingletonEnum singleton = SingletonEnum.INSTANCE;
        System.out.println(singleton.getValue());
        singleton.setValue(2);
        System.out.println(singleton.getValue());
    }
}
