package main.geometris.blocks;

import main.geometris.GameScreen;
import main.geometris.Geometris;


public class ActiveBlockMatrix extends Matrix {
	int direction;
	colour colour;

	public ActiveBlockMatrix(String col, GameScreen game) {
		this.game = game;
		this.geometris = game.geometris;
		this.matrixHeight = 3;
		this.matrixWidth = 3;
		geometris.assets.load();
		geometris.assets.manager.finishLoading();
		matrix = new ActiveBlock[matrixHeight][matrixWidth];
		generateMatrix(col, game);
		this.colour = this.matrix[0][0].getColour();
		direction = 0;
	}

	private void generateMatrix(String col, GameScreen game) {
		switch(col) {
			case "CYAN":
				matrix[0][0] = new ActiveBlock(0, 0, colour.CYAN, game);
				break;
			case "PURPLE":
				matrix[0][0] = new ActiveBlock(0, 0, colour.PURPLE, game);
				matrix[1][0] = new ActiveBlock(1, 0, colour.PURPLE, game);
				matrix[2][0] = new ActiveBlock(2, 0, colour.PURPLE, game);
				break;
			case "MAGENTA":
				matrix[0][0] = new ActiveBlock(0, 0, colour.MAGENTA, game);
				matrix[0][1] = new ActiveBlock(0, 1, colour.MAGENTA, game);
				matrix[1][0] = new ActiveBlock(1, 0, colour.MAGENTA, game);
				matrix[1][1] = new ActiveBlock(1, 1, colour.MAGENTA, game);
				break;
			case "ORANGE":
				matrix[0][0] = new ActiveBlock(0, 0, colour.ORANGE, game);
				matrix[1][0] = new ActiveBlock(1, 0, colour.ORANGE,game);
				matrix[1][1] = new ActiveBlock(1, 1, colour.ORANGE, game);
				break;
			case "YELLOW":
				matrix[0][0] = new ActiveBlock(0, 0, colour.YELLOW, game);
				matrix[0][1] = new ActiveBlock(0, 1, colour.YELLOW, game);
				matrix[1][0] = new ActiveBlock(1, 0, colour.YELLOW, game);
				matrix[2][0] = new ActiveBlock(2, 0, colour.YELLOW, game);
				break;
			case "GREEN":
				matrix[0][0] = new ActiveBlock(0, 0, colour.GREEN, game);
				matrix[1][0] = new ActiveBlock(1, 0, colour.GREEN, game);
				matrix[1][1] = new ActiveBlock(1, 1, colour.GREEN, game);
				matrix[2][0] = new ActiveBlock(2, 0, colour.GREEN, game);
				break;
		}
		float addOffset = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (matrix[i][j] == null) {
					matrix[i][j] = new ActiveBlock(i, j, colour.NULL, game);
				}
				matrix[i][j].setOffset(addOffset);
			}
			addOffset -= (float) (matrix[i][0].getHeight());
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

	public void rotate(int dir) {
		direction = dir;
		for (int i = 0; i < matrixHeight; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				matrix[i][j].rotate(direction);
			}
		}
	}

	public int getDirection() {
		return direction;
	}

	public void moveOut(int heightIndex, float addBlockOffset) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				((ActiveBlock) matrix[i][j]).setRadius(115);
				((ActiveBlock) matrix[i][j]).setSizeScale(1);
				((ActiveBlock) matrix[i][j]).setHeightIndex(heightIndex - i);
				matrix[i][j].setOffset(addBlockOffset);
			}
			addBlockOffset -= (float) (matrix[i][0].getHeight() + 4);
		}
	}

	public colour[][] invertMatrix(Block[][] matrix) {
		colour[][] newMatrix = new colour[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = i; j < 3; j++) {
				colour temp = matrix[i][j].getColour();
				newMatrix[i][j] = matrix[j][i].getColour();
				newMatrix[j][i] = temp;
			}
		}
		return newMatrix;
	}

	public colour[][] rotateClockwise() {
		colour[][] newMatrix = invertMatrix(matrix);
		for (int i = 0; i < 3; i++) {
			colour temp = newMatrix[i][0];
			newMatrix[i][0] = newMatrix[i][2];
			newMatrix[i][2] = temp;
		}
		newMatrix = adjustNullBlocks(newMatrix);
		return newMatrix;
	}

	public colour[][] rotateAntiClockwise() {
		colour[][] newMatrix = invertMatrix(matrix);
		for (int i = 0; i < 3; i++) {
			colour temp = newMatrix[0][i];
			newMatrix[0][i] = newMatrix[2][i];
			newMatrix[2][i] = temp;
		}
		newMatrix = adjustNullBlocks(newMatrix);
		return newMatrix;
	}

	public colour[][] adjustNullBlocks(colour[][] newMatrix) {
		for (int i = 0; i < 2; i++) {
			if (
					newMatrix[0][0] == Matrix.colour.NULL &&
							newMatrix[0][1] == Matrix.colour.NULL &&
							newMatrix[0][2] == Matrix.colour.NULL
			) {
				newMatrix = adjustBlocksUp(newMatrix);
			}
		}
		for (int i = 0; i < 2; i++) {
			if (
					newMatrix[0][0] == Matrix.colour.NULL &&
							newMatrix[1][0] == Matrix.colour.NULL &&
							newMatrix[2][0] == Matrix.colour.NULL
			) {
				newMatrix = adjustBlocksLeft(newMatrix);
			}
		}

		return newMatrix;
	}

	public colour[][] adjustBlocksUp(colour[][] newMatrix) {
		colour[][] adjustedMatrix = new colour[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				adjustedMatrix[i][j] = newMatrix[(i + 1) % 3][j];
			}
		}
		return adjustedMatrix;
	}

	public colour[][] adjustBlocksLeft(colour[][] newMatrix) {
		colour[][] adjustedMatrix = new colour[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				adjustedMatrix[i][j] = newMatrix[i][(j + 1) % 3];
			}
		}
		return adjustedMatrix;
	}

	public void transferMatrix(colour[][] newMatrix) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix[i][j].setColour(newMatrix[i][j]);
			}
		}
	}

	public colour getColour() {
		return colour;
	}

}