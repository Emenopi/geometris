package main.geometris;

import java.util.List;

public class LogIn {

    public enum Status {
        LOGGED_IN,
        REGISTER,
        RETRY_PASSWORD,
        LOGGED_OUT
    }

    Status loginStatus = Status.LOGGED_OUT;
    AllPlayers allPlayers = new AllPlayers();
    List<Player> listOfPlayers = allPlayers.getListOfPlayers();
    private String getPassword(String emailAddress){
        String password = "";

        for (Player player :listOfPlayers){
            if (player.getEmailAddress().equals(emailAddress)){
                password = player.getPassword();
            }
        }
        return password;
    }

    public void setLoginStatus(Status status) {
        this.loginStatus = status;
    }

    public Status getLoginStatus() {
        return this.loginStatus;
    }

    public Player getPlayer(String email) {
        for (Player player :listOfPlayers){
            if (player.getEmailAddress().equals(email)){
                return player;
            }
        }
        return null;
    }

    public void logIn(String email, String passwordInput) {
        String password = getPassword(email);
        if (password == "") {
            this.loginStatus = Status.REGISTER;
        }
        else if (password.equals(passwordInput)){
            this.loginStatus = Status.LOGGED_IN;
        }
        else {
            this.loginStatus = Status.RETRY_PASSWORD;
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 1e1a0167963a6ec382686651a43911ad834ffa72
