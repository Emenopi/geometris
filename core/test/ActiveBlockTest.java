import main.geometris.GameScreen;
import main.geometris.Geometris;
import main.geometris.blocks.ActiveBlockMatrix;
import org.junit.Assert;
import org.junit.Test;

public class ActiveBlockTest {
    Geometris geo = new Geometris();
    GameScreen gameScreen = new GameScreen(geo);

    public ActiveBlockTest() {
    }

    @Test
    public void activeBlockCyanTest() {
        ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("CYAN", this.gameScreen);
        String[][] cyanBlock = new String[][]{{"CYAN", "NULL", "NULL"}, {"NULL", "NULL", "NULL"}, {"NULL", "NULL", "NULL"}};
        Assert.assertArrayEquals(cyanBlock, activeBlock.getMatrixString());
    }

    @Test
    public void activeBlockPurpleTest() {
        ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("PURPLE", this.gameScreen);
        String[][] purpleBlock = new String[][]{{"PURPLE", "NULL", "NULL"}, {"PURPLE", "NULL", "NULL"}, {"PURPLE", "NULL", "NULL"}};
        Assert.assertArrayEquals(purpleBlock, activeBlock.getMatrixString());
    }

    @Test
    public void activeBlockMagentaTest() {
        ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("MAGENTA", this.gameScreen);
        String[][] magentaBlock = new String[][]{{"MAGENTA", "MAGENTA", "NULL"}, {"MAGENTA", "MAGENTA", "NULL"}, {"NULL", "NULL", "NULL"}};
        Assert.assertArrayEquals(magentaBlock, activeBlock.getMatrixString());
    }

    @Test
    public void activeBlockOrangeTest() {
        ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("ORANGE", this.gameScreen);
        String[][] orangeBlock = new String[][]{{"ORANGE", "NULL", "NULL"}, {"ORANGE", "ORANGE", "NULL"}, {"NULL", "NULL", "NULL"}};
        Assert.assertArrayEquals(orangeBlock, activeBlock.getMatrixString());
    }

    @Test
    public void activeBlockMatrixYellowTest() {
        ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("YELLOW", this.gameScreen);
        String[][] yellowBlock = new String[][]{{"YELLOW", "YELLOW", "NULL"}, {"YELLOW", "NULL", "NULL"}, {"YELLOW", "NULL", "NULL"}};
        Assert.assertArrayEquals(yellowBlock, activeBlock.getMatrixString());
    }

    @Test
    public void activeBlockGreenTest() {
        ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("GREEN", this.gameScreen);
        String[][] greenBlock = new String[][]{{"GREEN", "NULL", "NULL"}, {"GREEN", "GREEN", "NULL"}, {"GREEN", "NULL", "NULL"}};
        Assert.assertArrayEquals(greenBlock, activeBlock.getMatrixString());
    }
}
