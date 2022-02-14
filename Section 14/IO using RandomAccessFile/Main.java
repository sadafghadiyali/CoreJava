import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Locations locations = new Locations();
    private static Map<String,String> vocabulary = new HashMap<String,String>();
    public static void main(String[] args) throws IOException {
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        //int loc = 1 ;

        vocabulary.put("NORTH","N");
        vocabulary.put("SOUTH","S");
        vocabulary.put("EAST","E");
        vocabulary.put("WEST","W");
        vocabulary.put("QUIT","Q");

        Scanner sc=new Scanner(System.in);
        Location currentLocation = locations.getLocation(1);
        while(true) {
            System.out.println(currentLocation.getDescription());
            if (currentLocation.getLocationID() == 0) {
                break;
            }

            Map<String, Integer> exits = currentLocation.getExits();



            System.out.print("Available exits are ");
            for (String key : exits.keySet()) {
                System.out.print(key + ", ");
            }
            System.out.println();
            String direction = sc.nextLine().toUpperCase();

            String[] dirSplit = direction.split(" ");

            for (String dir : dirSplit) {
                if (vocabulary.containsKey(dir)) {
                    direction = vocabulary.get(dir);
                }
            }
            if (exits.containsKey(direction)) {
                currentLocation = locations.getLocation(exits.get(direction));
            }
            else {
                System.out.println("You cannot go in that direction");
            }
        }
        locations.close();
    }
}
