import org.junit.jupiter.api.Test;

import geometris.GameScreen;

import geometris.blocks.GameMatrix;
import geometris.Geometris;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GeometrisTest {
	Geometris geometris = new Geometris();
	GameScreen game = new GameScreen(geometris);
	GameMatrix gameMatrix = new GameMatrix(15, 60, game);


	@Test
	public void gameMatrixHeightTest() {
		assertEquals(15, gameMatrix.getHeight());
	}
	
	@Test
	public void gameMatrixWidthTest() {
		assertEquals(60, gameMatrix.getWidth());
	}
	
}
