import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import geometris.ActiveBlockMatrix;


public class ActiveBlockTest {
	@Test
	public void activeBlockCyanTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("CYAN");
		String[][] cyanBlock = {
				{"CYAN", "NULL", "NULL"},
				{"NULL", "NULL", "NULL"},
				{"NULL", "NULL", "NULL"}
						};
		assertArrayEquals(cyanBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockPurpleTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("PURPLE");
		String[][] purpleBlock = {
				{"PURPLE", "NULL", "NULL"},
				{"PURPLE", "NULL", "NULL"},
				{"PURPLE", "NULL", "NULL"}
		};
		assertArrayEquals(purpleBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockMagentaTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("MAGENTA");
		String[][] magentaBlock = {
				{"MAGENTA", "MAGENTA", "NULL"},
				{"MAGENTA", "MAGENTA", "NULL"},
				{"NULL", "NULL", "NULL"}
		};
		assertArrayEquals(magentaBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockOrangeTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("ORANGE");
		String[][] orangeBlock = {
				{"ORANGE", "NULL", "NULL"},
				{"ORANGE", "ORANGE", "NULL"},
				{"NULL", "NULL", "NULL"}
		};
		assertArrayEquals(orangeBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockMatrixYellowTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("YELLOW");
		String[][] yellowBlock = {
				{"YELLOW", "YELLOW", "NULL"},
				{"YELLOW", "NULL", "NULL"},
				{"YELLOW", "NULL", "NULL"}
		};
		assertArrayEquals(yellowBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockGreenTest() {
		ActiveBlockMatrix activeBlock = new ActiveBlockMatrix("GREEN");
		String[][] greenBlock = {
				{"GREEN", "NULL", "NULL"},
				{"GREEN", "GREEN", "NULL"},
				{"GREEN", "NULL", "NULL"}
		};
		assertArrayEquals(greenBlock, activeBlock.getMatrixString());
	}
}
