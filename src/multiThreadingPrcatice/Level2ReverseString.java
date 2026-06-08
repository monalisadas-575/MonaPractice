package multiThreadingPrcatice;

/*2. todo  Reverse string using multiple threads
       Split string processing into chunks.

 */

class ReverseWorker extends Thread{
     private String part;
     private String result;
     public ReverseWorker(String part){
         this.part = part;
     }
     public void run(){
         StringBuilder sb = new StringBuilder(part);
         result = sb.reverse().toString();
     }
     public String getResul(){
         return result;
     }
}

public class Level2ReverseString {
    public static void main(String[] args) throws InterruptedException {
        String structure = "HELLOWORLD";

        String part1 = structure.substring(0,5);
        String part2 = structure.substring(5);

        ReverseWorker t1 = new ReverseWorker(part1);
        ReverseWorker t2 = new ReverseWorker(part2);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        String reversed = t1.getResul()+t2.getResul();
        System.out.println("Original :"+structure);
        System.out.println("Reversed :"+reversed);
    }

}