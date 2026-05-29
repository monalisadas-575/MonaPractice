package multiThreadingPrcatice;

/*
5. Todo Synchronize bank account withdrawal
    Scenario:Two threads withdrawing from same account.
    Concepts:
    race condition
    synchronized block
 */
public class BeginerBankAccount {
    public static void main(String[] args) {
        BankAccount bc = new BankAccount();
        Customer c1 = new Customer(bc, "Mona", 500);
        Customer c2 = new Customer(bc, "raja", 800);
        c1.start();
        c2.start();
    }
}
class BankAccount{
    private int balance = 1000;
    public void withdraw(String name, int amount){

        synchronized(this){
            System.out.println(name+ " trying to withdraw " +amount);

            if(balance >= amount){
                System.out.println(name+" processing withdrawl "+amount);
                balance = balance-amount;
                System.out.println(name + " completed withdrawal");
                System.out.println("Remaining Balance: " + balance);
            }
            else{
                System.out.println(name +" insufficient balance");
            }
        }
    }
}
class Customer extends Thread{
    BankAccount account;
    int amount;
    public Customer(BankAccount account,String name,int amount){
        super(name);
        this.account = account;
        this.amount = amount;
    }
    public void run(){
        account.withdraw(getName(),amount);
    }

}
