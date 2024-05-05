package main.geometris;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import main.loader.Assets;

public class Geometris extends Game {

	public Assets assets;
	public Assets assetManager = new Assets();

	private GameScreen gameScreen;
	private PauseScreen pauseScreen;
	private GameOverScreen gameOverScreen;
	private LeaderboardScreen leaderboardScreen;
	private LoginScreen loginScreen;
	private RegisterScreen registerScreen;

	public final static int GAME = 0;
	public final static int PAUSE = 1;
	public final static int GAMEOVER = 2;
	public final static int LEADERBOARD = 3;

	public final static int LOGIN = 4;
	public final static int REGISTER = 5;

	int score;
	Preferences highScore;
	boolean isHighScore;
	Player player;
	
	@Override
	public void create () {
		init();
	}

	public Player getPlayer() { return this.player; }

	public void setPlayer(Player player) { this.player = player; }

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

	public void changeScreen(int screen){
		switch(screen){
			case PAUSE:
				if(pauseScreen == null) pauseScreen = new PauseScreen(this);
				this.setScreen(pauseScreen);
				break;
			case GAME:
				if(gameScreen == null) gameScreen = new GameScreen(this);
				this.setScreen(gameScreen);
				break;
			case GAMEOVER:
				if(gameOverScreen == null) gameOverScreen = new GameOverScreen(this);
				this.setScreen(gameOverScreen);
				break;
			case LEADERBOARD:
				if(leaderboardScreen == null) leaderboardScreen = new LeaderboardScreen(this);
				this.setScreen(leaderboardScreen);
				break;
			case LOGIN:
				if(loginScreen == null) loginScreen = new LoginScreen(this);
				this.setScreen(loginScreen);
				break;
			case REGISTER:
				if (registerScreen == null) registerScreen = new RegisterScreen(this);
				this.setScreen(registerScreen);
				break;

		}
	}

	public void init() {
		highScore = Gdx.app.getPreferences("highScore");
		assets = new Assets();
		assets.load();
		assets.manager.finishLoading();
		pauseScreen = new PauseScreen(this);
		setScreen(pauseScreen);
		score = 0;
		isHighScore = false;
	}

	public void restart() {
		init();
		resetScreens();
		changeScreen(GAME);
	}

	public void resetScreens() {
		gameScreen.dispose();
		gameScreen = new GameScreen(this);
		pauseScreen.dispose();
		pauseScreen = new PauseScreen(this);
		gameOverScreen.dispose();
		gameOverScreen = new GameOverScreen(this);
		leaderboardScreen.dispose();
		leaderboardScreen = new LeaderboardScreen(this);
		loginScreen.dispose();
		loginScreen = new LoginScreen(this);
		registerScreen.dispose();
		registerScreen = new RegisterScreen(this);
	}
	@Override
	public void dispose () {
		assetManager.manager.dispose();
	}
}
