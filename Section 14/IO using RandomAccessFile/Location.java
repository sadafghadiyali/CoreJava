import java.util.HashMap;
import java.util.Map;

public class Location {

    private final Map<String, Integer> exits;
    private final int locationID;
    private final String description;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits=new HashMap<>();
        this.exits.put("Q",0);
    }
    public Location(int locationID, String description,Map<String,Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits==null)
            this.exits=new HashMap<>();
        else{
            this.exits=exits;
        }
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String,Integer>(exits);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public void addExit(String direction, int locationID){
        this.exits.put(direction,locationID);
    }
}
