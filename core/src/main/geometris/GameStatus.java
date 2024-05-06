package main.geometris;

public class GameStatus implements ScreenStrategy{
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.gameScreen == null) geo.gameScreen = new GameScreen(geo);
        geo.setScreen(geo.gameScreen);
    }
}
