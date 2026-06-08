package multiThreadingPrcatice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
todo 1. Implement Producer Consumer using BlockingQueue
 Expected: ArrayBlockingQueue put() take()
 */
public class Level2ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);  //maximum can hold 3 items at same time.
        // Consumer is fast enough to keep removing items so producer never gets blocked.

        ProducerBlocking p = new ProducerBlocking(queue);
        ConsumerBlocking c= new ConsumerBlocking(queue);
        p.start();
        c.start();
    }
}
class ProducerBlocking extends Thread {
    BlockingQueue<Integer> queue;

    public ProducerBlocking(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                queue.put(i);  //added item
                System.out.println("Produced :" + i);
                Thread.sleep(500);
            }// after printing produced context switching happens so CPU switches to consumetr thread.

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class ConsumerBlocking extends Thread{
    BlockingQueue<Integer> queue;

    public ConsumerBlocking(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    public void run(){
        try{
            for(int i=1; i<=5; i++){
                int value = queue.take();//remove item
                System.out.println("Consumed :"+value);
                Thread.sleep(1000);  //if it sleeps for 5sec then at time it will produce [1,2,3] now 3 items are in queue
                // then consumer will consume because queue is filled now then it can add 1 item to queue again wait 5sec for consumer to consume
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

