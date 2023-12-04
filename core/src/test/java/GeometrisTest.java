import static org.junit.Assert.assertEquals;

import org.junit.Test;

import geometris.Geometris;
import geometris.Matrix;


public class GeometrisTest {
	Geometris geometris = new Geometris();
	Matrix gameMatrix = new Matrix(15, 60, geometris);

	@Test
	public void gameMatrixHeightTest() {
		assertEquals(15, gameMatrix.getHeight());
	}
	
	@Test
	public void gameMatrixWidthTest() {
		assertEquals(60, gameMatrix.getWidth());
	}
	
}
