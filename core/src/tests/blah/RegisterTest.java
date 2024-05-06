import main.geometris.LogIn;
import main.geometris.ReadDelimitedFile;
import main.geometris.Register;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegisterTest {

    @Test
    void validRegisterSavesNewPlayerInfo() {
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
    void missingEmailRegisterSetsStatusMissingEmail() {
        String email = "";
        String forename = "testName";
        String surname = "surnameTest";
        String password = "0123";
        Register register = new Register();
        register.register(email, forename, surname, password);
        assertEquals(Register.RegisterStatus.MISSING_EMAIL, register.getRegisterStatus());

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
        assertEquals(LogIn.Status.REGISTER, login.getLoginStatus());
    }
}