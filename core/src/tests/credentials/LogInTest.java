package tests.credentials;

import main.geometris.credentials.LogIn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogInTest {

    @Test
    void whenGetPlayerNameCalled_thenReturnsCorrectPlayer() {
        LogIn login = new LogIn();
        String email = "matthew.barr@glasgow.ac.uk";
        assertEquals("Matt Barr", login.getPlayer(email).getName());

    }
    @Test
    void whenCredentialsCorrect_thenLoginSuccessful(){
        LogIn login = new LogIn();
        String email = "derek.somerville@glasgow.ac.uk";
        String password = "1234";
        login.logIn(email, password);
        assertEquals(LogIn.Status.LOGGED_IN, login.getLoginStatus());
    }

    @Test
    void whenUnknownUser_thenLoginStatusIsRegister() {
        LogIn login = new LogIn();
        String email = "test@test.com";
        String password = "1234";
        login.logIn(email, password);
        assertEquals(LogIn.Status.REGISTER, login.getLoginStatus());
    }

    @Test
    void whenIncorrectPassword_thenLoginStatusIsRetryPassword() {
        LogIn login = new LogIn();
        String email = "derek.somerville@glasgow.ac.uk";
        String password = "1111";
        login.logIn(email, password);
        assertEquals(LogIn.Status.RETRY_PASSWORD, login.getLoginStatus());
    }
}