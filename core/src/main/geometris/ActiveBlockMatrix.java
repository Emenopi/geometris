package geometris;

public class ActiveBlockMatrix extends Matrix {

	public ActiveBlockMatrix(String col) {
		super(3, 3);
		matrixHeight = 3;
		matrixWidth = 3;		
		matrix = generateMatrix(col);
	}
	
	private Block[][] generateMatrix(String col) {
		Block[][] activeBlockMatrix = new Block[3][3];		
		switch(col) {
		case "CYAN":
			activeBlockMatrix[0][0] = new Block(0, 0, colour.CYAN, 0);
			break;
		case "PURPLE":
			activeBlockMatrix[0][0] = new Block(0, 0, colour.PURPLE, 0);
			activeBlockMatrix[1][0] = new Block(1, 0, colour.PURPLE, 0);
			activeBlockMatrix[2][0] = new Block(2, 0, colour.PURPLE, 0);
			break;
		case "MAGENTA":
			activeBlockMatrix[0][0] = new Block(0, 0, colour.MAGENTA, 0);
			activeBlockMatrix[0][1] = new Block(0, 1, colour.MAGENTA, 0);
			activeBlockMatrix[1][0] = new Block(1, 0, colour.MAGENTA, 0);
			activeBlockMatrix[1][1] = new Block(1, 1, colour.MAGENTA, 0);
			break;
		case "ORANGE":
			activeBlockMatrix[0][0] = new Block(0, 0, colour.ORANGE, 0);
			activeBlockMatrix[1][0] = new Block(1, 0, colour.ORANGE, 0);
			activeBlockMatrix[1][1] = new Block(1, 1, colour.ORANGE, 0);
			break;
		case "YELLOW":
			activeBlockMatrix[0][0] = new Block(0, 0, colour.YELLOW, 0);
			activeBlockMatrix[0][1] = new Block(0, 1, colour.YELLOW, 0);
			activeBlockMatrix[1][0] = new Block(1, 0, colour.YELLOW, 0);
			activeBlockMatrix[2][0] = new Block(2, 0, colour.YELLOW, 0);
			break;
		case "GREEN":
			activeBlockMatrix[0][0] = new Block(0, 0, colour.GREEN, 0);
			activeBlockMatrix[1][0] = new Block(1, 0, colour.GREEN, 0);
			activeBlockMatrix[1][1] = new Block(1, 1, colour.GREEN, 0);
			activeBlockMatrix[2][0] = new Block(2, 0, colour.GREEN, 0);
			break;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (activeBlockMatrix[i][j] == null) {
					activeBlockMatrix[i][j] = new Block(i, j, colour.NULL, 0);
				}
			}
		}
		
		return activeBlockMatrix;
	}

}
