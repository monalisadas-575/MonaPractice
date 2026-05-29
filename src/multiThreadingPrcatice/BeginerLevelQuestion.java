package multiThreadingPrcatice;

import java.lang.reflect.Array;

/*3.todo Print even and odd numbers using 2 threads
     Expected concepts:
     synchronization
     wait
     notify
 */
public class BeginerLevelQuestion {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();
        Thread oddThread = new Thread(()->{
            printer.printOdd();
        });
        Thread evenThread = new Thread(()->{
            printer.printEven();
        });
        oddThread.start();
        evenThread.start();

        //1. print even and odd number using 2 thread

    }
}
class NumberPrinter {
    private int number = 1;
    private final int max = 10;

    public synchronized void printOdd() {
        while (number <= max) {

            while (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= max) {
                System.out.println("Odd thread :" + number);
                number++;
                notify();
            }
        }
    }

    public synchronized void printEven() {
        while (number <= max) {

            while (number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= max) {
                System.out.println("even thread :" + number);
                number++;
                notify();
            }
        }
    }
}