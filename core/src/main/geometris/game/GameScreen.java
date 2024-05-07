package main.geometris.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import main.geometris.blocks.ActiveBlockMatrix;
import main.geometris.blocks.GameMatrix;
import main.geometris.controllers.InputController;
import main.geometris.credentials.ReadDelimitedFile;
import main.loader.Assets;

public class GameScreen implements Screen {
    String scoreLabel;
    public Geometris geometris;
    SpriteBatch batch;
    ShapeRenderer centreCircle;
    GameMatrix gameMatrix;
    ActiveBlockMatrix activeBlockMatrix;
    String activeColour;
    Texture boundaryCircle;
    Engine engine;
    Stage stage;
    Skin skin;
    String score;
    BitmapFont font;

    private InputController controller;

    public GameScreen(Geometris geo) {
        this.geometris = geo;
        batch = new SpriteBatch();
        geometris.assetManager.load();
        geometris.assetManager.queueAddSkin();
        geometris.assetManager.manager.finishLoading();
        boundaryCircle = geo.assets.manager.get(Assets.boundaryCircle);

        centreCircle = new ShapeRenderer();

        gameMatrix = new GameMatrix(15, 60, this);
        engine = new Engine(gameMatrix,  this, geometris);
        activeColour = engine.getActiveColour();
        activeBlockMatrix = engine.getActiveMatrix();
        stage = new Stage(new ScreenViewport());
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        skin = geometris.assetManager.manager.get(Assets.skin);
        font = skin.getFont("title");
        score = "0";
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        score = String.valueOf(geometris.getScore());
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

        scoreLabel = "Score: " + score;

        ScreenUtils.clear(0, 0, 0, 0);

        batch.begin();
        font.setColor(Color.WHITE);
        font.getData().setScale(0.5F, 0.5F);
        font.draw(batch, scoreLabel, 10, 890);
        batch.draw(boundaryCircle, boundaryCircleBorderX, boundaryCircleBorderY, boundaryCircleWidth, boundaryCircleHeight);
        if (geometris.assetManager.manager.update()) {
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
        geometris.setStrategy(new GameStrategy());
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

    public void setActiveBlockMatrix(ActiveBlockMatrix am) {
        activeBlockMatrix = am;
        activeColour = activeBlockMatrix.getMatrixString()[0][0];
    }

    public void endGame() {
        if (geometris.getIsHighScore()) {
            ReadDelimitedFile readDelimitedFile = new ReadDelimitedFile();
            readDelimitedFile.saveHighScore(this.geometris.player, Integer.parseInt(score));
        }
        geometris.setStrategy(new GameOverStrategy());
    }

    @Override
    public void dispose() {
        batch.dispose();
        boundaryCircle.dispose();
        stage.dispose();
    }
}