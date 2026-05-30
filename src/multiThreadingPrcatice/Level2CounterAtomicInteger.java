package multiThreadingPrcatice;

import java.util.concurrent.atomic.AtomicInteger;

class CounterAtomic{
    private AtomicInteger count = new AtomicInteger(0);

    public void increment(){
        count.incrementAndGet();
    }
    public int getCount(){
        return count.get();
    }
}
class AtomicThread extends Thread{
    CounterAtomic counter;

    public AtomicThread(CounterAtomic counter) {
        this.counter = counter;
    }
    public void run(){
        for(int i = 0; i<1000;i++){
            counter.increment();
        }
    }
}
public class Level2CounterAtomicInteger {
    public static void main(String[] args) throws InterruptedException {
        CounterAtomic counter = new CounterAtomic();
        AtomicThread t1  = new AtomicThread(counter);
        AtomicThread t2 = new AtomicThread(counter);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final Count = " + counter.getCount());

    }
}
