package geometris;

public class ActiveBlockMatrix extends Matrix {
	
	ActiveBlock[][] matrix;

	public ActiveBlockMatrix(String col, Geometris geo) {
		super(3, 3, geo);
		matrixHeight = 3;
		matrixWidth = 3;		
		matrix = generateMatrix(col, geo);
	}
	
	private ActiveBlock[][] generateMatrix(String col, Geometris geo) {
		ActiveBlock[][] activeBlockMatrix = new ActiveBlock[3][3];
		float offsetOne = 14;
		float offsetTwo = 28;
		switch(col) {
		case "CYAN":
			activeBlockMatrix[0][0] = new ActiveBlock(0, 0, colour.CYAN, 0, geo);
			break;
		case "PURPLE":
			activeBlockMatrix[0][0] = new ActiveBlock(0, 0, colour.PURPLE, 0, geo);
			activeBlockMatrix[1][0] = new ActiveBlock(1, 0, colour.PURPLE, offsetOne, geo);
			activeBlockMatrix[2][0] = new ActiveBlock(2, 0, colour.PURPLE, offsetTwo, geo);
			break;
		case "MAGENTA":
			activeBlockMatrix[0][0] = new ActiveBlock(0, 0, colour.MAGENTA, 0, geo);
			activeBlockMatrix[0][1] = new ActiveBlock(0, 1, colour.MAGENTA, 0, geo);
			activeBlockMatrix[1][0] = new ActiveBlock(1, 0, colour.MAGENTA, offsetOne, geo);
			activeBlockMatrix[1][1] = new ActiveBlock(1, 1, colour.MAGENTA, offsetOne, geo);
			break;
		case "ORANGE":
			activeBlockMatrix[0][0] = new ActiveBlock(0, 0, colour.ORANGE, 0, geo);
			activeBlockMatrix[1][0] = new ActiveBlock(1, 0, colour.ORANGE, offsetOne,geo);
			activeBlockMatrix[1][1] = new ActiveBlock(1, 1, colour.ORANGE, offsetOne, geo);
			break;
		case "YELLOW":
			activeBlockMatrix[0][0] = new ActiveBlock(0, 0, colour.YELLOW, 0, geo);
			activeBlockMatrix[0][1] = new ActiveBlock(0, 1, colour.YELLOW, 0, geo);
			activeBlockMatrix[1][0] = new ActiveBlock(1, 0, colour.YELLOW, offsetOne, geo);
			activeBlockMatrix[2][0] = new ActiveBlock(2, 0, colour.YELLOW, offsetTwo, geo);
			break;
		case "GREEN":
			activeBlockMatrix[0][0] = new ActiveBlock(0, 0, colour.GREEN, 0, geo);
			activeBlockMatrix[1][0] = new ActiveBlock(1, 0, colour.GREEN, offsetOne, geo);
			activeBlockMatrix[1][1] = new ActiveBlock(1, 1, colour.GREEN, offsetOne, geo);
			activeBlockMatrix[2][0] = new ActiveBlock(2, 0, colour.GREEN, offsetTwo, geo);
			break;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (activeBlockMatrix[i][j] == null) {
					activeBlockMatrix[i][j] = new ActiveBlock(i, j, colour.NULL, 14 * i, geo);
				}
			}
		}
		
		return activeBlockMatrix;
	}

}
