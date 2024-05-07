package main.geometris.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameOverScreen implements Screen {
    private final Geometris geometris;
    Stage stage;
    int score;
    Skin skin;
    Table table;
    BitmapFont font;
    String scoreLabelText;

    public GameOverScreen(Geometris geo) {
        geometris = geo;
        score = geometris.getScore();
        stage = new Stage(new ScreenViewport());
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        skin = new Skin(Gdx.files.internal("skin/comic-ui.json"));
        font = skin.getFont("title");
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        table = new Table(skin);
        table.setFillParent(true);
        stage.addActor(table);
        Label gameOver = new Label("GAME OVER", skin, "title");
        gameOver.setBounds( gameOver.getX(), gameOver.getY(), gameOver.getWidth(), gameOver.getHeight() );

        gameOver.setAlignment( Align.center );

        TextButton playAgain = new TextButton("Play Again", skin);
        TextButton quit = new TextButton("Quit", skin);
        scoreLabelText = "You Scored: " + geometris.getScore();
        if (geometris.getIsHighScore()) {
            scoreLabelText = "!!!HIGH SCORE!!! : " + score;
        } else if (geometris.getisPersonalBest()) {
            scoreLabelText = "!!!PERSONAL BEST!!!" + score;
        }
        Label scoreLabel = new Label(scoreLabelText, skin, "half-tone");

        table.add(gameOver).fillX().uniformX().pad(0, 0, 0, 0);
        table.row().pad(70, 0, 10, 0);
        table.add(scoreLabel).fillX().uniformX().pad(0, 0, 30, 0);
        table.row().pad(10, 0, 10, 0);
        table.add(playAgain).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(quit).fillX().uniformX();

        playAgain.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                geometris.restart();
            }
        });
        quit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

    }

    @Override
    public void render(float delta) {
        geometris.setStrategy(new GameOverStrategy());
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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

    @Override
    public void dispose() {
        stage.dispose();
    }
}