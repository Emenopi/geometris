package main.geometris;

import java.util.List;
import java.util.Scanner;

public class LogIn {
    private String getPassword(String emailAddress){
        AllPlayers allPlayers = new AllPlayers();
        String password = "";
        List<Player> listOfPlayers = allPlayers.getListOfPlayers();
        for (Player player :listOfPlayers){
            if (player.getEmailAddress().equals(emailAddress)){
                password = player.getPassword();
            }
        }
        return password;
    }

    public String logIn(String email, String passwordInput) {
        String password = getPassword(email);
        if (password == "") {
            return "Please register";
        }
        else if (password.equals(passwordInput)){
            return "Logged in!";
        }
        else {
            return "Wrong password";
        }
    }
}
