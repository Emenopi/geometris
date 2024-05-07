package tests.blocks;

import main.geometris.blocks.Matrix;
import main.geometris.game.GameScreen;
import main.geometris.game.Geometris;
import main.geometris.blocks.ActiveBlockMatrix;
import main.geometris.blocks.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
@ExtendWith(MockitoExtension.class)
class ActiveBlockMatrixTest {

    ActiveBlockMatrix activeBlockMatrix;
    @Mock
    private GameScreen gameScreen;
    Block[][] initMatrix;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        initMatrix = new Block[3][3];
    }
    @Test
    void whenColourIsCyan_thenMatrixIsCyanBlockShape() {
        activeBlockMatrix = spy(new ActiveBlockMatrix("CYAN", gameScreen));
        String[][] purpleBlock = new String[][]{{"CYAN", "NULL", "NULL"}, {"NULL", "NULL", "NULL"}, {"NULL", "NULL", "NULL"}};
        assertArrayEquals(purpleBlock, activeBlockMatrix.getMatrixString());
    }

    @Test
    void whenColourIsPurple_thenMatrixIsPurpleLineShape() {
        activeBlockMatrix = spy(new ActiveBlockMatrix("PURPLE", gameScreen));
        String[][] purpleBlock = new String[][]{{"PURPLE", "NULL", "NULL"}, {"PURPLE", "NULL", "NULL"}, {"PURPLE", "NULL", "NULL"}};
        assertArrayEquals(purpleBlock, activeBlockMatrix.getMatrixString());
    }

    @Test
    void whenColourIsMagenta_thenMatrixIsMagentaSquareShape() {
        Block[][] init = new Block[3][3];
        activeBlockMatrix = new ActiveBlockMatrix("MAGENTA", gameScreen);
        String[][] magentaBlock = new String[][]{{"MAGENTA", "MAGENTA", "NULL"}, {"MAGENTA", "MAGENTA", "NULL"}, {"NULL", "NULL", "NULL"}};
        assertArrayEquals(magentaBlock, activeBlockMatrix.getMatrixString());
    }

    @Test
    void whenColourIsOrange_thenMatrixIsOrangeShape() {
        activeBlockMatrix = new ActiveBlockMatrix("ORANGE", this.gameScreen);
        String[][] orangeBlock = new String[][]{{"ORANGE", "NULL", "NULL"}, {"ORANGE", "ORANGE", "NULL"}, {"NULL", "NULL", "NULL"}};
        assertArrayEquals(orangeBlock, activeBlockMatrix.getMatrixString());
    }

    @Test
    void whenColourIsYellow_thenMatrixIsYellowShape() {
        activeBlockMatrix = new ActiveBlockMatrix("YELLOW", gameScreen);
        String[][] yellowBlock = new String[][]{{"YELLOW", "YELLOW", "NULL"}, {"YELLOW", "NULL", "NULL"}, {"YELLOW", "NULL", "NULL"}};
        assertArrayEquals(yellowBlock, activeBlockMatrix.getMatrixString());
    }

    @Test
    void whenColourIsGreen_thenMatrixIsGreenShape() {
        activeBlockMatrix = new ActiveBlockMatrix("GREEN", gameScreen);
        String[][] greenBlock = new String[][]{{"GREEN", "NULL", "NULL"}, {"GREEN", "GREEN", "NULL"}, {"GREEN", "NULL", "NULL"}};
        assertArrayEquals(greenBlock, activeBlockMatrix.getMatrixString());
    }

    @Test
    void whenRotateMatrixClockWise_thenMatrixRotatedClockwise() {
        activeBlockMatrix = new ActiveBlockMatrix("GREEN", gameScreen);
        String[][] greenBlock = new String[][]{{"GREEN", "GREEN", "GREEN"}, {"NULL", "GREEN", "NULL"}, {"NULL", "NULL", "NULL"}};
        Matrix.colour[][] rotatedMatrix = activeBlockMatrix.rotateClockwise();
        assertEquals(Arrays.deepToString(greenBlock), Arrays.deepToString(rotatedMatrix));
    }

    @Test
    void whenRotateMatrixAntilockWise_thenMatrixRotatedAntilockwise() {
        activeBlockMatrix = new ActiveBlockMatrix("GREEN", gameScreen);
        String[][] greenBlock = new String[][]{{"NULL", "GREEN", "NULL"}, {"GREEN", "GREEN", "GREEN"}, {"NULL", "NULL", "NULL"}};
        Matrix.colour[][] rotatedMatrix = activeBlockMatrix.rotateAntiClockwise();
        assertEquals(Arrays.deepToString(greenBlock), Arrays.deepToString(rotatedMatrix));
    }
}