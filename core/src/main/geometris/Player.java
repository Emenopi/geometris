package main.geometris;

public class Player {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private Integer score;
    final public static String dataSourceName = "customer";

    public Player(String emailAddress, String firstName, String lastName, String password, String score){
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.score = Integer.valueOf(score);
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmailAddress(){
        return this.emailAddress;
    }

    public String getPassword(){
        return this.password;
    }

    public Integer getScore(){
        return this.score;
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }


}
