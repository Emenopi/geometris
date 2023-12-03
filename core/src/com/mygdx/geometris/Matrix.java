package mygdx.geometris;

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
		BLACK
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
	
	public Block[][] getMatrix() {
		return matrix;
	}
	
	public Sprite getBlockSprite(int hIndex, int wIndex) {
		return matrix[hIndex][wIndex].getBlockSprite();
	}


	public void main(String[] args) {
	}

}
