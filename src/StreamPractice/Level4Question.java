package StreamPractice;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Level4Question {
    public static void main(String[] args) {
        // 1.Flatten nested Map
        List<List<Integer>> numberList = Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(3,4),
                Arrays.asList(5,6)
        );
        List<Integer> flatList = numberList.stream().flatMap(x -> x.stream()).toList();
        System.out.println(flatList);  //[1, 2, 3, 4, 5, 6]

        //2.Convert list to map
        Employee emp1 =new Employee(110,"Monalisa","IT");
        Employee emp2 =new Employee(111,"Sam","IT");
        Employee emp3 =new Employee(112,"Lisa","Finance");
        List<Employee> employeelIst = Arrays.asList(emp1,emp2,emp3);
        Map<Integer, String> listToMap = employeelIst.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println(listToMap);    //{112=Lisa, 110=Monalisa, 111=Sam}

        //3.Find Longest String
        List<String> stringList =Arrays.asList("Java","Microservices","Spring");
        Optional<String> max = stringList.stream().max((Comparator.comparing(String::length)));
        System.out.println(max.orElse(null));        //Microservices

        //4. find common element between two list
        List<Integer> list1 =Arrays.asList(1,2,3,4);
        List<Integer> list2 =Arrays.asList(3,4,5,6);

        List<List<Integer>> listOfList = Arrays.asList(list1,list2);
        List<Integer> common = listOfList.stream().flatMap(x -> x.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println(common);  //todo type 1 to find common element b/w 2 list  - [3, 4]

        List<Integer> result = list1.stream().filter(list2::contains).toList();
        System.out.println(result);        //todo type 2 to find common element b/w 2 list  - [3, 4]

        //5. Check if all numbers are positive
        List<Integer> list3 =Arrays.asList(3,4,-5,6);
        boolean checkAll = list3.stream().allMatch(x -> x > 0);
        System.out.println(checkAll);    //false



    }
}
