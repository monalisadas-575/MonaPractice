 package multiThreadingPrcatice.level3AvoidDeadLock;

import java.util.concurrent.locks.ReentrantLock;

public class AvoidUsingTryLock {
    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while(true){
                if(lock1.tryLock()){
                    try{
                        if(lock2.tryLock()){
                            try{
                                System.out.println("Thread 1 working");
                                break;
                            }finally{
                                lock2.unlock();
                            }
                        }
                    }finally {
                        lock1.unlock();
                    }
                }
            }
        });
        t1.start();
    }

}
