package tests.credentials;

import main.geometris.credentials.LogIn;
import main.geometris.credentials.ReadDelimitedFile;
import main.geometris.credentials.Register;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegisterTest {

    @Test
    void whenRegisterDetailsValid_thenSavesNewPlayerInfo() {
        String email = "testRegister@test.com";
        String forename = "testName";
        String surname = "surnameTest";
        String password = "0123";
        Register register = new Register();
        register.register(email, forename, surname, password);

        LogIn login = new LogIn();
        login.logIn(email, password);
        assertEquals(LogIn.Status.LOGGED_IN, login.getLoginStatus());

        ReadDelimitedFile readDelimitedFile = new ReadDelimitedFile();
        readDelimitedFile.removePlayerData(email);
    }

    @Test
    void whenMissingEmail_thenRegisterStatusIsMissingEmail() {
        String email = "";
        String forename = "testName";
        String surname = "surnameTest";
        String password = "0123";
        Register register = new Register();
        register.register(email, forename, surname, password);
        assertEquals(Register.RegisterStatus.MISSING_EMAIL, register.getRegisterStatus());

    }

    @Test
    void whenInvalidRegister_thenNoSavePlayerInfo() {
        String email = "";
        String forename = "testingName";
        String surname = "TestSurnameTest";
        String password = "4567";
        Register register = new Register();
        register.register(email, forename, surname, password);

        LogIn login = new LogIn();
        login.logIn(email, password);
        assertEquals(LogIn.Status.REGISTER, login.getLoginStatus());
    }
}