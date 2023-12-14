package geometris;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import geometris.blocks.ActiveBlockMatrix;
import geometris.blocks.GameMatrix;
import geometris.controllers.InputController;
import loader.Assets;

public class Geometris extends Game {

	public Assets assets;
	public Assets assetManager = new Assets();

	private GameScreen gameScreen;
	private PauseScreen pauseScreen;
	private GameOverScreen gameOverScreen;

	public final static int GAME = 0;
	public final static int PAUSE = 1;
	public final static int GAMEOVER = 2;

	int score;
	Preferences highScore;
	
	@Override
	public void create () {
		highScore = Gdx.app.getPreferences("highScore");
		assets = new Assets();
		assets.load();
		assets.manager.finishLoading();
		pauseScreen = new PauseScreen(this);
		setScreen(pauseScreen);
		score = 0;
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
	@Override
	public void render () {
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
		}
	}
	
	@Override
	public void dispose () {
		assetManager.manager.dispose();
	}
}
