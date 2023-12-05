package geometris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ActiveBlock extends Block {
	
	public ActiveBlock(int hIndex, int wIndex, geometris.Matrix.colour col, float offset, Geometris geo) {
		super(hIndex, wIndex, col, offset, geo);
	}
	
	private double getOffsetX() {
		double offset = Math.sin(Math.toRadians(widthIndex * 6.0));
		return offset;
	}
	
	private double getOffsetY() {
		double offset = Math.cos(Math.toRadians(widthIndex* 6.0));
		return offset;
	}
	
	public float getPositionX() {
		double centre = (Gdx.graphics.getWidth() / 2.0);
		double centreMargin = 115 + additionalOffset;
		double positionX;
		double defaultPositionX = centre;
		positionX = defaultPositionX-(centreMargin*getOffsetX());
		return (float) positionX;
	}
	
	public float getPositionY() {
		double centre = (Gdx.graphics.getHeight() / 2.0);
		double centreMargin = 115  + additionalOffset;
		double positionY;
		double defaultPositionY = centre;
		double indexAdjustment = 50 * Math.sin(Math.toRadians(heightIndex)) + 65;
		positionY = defaultPositionY+(centreMargin*getOffsetY()) - indexAdjustment;
		return (float) positionY;
	}
	
	private void resizeBlock() {
		double[] size = getBlockSize(1/(heightIndex + 1), widthIndex);
		float newHeight = (float) size[0];
		float newWidth = (float) size[1];
		blockSprite.setOrigin(newWidth, 0);
		blockSprite.setSize(newWidth, newHeight);
		
	}
	
	public Sprite getBlockSprite() {
		blockSprite = getBlockSprite(colour);
		resizeBlock();
		float rotation = widthIndex * 6;
		blockSprite.setRotation(rotation);		
		rotatedHeight = blockSprite.getRegionHeight();
		rotatedWidth = blockSprite.getRegionWidth();
		blockSprite.setPosition(getPositionX(), getPositionY());
		return blockSprite;
	}
	
	public String getBlockString() {
		return colour.toString();
	}

}
