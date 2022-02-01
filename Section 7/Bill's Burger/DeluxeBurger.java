public class DeluxeBurger extends Hamburger{

    public DeluxeBurger(){
        super("Deluxe","bacon",14.54,"bagel");
        super.addHamburgerAddition1("chips",2.75);
        super.addHamburgerAddition2("drink",1.81);
    }
    
    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

}

