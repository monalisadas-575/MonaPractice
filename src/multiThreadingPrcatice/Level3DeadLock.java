package multiThreadingPrcatice;

//todo 1. Implement Deadlock Scenario
//Then explain how to avoid it.-?todo these approach explained in level3AvoidDeadlock package.

public class Level3DeadLock {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (lock1){
                System.out.println("Thread-1 acquired lock1");
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread-1 is waiting for lock2");
                synchronized(lock2){
                    System.out.println("Thread-1 acquired lock2");
                }
            }
        });

        Thread t2= new Thread(()->{
            synchronized (lock2){
                System.out.println("Thread-2 is acquired lock2");
                try {
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread-2 is waiting for lock1");
                synchronized(lock1){
                    System.out.println("Thread-2 acquired lock1");
                }
            }
        });
         t1.start();
         t2.start();
    }
}
