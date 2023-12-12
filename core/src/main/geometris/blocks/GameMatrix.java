package geometris.blocks;

import geometris.Geometris;
import geometris.blocks.Block;
import geometris.blocks.GameBlock;
import geometris.blocks.Matrix;

public class GameMatrix extends Matrix {

	// Constructor	
	public GameMatrix(int h, int w, Geometris geo) {
		this.geometris = geo;
		matrixHeight = h;
		matrixWidth = w;
		
		matrix = new Block[matrixHeight][matrixWidth];
		float addBlockOffset = 0;
		for (int i = 0; i < matrixHeight; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				matrix[i][j] = new GameBlock(i, j, colour.NULL, geometris);
				matrix[i][j].setOffset(addBlockOffset);
			}
			addBlockOffset += (float) (matrix[i][0].getHeight() + 4);
		}
	}

	public void addToMatrix(int hIndex, int wIndex, colour col) {
		float addBlockOffset = matrix[hIndex][wIndex].getOffset();
		matrix[hIndex][wIndex] = new GameBlock(hIndex, wIndex, col, geometris);
		matrix[hIndex][wIndex].setOffset(addBlockOffset);
	}

	public boolean check(Block[][] activeMatrix, int heightToCheck, int hIndex, int direction) {
		for (int i = 0; i < heightToCheck; i++) {
			for (int j = 0; j < 3; j++) {
				if(activeMatrix[i][j].getColour() != colour.NULL && matrix[hIndex - i][direction + j].getColour() != colour.NULL) {
					return false;
				}
			}
		}
		return true;
	}
}
