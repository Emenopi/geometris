package geometris;

public class ActiveBlockMatrix extends Matrix {
	
	ActiveBlock[][] matrix;

	public ActiveBlockMatrix(String col) {
		super(3, 3);
		matrixHeight = 3;
		matrixWidth = 3;		
		matrix = generateMatrix(col);
	}
	
	private ActiveBlock[][] generateMatrix(String col) {
		ActiveBlock[][] activeBlockMatrix = new ActiveBlock[3][3];
		float offsetOne = 14;
		float offsetTwo = 28;
		switch(col) {
		case "CYAN":
			activeBlockMatrix[0][0] = new ActiveBlock(0, 0, colour.CYAN, 0);
			break;
		case "PURPLE":
			activeBlockMatrix[0][0] = new ActiveBlock(0, 0, colour.PURPLE, 0);
			activeBlockMatrix[1][0] = new ActiveBlock(1, 0, colour.PURPLE, offsetOne);
			activeBlockMatrix[2][0] = new ActiveBlock(2, 0, colour.PURPLE, offsetTwo);
			break;
		case "MAGENTA":
			activeBlockMatrix[0][0] = new ActiveBlock(0, 0, colour.MAGENTA, 0);
			activeBlockMatrix[0][1] = new ActiveBlock(0, 1, colour.MAGENTA, 0);
			activeBlockMatrix[1][0] = new ActiveBlock(1, 0, colour.MAGENTA, offsetOne);
			activeBlockMatrix[1][1] = new ActiveBlock(1, 1, colour.MAGENTA, offsetOne);
			break;
		case "ORANGE":
			activeBlockMatrix[0][0] = new ActiveBlock(0, 0, colour.ORANGE, 0);
			activeBlockMatrix[1][0] = new ActiveBlock(1, 0, colour.ORANGE, offsetOne);
			activeBlockMatrix[1][1] = new ActiveBlock(1, 1, colour.ORANGE, offsetOne);
			break;
		case "YELLOW":
			activeBlockMatrix[0][0] = new ActiveBlock(0, 0, colour.YELLOW, 0);
			activeBlockMatrix[0][1] = new ActiveBlock(0, 1, colour.YELLOW, 0);
			activeBlockMatrix[1][0] = new ActiveBlock(1, 0, colour.YELLOW, offsetOne);
			activeBlockMatrix[2][0] = new ActiveBlock(2, 0, colour.YELLOW, offsetTwo);
			break;
		case "GREEN":
			activeBlockMatrix[0][0] = new ActiveBlock(0, 0, colour.GREEN, 0);
			activeBlockMatrix[1][0] = new ActiveBlock(1, 0, colour.GREEN, offsetOne);
			activeBlockMatrix[1][1] = new ActiveBlock(1, 1, colour.GREEN, offsetOne);
			activeBlockMatrix[2][0] = new ActiveBlock(2, 0, colour.GREEN, offsetTwo);
			break;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (activeBlockMatrix[i][j] == null) {
					activeBlockMatrix[i][j] = new ActiveBlock(i, j, colour.NULL, 14 * i);
				}
			}
		}
		
		return activeBlockMatrix;
	}

}
