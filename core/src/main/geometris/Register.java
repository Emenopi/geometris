package main.geometris;

public class Register {
    public enum RegisterStatus {
        REGISTERED,
        MISSING_EMAIL,
        MISSING_FORENAME,
        MISSING_SURNAME,
        MISSING_PASSWORD,
        LOGGED_OUT
    }
    RegisterStatus registerStatus = RegisterStatus.LOGGED_OUT;

    Player player;
    public void register(String email, String forename, String surname, String password) {
        if (email.isEmpty()) {
            this.registerStatus = RegisterStatus.MISSING_EMAIL;
            return;
        } else if (forename.isEmpty()) {
            this.registerStatus = RegisterStatus.MISSING_FORENAME;
        } else if (surname.isEmpty()) {
            this.registerStatus = RegisterStatus.MISSING_SURNAME;
        } else if (password.isEmpty()) {
            this.registerStatus = RegisterStatus.MISSING_EMAIL;
        } else {
            this.registerStatus = RegisterStatus.REGISTERED;
            player = new Player(email, forename, surname, password, "0");
            ReadDelimitedFile readDelimitedFile = new ReadDelimitedFile();
            readDelimitedFile.addNewPlayer(player);
        }
    }

    public RegisterStatus getRegisterStatus() {
        return this.registerStatus;
    }

    public Player getPlayer() {
        return this.player;
    }
}
