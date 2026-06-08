package multiThreadingPrcatice;

/*
todo 3. Find sum of large array using multithreading
 Expected: divide and conquer thread joining
 */

class SumWorker extends Thread{
    private int[] arr;
    private int start;
    private int end;
    private int sum = 0;
    public SumWorker(int[] arr,int start, int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    public void run(){
        for(int i =start;i<end;i++){
            sum += arr[i];
        }
        System.out.println(Thread.currentThread().getName()+" Partial sum :"+sum);
    }

    public int getSum(){
        return sum;
    }

}
public class Level2SumArray {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1,2,3,4,5,6,7,8};
        int mid = arr.length/2;
        SumWorker t1 = new SumWorker(arr,0,mid);
        SumWorker t2 = new SumWorker(arr,mid,arr.length);
        t1.start();
        t2.start();  //here 2 array will create by multithreading [1 2 3 4] [5 6 7 8].
        // after splitting partial sum of each 1+2+3+4=10, 5+6+7+8=26 then combine result
        t1.join();
        t2.join();
        int total = t1.getSum()+t2.getSum();
        System.out.println("Final sum of :"+total);
    }
}
