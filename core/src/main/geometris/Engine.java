package geometris;

import com.badlogic.gdx.Gdx;
import geometris.blocks.ActiveBlock;
import geometris.blocks.Block;
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
    int direction;
    String activeColour;
    Geometris geometris;
    boolean canMove;
    int heightToCheck = 1;
    int movingBlockHeightIndex;
    Engine(InputController ctrl, GameMatrix gm, ActiveBlockMatrix am, Geometris geo) {
        controller = ctrl;
        gameMatrix = gm;
        activeMatrix = am;
        geometris = geo;
        activeColour = activeMatrix.getMatrix()[0][0].getBlockString();
        movingBlockHeightIndex = 0;
        direction = 0;
        canMove = true;
    }

    public void run() {
        Gdx.input.setInputProcessor(controller);
        rotationClock += Gdx.graphics.getDeltaTime();

        if (!brickMoving) {
            rotateActiveBlock();
        } else if (movingBlockHeightIndex < 14 && canMove){
            canMove = gameMatrix.check(activeMatrix.getMatrix(), heightToCheck, movingBlockHeightIndex + 1, direction);
            moveBrick();
        } else {
            transferToGameMatrix();
            brickMoving = false;
            movingBlockHeightIndex = 0;
            heightToCheck = 1;
            canMove = true;
            regenerateActiveMatrix();
            activeMatrix.rotate(direction);
        }
        if (controller.space) {
            brickMoving = true;
            addBlockOffset = 0;

        }
    }

    private void rotateActiveBlock() {
        if (rotationClock > 1) {
            direction = (direction + 1) % 60;
            activeMatrix.rotate(direction);
            rotationClock = 0;
        }
    }

    public void moveBrick() {
        movementClock += Gdx.graphics.getDeltaTime();
        if (movementClock > 0.3) {
            movingBlockHeightIndex += 1;
            activeMatrix.moveOut(movingBlockHeightIndex, addBlockOffset);
            addBlockOffset += (float) (((ActiveBlock) activeMatrix.getMatrix()[0][0]).getHeight() + 4);
            movementClock = 0;
            if (heightToCheck < 3) {
                heightToCheck += 1;
            }
        }
    }

    public void transferToGameMatrix() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!activeMatrix.getMatrix()[i][j].getColourString().equals("NULL")) {
                    gameMatrix.addToMatrix(movingBlockHeightIndex - i, activeMatrix.getDirection() + j, activeMatrix.getMatrix()[0][0].getColour());
                }
            }
        }
    }

    private String getActiveColour() {
        int randomInt = (int) Math.floor(Math.random() * 6);
        String colour;
        switch(randomInt) {
            case 0:
                colour = "CYAN";
                break;
            case 1:
                colour = "PURPLE";
                break;
            case 2:
                colour = "MAGENTA";
                break;
            case 3:
                colour = "ORANGE";
                break;
            case 4:
                colour = "YELLOW";
                break;
            case 5:
                colour = "GREEN";
                break;
            default:
                colour = "CYAN";
                break;
        }
        return colour;
    }

    public void regenerateActiveMatrix() {
        activeColour = getActiveColour();
        activeMatrix = new ActiveBlockMatrix(activeColour, geometris);
        geometris.setActiveBlockMatrix(activeMatrix);
    }
}
