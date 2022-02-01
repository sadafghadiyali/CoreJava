import java.util.*;

public class Branch {
    
    // write code here
    private String name;
    private ArrayList<Customer> customers;
    
    public Branch(String name){
        this.name=name;
        this.customers=new ArrayList<Customer>();
    }
    public String getName(){
        return name;
    }
    public ArrayList<Customer> getCustomers(){
        return this.customers;
    }
    public boolean newCustomer(String name,double transaction){
        if(findCustomer(name)==null){
            this.customers.add(new Customer(name,transaction));
            return true;
        }else{
            return false;
        }
    }
    public boolean addCustomerTransaction(String name, double transaction){
        Customer cust=findCustomer(name);
        if(cust!=null){
            cust.addTransaction(transaction);
            return true;
        }
        else{
            return false;
        }
    }
    private Customer findCustomer(String name){
        for(int i=0;i<this.customers.size();i++){
            if(this.customers.get(i).getName().equals(name)){
                return this.customers.get(i);
            }
        }
        return null;
    }
}