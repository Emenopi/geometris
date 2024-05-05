package main.geometris;

public class Player {
    private String forename;
    private String surname;
    private String emailAddress;
    private String password;
    private String score;
    final public static String dataSourceName = "customer";

    public Player(String firstName, String lastName, String emailAddress, String password, String score){
        this.emailAddress = emailAddress;
        this.forename = firstName;
        this.surname = lastName;
        this.password = password;
        this.score = score;
    }

    public String getFirstName(){
        return this.forename;
    }

    public String getLastName(){
        return this.surname;
    }

    public String getEmailAddress(){
        return this.emailAddress;
    }

    public String getPassword(){
        return this.password;
    }

    public String getScore(){
        return this.score;
    }

    public String getName(){
        return this.forename + " " + this.surname;
    }


}
