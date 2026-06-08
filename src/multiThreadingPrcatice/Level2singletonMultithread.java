package multiThreadingPrcatice;


class Singleton{
    private static volatile Singleton instance;
    private Singleton(){
        System.out.println("Singleton got created");
    }
    public static Singleton getInstance(){
        if(instance==null){ //1st check once object created it eneter into synchronized while other thread wait for lock
            synchronized(Singleton.class){
                if(instance==null){  //2nd check because another thread may have created while current thread was waiting for lock
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
class MyThread extends Thread{
    public void run(){
        Singleton s = Singleton.getInstance();
        System.out.println(s.hashCode());
    }
}
public class Level2singletonMultithread {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start(); //1381438598   1381438598

    } //Double checked locking ensures only one singleton instance is created in a multithread environment while
    // minimizing synchronization overhead.

}
