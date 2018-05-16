package java8Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by zhangying on 2018/5/16.
 */
public class Example1 {

    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            public void run() {
//                System.out.println("Before Java8, too much code for too little to do");
//            }
//        }).start();
//
//        //Java 8方式：
//        new Thread( () -> System.out.println("in Java8, Lambda expression rocks!!") ).start();
//
//        new Thread(()-> System.out.println("hello jeff!")).start();


        // Java 8之前：
//        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        for (String feature : features) {
//            System.out.println(feature);
//        }

//        features.forEach(p -> System.out.println(p));
//        List<String> stringList = Arrays.asList("aaaa", "bbbb", "ccccc", "ddddd");
//        stringList.forEach(p-> System.out.println(p));


        // 不使用lambda表达式为每个订单加上12%的税
//        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        for (Integer cost : costBeforeTax) {
//            double price = cost + .12*cost;
//            System.out.println(price);
//        }

        // 使用lambda表达式
        List<BigDecimal> costBeforeTax2 = Arrays.asList(new BigDecimal("100"), new BigDecimal("200"), new BigDecimal("300"));
//        costBeforeTax2.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);

//        costBeforeTax2.stream().map((ct) -> ct + 1.1*ct).forEach(System.out::println);

//        Integer totalAmt =  costBeforeTax2.stream().map((cost) -> 2*cost).reduce((sum, cost1) -> sum + cost1).get();
//        System.out.println(totalAmt);
//

        BigDecimal totalAmt =  costBeforeTax2.stream().map((cost) -> cost).reduce(BigDecimal.TEN,  BigDecimal::add);
        System.out.println(totalAmt);

    }


}
