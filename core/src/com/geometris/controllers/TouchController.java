package com.geometris.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.geometris.Engine;

public class TouchController implements GestureDetector.GestureListener {
    Engine engine;

    public TouchController(Engine e) {
        engine = e;
    }
    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        if (!engine.getBrickMoving() && engine.getCanMove()){
            engine.setBrickMoving(true);
            engine.setAddBlockOffset(0);
        }
        return true;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        System.out.println("y: " + ( Math.floor(velocityY * 1000) / 100));
        System.out.println("x: " + ( Math.floor(velocityX * 1000) / 100));
        return true;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return true;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
