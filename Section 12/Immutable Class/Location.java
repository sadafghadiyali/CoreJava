/*
    Make Location Class in previous Challenge IMMUTABLE
*/

import java.util.HashMap;
import java.util.Map;

final public class Location {
    final private int locationID;
    final private  String description;
    final private Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits!=null)
            this.exits = new HashMap<String, Integer>(exits);
        else
            this.exits=new HashMap<String,Integer>();
        this.exits.put("Q", 0);
    }

    // public void addExit(String direction, int location) {
    //     exits.put(direction, location);
    // }
   
    
    public int getLocationID() {
        return locationID;
    }
    

    public String getDescription() {
        return description;
    }
    

    public Map<String, Integer> getExits() {
        return new HashMap<String,Integer>(exits);
    }
    
}

/*
Make the Location class an Immutable Class.

The strategy for creating an Immutable Class is:

    Steps:

    1. Don't provide setters.

    2. Make all fields final and private

    3. Don't allow the class to be subclassed.

    4. If the instance fields include references to mutable objects, don't allow those objects to be changed:   

            -  Don't provide methods that modify the mutable objects.

            -  Don't share references to the mutable objects.

As an added Task, handle the case where exits is null when passed to the constructor.

NOTE: Not all classes documented as "immutable" follow these rules. However, the steps above are the basis of an Immutable Class.

*/