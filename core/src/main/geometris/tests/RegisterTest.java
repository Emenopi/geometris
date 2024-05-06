package main.geometris.tests;

import main.geometris.LogIn;
import main.geometris.Register;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {

    @Test
    void validRegisterSavesNewPlayerInfo() {
        String email = "test@test.com";
        String forename = "testName";
        String surname = "surnameTest";
        String password = "0123";
        Register register = new Register();
        register.register(email, forename, surname, password);

        LogIn login = new LogIn();
        login.logIn(email, password);
        assertEquals(login.getLoginStatus(), LogIn.Status.LOGGED_IN);
    }

    @Test
    void missingEmailRegisterSetsStatusMissingEmail() {
        String email = "";
        String forename = "testName";
        String surname = "surnameTest";
        String password = "0123";
        Register register = new Register();
        register.register(email, forename, surname, password);
        assertEquals(register.getRegisterStatus(), Register.RegisterStatus.MISSING_EMAIL);

    }

    @Test
    void invalidRegisterDoesNotSavePlayerInfo() {
        String email = "";
        String forename = "testingName";
        String surname = "TestSurnameTest";
        String password = "4567";
        Register register = new Register();
        register.register(email, forename, surname, password);

        LogIn login = new LogIn();
        login.logIn(email, password);
        assertEquals(login.getLoginStatus(), LogIn.Status.REGISTER);
    }
}