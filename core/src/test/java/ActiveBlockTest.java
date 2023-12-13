
import geometris.GameScreen;

import geometris.blocks.ActiveBlockMatrix;
import geometris.Geometris;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class ActiveBlockTest {
	Geometris geo = new Geometris();
	GameScreen game = new GameScreen(geo);
	@Test
	public void activeBlockCyanTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("CYAN", game);
		String[][] cyanBlock = {
				{"CYAN", "NULL", "NULL"},
				{"NULL", "NULL", "NULL"},
				{"NULL", "NULL", "NULL"}
						};
		assertArrayEquals(cyanBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockPurpleTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("PURPLE", game);
		String[][] purpleBlock = {
				{"PURPLE", "NULL", "NULL"},
				{"PURPLE", "NULL", "NULL"},
				{"PURPLE", "NULL", "NULL"}
		};
		assertArrayEquals(purpleBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockMagentaTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("MAGENTA", game);
		String[][] magentaBlock = {
				{"MAGENTA", "MAGENTA", "NULL"},
				{"MAGENTA", "MAGENTA", "NULL"},
				{"NULL", "NULL", "NULL"}
		};
		assertArrayEquals(magentaBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockOrangeTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("ORANGE", game);
		String[][] orangeBlock = {
				{"ORANGE", "NULL", "NULL"},
				{"ORANGE", "ORANGE", "NULL"},
				{"NULL", "NULL", "NULL"}
		};
		assertArrayEquals(orangeBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockMatrixYellowTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("YELLOW", game);
		String[][] yellowBlock = {
				{"YELLOW", "YELLOW", "NULL"},
				{"YELLOW", "NULL", "NULL"},
				{"YELLOW", "NULL", "NULL"}
		};
		assertArrayEquals(yellowBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockGreenTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("GREEN", game);
		String[][] greenBlock = {
				{"GREEN", "NULL", "NULL"},
				{"GREEN", "GREEN", "NULL"},
				{"GREEN", "NULL", "NULL"}
		};
		assertArrayEquals(greenBlock, activeBlock.getMatrixString());
	}
}
