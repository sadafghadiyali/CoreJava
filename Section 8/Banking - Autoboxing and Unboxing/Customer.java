import java.util.*;
public class Customer {
    // write code here
    private String name;
    private ArrayList<Double> transactions;
    
    public Customer(String name,double transactions){
        this.name=name;
        this.transactions=new ArrayList<Double>();
        this.transactions.add(transactions);
    }
    public String getName(){
        return name;
    }
    public ArrayList<Double> getTransactions(){
        return transactions;
    }
    public void addTransaction(double transaction){
        this.transactions.add(transaction);  
    }
}