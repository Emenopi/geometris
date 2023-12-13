package geometris;

import com.badlogic.gdx.Gdx;
import geometris.blocks.ActiveBlock;
import geometris.blocks.ActiveBlockMatrix;
import geometris.blocks.GameMatrix;
import geometris.blocks.Matrix.colour;
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
    GameScreen game;
    boolean canMove;
    int heightToCheck = 1;
    int movingBlockHeightIndex;

    boolean canPlay;
    public Engine(GameMatrix gm, GameScreen g) {
        controller = new InputController(this);
        gameMatrix = gm;
        game = g;
        generateActiveMatrix();
        movingBlockHeightIndex = -1;
        direction = 0;
        canMove = true;
        canPlay = checkCanPlay();
    }

    public void run() {
        Gdx.input.setInputProcessor(controller);
        rotationClock += Gdx.graphics.getDeltaTime();
        if (!canPlay) {game.endGame();}
        if (movingBlockHeightIndex < 14) {
            canMove = gameMatrix.check(activeMatrix.getMatrix(), heightToCheck, movingBlockHeightIndex + 1, direction);
        } else {canMove = false;}

        if (!brickMoving) {
            rotateActiveBlock();
        } else if (canMove){
            moveBrick();
        } else {
            transferToGameMatrix();
            checkLines();
            brickMoving = false;
            movingBlockHeightIndex = -1;
            heightToCheck = 1;
            canPlay = checkCanPlay();
            canMove = canPlay;
            generateActiveMatrix();
            activeMatrix.rotate(direction);
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
                    gameMatrix.addToMatrix(movingBlockHeightIndex - i, activeMatrix.getDirection() + j, activeMatrix.getColour());
                }
            }
        }
    }

    public String getActiveColour() {
        int randomInt = (int) Math.floor(Math.random() * 6);
        String colour;
        switch(randomInt) {
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

    public void generateActiveMatrix() {
        activeColour = getActiveColour();
        activeMatrix = new ActiveBlockMatrix(activeColour, game);
        game.setActiveBlockMatrix(activeMatrix);
    }

    public void checkLines() {
        for (int i = 0; i < gameMatrix.matrixHeight; i++) {
            for (int j = 0; j < gameMatrix.getWidth(); j++) {
                if (gameMatrix.getMatrix()[i][j].getColour() == colour.NULL) {
                    break;
                } else if (gameMatrix.getMatrix()[i][j].getColour() != colour.NULL && j == 59) {
                    gameMatrix.removeLine(i);
                }
            }
        }
    }

    public boolean checkCanPlay() {
        for (int w = 0; w < gameMatrix.matrixWidth; w++) {
            if (gameMatrix.check(activeMatrix.getMatrix(), 2, 3, w)) {
                return true;
            }
        }
        return false;
    }

    public boolean getCanMove() {
        return canMove;
    }

    public boolean getBrickMoving() {
        return brickMoving;
    }

    public void setBrickMoving(boolean isMoving) {
        brickMoving = isMoving;
    }

    public void setAddBlockOffset(float offset) {
        addBlockOffset = offset;
    }

    public void rotateClockwise() {
        activeMatrix.rotateClockwise();
    }

    public void rotateAnticlockwise() {
        activeMatrix.rotateAntiClockwise();
    }

    public ActiveBlockMatrix getActiveMatrix() {
        return activeMatrix;
    }
}
