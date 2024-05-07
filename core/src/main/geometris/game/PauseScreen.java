package main.geometris.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import main.geometris.controllers.PauseStatus;
import main.loader.Assets;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PauseScreen implements Screen {
    private Geometris geometris;
    Stage stage;
    Assets assets;
    Skin skin;
    boolean loggedIn;

    public PauseScreen(Geometris geo) {
        geometris = geo;
        stage = new Stage(new ScreenViewport());
        assets = geometris.assets;
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        geometris.assetManager.queueAddSkin();
        geometris.assetManager.manager.finishLoading();
        skin = geometris.assetManager.manager.get(Assets.skin);
        loggedIn = geometris.getPlayer() != null;
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        Label geometrisLabel = new Label("GEOMETRIS", skin, "title");
        table.add(geometrisLabel).fillX().uniformX().pad(0, 0, 10, 0);
        table.row().pad(10, 0, 70, 0);
        Label playerLabel = new Label(geometris.getPlayer().getName(), skin, "narration");
        table.add(playerLabel).fillX().uniformX().pad(0, 0, 10, 0);
        table.row().pad(10, 0, 10, 0);

        TextButton play = new TextButton("Play", skin);
        TextButton quit = new TextButton("Quit", skin);

        table.row().pad(70, 0, 10, 0);
        table.add(play).fillX().uniformX();


        play.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                geometris.setStrategy(new GameStrategy());
            }
        });


        TextButton quitButton = new TextButton("Quit", skin);

        table.row().pad(30, 0, 10, 0);
        table.add(quitButton).fillX().uniformX();

        quitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });



    }


    @Override
    public void render(float delta) {
        geometris.setStrategy(new PauseStatus());
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