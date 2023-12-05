package geometris;

import com.badlogic.gdx.graphics.g2d.Sprite;

abstract class Matrix {
	
	Block[][] matrix;
	Geometris geometris;
	int matrixHeight;
	int matrixWidth;

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
	

}
