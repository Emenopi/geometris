package tests.credentials;

import main.geometris.credentials.LogIn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogInTest {

    @Test
    void getPlayerNameFromValidEmail() {
        LogIn login = new LogIn();
        String email = "matthew.barr@glasgow.ac.uk";
        assertEquals("Matt Barr", login.getPlayer(email).getName());

    }
    @Test
    void correctCredentialsLoginSuccessful(){
        LogIn login = new LogIn();
        String email = "derek.somerville@glasgow.ac.uk";
        String password = "1234";
        login.logIn(email, password);
        assertEquals(LogIn.Status.LOGGED_IN, login.getLoginStatus());
    }

    @Test
    void unknownUserLoginChangesStatusToRegister() {
        LogIn login = new LogIn();
        String email = "test@test.com";
        String password = "1234";
        login.logIn(email, password);
        assertEquals(LogIn.Status.REGISTER, login.getLoginStatus());
    }

    @Test
    void incorrectPasswordLoginChangesStatusToRetryPassword() {
        LogIn login = new LogIn();
        String email = "derek.somerville@glasgow.ac.uk";
        String password = "1111";
        login.logIn(email, password);
        assertEquals(LogIn.Status.RETRY_PASSWORD, login.getLoginStatus());
    }
}