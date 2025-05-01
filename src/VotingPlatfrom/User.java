package VotingPlatfrom;

public abstract class User {
    private String name;
    private String password;


    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getName(){ return name.trim().toLowerCase(); }
    public String getPassword(){return this.password;}
    public boolean checkPassword(String pass){ return this.password.equals(pass); }

}
