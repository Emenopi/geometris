import main.geometris.GameScreen;
import main.geometris.Geometris;
import main.geometris.blocks.GameMatrix;
import org.junit.Assert;
import org.junit.Test;

public class GeometrisTest {
        Geometris geometris = new Geometris();
        GameScreen gameScreen = new GameScreen(geometris);
        GameMatrix gameMatrix;

        public GeometrisTest() {
            this.gameMatrix = new GameMatrix(15, 60, this.gameScreen);
        }

        @Test
        public void gameMatrixHeightTest() {
            Assert.assertEquals(15L, (long)this.gameMatrix.getHeight());
        }

        @Test
        public void gameMatrixWidthTest() {
            Assert.assertEquals(60L, (long)this.gameMatrix.getWidth());
        }
    }
