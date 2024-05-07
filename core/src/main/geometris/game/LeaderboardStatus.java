package main.geometris.game;

import main.geometris.ScreenStrategy;

public class LeaderboardStatus implements ScreenStrategy {
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.leaderboardScreen == null) geo.leaderboardScreen = new LeaderboardScreen(geo);
        geo.setScreen(geo.leaderboardScreen);
    }
}
