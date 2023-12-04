import static org.junit.Assert.assertEquals;

import org.junit.Test;

import geometris.Matrix;


public class GeometrisTest {
	
	Matrix gameMatrix = new Matrix(15, 60);

	@Test
	public void gameMatrixHeightTest() {
		assertEquals(15, gameMatrix.getHeight());
	}
	
	@Test
	public void gameMatrixWidthTest() {
		assertEquals(60, gameMatrix.getWidth());
	}
	
}
