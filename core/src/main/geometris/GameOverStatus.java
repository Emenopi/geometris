package main.geometris;

public class GameOverStatus implements ScreenStrategy{
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.gameOverScreen == null) geo.gameOverScreen = new GameOverScreen(geo);
        geo.setScreen(geo.gameOverScreen);
    }
}
