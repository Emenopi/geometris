package main.geometris.game;

import main.geometris.ScreenStrategy;
import main.geometris.game.Geometris;
import main.geometris.game.StartScreen;

public class StartStrategy implements ScreenStrategy {
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.startScreen == null) geo.startScreen = new StartScreen(geo);
        geo.setScreen(geo.startScreen);
    }
}
