package geometris.controllers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import geometris.Engine;
import geometris.Geometris;

public class InputController implements InputProcessor {
    Engine engine;

    public InputController(Engine e) {
        engine = e;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch(keycode) {
            case Input.Keys.SPACE:
                if (!engine.getBrickMoving() && engine.getCanMove()){
                    engine.setBrickMoving(true);
                    engine.setAddBlockOffset(0);
                }
                break;
            case Input.Keys.SHIFT_RIGHT:
                if (engine.getBrickMoving()) {
                    engine.rotateClockwise();
                }
                break;
            case Input.Keys.SHIFT_LEFT:
                if(engine.getBrickMoving()) {
                    engine.rotateAnticlockwise();
                }
                break;
            case Input.Keys.LEFT:
                if (engine.getBrickMoving()) {
                    engine.decreaseDirection();
                }
                break;
            case Input.Keys.RIGHT:
                if (engine.getBrickMoving()) {
                    engine.increaseDirection();
                }
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch(keycode) {
            case Input.Keys.SPACE:
                break;
            case Input.Keys.LEFT:
                break;
            case Input.Keys.RIGHT:
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
