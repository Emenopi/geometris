package geometris;

import com.badlogic.gdx.Gdx;
import geometris.controllers.InputController;

public class Engine {
    double clock;
    private InputController controller;
    GameMatrix gameMatrix;
    ActiveBlockMatrix activeMatrix;
    boolean brickMoving = false;
    Engine(InputController ctrl, GameMatrix gm, ActiveBlockMatrix am) {
        controller = ctrl;
        gameMatrix = gm;
        activeMatrix = am;
    }

    public void run() {
        clock += Gdx.graphics.getDeltaTime();
        if (!brickMoving) {rotateActiveBlock();}
        if (controller.space) {
            fireBrick();
        }
    }

    private void rotateActiveBlock() {
        if (clock > 1) {
            activeMatrix.rotate();
            clock = 0;
        }
    }
    public void fireBrick() {
        brickMoving = true;
    }
}
