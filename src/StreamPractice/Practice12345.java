package StreamPractice;

import dto.PrivateEmployee;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Practice12345 {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1, 3, 5, 6, 7);
        System.out.println(numberList.stream().reduce(10, (x, y) -> x + y));


        List<PrivateEmployee> privateEmployees = new ArrayList<>();
        PrivateEmployee privateEmployee1 = new PrivateEmployee("dunga", "CIVIL", 30);
        PrivateEmployee privateEmployee2 = new PrivateEmployee("dunu", "CSE", 31);
        PrivateEmployee privateEmployee3 = new PrivateEmployee("pandu", "MECH", 2);
        privateEmployees.add(privateEmployee1);
        privateEmployees.add(privateEmployee2);
        privateEmployees.add(privateEmployee3);

        List<PrivateEmployee> result = new ArrayList<>();
        for (PrivateEmployee employee : privateEmployees) {
            if (new MyOwn().test(employee.getAge()))
                result.add(employee);
        }

        //After Stream
        Predicate<PrivateEmployee> pp= y -> y.getName().startsWith("d");
        Predicate<PrivateEmployee> qq= x -> x.getAge() > 12;
        List<PrivateEmployee> result1 = privateEmployees.stream()
                .filter(pp.and(qq)).toList();

        result1.forEach(x -> System.out.println(x.getName()));
        System.out.println("=======================");
        System.out.println( result1.stream().map(PrivateEmployee::getName).toList());
        List<Integer> list1 = Arrays.asList(1,2,1,3);
        List<Integer> list2 = Arrays.asList(2,3,3,4);
        List<Integer> list3 =list1.stream().distinct().toList();
        List<Integer> list4 =list2.stream().distinct().toList();

        List<List<Integer>> listOfList = Arrays.asList(list3, list4);
        List<Integer> resultList = listOfList.stream().flatMap(x -> x.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(c -> c.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println(resultList);
        System.out.println("=======================");

        List.of(list1.stream().distinct().toList(),
                list2.stream().distinct().toList())
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(c -> c.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList()
                .forEach(System.out::println);


    }
}
