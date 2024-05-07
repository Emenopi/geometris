package main.geometris.game;

import main.geometris.ScreenStrategy;

public class GameOverStrategy implements ScreenStrategy {
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.gameOverScreen == null) geo.gameOverScreen = new GameOverScreen(geo);
        geo.setScreen(geo.gameOverScreen);
    }
}
