package main.geometris.controllers;

import main.geometris.game.Geometris;
import main.geometris.game.PauseScreen;
import main.geometris.ScreenStrategy;

public class PauseStatus implements ScreenStrategy {
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.pauseScreen == null) geo.pauseScreen = new PauseScreen(geo);
        geo.setScreen(geo.pauseScreen);
    }
}
