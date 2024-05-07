package main.geometris.credentials;

import main.geometris.game.Geometris;
import main.geometris.ScreenStrategy;

public class LoginStrategy implements ScreenStrategy {
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.loginScreen == null) geo.loginScreen = new LoginScreen(geo);
        geo.setScreen(geo.loginScreen);
    }
}
