package VotingPlatfrom;

import java.util.ArrayList;
import java.util.List;


public  class Voting {
    private List<Admin> admins;
    private List<Voter> voters;

    public Voting() {
        this.admins = new ArrayList<>();
        this.voters = new ArrayList<>();
    }

    public List<Admin> getAdmins(){return this.admins;}
    public List<Voter> getVoters(){return this.voters;}

    public void addAdmin(String name, String password) {
        Admin Newadmin = new Admin(name.trim().toLowerCase(), password);
        for (Admin admin : admins) {
            if (admin.getName().equals(name) && admin.checkPassword(password)) {
                return;
            }
        }
        admins.add(Newadmin);
    }

    public void  addVoter(String name, String password){
        Voter newVoter = new Voter(name.trim().toLowerCase(),password);
        for (Voter voter:voters){
            if(voter.getName().equals(name)&& voter.checkPassword(password)){
                return;
            }
        }
        voters.add(newVoter);


    }
    public Admin findAdmin(String name, String password) {
        for (Admin admin : admins) {
            if (admin.getName().equals(name) && admin.checkPassword(password)) {
                return admin;
            }

        }
        return null;
    }

    public Voter findVoter(String name, String password) {
        for (Voter voter : voters) {
            if (voter.getName().equals(name) && voter.checkPassword(password)) {
                return voter;
            }
        }
        return null;
    }


    public void removeAdmin(String name, String password){
        for(Admin admin: admins){
            if(admin.getName().equals(name) && admin.checkPassword(password)){
                admins.remove(admin);
                break;
            }
        }
    }
}
