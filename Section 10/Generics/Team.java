import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team <T>>{
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        if(members.contains(player)){
            System.out.println(player.getName()+" already exists in "+this.name);
            return false;
        }else{
            this.members.add(player);
            return true;
        }
    }
    public int numPlayers(){
        return this.members.size();
    }
    public void matchResult(Team<T> opponent,int ourResult,int theirResult){
        String message = "";
        if(ourResult>theirResult){
            won++;
            message=" won against ";
        }else if(ourResult<theirResult){
            lost++;
            message= " lost against ";
        }else{
            tied++;
            message = " tied with ";
        }
        played++;
        if(opponent!=null){
            System.out.println(this.name + message + opponent.getName());
            matchResult(null,theirResult,ourResult);
        }
    }
    public int ranking() {
        return (won * 2) + tied;
    }


    @Override
    public int compareTo(Team<T> opponent) {
        if(this.ranking() < opponent.ranking()){
            return -1;
        }else if(this.ranking() > opponent.ranking()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
