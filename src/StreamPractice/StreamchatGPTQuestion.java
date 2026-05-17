package StreamPractice;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamchatGPTQuestion {
    //todo generating high employee salary, filtering them & processing them
    public static void main(String[] args) {

        //supplier-> generating salary for employees
        Supplier<Integer> salaryGenerator =()->(int)(Math.random()*100000);

        //predicate-> if salary is high
        Predicate<Integer> highSalary = salary-> salary>50000;

        //consumer-> process employee salary
        Consumer<Integer> processSalary = salary->{
                double tax = salary* 0.1;
            System.out.println(" Salary :"+salary+
                    " | Tax :"+tax+
                    " | final :"+(salary-tax)
            );
        };

        Stream.generate(salaryGenerator).limit(10).filter(highSalary).forEach(processSalary);
    }
}
