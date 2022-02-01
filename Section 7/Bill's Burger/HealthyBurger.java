public class HealthyBurger extends Hamburger{

    private String healthyExtra1Name,healthyExtra2Name;
    private double healthyExtra1Price,healthyExtra2Price;
    
    public HealthyBurger(String meat,double price){
        super("Healthy",meat,price,"brown");
        
    }

    public void addHealthyAddition1(String healthyExtra1Name,double healthyExtra1Price){
        this.healthyExtra1Name=healthyExtra1Name;
        this.healthyExtra1Price=healthyExtra1Price;
    }
    
    public void addHealthyAddition2(String healthyExtra2Name,double healthyExtra2Price){
        this.healthyExtra2Name=healthyExtra2Name;
        this.healthyExtra2Price=healthyExtra2Price;
    }
    
    @Override
    public double itemizeHamburger(){
        double Hprice=super.itemizeHamburger();
        
        if(healthyExtra1Name!=null){
            System.out.println( "Added "+healthyExtra1Name+" for an extra "+healthyExtra1Price);
            Hprice+=healthyExtra1Price;
        }
        if(healthyExtra2Name!=null){
            System.out.println( "Added "+healthyExtra2Name+" for an extra "+healthyExtra2Price);
            Hprice+=healthyExtra2Price;
        }
        
        return (Hprice);
    }
}