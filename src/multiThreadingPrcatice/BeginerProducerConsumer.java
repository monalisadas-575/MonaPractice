package multiThreadingPrcatice;

/*
4. Todo Producer Consumer Problem (basic)
    Expected:
    shared buffer
    wait()
    notify()
 */

public class BeginerProducerConsumer {
    public static void main(String[] args) {
        SharedResource buffer = new SharedResource();

        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);
        p.start();
        c.start();
    }

}
class SharedResource{
    private int data;
    private boolean hasData;

    public synchronized void produce(int value){
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            data = value;
            hasData = true;
            System.out.println("produced :"+value);
            notify();

    }

    public synchronized int consume(){
        while(!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            hasData =false;
            System.out.println("Consumed :"+data);
            notify();
            return data;
    }
}

class Producer extends Thread{
    SharedResource buffer;

    public Producer(SharedResource buffer){
        this.buffer = buffer;
    }

    public void run(){
        for(int i = 1; i<=5; i++){
            buffer.produce(i);
        }
    }
}

class Consumer extends Thread{
    SharedResource buffer;

    public Consumer(SharedResource buffer) {
        this.buffer = buffer;
    }

    public void run(){
        for(int i=1; i<=5; i++){
            buffer.consume();
        }
    }
}