package multiThreadingPrcatice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
todo Fixed Thread Pool Example ExecutorService service = Executors.newFixedThreadPool(3);
  Questions: What happens if tasks exceed thread count? How queue works internally?
 */

class Task implements Runnable{
    int id;
    public Task(int id){
        this.id = id;
    }

    public void run(){
        System.out.println("Task "+"executed by "+Thread.currentThread().getName());
    try{
        Thread.sleep(3000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
    }
}
public class Level2FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        /* this creates maximum 3 worker thread
         but we have to submit 5 tasks. for task 3 & task4 cant run immediately they go into an internal queue.
         newFixedThreadPool internally uses Linked blocking queue so this queue stores waiting task.

         When Thread-2 finishes its task instead of dying it becomes reusable. Pool took next task from the queue
         and assigned to Thread-2.

         *///In one line, extra tasks are stored in an internal blocking queue until worker threads become free.

        for(int i = 1;i<=5;i++) {
            executor.execute(new Task(i));
        }
        executor.shutdown();
    }
}
