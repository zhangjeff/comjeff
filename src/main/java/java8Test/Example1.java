package java8Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
//        List<BigDecimal> costBeforeTax2 = Arrays.asList(new BigDecimal("100"), new BigDecimal("200"), new BigDecimal("300"));
//        costBeforeTax2.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);

//        costBeforeTax2.stream().map((ct) -> ct + 1.1*ct).forEach(System.out::println);

//        Integer totalAmt =  costBeforeTax2.stream().map((cost) -> 2*cost).reduce((sum, cost1) -> sum + cost1).get();
//        System.out.println(totalAmt);
//
//
//        BigDecimal totalAmt =  costBeforeTax2.stream().map((cost) -> cost).reduce(BigDecimal.TEN,  BigDecimal::add);
//        System.out.println(totalAmt);


//        List<String> stringList = Arrays.asList("aaaa", "bbbb", "ccccc", "adddddrrrrrr");
//
//        List<String> filtered = stringList.stream().filter(x -> x.length()> 4).collect(Collectors.toList());
//        System.out.printf("Original List : %s, filtered list : %s %n", stringList, filtered);
//
//        List<String> filterNew = stringList.stream().filter(x->x.startsWith("a")).collect(Collectors.toList());
//        System.out.printf("Original List : %s, filtered list : %s %n", stringList, filterNew);


//        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
//        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
//        System.out.println(G7Countries);

        // 用所有不同的数字创建一个正方形列表
//        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
//        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
////        List<Integer> distinct = numbers.stream().map( i -> i*i).collect(Collectors.toList());
//        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);

        //获取数字的个数、最小值、最大值、总和以及平均值
//        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
//        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
//
//        System.out.println("Highest prime number in List : " + stats.getMax());
//        System.out.println("Lowest prime number in List : " + stats.getMin());
//        System.out.println("Sum of all prime numbers : " + stats.getSum());
//        System.out.println("Average of all prime numbers : " + stats.getAverage());


//        List<Integer> primes = Arrays.asList(new Integer[]{2, 3,5,7});
//        int factor = 2;
//        primes.forEach(p -> System.out.println(p*factor));
//        primes.forEach(element -> { System.out.println(factor*element); });
//        primes.forEach(p -> {System.out.println(p*factor);});

//        String[] atp = {"Rafael Nadal", "Novak Djokovic",
//                "Stanislas Wawrinka",
//                "David Ferrer","Roger Federer",
//                "Andy Murray","Tomas Berdych",
//                "Juan Martin Del Potro"};
//        List<String> players =  Arrays.asList(atp);
//        players.forEach((play) -> System.out.print(play + ";"));
//        players.forEach(System.out::println);

        new Thread(() -> System.out.println("hello Jeff!")).start();
        Runnable runnable = () -> System.out.println("hello jeff2 !");
        new Thread(runnable).start();
    }


}
