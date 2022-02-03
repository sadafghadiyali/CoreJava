import java.util.*;
public class Player implements ISaveable{
    // write code here
    private String name,weapon;
    private int hitPoints,strength;
    
    public Player(String name,int hitPoints,int strength){
        this.name=name;
        this.hitPoints=hitPoints;
        this.strength=strength;
        this.weapon="Sword";
    }
    
    public String getName(){
        return name;
    }
    public String getWeapon(){
        return weapon;
    }
    public int getHitPoints(){
        return hitPoints;
    }
    public int getStrength(){
        return strength;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setWeapon(String weapon){
        this.weapon=weapon;
    }
    public void setHitPoints(int hitPoints){
        this.hitPoints=hitPoints;
    }
    public void setStrength(int strength){
        this.strength=strength;
    }
    @Override
    public String toString(){
        return ("Player{name='"+this.name+
        "', hitPoints="+this.hitPoints+
        ", strength="+this.strength+
        ", weapon='"+this.weapon+"'}");
    }
    @Override
    public List<String> write(){
        List<String> list=new ArrayList<String>();
        list.add(this.name);
        list.add(""+this.hitPoints);
        list.add(""+this.strength);
        list.add(this.weapon);
        return list;
    }
    @Override
    public void read(List<String> list){
        if(list!=null && list.size()>0){
            this.name=list.get(0);
            this.hitPoints=Integer.parseInt(list.get(1));
            this.strength=Integer.parseInt(list.get(2));
            this.weapon=list.get(3);
        }
    }
}

//import java.util.*;
public class Monster implements ISaveable{
    // write code here
    private String name;
    private int hitPoints,strength;
    
    public Monster(String name,int hitPoints,int strength){
        this.name=name;
        this.hitPoints=hitPoints;
        this.strength=strength;
    }
    
    public String getName(){
        return name;
    }
    
    public int getHitPoints(){
        return hitPoints;
    }
    public int getStrength(){
        return strength;
    }
    
    @Override
    public String toString(){
        return ("Monster{name='"+this.name+
        "', hitPoints="+this.hitPoints+
        ", strength="+this.strength+"}");
    }
    @Override
    public List<String> write(){
        List<String> list=new ArrayList<String>();
        list.add(this.name);
        list.add(""+this.hitPoints);
        list.add(""+this.strength);
        return list;
    }
    @Override
    public void read(List<String> list){
        if(list!=null && list.size()>0){
            this.name=list.get(0);
            this.hitPoints=Integer.parseInt(list.get(1));
            this.strength=Integer.parseInt(list.get(2));
            
        }
    }
}

//import java.util.*;
public interface ISaveable {
    // write code here
    List<String> write();
    void read(List<String> list);
}



public class InterfaceChallengeMain {

    public static void main(String[] args) {
        // Create a simple interface that allows an object to be saved to some sort of storage medium.
        // The exact type of medium is not known to the interface (nor to the classes that implement it).
        // The interface will just specify 2 methods, one to return an ArrayList of values to be saved
        // and the other to populate the object's fields from an ArrayList.
        //
        // Create some sample classes that implement your saveable interface (we've used the idea of a game,
        // with Players and Monsters, but you can create any type of classes that you want).
        //
        // Override the toString() method for each of your classes so that they can be easily printed to enable
        // the program to be tested easier.
        //
        // In Main, write a method that takes an object that implements the interface as a parameter and
        // "saves" the values.
        // We haven't covered I/O yet, so your method should just print the values to the screen.
        // Also in Main, write a method that restores the values to a saveable object.
        // Again, we are not going to use Java file I/O; instead use the readValues() method below to
        // simulate getting values from a file – this allows you to type as many values as your class
        // requires, and returns an ArrayList.

        Player tim = new Player("Tim", 10, 15);
        System.out.println(tim.toString());
        saveObject(tim);

        tim.setHitPoints(8);
        System.out.println(tim);
        tim.setWeapon("Stormbringer");
        saveObject(tim);
//        loadObject(tim);
        System.out.println(tim);

        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println("Strength = " + ((Monster) werewolf).getStrength());
        saveObject(werewolf);

    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for(int i=0; i<objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}
