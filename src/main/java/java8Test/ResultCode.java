package java8Test;

/**
 * Created by zhangying on 2018/3/19.
 */
public enum ResultCode {
    C200("200", "success"),

    C400("400", "bad request"),

    Test("Test", "hello and hellow"),
    ;

    public String code;

    public String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    ResultCode(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return code + "--" + desc;
    }

    public static void main(String[] args) {
        ResultCode[] resultCodes = ResultCode.values();

        for (ResultCode resultCode : resultCodes) {
            System.out.println(resultCode);
            System.out.println(resultCode.ordinal());
        }
    }
}
