//****************BASIC INPUT AND OUTPUT**************************

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {

//      WRITING into locations.dat using RandomAccessFile
        try (RandomAccessFile rao = new RandomAccessFile("location_Random.dat", "rwd")) {
            //File contains 4 sections
            //1st - number of records - 4 bytes
            //2nd - start Offset for location section
            //3rd - Index
            //4th - Finally the location object will be written here

            //1st section - number of records
            rao.writeInt(locations.size());

            //2nd section - start Offset for locations section
            int indexSize = locations.size() * 3 * Integer.SIZE;
            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.SIZE);
            rao.writeInt(locationStart);

            long indexStart = rao.getFilePointer();

            int startPointer = locationStart;
            rao.seek(startPointer);

            //4th section - Locations
            for (Location location : locations.values()) {
                rao.writeInt(location.getLocationID());
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for (String description : location.getExits().keySet()) {
                    builder.append(description);
                    builder.append(",");
                    builder.append(location.getExits().get(description));
                    builder.append(",");
                }
                rao.writeUTF(builder.toString());
                //Storing IndexRecord to write in index section all together
                IndexRecord indexRecord = new IndexRecord(startPointer, (int) rao.getFilePointer() - startPointer);
                index.put(location.getLocationID(), indexRecord);

                //setting startPointer for next location record
                startPointer = (int) rao.getFilePointer();
            }
            rao.seek(indexStart);
            for (int locationId : index.keySet()) {
                rao.writeInt(locationId);
                rao.writeInt(index.get(locationId).getStartByte());
                rao.writeInt(index.get(locationId).getLength());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static {

//    //===============READING data from locations_Random.dat============================
        try {

            ra = new RandomAccessFile("location_Random.dat", "rwd");
            int numberOfRecords = ra.readInt();
            int locationStart = ra.readInt();

            //putting the index in the index map
            while (ra.getFilePointer() < locationStart) {
                int locationId = ra.readInt();
                int locationStartPoint = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord indexRecord = new IndexRecord(locationStartPoint, locationLength);
                index.put(locationId, indexRecord);
            }
        } catch (IOException io) {
            io.printStackTrace();
        }


    }

    public static Location getLocation(int locationId) throws IOException {
        IndexRecord record = index.get(locationId);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        Location location = new Location(locationId, description, null);

        if (locationId != 0) {
            for (int i = 0; i < exitPart.length; i++) {
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i + 1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }

        return location;
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
        return locations.put(key, value);
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

    public void close() throws IOException {
        ra.close();
    }
}
