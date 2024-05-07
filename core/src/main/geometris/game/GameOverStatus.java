package main.geometris.game;

import main.geometris.ScreenStrategy;
import main.geometris.game.GameOverScreen;
import main.geometris.game.Geometris;

public class GameOverStatus implements ScreenStrategy {
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.gameOverScreen == null) geo.gameOverScreen = new GameOverScreen(geo);
        geo.setScreen(geo.gameOverScreen);
    }
}
