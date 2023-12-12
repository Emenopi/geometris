package geometris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import geometris.blocks.ActiveBlockMatrix;
import geometris.blocks.GameMatrix;
import geometris.controllers.InputController;

public class GameScreen implements Screen {
    Geometris geometris;
    SpriteBatch batch;
    public Assets assets;
    AssetManager assetManager;
    ShapeRenderer centreCircle;
    GameMatrix gameMatrix;
    ActiveBlockMatrix activeBlockMatrix;
    String activeColour;
    Texture boundaryCircle;

    Engine engine;
    Stage stage;

    private InputController controller;

    public GameScreen(Geometris geo) {
        geometris = geo;
        batch = new SpriteBatch();
		assets = new Assets();
		assetManager = new AssetManager();
		assets.load();
		assets.manager.finishLoading();
		boundaryCircle = assets.manager.get(Assets.boundaryCircle);

		centreCircle = new ShapeRenderer();

		gameMatrix = new GameMatrix(15, 60, this);
		activeColour = getActiveColour();

		activeBlockMatrix = new ActiveBlockMatrix(activeColour, this);

		engine = new Engine(gameMatrix, activeBlockMatrix, this);
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }
    @Override
    public void show() {

		engine.run();

		float boundaryCircleWidth = 819;
		float boundaryCircleHeight = 819;
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float screenCentre = screenWidth / 2;

		double boundaryCircleInnerRadius = (boundaryCircleWidth/2) * 0.88;
		float centreCircleRadius = (float) (boundaryCircleInnerRadius/3.2);

		int boundaryCircleBorderX = (int) ((screenWidth - boundaryCircleWidth) /2);
		int boundaryCircleBorderY = (int) ((screenHeight - boundaryCircleHeight) /2);


		ScreenUtils.clear(0, 0, 0, 0);

		batch.begin();
		batch.draw(boundaryCircle, boundaryCircleBorderX, boundaryCircleBorderY, boundaryCircleWidth, boundaryCircleHeight);
		if (assets.manager.update()) {
			for (int i = 0; i < gameMatrix.matrixHeight; i++) {
				for (int j = 0; j < gameMatrix.matrixWidth; j++) {
					gameMatrix.getBlockSprite(i, j).draw(batch);
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
					activeBlockMatrix.getBlockSprite(i, j).draw(batch);
			}
		}

		batch.end();
    }

    @Override
    public void render(float delta) {
        geometris.changeScreen(Geometris.GAME);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    public AssetManager getAssetManager() {
        return assetManager;
    }


    private String getActiveColour() {
        int randomInt = (int) Math.floor(Math.random() * 6);
        String colour;
        switch(randomInt) {
            case 0:
                colour = "CYAN";
                break;
            case 1:
                colour = "PURPLE";
                break;
            case 2:
                colour = "MAGENTA";
                break;
            case 3:
                colour = "ORANGE";
                break;
            case 4:
                colour = "YELLOW";
                break;
            case 5:
                colour = "GREEN";
                break;
            default:
                colour = "CYAN";
                break;
        }
        return colour;
    }

    public void setActiveBlockMatrix(ActiveBlockMatrix am) {
        activeBlockMatrix = am;
        activeColour = activeBlockMatrix.getMatrixString()[0][0];
    }

    public void endGame() {
        geometris.changeScreen(Geometris.GAMEOVER);
    }

    @Override
    public void dispose() {
        batch.dispose();
        boundaryCircle.dispose();
        assetManager.dispose();
        stage.dispose();
    }
}
