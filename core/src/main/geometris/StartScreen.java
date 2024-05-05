package main.geometris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import main.loader.Assets;

public class StartScreen implements Screen {
    private Geometris geometris;
    Stage stage;
    Assets assets;
    Skin skin;
    boolean loggedIn;

    public StartScreen(Geometris geo) {
        geometris = geo;
        stage = new Stage(new ScreenViewport());
        assets = geometris.assets;
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        geometris.assetManager.queueAddSkin();
        geometris.assetManager.manager.finishLoading();
        skin = geometris.assetManager.manager.get(Assets.skin);
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
        Label geometrisLabel = new Label("GEOMETRIS", skin, "title");
        table.add(geometrisLabel).fillX().uniformX().pad(0, 0, 70, 0);
<<<<<<< HEAD
            TextButton loginButton = new TextButton("Log In", skin);
            TextButton registerButton = new TextButton("Register", skin);

            table.row().pad(10, 0, 10, 0);
            table.add(loginButton).fillX().uniformX();
            table.row();
            table.add(registerButton).fillX().uniformX();

            loginButton.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    geometris.changeScreen(Geometris.LOGIN);
                }
            });

            registerButton.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    geometris.changeScreen(Geometris.REGISTER);
                }
            });
=======
        TextButton loginButton = new TextButton("Log In", skin);
        TextButton registerButton = new TextButton("Register", skin);

        table.row().pad(10, 0, 10, 0);
        table.add(loginButton).fillX().uniformX();
        table.row();
        table.add(registerButton).fillX().uniformX();

        loginButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                geometris.changeScreen(Geometris.LOGIN);
            }
        });

        registerButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                geometris.changeScreen(Geometris.REGISTER);
            }
        });
>>>>>>> 1e1a0167963a6ec382686651a43911ad834ffa72

        TextButton quitButton = new TextButton("Quit", skin);

        table.row().pad(70, 0, 10, 0);
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
        geometris.changeScreen(Geometris.START);
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 1e1a0167963a6ec382686651a43911ad834ffa72
