package main.geometris.credentials;

import main.geometris.game.Geometris;
import main.geometris.ScreenStrategy;

public class RegisterStrategy implements ScreenStrategy {
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.registerScreen == null) geo.registerScreen = new RegisterScreen(geo);
        geo.setScreen(geo.registerScreen);
    }
}
