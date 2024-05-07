package tests.blocks;

import com.badlogic.gdx.Game;
import main.geometris.blocks.*;
import main.geometris.game.GameScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.spy;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GameMatrixTest {
    GameMatrix gameMatrix;
    @Mock
    private GameScreen gameScreen;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameMatrix = spy(new GameMatrix(10, 10, gameScreen));
    }

    void fillMatrix() {
        for (int i = 0; i < gameMatrix.matrixHeight; i++) {
            for (int j = 0; j < gameMatrix.matrixWidth; j++) {
                gameMatrix.addToMatrix(i, j, Matrix.colour.GREEN);
            }
        }
    }

    void fillMatrixExceptOneColumn(int columnIndex) {
        for (int i = 0; i < gameMatrix.matrixHeight; i++) {
            for (int j = 0; j < gameMatrix.matrixWidth; j++) {
                if (j != columnIndex) {
                    gameMatrix.addToMatrix(i, j, Matrix.colour.GREEN);
                }
            }
        }
    }

    void fillEndRowMatrix() {
        for (int i = 0; i < gameMatrix.matrixWidth; i++) {
            gameMatrix.addToMatrix(9, i, Matrix.colour.GREEN);
        }
    }

    @Test
    void whenGameMatrixInitialised_thenGameMatrixIsCorrectSize() {
        assertEquals(gameMatrix.getMatrix().length, 10);
    }
    @Test
    void whenGameMatrixInitialised_thenNewMatrixColourIsNull() {
        for (int i = 0; i < gameMatrix.matrixHeight; i++) {
            for (int j = 0; j < gameMatrix.matrixWidth; j++) {
                assertEquals(gameMatrix.getMatrix()[i][j].getColour(), Matrix.colour.NULL);
            }
        }
    }

    @Test
    void whenAddToMatrixCalled_thenAddCorrectBlockToPosition() {
        gameMatrix.addToMatrix(9, 2, Matrix.colour.GREEN);
        assertEquals(gameMatrix.getMatrix()[9][2].getColour(), Matrix.colour.GREEN);
    }

    @Test
    void whenMatrixFull_thenCheckMatrixReturnsFalse() {
        fillMatrix();
        Block[][] cyanBlock = new ActiveBlockMatrix("CYAN", gameScreen).getMatrix();
        assertEquals(gameMatrix.check(cyanBlock, 3, 3, 2), false);
    }

    @Test
    void givenMatrixHasSpace_whenCheckCalledWithEmptyDirectionIndex_thenCheckMatrixReturnsTrue() {
        fillMatrixExceptOneColumn(3);
        Block[][] cyanBlock = new ActiveBlockMatrix("CYAN", gameScreen).getMatrix();
        assertEquals(gameMatrix.check(cyanBlock, 3, 9, 3), true);
    }

    @Test
    void givenMatrixLineIsFull_whenRemoveLineCalled_thenRemoveLine() {
        fillEndRowMatrix();
        gameMatrix.removeLine(9);
        for (int i = 0; i < gameMatrix.getWidth(); i++) {
                assertEquals(gameMatrix.getMatrix()[9][i].getColour(), Matrix.colour.NULL);
            }
        }
}
