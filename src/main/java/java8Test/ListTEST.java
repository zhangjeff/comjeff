package java8Test;

import java.util.Arrays;
import java.util.List;

public class ListTEST {

    public static void main(String[] args) {
        List<String> aaList = Arrays.asList("111","222","333","444");
        aaList.stream().map("p":: concat).forEach(System.out::println);
    }
}
