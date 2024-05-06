package main.geometris;

public class LeaderboardStatus implements ScreenStrategy{
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.leaderboardScreen == null) geo.leaderboardScreen = new LeaderboardScreen(geo);
        geo.setScreen(geo.leaderboardScreen);
    }
}
