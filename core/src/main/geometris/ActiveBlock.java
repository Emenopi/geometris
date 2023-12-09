package geometris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ActiveBlock extends Block {
	final boolean isActive = true;
	
	public ActiveBlock(int hIndex, int wIndex, geometris.Matrix.colour col, Geometris geo) {
		this.heightIndex = hIndex;
		this.widthIndex = wIndex;
		this.colour = col;
		this.geometris = geo;
		this.assets = geo.assets;
	}
	public void resizeBlock() {
		double[] size = getBlockSize(heightIndex);
		float newHeight = (float) (size[0] * 0.8);
		float newWidth = (float) (size[1] * 0.8);
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
	
	private double getOffsetX() {
        return Math.sin(Math.toRadians((widthIndex + direction) * 6.0));
	}
	
	private double getOffsetY() {
        return Math.cos(Math.toRadians((widthIndex + direction) * 6.0));
	}

	public float getPositionX() {
		double centre = (Gdx.graphics.getWidth() / 2.0);
		double centreMargin = 100 - additionalOffset;
		double widthOffset = (getWidth()/2 * Math.cos(Math.toRadians((widthIndex + direction) * 6)));
		double positionX = centre + (centreMargin*getOffsetX()) - widthOffset;
		return (float) positionX;
	}

	public float getPositionY() {
		double centre = (Gdx.graphics.getHeight() / 2.0);
		double centreMargin = 100  - additionalOffset;
		double widthOffset = (getWidth()/2 * Math.sin(Math.toRadians((widthIndex + direction) * 6)));
		double positionY = centre + (centreMargin*getOffsetY()) + widthOffset;
		return (float) positionY;
	}

	public String getBlockString() {
		return this.colour.toString();
	}
}

