package VotingPlatfrom;

import java.util.HashMap;
import java.util.Map;

public class Voter extends User {



    public Voter(String name, String pin){
        super(name,pin);

    }



    public HashMap<String,Integer> getvoting(String link, Voting voting){
        for(Admin admin:voting.getAdmins()){
        if(admin.checkLink(link)){
            return admin.getPool();
        }
        }
        return null;
    }


    public void checkIfVoterhasVotedAlready(Admin admin) {
        for (Voter voter : admin.getHasVoted()) {
            if (voter.getName().equals(this.getName()) && voter.checkPassword(this.getPassword())) {
                throw new IllegalArgumentException("You have voted already");
            }
        }

        admin.getHasVoted().add(this);
    }


    public void vote(String party, String link, Voting voting,Admin admin){
        HashMap<String,Integer> candidate = getvoting(link,voting);
        checkIfVoterhasVotedAlready(admin);
        int num;
        for(Map.Entry<String, Integer> entry : candidate.entrySet()){
            if(entry.getKey().equals(party)){
              num = entry.getValue();
              num++;
              entry.setValue(num);
            }
        }
    }


    public String toString(){
        return "name: "+super.getName() ;
    }


}
