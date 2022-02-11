//****************BASIC INPUT AND OUTPUT**************************

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location> locations = new HashMap<>();

    public static void main(String[] args) throws IOException{

//      WRITING into locations.dat using DataOutputStream
        try(DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))){
            for(Location location : locations.values()){
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());
                locFile.writeInt(location.getExits().size()-1);
                for(String direction : location.getExits().keySet()){
                    if(!direction.equalsIgnoreCase("Q")){
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }

    }
    static {
           
//    //===============READING data from locations.dat============================
    try(DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))){
        boolean eof = false;
        while(!eof){
            try{
                int locID = locFile.readInt();
                String description = locFile.readUTF();
                Map<String,Integer> exits = new LinkedHashMap<>();
                int sizeOfExits = locFile.readInt();
                for(int i=0 ; i<sizeOfExits;i++){
                    String direction = locFile.readUTF();
                    int destination = locFile.readInt();
                    exits.put(direction,destination);
                }
                locations.put(locID,new Location(locID,description,exits));
            }catch (EOFException e){
                eof=true;
            }

        }
    }catch(IOException io){
        io.printStackTrace();
    }



}

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
