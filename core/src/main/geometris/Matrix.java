package geometris;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Matrix {
	int matrixHeight;
	int matrixWidth;
	Block[][] matrix;
	
	enum colour {
		CYAN,
		PURPLE,
		MAGENTA,
		ORANGE,
		YELLOW,
		GREEN,
		BLACK,
		NULL
	}

	// Constructor	
	public Matrix(int h, int w) {
		matrixHeight = h;
		matrixWidth = w;
		
		matrix = new Block[matrixHeight][matrixWidth];
		float addBlockOffset = 0;
		for (int i = 0; i < matrixHeight; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				matrix[i][j] = new Block(i, j, colour.CYAN, addBlockOffset);
			}
			addBlockOffset += matrix[i][0].getHeight() + 4;
		}
	}
	
	public Matrix(String col) {
		matrixHeight = 3;
		matrixWidth = 3;		
		matrix = generateActiveBlockMatrix(col);
		
	}
	
	private Block[][] generateActiveBlockMatrix(String col) {
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
	
	public Block[][] getMatrix() {
		return matrix;
	}
	
	public Sprite getBlockSprite(int hIndex, int wIndex) {
		return matrix[hIndex][wIndex].getBlockSprite();
	}
	
	public int getHeight() {
		return matrixHeight;
	}
	
	public int getWidth() {
		return matrixWidth;
	}
	
	public String[][] getMatrixString() {
		String[][] matrixString = new String[matrixHeight][matrixWidth];
		for (int i = 0; i < matrixHeight; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				matrixString[i][j] = matrix[i][j].getColour().toString();
			}
		}
		
		return matrixString;
	}


	public void main(String[] args) {
	}

}
