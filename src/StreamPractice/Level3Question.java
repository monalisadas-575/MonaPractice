package StreamPractice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Level3Question {
    public static void main(String[] args) {

        //11.Find duplicate elements
        List<Integer> numbers = Arrays.asList(1,2,3,2,4,5,1);
        numbers.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(c->c.getValue()>1)
                .map(c->c.getKey()).forEach(System.out::println);

        //12.Partition even & odd number
        List<Integer> number2 = Arrays.asList(1,2,3,4,5);
        Map<String, List<Integer>> collect =
                number2.stream().
                        collect(Collectors.groupingBy(x -> x % 2 == 0?"Even":"Odd"));
        System.out.println(collect);

        //13. Group employees by department
        List<Employee> employeeList = Arrays.asList(new Employee(100,"Mona","IT")
                ,new Employee(101,"Raja","Finance")
                ,new Employee(102,"Loja","Finance")
                ,new Employee(103,"Rinky","IT"));
        Map<String,List<String>> listWithDepartment =employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDept
                        ,Collectors.mapping(Employee::getName,Collectors.toList())))
                ;
        System.out.println(listWithDepartment);     //{Finance=[Raja, Loja], IT=[Mona, Rinky]}


    }

}
 class Employee{
    int id;
    String name;
    String dept;

    public Employee(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
