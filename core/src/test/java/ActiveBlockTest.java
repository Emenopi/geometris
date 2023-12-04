import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import geometris.Matrix;


public class ActiveBlockTest {
	@Test
	public void activeBlockCyanTest() {
		Matrix activeBlock = new Matrix("CYAN");
		String[][] cyanBlock = {
				{"CYAN", "NULL", "NULL"},
				{"NULL", "NULL", "NULL"},
				{"NULL", "NULL", "NULL"}
						};
		assertArrayEquals(cyanBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockPurpleTest() {
		Matrix activeBlock = new Matrix("PURPLE");
		String[][] purpleBlock = {
				{"PURPLE", "NULL", "NULL"},
				{"PURPLE", "NULL", "NULL"},
				{"PURPLE", "NULL", "NULL"}
		};
		assertArrayEquals(purpleBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockMagentaTest() {
		Matrix activeBlock = new Matrix("MAGENTA");
		String[][] magentaBlock = {
				{"MAGENTA", "MAGENTA", "NULL"},
				{"MAGENTA", "MAGENTA", "NULL"},
				{"NULL", "NULL", "NULL"}
		};
		assertArrayEquals(magentaBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockOrangeTest() {
		Matrix activeBlock = new Matrix("ORANGE");
		String[][] orangeBlock = {
				{"ORANGE", "NULL", "NULL"},
				{"ORANGE", "ORANGE", "NULL"},
				{"NULL", "NULL", "NULL"}
		};
		assertArrayEquals(orangeBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockMatrixYellowTest() {
		Matrix activeBlock = new Matrix("YELLOW");
		String[][] yellowBlock = {
				{"YELLOW", "YELLOW", "NULL"},
				{"YELLOW", "NULL", "NULL"},
				{"YELLOW", "NULL", "NULL"}
		};
		assertArrayEquals(yellowBlock, activeBlock.getMatrixString());
	}
	
	@Test
	public void activeBlockGreenTest() {
		Matrix activeBlock = new Matrix("GREEN");
		String[][] greenBlock = {
				{"GREEN", "NULL", "NULL"},
				{"GREEN", "GREEN", "NULL"},
				{"GREEN", "NULL", "NULL"}
		};
		assertArrayEquals(greenBlock, activeBlock.getMatrixString());
	}
}
