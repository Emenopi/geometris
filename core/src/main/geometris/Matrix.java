package geometris;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

abstract class Matrix {
	
	Block[][] matrix;
	Geometris geometris;
	Assets assets;
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
	

	public Sprite getBlockSprite(colour colour) {
		Texture blockImg;
		switch(colour) {
		case CYAN:
			blockImg = assets.manager.get(Assets.cyanBlockActive);
			break;
		case PURPLE:
			blockImg = assets.manager.get(Assets.purpleBlockActive);
			break;
		case MAGENTA:
			blockImg = assets.manager.get(Assets.magentaBlockActive);
			break;
		case ORANGE:
			blockImg = assets.manager.get(Assets.orangeBlockActive);
			break;
		case YELLOW:
			blockImg = assets.manager.get(Assets.yellowBlockActive);
			break;
		case GREEN:
			blockImg = assets.manager.get(Assets.greenBlockActive);
			break;
		default:
			blockImg = assets.manager.get(Assets.nullBlock);
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
