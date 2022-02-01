public class Hamburger {
    
    private String name,meat,breadRollType;
    private double price;
    
    private String addition1Name,addition2Name,addition3Name,addition4Name;
    private double addition1Price,addition2Price,addition3Price,addition4Price;
    
    
    public Hamburger(String name,String meat,double price,String breadRollType){
        
        this.name=name;
        this.meat=meat;
        this.breadRollType=breadRollType;
        this.price=price;
    }
    
    public void addHamburgerAddition1(String name,double price){
        this.addition1Name=name;
        this.addition1Price=price;
    }
    
    public void addHamburgerAddition2(String addition2Name,double addition2Price){
        this.addition2Name=addition2Name;
        this.addition2Price=addition2Price;
    }
    public void addHamburgerAddition3(String addition3Name,double addition3Price){
        this.addition3Name=addition3Name;
        this.addition3Price=addition3Price;
    }
    public void addHamburgerAddition4(String addition4Name,double addition4Price){
        this.addition4Name=addition4Name;
        this.addition4Price=addition4Price;
    }
    
    public double itemizeHamburger(){
        if(addition1Name!=null){
            System.out.println( "Added "+addition1Name+" for an extra "+addition1Price);
            price=price+addition1Price;
        }
        if(addition2Name!=null){
            System.out.println( "Added "+addition2Name+" for an extra "+addition2Price);
            price=price+addition2Price;
        }
        if(addition3Name!=null){
            System.out.println( "Added "+addition3Name+" for an extra "+addition3Price);
            price=price+addition3Price;
        }
        if(addition4Name!=null){
            System.out.println( "Added "+addition4Name+" for an extra "+addition4Price);
            price=price+addition4Price;
        }
        return price;
    }
}