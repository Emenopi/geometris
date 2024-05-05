package main.geometris.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FormStage extends Stage {
    private char typedChar;
    private boolean backspace = false;
    public FormStage(ScreenViewport screenViewport) {
    }
    @Override
    public boolean keyTyped(char character) {
        this.typedChar = character;
        return super.keyTyped(character);
    }

    @Override
    public boolean keyDown(int keyCode) {
        if (keyCode == Input.Keys.BACKSPACE) {
            backspace = true;
        }else {
            backspace = false;
        }
        return super.keyDown(keyCode);
    }

    public boolean getIsBackspace() {
        return this.backspace;
    }
    public char getChar () {
        return this.typedChar;
    }
}
