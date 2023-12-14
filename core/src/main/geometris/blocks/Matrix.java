package geometris.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import loader.Assets;
import geometris.GameScreen;
import geometris.Geometris;
import geometris.blocks.Block;

public abstract class Matrix {
	
	Block[][] matrix;
	GameScreen game;
	Geometris geometris;
	public int matrixHeight;
	public int matrixWidth;

	public enum colour {
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
	

	public Sprite getBlockSprite(colour colour) {
		Texture blockImg;
		switch(colour) {
		case CYAN:
			blockImg = geometris.assetManager.manager.get(Assets.cyanBlockActive);
			break;
		case PURPLE:
			blockImg = geometris.assetManager.manager.get(Assets.purpleBlockActive);
			break;
		case MAGENTA:
			blockImg = geometris.assetManager.manager.get(Assets.magentaBlockActive);
			break;
		case ORANGE:
			blockImg = geometris.assetManager.manager.get(Assets.orangeBlockActive);
			break;
		case YELLOW:
			blockImg = geometris.assetManager.manager.get(Assets.yellowBlockActive);
			break;
		case GREEN:
			blockImg = geometris.assetManager.manager.get(Assets.greenBlockActive);
			break;
		default:
			blockImg = geometris.assetManager.manager. get(Assets.nullBlock);
			break;
		}

        return new Sprite(blockImg);
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
				matrixString[i][j] = matrix[i][j].getColourString();
			}
		}
		
		return matrixString;
	}
	

}
