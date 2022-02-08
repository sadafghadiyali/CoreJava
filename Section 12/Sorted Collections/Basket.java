import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final Map<StockItem,Integer> list;
    private final String name;

    public Basket(String name) {
        this.name = name;
        list = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public int addToBasket(StockItem item, int quantity){
        if(item!=null && quantity>0){
            int inBasket =  list.getOrDefault(item,0);
            list.put(item,inBasket + quantity);
            return item.availableQuantity();
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity){
        int inBasket = list.getOrDefault(item,0);
        int newQuantity = inBasket-quantity;
        if(newQuantity>0 ){
            list.put(item,newQuantity);
            return quantity;
        }else if(newQuantity==0){
            list.remove(item);
            return quantity;
        }
        return 0;
    }
    public void clearBasket(){
        list.clear();
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }
    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + " items\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }


}
