package main.geometris;

public class RegisterStrategy implements ScreenStrategy{
    @Override
    public void changeScreen(Geometris geo) {
        if(geo.registerScreen == null) geo.registerScreen = new RegisterScreen(geo);
        geo.setScreen(geo.registerScreen);
    }
}
