package StreamPractice;
import java.util.Arrays;
import java.util.List;

public class Level1Questions {
    public static void main(String[] args) {
        //Filtering even Numbers
        List<Integer>  numbers = Arrays.asList(1,2,3,4,5,6);
        System.out.println(numbers.stream().filter(x-> x%2 ==0).toList());
        //Convert names to Uppercase
        List<String> names = Arrays.asList("alex","john");
        System.out.println(names.stream().map(String::toUpperCase).toList());
        //find count of string starting with A
        List<String> name = Arrays.asList("alex","john","amiya");
        System.out.println(name.stream().filter(x->x.toUpperCase().startsWith("A")).count());
        //sort integer list
        List<Integer>  number1 = Arrays.asList(5,1,9,2);
        System.out.println(number1.stream().sorted().toList());
        //remove duplicates
        List<Integer>  number2 = Arrays.asList(1,2,2,3,3,4);
        System.out.println(number2.stream().distinct().toList());
    }
}
