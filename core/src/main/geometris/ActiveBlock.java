package geometris;

import com.badlogic.gdx.Gdx;

public class ActiveBlock extends Block {
	int direction;
	final boolean isActive = true;
	
	public ActiveBlock(int hIndex, int wIndex, geometris.Matrix.colour col, float offset, Geometris geo) {
		this.heightIndex = hIndex;
		this.widthIndex = wIndex;
		this.colour = col;
		this.additionalOffset = offset;
		this.geometris = geo;
		this.assets = geo.assets;
	}
	
	private double getOffsetX() {
        return Math.sin(Math.toRadians((widthIndex + direction) * 6.0));
	}
	
	private double getOffsetY() {
        return Math.cos(Math.toRadians((widthIndex + direction) * 6.0));
	}
	
	public float getPositionX() {
		double centre = (Gdx.graphics.getWidth() / 2.0);
		double centreMargin = 135 - additionalOffset + (heightIndex * 30);
		double positionX;
        positionX = centre +(centreMargin*getOffsetX());
		return (float) positionX;
	}
	
	public float getPositionY() {
		double centre = (Gdx.graphics.getHeight() / 2.0);
		double centreMargin = 135  - additionalOffset;
		double positionY;
        double indexAdjustment = 50 * Math.sin(Math.toRadians(heightIndex)) + 65;
		positionY = centre +(centreMargin*getOffsetY()) - indexAdjustment;
		return (float) positionY;
	}
	
	protected void resizeBlock() {
		double[] size = getBlockSize(1/(heightIndex + 1), widthIndex);
		float newHeight = (float) size[0];
		float newWidth = (float) size[1];
		blockSprite.setOrigin(newWidth, 0);
		blockSprite.setSize(newWidth, newHeight);
		
	}
	
	public void setDirection(int dir) {
		direction = dir;
	}

}
