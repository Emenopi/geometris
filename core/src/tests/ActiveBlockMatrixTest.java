package tests;

import com.badlogic.gdx.Game;
import main.geometris.GameScreen;
import main.geometris.Geometris;
import main.geometris.blocks.ActiveBlockMatrix;
import main.geometris.blocks.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
@ExtendWith(MockitoExtension.class)
class ActiveBlockMatrixTest {

    private Geometris application;
    ActiveBlockMatrix activeBlockMatrix;
    @Mock
    private Geometris geo;
    @Mock
    private GameScreen gameScreen;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Block[][] initMatrix = new Block[3][3];
        activeBlockMatrix = spy(new ActiveBlockMatrix("PURPLE", gameScreen, initMatrix));
    }

    @Test
    public void activeBlockPurpleTest() {
        Block[][] initMatrix = new Block[3][3];
        String[][] purpleBlock = new String[][]{{"PURPLE", "NULL", "NULL"}, {"PURPLE", "NULL", "NULL"}, {"PURPLE", "NULL", "NULL"}};
        assertArrayEquals(purpleBlock, activeBlockMatrix.getMatrixString());
    }

//    @Test
//    public void activeBlockMagentaTest() {
//        Block[][] init = new Block[3][3];
//        ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("MAGENTA", this.gameScreen, init);
//        String[][] magentaBlock = new String[][]{{"MAGENTA", "MAGENTA", "NULL"}, {"MAGENTA", "MAGENTA", "NULL"}, {"NULL", "NULL", "NULL"}};
//        assertArrayEquals(magentaBlock, activeBlock.getMatrixString());
//    }
//
//    @Test
//    public void activeBlockOrangeTest() {
//        ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("ORANGE", this.gameScreen);
//        String[][] orangeBlock = new String[][]{{"ORANGE", "NULL", "NULL"}, {"ORANGE", "ORANGE", "NULL"}, {"NULL", "NULL", "NULL"}};
//        assertArrayEquals(orangeBlock, activeBlock.getMatrixString());
//    }
//
//    @Test
//    public void activeBlockMatrixYellowTest() {
//        ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("YELLOW", this.gameScreen);
//        String[][] yellowBlock = new String[][]{{"YELLOW", "YELLOW", "NULL"}, {"YELLOW", "NULL", "NULL"}, {"YELLOW", "NULL", "NULL"}};
//        assertArrayEquals(yellowBlock, activeBlock.getMatrixString());
//    }
//
//    @Test
//    public void activeBlockGreenTest() {
//        ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("GREEN", this.gameScreen);
//        String[][] greenBlock = new String[][]{{"GREEN", "NULL", "NULL"}, {"GREEN", "GREEN", "NULL"}, {"GREEN", "NULL", "NULL"}};
//        assertArrayEquals(greenBlock, activeBlock.getMatrixString());
//    }
}