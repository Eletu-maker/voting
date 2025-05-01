package VotingPlatfrom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;




public class Admin extends User {
    private Random random = new Random();


    private int numberOfParty;
    private HashMap<String,Integer> pool;
    private String link;
    private String title;
    private List<Voter> hasVoted;


    public Admin(String name, String password){
        super(name,password);
        this.numberOfParty = 0;
        this.pool = new HashMap<>();
        this.link = dLink();
        this.title = "";
        this.hasVoted = new ArrayList<>();

    }


    public List<Voter> getHasVoted(){
        return this.hasVoted;
    }


    public String dLink(){
        StringBuilder link = new StringBuilder();

        for (int count=0; count< 5; count++){
            int randomInt = random.nextInt(10);
            String singleNum = String.valueOf(randomInt);
            link.append(singleNum);
        }
        return link.toString();
    }

    public String getLink(){return this.link;}
    public void setTitle(String title){
        this.title =title;
    }
    public String getTitle(){return this.title;}

    public boolean checkLink(String input){
        return input.equals(this.link);
    }


    public void createPool(List<String> partiesNames){
        for(String name: partiesNames){
            this.pool.put(name,0);
        }
        this.numberOfParty = partiesNames.size();
    }

    public HashMap<String,Integer> getPool(){
        if(this.pool.isEmpty())return null;
        return this.pool;
    }

    public String toString(){
        return "name: "+super.getName()+"/n title: "+this.title+"/n link: "+this.link+"/n parties: "+this.numberOfParty;
    }
}


