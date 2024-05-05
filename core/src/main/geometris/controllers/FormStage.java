package main.geometris.controllers;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FormStage extends Stage {
    private char typedChar;
    public FormStage(ScreenViewport screenViewport) {
    }
    @Override
    public boolean keyTyped(char character) {
        this.typedChar = character;
        return super.keyTyped(character);
    }

    public char getChar () {
        return this.typedChar;
    }
}
