package main.geometris.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FormStage extends Stage {
    private int typedChar;
    public FormStage(ScreenViewport screenViewport) {
    }
    @Override
    public boolean keyTyped(char character) {
        return super.keyTyped(character);
    }

    @Override
    public boolean keyDown(int keyCode) {
        if (keyCode == Input.Keys.BACKSPACE) {
            typedChar = keyCode;
        } else {
            if (Input.Keys.toString(keyCode).length() == 1) {
                typedChar = keyCode;
            }
        }
        return super.keyDown(keyCode);
    }

    public int getChar () {
        return this.typedChar;
    }
}
