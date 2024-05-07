package main.geometris.game;

import main.geometris.ScreenStrategy;

public class PauseStrategy implements ScreenStrategy {
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.pauseScreen == null) geo.pauseScreen = new PauseScreen(geo);
        geo.setScreen(geo.pauseScreen);
    }
}
