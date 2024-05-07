package main.geometris.game;

import main.geometris.ScreenStrategy;
import main.geometris.game.Geometris;
import main.geometris.game.LeaderboardScreen;

public class LeaderboardStatus implements ScreenStrategy {
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.leaderboardScreen == null) geo.leaderboardScreen = new LeaderboardScreen(geo);
        geo.setScreen(geo.leaderboardScreen);
    }
}
