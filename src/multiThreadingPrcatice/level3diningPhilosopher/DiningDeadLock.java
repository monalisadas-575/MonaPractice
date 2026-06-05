package multiThreadingPrcatice.level3diningPhilosopher;

public class DiningDeadLock implements Runnable {
    private final Object leftFork;
    private final Object rightFork;

    public DiningDeadLock(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {

        while (true) {

            synchronized (leftFork) {

                System.out.println(Thread.currentThread().getName()
                        + " picked left fork");

                synchronized (rightFork) {

                    System.out.println(Thread.currentThread().getName()
                            + " eating");
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
