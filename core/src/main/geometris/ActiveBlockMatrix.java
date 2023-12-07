package geometris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class ActiveBlockMatrix extends Matrix {
	
	ActiveBlock[][] matrix;
	int direction;
	colour colour;


	public ActiveBlockMatrix(String col, Geometris geo) {
		this.geometris = geo;
		this.assets = geo.assets;
		this.matrixHeight = 3;
		this.matrixWidth = 3;
		this.matrix = generateMatrix(col, geo);
		this.colour = this.matrix[0][0].getColour();
		direction = 0;
	}
	
	private ActiveBlock[][] generateMatrix(String col, Geometris geo) {
		ActiveBlock[][] activeBlockMatrix = new ActiveBlock[3][3];
		float offsetOne = (float) 13.45;
		float offsetTwo = (float) 27.34;
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
					activeBlockMatrix[i][j] = new ActiveBlock(i, j, colour.NULL, 0, geo);
				}
				activeBlockMatrix[i][j].setDirection(direction);
			}
		}
		
		return activeBlockMatrix;
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

	public float getPositionX() {
		double centre = (Gdx.graphics.getWidth() / 2.0) - 5;
		double blockHeight = getSpriteHeight();
		double offset = (-6 + blockHeight * 0.3) * getOffsetX();
		double positionX;
		positionX = centre + offset;
		return (float) positionX;
	}

	public float getPositionY() {
		double centre = (Gdx.graphics.getHeight() / 2.0) - 5;
		double blockHeight = getSpriteHeight();
		double offset = (-20 + blockHeight * 0.3) * getOffsetY();
		double positionY;
		positionY = centre + offset;
		return (float) positionY;
	}

	private double getSpriteHeight() {
		Sprite sprite = this.getBlockSprite(colour);
		sprite.rotate(direction * 6);
		sprite.setSize((float) (sprite.getRegionWidth() * 0.3), (float) (sprite.getRegionHeight() * 0.3));
		return sprite.getRegionHeight();
	}

	private double getSpriteWidth() {
		Sprite sprite = this.getBlockSprite(colour);
		sprite.setSize((float) (sprite.getRegionWidth() * 0.2), (float) (sprite.getRegionHeight() * 0.2));
		sprite.setRotation(direction * -6);
		return sprite.getRegionWidth();
	}

	public Sprite getSprite() {
		Sprite sprite = this.getBlockSprite(colour);
		double height = sprite.getRegionHeight() * 0.2;
		double width = sprite.getRegionWidth() * 0.2;
		sprite.setSize((float) width, (float) height);
		sprite.setOrigin((float) (width/2), (float) (height/2));
		sprite.setRotation(direction * -6);
		sprite.setPosition(getPositionX(), getPositionY());
		return sprite;
	}

	public void rotate() {
		direction = (direction + 1) % 60;
	}

}
