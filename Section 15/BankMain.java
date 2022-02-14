//=============tryLock==============

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


public class BankMain {

    public static void main(String[] args) {
        final BankAccount account = new BankAccount("12345-678", 1000.00);

     Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300);
                account.withdraw(50);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100);


            }
        });
        t1.start();
        t2.start();


    }
}



 class BankAccount {

    private double balance;
    private String accountNumber;
    private ReentrantLock lock ;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock=new ReentrantLock();
    }

    public void deposit(double amount) {
        boolean status = false;
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try {
                    balance += amount;
                    status=true;
                }finally {
                    lock.unlock();
                }
            }
            else{
                System.out.println("Unable to get the lock");
            }
        }catch (InterruptedException e){
            e.getMessage();
        }
        System.out.println("Transaction status = "+status);

    }

    public void withdraw(double amount) {
        boolean status = false;
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try {
                    balance -= amount;
                    status=true;
                }finally {
                    lock.unlock();
                }
            }
            else{
                System.out.println("Unable to get the lock");
            }
        }catch (InterruptedException e){
            e.getMessage();
        }
        System.out.println("Transaction status = "+status);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber(){
        System.out.println(this.accountNumber);
    }

}