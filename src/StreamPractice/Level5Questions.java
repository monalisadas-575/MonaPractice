package StreamPractice;
import java.util.*;
import java.util.stream.Collectors;

public class Level5Questions {
    public static void main(String[] args) {
        //21. Custom sorting by length
        List<String> list1 = Arrays.asList("Java","C","Python");
        List<String> ascendinglist = list1.stream().sorted((x, y) -> x.length() - y.length()).toList();
        System.out.println(ascendinglist);    //[C, Java, Python]

        List<String> descendingList = list1.stream().sorted(Comparator.comparing(String::length).reversed()).toList();
        System.out.println(descendingList);   //[Python, Java, C]

        //22.find top 3 highest numbers
        List<Integer> numbers = Arrays.asList(5,99,12,45,88,100);
         List<Integer> highestNumber=numbers.stream().sorted(Comparator.comparing(Integer::intValue)
                 .reversed()).limit(3).toList(); //todo type-1
        System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).limit(3).toList()); //todo type-2
        System.out.println(highestNumber);

        //23. Find sum of squares
        List<Integer> number = Arrays.asList(1,2,3);
        Optional<Integer> sumResult = number.stream().map(x -> x * x).reduce(Integer::sum);
        System.out.println(sumResult.get());    //9+4+1 =14

        //24. find employees older than 30 sorted by salary
        Employee emp1 = new Employee(21,115,"chhunu","Machinary");
        Employee emp2 = new Employee(34,115,"kunnu","IT");
        Employee emp3 = new Employee(30,115,"Munnu","Machinary");
        Employee emp4 = new Employee(38,115,"jhunnu","IT");
        emp1.setSalary(20000);
        emp2.setSalary(30000);
        emp3.setSalary(50000);
        emp4.setSalary(8000);

        List<Employee> employeeList = Arrays.asList(emp1,emp2,emp3,emp4);
        Map<String, Long> collect = employeeList.stream().filter(x -> x.getAge() > 30)
                .sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        System.out.println(collect);       //{kunnu=30000, jhunnu=8000}


    }
}
