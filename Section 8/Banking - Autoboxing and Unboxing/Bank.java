import java.util.*;
public class Bank {
    // write code here
    private String name;
    private ArrayList<Branch> branches;
    
    public Bank(String name){
        this.name=name;
        this.branches=new ArrayList<Branch>();
        
    }
    public boolean addBranch(String name){
        if(findBranch(name)==null){
            this.branches.add(new Branch(name));
            return true;
        }
        return false;
    }
    public boolean addCustomer(String branchName,String custName,double transaction){
        Branch br = findBranch(branchName);
        if(br!=null){
            //System.out.println("adding custName "+custName+" of branch "+branchName);
            return br.newCustomer(custName,transaction);
            //return true;
        }else
            return false;
    }
    
    public boolean addCustomerTransaction(String branchName,String custName,double transaction){
        Branch br= findBranch(branchName);
        
        if(br!=null ){
            return br.addCustomerTransaction(custName,transaction);
            //return true;
            
        }
        
            return false;
        
    }
    private Branch findBranch(String branchName){
        for(int i=0;i<this.branches.size();i++){
            if(this.branches.get(i).getName().equals(branchName)){
                return this.branches.get(i);
            }
        }return null;
    }
    public boolean listCustomers(String branchName,boolean listTransactions){
        Branch br=findBranch(branchName);
        if(br!=null){
            ArrayList<Customer> cust = br.getCustomers();
            System.out.println("Customer details for branch "+branchName);
            for(int i=0;i<cust.size();i++){
                System.out.println("Customer: "+cust.get(i).getName()+"["+(i+1)+"]");
                if(listTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> tr=cust.get(i).getTransactions();
                    for(int j=0;j<tr.size();j++){
                        System.out.println("["+(j+1)+"]  Amount "+tr.get(j));
                    }
                }
            }
            return true;
            
        }
        return false;
    }
}