import static org.junit.Assert.assertEquals;

import org.junit.Test;

import geometris.blocks.GameMatrix;
import geometris.Geometris;


public class GeometrisTest {
	Geometris geometris = new Geometris();
	GameMatrix gameMatrix = new GameMatrix(15, 60, geometris);

	@Test
	public void gameMatrixHeightTest() {
		assertEquals(15, gameMatrix.getHeight());
	}
	
	@Test
	public void gameMatrixWidthTest() {
		assertEquals(60, gameMatrix.getWidth());
	}
	
}
