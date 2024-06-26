package main.geometris.blocks;

import main.geometris.game.GameScreen;

public class GameMatrix extends Matrix {

	// Constructor
	public GameMatrix(int h, int w, GameScreen game) {
		this.game = game;
		this.geometris = game.geometris;
		matrixHeight = h;
		matrixWidth = w;


		matrix = new Block[matrixHeight][matrixWidth];
		float addBlockOffset = 0;
		for (int i = 0; i < matrixHeight; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				matrix[i][j] = new GameBlock(i, j, colour.NULL, game);
				matrix[i][j].setOffset(addBlockOffset);
			}
			addBlockOffset += (float) (matrix[i][0].getHeight() + 4);
		}
	}

	public void addToMatrix(int hIndex, int wIndex, colour col) {
		float addBlockOffset = matrix[hIndex][wIndex].getOffset();
		matrix[hIndex][wIndex] = new GameBlock(hIndex, wIndex, col, game);
		matrix[hIndex][wIndex].setOffset(addBlockOffset);
	}

	public boolean check(Block[][] activeMatrix, int heightToCheck, int hIndex, int direction) {
		for (int i = 0; i < heightToCheck; i++) {
			for (int j = 0; j < 3; j++) {
				if(activeMatrix[i][j].getColour() != colour.NULL && matrix[hIndex - i][(direction + j) % 60].getColour() != colour.NULL) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean check(colour[][] activeMatrix, int heightToCheck, int hIndex, int direction) {
		for (int i = 0; i < heightToCheck; i++) {
			for (int j = 0; j < 3; j++) {
				if(activeMatrix[i][j] != colour.NULL && matrix[hIndex - i][(direction + j) % 60].getColour() != colour.NULL) {
					return false;
				}
			}
		}
		return true;
	}

	public Block[][] getMatrix() {
		return this.matrix;
	}

	public void removeLine(int hIndex) {
		for (int h = hIndex; h >= 0; h--) {
			for (int w = 0; w < matrixWidth; w++) {
				if (h != 0) {
					matrix[h][w].setColour(matrix[h - 1][w].getColour());
				} else {
					matrix[h][w].setColour(colour.NULL);
				}
			}
		}
	}
}