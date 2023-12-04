import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import geometris.ActiveBlockMatrix;
import geometris.Geometris;


public class ActiveBlockTest {
	Geometris geometris = new Geometris();
	@Test
	public void activeBlockCyanTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("CYAN", geometris);
		String[][] cyanBlock = {
				{"CYAN", "NULL", "NULL"},
				{"NULL", "NULL", "NULL"},
				{"NULL", "NULL", "NULL"}
						};
		assertArrayEquals(cyanBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockPurpleTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("PURPLE", geometris);
		String[][] purpleBlock = {
				{"PURPLE", "NULL", "NULL"},
				{"PURPLE", "NULL", "NULL"},
				{"PURPLE", "NULL", "NULL"}
		};
		assertArrayEquals(purpleBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockMagentaTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("MAGENTA", geometris);
		String[][] magentaBlock = {
				{"MAGENTA", "MAGENTA", "NULL"},
				{"MAGENTA", "MAGENTA", "NULL"},
				{"NULL", "NULL", "NULL"}
		};
		assertArrayEquals(magentaBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockOrangeTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("ORANGE", geometris);
		String[][] orangeBlock = {
				{"ORANGE", "NULL", "NULL"},
				{"ORANGE", "ORANGE", "NULL"},
				{"NULL", "NULL", "NULL"}
		};
		assertArrayEquals(orangeBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockMatrixYellowTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("YELLOW", geometris);
		String[][] yellowBlock = {
				{"YELLOW", "YELLOW", "NULL"},
				{"YELLOW", "NULL", "NULL"},
				{"YELLOW", "NULL", "NULL"}
		};
		assertArrayEquals(yellowBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockGreenTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("GREEN", geometris);
		String[][] greenBlock = {
				{"GREEN", "NULL", "NULL"},
				{"GREEN", "GREEN", "NULL"},
				{"GREEN", "NULL", "NULL"}
		};
		assertArrayEquals(greenBlock, activeBlock.getMatrixString());
	}
}
