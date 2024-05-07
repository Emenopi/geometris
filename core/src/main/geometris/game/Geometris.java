package main.geometris.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import main.geometris.*;
import main.geometris.credentials.LoginScreen;
import main.geometris.credentials.Player;
import main.geometris.credentials.ReadDelimitedFile;
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
		ReadDelimitedFile readDelimitedFile = new ReadDelimitedFile();
		return readDelimitedFile.getHighScore();
	}
	public boolean getisPersonalBest() {
        return score > Integer.parseInt(player.getScore());
    }

	public boolean getIsHighScore() {
        return score > getHighScore();
    }

	public void saveHighScore() {
		if (getisPersonalBest()) {
			ReadDelimitedFile readDelimitedFile = new ReadDelimitedFile();
			readDelimitedFile.saveHighScore(this.player, score);
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
		assets = new Assets();
		assets.load();
		assets.manager.finishLoading();
		setStrategy(new StartStrategy());

		score = 0;
	}

	public void restart() {
		init();
		resetScreens();
		this.setStrategy(new GameStrategy());
	}

	public void resetScreens() {
		if (gameScreen != null) {
			gameScreen.dispose();
			gameScreen = new GameScreen(this);
		}
	}
	@Override
	public void dispose () {
		assetManager.manager.dispose();
	}
}