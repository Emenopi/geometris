package main.geometris.tests;
import main.geometris.LogIn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogInTest {

    @Test
    void getPlayer() {
        LogIn login = new LogIn();
        String email = "matthew.barr@glasgow.ac.uk";
        assertEquals(login.getPlayer(email).getName(), "Matt Barr");

    }
}