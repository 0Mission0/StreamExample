package idv.mission.example.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceTest {
    public static void main(String[] args) {
        // int count = Stream.of(1, 2, 3).reduce(100, (sum, element) -> sum + element);
        int count = Stream.of(1, 2, 3).reduce(1, (sum, element) -> sum + element);
        System.out.println("count = " + count);

        String words = Stream.of("is", "a", "book").reduce("This", (result, element) -> result + " " + element);
        System.out.println("words = " + words);

        // Notice Option Integer should match with get()
        int min = Stream.of(1, 2, 3).min(Comparator.comparing(element -> element)).get();
        System.out.println("min = " + min);

        int max = Stream.of(1, 2, 3).reduce(0, (tempMax, element) -> Integer.max(tempMax, element));
        System.out.println("max = " + max);

        int sum = Stream.of(1, 2, 3).reduce(1, (tempSum, element) -> tempSum + element);
        System.out.println("sum = " + sum);
        
        String[] strArray = {"1", "2", "3"};
        String result = Stream.of(strArray).reduce("", (tempResult, element) -> tempResult + "'" + element + "',");
        System.out.println("result = " + result);
        
        result = Stream.of(strArray).map(str -> "'" + str + "'").collect(Collectors.joining(", "));
        System.out.println("result = " + result);
        
        List<String> defaultOrder = Arrays.asList(new String[]{"package_name", "contract_period", "monthly_fee"});
        //defaultOrder = defaultOrder.stream().filter(str -> !str.equals("package_name")).collect(Collectors.toList());
        String combinedStr = defaultOrder.stream().map(str -> "'" + str + "'").collect(Collectors.joining(", "));
        System.out.println(combinedStr);
    }
}
