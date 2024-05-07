package main.geometris.game;

import main.geometris.ScreenStrategy;
import main.geometris.game.GameScreen;
import main.geometris.game.Geometris;

public class GameStatus implements ScreenStrategy {
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.gameScreen == null) geo.gameScreen = new GameScreen(geo);
        geo.setScreen(geo.gameScreen);
    }
}
