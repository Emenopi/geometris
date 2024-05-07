package tests.credentials;

import main.geometris.credentials.LogIn;
import main.geometris.credentials.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class LogInMockTest {
LogIn login;

String email = "test@test.com";;

    @BeforeEach
    public void setup() {
        login = spy(new LogIn());
    }

    @Test
    void correctCredentialsLoginSuccessful(){
        String password = "0000";
        when(login.getPassword(email)).thenReturn("0000");
        login.logIn(email, password);
        assertEquals(LogIn.Status.LOGGED_IN, login.getLoginStatus());
    }

    @Test
    void unknownUserLoginChangesStatusToRegister() {
        LogIn login = new LogIn();
        String email = "testUnknown@test.com";
        String password = "1234";
        login.logIn(email, password);
        assertEquals(LogIn.Status.REGISTER, login.getLoginStatus());
    }

    @Test
    void incorrectPasswordLoginChangesStatusToRetryPassword() {
        String email = "test@test.com";
        String password = "1111";
        when(login.getPassword(email)).thenReturn("0000");
        login.logIn(email, password);
        assertEquals(LogIn.Status.RETRY_PASSWORD, login.getLoginStatus());
    }
}
