package multiThreadingPrcatice.level3AvoidDeadLock;

public class AvoidUsingLockingOrder {
    private static final Object lock1  = new Object();
    private static final Object lock2  = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized(lock1){
                synchronized(lock2){
                    System.out.println("Thread-1 completed");
                }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized(lock1){
                synchronized(lock2){
                    System.out.println("Thread2 completed");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
