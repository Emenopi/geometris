package tests;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
@ExtendWith(MockitoExtension.class)
class ActiveBlockMatrixTest {

    private Geometris application;
    ActiveBlockMatrix activeBlockMatrix;
    @Mock
    private Geometris geo;
    @Mock
    private GameScreen gameScreen;
    Block[][] initMatrix;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        initMatrix = new Block[3][3];
    }
    @Test
    public void activeBlockCyanTest() {
        activeBlockMatrix = spy(new ActiveBlockMatrix("CYAN", gameScreen, initMatrix));
        String[][] purpleBlock = new String[][]{{"CYAN", "NULL", "NULL"}, {"NULL", "NULL", "NULL"}, {"NULL", "NULL", "NULL"}};
        assertArrayEquals(purpleBlock, activeBlockMatrix.getMatrixString());
    }

    @Test
    public void activeBlockPurpleTest() {
        activeBlockMatrix = spy(new ActiveBlockMatrix("PURPLE", gameScreen, initMatrix));
        String[][] purpleBlock = new String[][]{{"PURPLE", "NULL", "NULL"}, {"PURPLE", "NULL", "NULL"}, {"PURPLE", "NULL", "NULL"}};
        assertArrayEquals(purpleBlock, activeBlockMatrix.getMatrixString());
    }

    @Test
    public void activeBlockMagentaTest() {
        Block[][] init = new Block[3][3];
        activeBlockMatrix = new ActiveBlockMatrix("MAGENTA", gameScreen, initMatrix);
        String[][] magentaBlock = new String[][]{{"MAGENTA", "MAGENTA", "NULL"}, {"MAGENTA", "MAGENTA", "NULL"}, {"NULL", "NULL", "NULL"}};
        assertArrayEquals(magentaBlock, activeBlockMatrix.getMatrixString());
    }

    @Test
    public void activeBlockOrangeTest() {
        activeBlockMatrix = new ActiveBlockMatrix("ORANGE", this.gameScreen, initMatrix);
        String[][] orangeBlock = new String[][]{{"ORANGE", "NULL", "NULL"}, {"ORANGE", "ORANGE", "NULL"}, {"NULL", "NULL", "NULL"}};
        assertArrayEquals(orangeBlock, activeBlockMatrix.getMatrixString());
    }

    @Test
    public void activeBlockMatrixYellowTest() {
        activeBlockMatrix = new ActiveBlockMatrix("YELLOW", gameScreen, initMatrix);
        String[][] yellowBlock = new String[][]{{"YELLOW", "YELLOW", "NULL"}, {"YELLOW", "NULL", "NULL"}, {"YELLOW", "NULL", "NULL"}};
        assertArrayEquals(yellowBlock, activeBlockMatrix.getMatrixString());
    }

    @Test
    public void activeBlockGreenTest() {
        activeBlockMatrix = new ActiveBlockMatrix("GREEN", gameScreen, initMatrix);
        String[][] greenBlock = new String[][]{{"GREEN", "NULL", "NULL"}, {"GREEN", "GREEN", "NULL"}, {"GREEN", "NULL", "NULL"}};
        assertArrayEquals(greenBlock, activeBlockMatrix.getMatrixString());
    }
}