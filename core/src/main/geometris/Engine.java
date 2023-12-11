package geometris;

import com.badlogic.gdx.Gdx;
import geometris.blocks.ActiveBlock;
import geometris.blocks.ActiveBlockMatrix;
import geometris.blocks.GameMatrix;
import geometris.controllers.InputController;

public class Engine {
    double rotationClock;
    double movementClock;
    private InputController controller;
    GameMatrix gameMatrix;
    ActiveBlockMatrix activeMatrix;
    boolean brickMoving = false;
    float addBlockOffset;

    int movingBlockHeightIndex;
    Engine(InputController ctrl, GameMatrix gm, ActiveBlockMatrix am) {
        controller = ctrl;
        gameMatrix = gm;
        activeMatrix = am;
        movingBlockHeightIndex = -1;
    }

    public void run() {
        Gdx.input.setInputProcessor(controller);
        rotationClock += Gdx.graphics.getDeltaTime();

        if (!brickMoving) {rotateActiveBlock();} else {moveBrick();}
        if (controller.space) {
            brickMoving = true;
            addBlockOffset = 0;

        }
    }

    private void rotateActiveBlock() {
        if (rotationClock > 1) {
            activeMatrix.rotate();
            rotationClock = 0;
        }
    }

    public void moveBrick() {
        movementClock += Gdx.graphics.getDeltaTime();
        if (movementClock > 1 && movingBlockHeightIndex < 14) {
            movingBlockHeightIndex += 1;
            activeMatrix.moveOut(movingBlockHeightIndex, addBlockOffset);
            addBlockOffset += (float) (((ActiveBlock) activeMatrix.getMatrix()[0][0]).getHeight() + 4);
            movementClock = 0;
        }
    }
}
