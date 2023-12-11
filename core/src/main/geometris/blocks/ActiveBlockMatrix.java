package geometris.blocks;

import geometris.Geometris;
import geometris.blocks.Matrix;
import geometris.blocks.ActiveBlock;


public class ActiveBlockMatrix extends Matrix {
	int direction;
	colour colour;


	public ActiveBlockMatrix(String col, Geometris geo) {
		this.geometris = geo;
		this.assets = geo.assets;
		this.matrixHeight = 3;
		this.matrixWidth = 3;
		matrix = new ActiveBlock[matrixHeight][matrixWidth];
		generateMatrix(col, geo);
		this.colour = this.matrix[0][0].getColour();
		direction = 0;
	}
	
	private void generateMatrix(String col, Geometris geo) {
		float offsetOne = (float) 13.45;
		float offsetTwo = (float) 27.34;
		switch(col) {
		case "CYAN":
			matrix[0][0] = new ActiveBlock(0, 0, colour.CYAN, geo);
			break;
		case "PURPLE":
			matrix[0][0] = new ActiveBlock(0, 0, colour.PURPLE, geo);
			matrix[1][0] = new ActiveBlock(1, 0, colour.PURPLE, geo);
			matrix[2][0] = new ActiveBlock(2, 0, colour.PURPLE, geo);
			break;
		case "MAGENTA":
			matrix[0][0] = new ActiveBlock(0, 0, colour.MAGENTA, geo);
			matrix[0][1] = new ActiveBlock(0, 1, colour.MAGENTA, geo);
			matrix[1][0] = new ActiveBlock(1, 0, colour.MAGENTA, geo);
			matrix[1][1] = new ActiveBlock(1, 1, colour.MAGENTA, geo);
			break;
		case "ORANGE":
			matrix[0][0] = new ActiveBlock(0, 0, colour.ORANGE, geo);
			matrix[1][0] = new ActiveBlock(1, 0, colour.ORANGE,geo);
			matrix[1][1] = new ActiveBlock(1, 1, colour.ORANGE, geo);
			break;
		case "YELLOW":
			matrix[0][0] = new ActiveBlock(0, 0, colour.YELLOW, geo);
			matrix[0][1] = new ActiveBlock(0, 1, colour.YELLOW, geo);
			matrix[1][0] = new ActiveBlock(1, 0, colour.YELLOW, geo);
			matrix[2][0] = new ActiveBlock(2, 0, colour.YELLOW, geo);
			break;
		case "GREEN":
			matrix[0][0] = new ActiveBlock(0, 0, colour.GREEN, geo);
			matrix[1][0] = new ActiveBlock(1, 0, colour.GREEN, geo);
			matrix[1][1] = new ActiveBlock(1, 1, colour.GREEN, geo);
			matrix[2][0] = new ActiveBlock(2, 0, colour.GREEN, geo);
			break;
		}
		float addOffset = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (matrix[i][j] == null) {
					matrix[i][j] = new ActiveBlock(i, j, colour.NULL, geo);
				}
				matrix[i][j].setOffset(addOffset);
			}
			addOffset += (float) (matrix[i][0].getHeight());
		}

	}
	
	public String[][] getMatrixString() {
		String[][] matrixString = new String[matrixHeight][matrixWidth];
		for (int i = 0; i < matrixHeight; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				matrixString[i][j] = matrix[i][j].getColourString();
			}
		}
		return matrixString;
	}

	private double getOffsetX() {
		return Math.sin(Math.toRadians(direction * 6.0));
	}

	private double getOffsetY() {
		return Math.cos(Math.toRadians(direction * 6));
	}

	public void rotate() {
		direction = (direction + 1) % 60;
		for (int i = 0; i < matrixHeight; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				matrix[i][j].rotate();
			}
		}
	}

}
