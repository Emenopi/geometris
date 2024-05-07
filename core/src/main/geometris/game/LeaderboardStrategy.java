package main.geometris.game;

import main.geometris.ScreenStrategy;

public class LeaderboardStrategy implements ScreenStrategy {
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.leaderboardScreen == null) geo.leaderboardScreen = new LeaderboardScreen(geo);
        geo.setScreen(geo.leaderboardScreen);
    }
}
