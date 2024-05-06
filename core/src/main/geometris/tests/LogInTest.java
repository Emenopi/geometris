package main.geometris.tests;
import main.geometris.LogIn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogInTest {

    @Test
    void getPlayerNameFromValidEmail() {
        LogIn login = new LogIn();
        String email = "matthew.barr@glasgow.ac.uk";
        assertEquals(login.getPlayer(email).getName(), "Matt Barr");

    }
    @Test
    void correctCredentialsLoginSuccessful(){
        LogIn login = new LogIn();
        String email = "derek.somerville@glasgow.ac.uk";
        String password = "1234";
        login.logIn(email, password);
        assertEquals(login.getLoginStatus(), LogIn.Status.LOGGED_IN);
    }

    @Test
    void unknownUserLoginChangesStatusToRegister() {
        LogIn login = new LogIn();
        String email = "test@test.com";
        String password = "1234";
        login.logIn(email, password);
        assertEquals(login.getLoginStatus(), LogIn.Status.REGISTER);
    }

    @Test
    void incorrectPasswordLoginChangesStatusToRetryPassword() {
        LogIn login = new LogIn();
        String email = "derek.somerville@glasgow.ac.uk";
        String password = "1111";
        login.logIn(email, password);
        assertEquals(login.getLoginStatus(), LogIn.Status.RETRY_PASSWORD);
    }
}