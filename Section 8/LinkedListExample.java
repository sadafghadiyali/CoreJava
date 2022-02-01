import java.util.*;

public class LinkedListExample{
	ArrayList<Album> albums = new ArrayList<>();
	
	Album album = new Album("Stormbringer", "Deep Purple");
	album.addSong("Stormbringer", 4.6);
	album.addSong("Love don't mean a thing", 4.22);
	album.addSong("Holy man", 4.3);
	album.addSong("Hold on", 5.6);
	album.addSong("Lady double dealer", 3.21);
	album.addSong("You can't do it right", 6.23);
	album.addSong("High ball shooter", 4.27);
	album.addSong("The gypsy", 4.2);
	album.addSong("Soldier of fortune", 3.13);
	albums.add(album);
	
	album = new Album("For those about to rock", "AC/DC");
	album.addSong("For those about to rock", 5.44);
	album.addSong("I put the finger on you", 3.25);
	album.addSong("Lets go", 3.45);
	album.addSong("Inject the venom", 3.33);
	album.addSong("Snowballed", 4.51);
	album.addSong("Evil walks", 3.45);
	album.addSong("C.O.D.", 5.25);
	album.addSong("Breaking the rules", 5.32);
	album.addSong("Night of the long knives", 5.12);
	albums.add(album);
	
	LinkedList<Song> playList = new LinkedList<Song>();
	albums.get(0).addToPlayList("You can't do it right", playList);
	albums.get(0).addToPlayList("Holy man", playList);
	albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
	albums.get(0).addToPlayList(9, playList);
	albums.get(1).addToPlayList(3, playList);
	albums.get(1).addToPlayList(2, playList);
	albums.get(1).addToPlayList(24, playList);  // There is no track 24	
}

public class Album {
    // write code here
    private String name,artist;
    private ArrayList<Song> songs;
    
    public Album(String name,String artist){
        this.name=name;
        this.artist=artist;
        this.songs=new ArrayList<Song>();
    }
    public boolean addSong(String title,double duration){
        
        if(findSong(title)!=null){
            return false;
        }else{
            songs.add(new Song(title,duration));
            return true;
        }
        
    }
    private Song findSong(String title){
        for(int i=0;i<this.songs.size();i++){
            if(songs.get(i).getTitle().equals(title)){
                return songs.get(i);
            }
        }
        return null;
    }
    public boolean addToPlayList(int track, LinkedList<Song> playList){
        int index = track-1;
        
        if(index>=0 && index<=this.songs.size()){
            playList.add(this.songs.get(index));
            return true;
        }
        else
            return false;
    }
    public boolean addToPlayList(String title,LinkedList<Song> playList){
        if(findSong(title)==null){
            return false;
        }else{
            playList.add(findSong(title));
            return true;
        }
    }
}

public class Song {
    // write code here
    
    private String title;
    private double duration;
    
    public Song(String title, double duration){
        this.title=title;
        this.duration=duration;
    }
    public String getTitle(){
        return title;
    }
    @Override
    public String toString(){
        return (this.title +": "+this.duration);
    }
}