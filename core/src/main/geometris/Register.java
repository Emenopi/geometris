package main.geometris;

public class Register {
    public enum RegisterStatus {
        REGISTERED,
        MISSING_EMAIL,
        MISSING_FORENAME,
        MISSING_SURNAME,
        MISSING_PASSWORD,
        LOGGED_OUT,
        LOG_IN
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
            ReadDelimitedFile readDelimitedFile = new ReadDelimitedFile();
            if (!readDelimitedFile.getDoesUserExit(email)) {
                player = new Player(email, forename, surname, password, "0");
                readDelimitedFile.addNewPlayer(player);
            } else {
                this.registerStatus = RegisterStatus.LOG_IN;
            }

        }
    }

    public RegisterStatus getRegisterStatus() {
        return this.registerStatus;
    }

    public Player getPlayer() {
        return this.player;
    }
}