package StreamPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPracticeOnMap {
    public static void main(String[] args) {
        //todo find employees with highest salary
        Map<String,Integer> salaries = new HashMap<>();
        salaries.put("Mohani",60000);
        salaries.put("Chandra",100000);
        salaries.put("Saumrit",70000);
        salaries.put("Rajendra",40000);
        Map.Entry<String, Integer> highestSalary = salaries.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        System.out.println(highestSalary);

        //todo find average salary of Employees
        Double collect = salaries.entrySet().stream().collect(Collectors.averagingDouble(Map.Entry::getValue));
        System.out.println(collect);    //67500.0

        //todo prints only those keys whose value >50

        Map<String, Integer> marks = Map.of(
                "Math", 90,
                "Science", 40,
                "English", 80
        );
        marks.entrySet().stream()  //to convert map into stream
                .filter(x->x.getValue()>50)
                .map(Map.Entry::getKey).forEach(System.out::println);

    }
}
