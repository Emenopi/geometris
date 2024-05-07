package main.geometris.game;

import main.geometris.ScreenStrategy;

public class GameStrategy implements ScreenStrategy {
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.gameScreen == null) geo.gameScreen = new GameScreen(geo);
        geo.setScreen(geo.gameScreen);
    }
}
