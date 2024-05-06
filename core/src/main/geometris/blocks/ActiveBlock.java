package main.geometris.blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import main.geometris.GameScreen;
import main.geometris.blocks.Matrix.colour;
import main.geometris.Geometris;

public class ActiveBlock extends Block {
	int gameMatrixHeightIndex;
	double sizeScale;

	public ActiveBlock(int hIndex, int wIndex, colour col, GameScreen game) {
		this.geometris = game.geometris;
		this.heightIndex = hIndex;
		this.widthIndex = wIndex;
		this.colour = col;
		this.game = game;
		this.radius = 100;
		gameMatrixHeightIndex = 0;
		sizeScale = 0.8;
		geometris.assets.load();
		geometris.assets.manager.finishLoading();
	}

	public void setRadius(int rad) {
		radius = rad;
	}

	public void setSizeScale(double scale) {
		sizeScale = scale;
	}

	public void setHeightIndex(int index) {
		this.heightIndex = index;
	}

	public void setGameMatrixHeight(int matrixBlockIndex) {
		gameMatrixHeightIndex = matrixBlockIndex;
	}

	public void resizeBlock() {
		double[] size = getBlockSize(heightIndex);
		float newHeight = (float) (size[0] * sizeScale);
		float newWidth = (float) (size[1] * sizeScale);
		blockSprite.setOrigin(0, 0);
		blockSprite.setSize(newWidth, newHeight);
	}
	public Sprite getBlockSprite() {
		blockSprite = getBlockSprite(colour);
		resizeBlock();
		float rotation = (widthIndex + direction) * -6;
		blockSprite.setRotation(rotation);
		rotatedHeight = blockSprite.getRegionHeight();
		rotatedWidth = blockSprite.getRegionWidth();
		blockSprite.setPosition(getPositionX(), getPositionY());
		return blockSprite;
	}

	public String getBlockString() {
		return this.colour.toString();
	}
}