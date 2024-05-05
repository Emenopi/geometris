package main.geometris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import main.geometris.controllers.FormStage;

public class LoginScreen implements Screen {

    private Geometris geometris;
    FormStage stage;
    main.loader.Assets assets;
    Skin skin;
    String email = "";
    String password = "";
    LogIn login;
    public LoginScreen(Geometris geo) {
        geometris = geo;
        assets = geometris.assets;
        geometris.assetManager.queueAddSkin();
        geometris.assetManager.manager.finishLoading();
        skin = geometris.assetManager.manager.get(main.loader.Assets.skin);
        stage = new FormStage(new ScreenViewport());
        login = new LogIn();
        if (geometris.getPlayer() != null) {
            login.setLoginStatus(LogIn.Status.LOGGED_IN);
        } else {
            login.setLoginStatus(LogIn.Status.LOGGED_OUT);
        }
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);


        Label geometrisLabel = new Label("LOG IN", skin, "title");
        table.add(geometrisLabel).center().uniformX().pad(0, 0, 70, 0);

        TextField emailField = new TextField("email:    ", skin);
        emailField.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (stage.getIsBackspace() && !email.isEmpty()) {
                    email = email.substring(0, email.length()-1);
                } else {
                    email += stage.getChar();
                }
            }
        });

        emailField.setText(emailField.getText() + email);


        table.row().pad(50, 0, 10, 0);
        table.add(emailField).width(400).expandX().pad(50, 0, 10, 0);
        TextField passwordField = new TextField("Password:    ", skin);

        passwordField.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (stage.getIsBackspace() && !password.isEmpty()) {
                    password = password.substring(0, password.length()-1);
                } else {
                    password += stage.getChar();
                }
            }
        });

        passwordField.setText("password:    " + "*".repeat(password.length()));

        table.row().pad(10,0, 10, 0);
        table.add(passwordField).width(400).expandX().pad(10, 0, 10, 0);
        TextButton loginButton = new TextButton("Log In", skin);
        table.row().pad(70, 0, 10, 0);
        table.add(loginButton).expandX().uniformX();
        loginButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                login.logIn(email, password);
            }
        });

        switch(login.getLoginStatus()) {
            case REGISTER:
                geometris.changeScreen(Geometris.REGISTER);
                break;
            case RETRY_PASSWORD:
                loginButton.setText("WRONG PASSWORD");
                password = "";
                login.setLoginStatus(LogIn.Status.LOGGED_OUT);
                break;
            case LOGGED_IN:
                geometris.setPlayer(login.getPlayer(email));
                geometris.changeScreen(Geometris.PAUSE);
        }

        TextButton quitButton = new TextButton("Quit", skin);

        table.row().pad(30, 0, 10, 0);
        table.add(quitButton).expandX().uniformX();

        quitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

    }


    @Override
    public void render(float delta) {
        geometris.changeScreen(Geometris.LOGIN);
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
