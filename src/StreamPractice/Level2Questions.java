package StreamPractice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Level2Questions {
    public static void main(String[] args) {
        //1. find maximum number
        List<Integer> numbers = Arrays.asList(10,45,3,99);
        Integer maxNumber = numbers.stream().max((x,y)->x-y).get();
        System.out.println(maxNumber);

        //2. find second max number
        Integer secondMax = numbers.stream().skip(1).findFirst().get() ;
        System.out.println(secondMax);

        //3.find first non-repeated character
        String name ="swiss";
        Character result = name.chars().mapToObj(c->(char)c)
                .filter(c->name.indexOf(c)==name.lastIndexOf(c))
                .findFirst()
                .orElse(null);
        System.out.println(result);    // todo one type to find 1st  non-repeating

        Character result2 = name.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(c->c.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst().      //w
                orElse(null);  // todo 2nd type to find 1st  non-repeating

        //4.find frequency of each character
        System.out.println(name.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));  //{s=3, w=1, i=1}


        //5. join string using comma
        List<String> name3 =Arrays.asList("Java","Python","Go");
        String collect = name3.stream().collect(Collectors.joining(","));
        System.out.println(collect);


    }
}
