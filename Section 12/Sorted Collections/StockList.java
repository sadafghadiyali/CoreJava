import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String,StockItem> list ;

    public StockList() {
        this.list=new LinkedHashMap<>();
    }

    public int addStock(StockItem item){
        if(item==null){
            System.out.println("We don't sell "+item.getName());
            return 0;
        }else{
        StockItem inStock = list.getOrDefault(item.getName(),item);

        if(inStock!=item){ //meaning item exits in stockList
            inStock.adjustStock(item.availableQuantity());
        }

        list.put(item.getName(),item);
        return item.getQuantityStock();
    }
    }

    public int sellStock(String item, int quantity){
        StockItem stockItem = list.get(item);
        if(stockItem != null){
            return stockItem.finaliseStock(quantity);
        }
//        if(item !=null && quantity>0 && stockItem.getQuantityStock() >= quantity) {
//            stockItem.adjustStock(-quantity);
//            return stockItem.getQuantityStock();
//        }
        else {
            System.out.println(item + " is not in the stocks list");
            return 0;
        }
    }

    public int reserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);

        if((inStock != null) && (quantity > 0)) {
            return inStock.reserveStock(quantity);
        }
        return 0;
    }

    public int unreserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);

        if((inStock != null) && (quantity > 0)) {
            return inStock.unreserveStock(quantity);
        }
        return 0;

    }

    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String, StockItem> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.getQuantityStock();

            s = s + stockItem + ". There are " + stockItem.getQuantityStock() + " in stock. Value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }

        return s + "Total stock value " + totalCost;
    }
}
