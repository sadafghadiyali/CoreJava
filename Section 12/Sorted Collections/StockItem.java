public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantityStock =0;
    int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }
    public StockItem(String name,double price, int quantityStock){
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if(price > 0.0)
            this.price = price;
    }

    public void adjustStock(int quantityStock){
        int newQuantity = this.quantityStock+quantityStock;
        if(newQuantity >= 0){
            this.quantityStock = newQuantity;
        }
    }

    public int availableQuantity(){
        return quantityStock-reserved;
    }

    public int reserveStock(int quantity){
        if(quantity<=availableQuantity()){
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(int quantity){
        if(quantity<=reserved){
            reserved=reserved-quantity;
            return quantity;
        }
        return 0;
    }
    public int finaliseStock(int quantity){
        if(quantity<=reserved){
            quantityStock=quantityStock-quantity;
            reserved = reserved-quantity;
            return quantity;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + 57;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj== null && obj.getClass() != this.getClass()){
            return false;
        }
        if(this.getName().equals(((StockItem)obj).getName())){
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(StockItem o) {
        if(o == this){
            return 0;
        }
        else if(o!=null){
            return this.getName().compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }
}
