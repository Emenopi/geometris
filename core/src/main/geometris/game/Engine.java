package main.geometris.game;

import com.badlogic.gdx.Gdx;
import main.geometris.blocks.ActiveBlock;
import main.geometris.blocks.ActiveBlockMatrix;
import main.geometris.blocks.Block;
import main.geometris.blocks.GameMatrix;
import main.geometris.blocks.Matrix.colour;
import main.geometris.controllers.InputController;

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
    int score;
    Geometris geometris;

    double rateOfMovement;

    boolean canPlay;
    public Engine(GameMatrix gm, GameScreen g, Geometris geo) {
        this.geometris = geo;
        controller = new InputController(this);
        gameMatrix = gm;
        game = g;
        generateActiveMatrix();
        movingBlockHeightIndex = -1;
        direction = 0;
        canMove = true;
        canPlay = checkCanPlay();
        score = 0;
        rateOfMovement = 0.5;
    }

    public void run() {
        Gdx.input.setInputProcessor(controller);
        rotationClock += Gdx.graphics.getDeltaTime();

        if (!canPlay) {
            geometris.setScore(score);
            geometris.saveHighScore();
            game.endGame();}
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
        if (rotationClock > rateOfMovement) {
            direction = (direction + 1) % 60;
            activeMatrix.rotate(direction);
            rotationClock = 0;
        }
    }

    public void moveBrick() {
        movementClock += Gdx.graphics.getDeltaTime();
        if (movementClock > rateOfMovement) {
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

    private void increaseScore() {
        score += 60;
        geometris.setScore(score);

    }

    public void increaseDirection() {
        if (gameMatrix.check(activeMatrix.getMatrix(), heightToCheck, movingBlockHeightIndex, (direction + 1) % 60)) {
            direction = (direction + 1) % 60;
            activeMatrix.rotate(direction);
        }
    }

    public void decreaseDirection() {
        if (gameMatrix.check(activeMatrix.getMatrix(), heightToCheck, movingBlockHeightIndex, ((60 + direction) - 1) % 60)) {
            direction = ((60 + direction) - 1) % 60;
            activeMatrix.rotate(direction);
        }
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
                    increaseScore();
                    if (rateOfMovement > 0.05) {
                        rateOfMovement -= 0.05;
                    }
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
        colour[][] activeMatrixCopy = activeMatrix.rotateClockwise();
        if (canRotate(activeMatrixCopy)) {
            activeMatrix.transferMatrix(activeMatrixCopy);
        }
    }

    public void rotateAnticlockwise() {
        colour[][] activeMatrixCopy = activeMatrix.rotateAntiClockwise();
        if (canRotate(activeMatrixCopy)) {
            activeMatrix.transferMatrix(activeMatrixCopy);
        }
    }

    private boolean canRotate(colour[][] rotatedMatrix) {
        return gameMatrix.check(rotatedMatrix, heightToCheck-1, movingBlockHeightIndex, direction);
    }

    public ActiveBlockMatrix getActiveMatrix() {
        return activeMatrix;
    }
}