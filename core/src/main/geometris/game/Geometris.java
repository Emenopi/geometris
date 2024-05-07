package main.geometris.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import main.geometris.*;
import main.geometris.credentials.LoginScreen;
import main.geometris.credentials.Player;
import main.geometris.credentials.RegisterScreen;
import main.loader.Assets;

public class Geometris extends Game {

	public Assets assets;
	public Assets assetManager = new Assets();

	GameScreen gameScreen;
	public PauseScreen pauseScreen;
	public GameOverScreen gameOverScreen;
	public LeaderboardScreen leaderboardScreen;
	public LoginScreen loginScreen;
	public RegisterScreen registerScreen;
	public StartScreen startScreen;

	public ScreenStrategy screenStrategy;

	int score;
	Preferences highScore;
	boolean isHighScore;
	Player player;

	@Override
	public void create () {
		init();
	}

	public void setScore(int s) {
		score = s;
	}

	public int getScore() {
		return score;
	}

	public int getHighScore() {
		return highScore.getInteger("highScore");
	}

	public boolean getIsHighScore() {
		return isHighScore;
	}

	public void saveHighScore() {
		if (score > highScore.getInteger("highScore")) {
			highScore.putInteger("highScore", score);
			highScore.flush();
			isHighScore = true;
		}
	}
	@Override
	public void render () {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
	@Override
	public void resize(int width, int height) {

	}

	public void setStrategy(ScreenStrategy strategy) {
		this.screenStrategy = strategy;
		changeScreen();
	}

	public void changeScreen(){
		this.screenStrategy.changeScreen(this);
	}
	public Player getPlayer() { return this.player; }

	public void setPlayer(Player player) { this.player = player; }

	public void init() {
		highScore = Gdx.app.getPreferences("highScore");
		assets = new Assets();
		assets.load();
		assets.manager.finishLoading();
		setStrategy(new StartStrategy());

		score = 0;
		isHighScore = false;
	}

	public void restart() {
		init();
		resetScreens();
		this.setStrategy(new GameStatus());
	}

	public void resetScreens() {
		gameScreen.dispose();
		gameScreen = new GameScreen(this);
		pauseScreen.dispose();
		pauseScreen = new PauseScreen(this);
	}
	@Override
	public void dispose () {
		assetManager.manager.dispose();
	}
}