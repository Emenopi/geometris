package geometris.blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import geometris.Assets;
import geometris.Geometris;
import geometris.blocks.Matrix.colour;

abstract class Block {
	boolean isActive;
	Assets assets;
	Sprite blockSprite;
	Geometris geometris;
	double[] blockSize = new double[2];
	
	float rotatedHeight;
	float rotatedWidth;
	int widthIndex;
	int heightIndex;
	float additionalOffset;
	int direction;
	
	colour colour;
	
	public void resizeBlock() {
		double[] size = getBlockSize(heightIndex);
		float newHeight = (float) size[0];
		float newWidth = (float) size[1];
		blockSprite.setOrigin(0, 0);
		blockSprite.setSize(newWidth, newHeight);
	}
	
	protected double[] getBlockSize(int hIndex) {
		double [] size = new double[2];
		
		double minBlockWidth = 12;
		double minBlockHeight = 9;
		
		double widthScaleFactor = (hIndex + 1) / 8.0;
		double heightScaleFactor = (hIndex + 1) / 20.1;
		
		double blockWidth = minBlockHeight + (minBlockWidth * widthScaleFactor);
		double blockHeight = minBlockHeight + (minBlockHeight * heightScaleFactor);
		
		size[0] = blockHeight;
		size[1] = blockWidth;
		
		return size;
		
	}
	
	public Sprite getBlockSprite(colour colour) {	
		Texture blockImg;
		switch(colour) {
		case CYAN:
			blockImg = assets.manager.get(Assets.cyanBlock);
			break;
		case PURPLE:
			blockImg = assets.manager.get(Assets.purpleBlock);
			break;
		case MAGENTA:
			blockImg = assets.manager.get(Assets.magentaBlock);
			break;
		case ORANGE:
			blockImg = assets.manager.get(Assets.orangeBlock);
			break;
		case YELLOW:
			blockImg = assets.manager.get(Assets.yellowBlock);
			break;
		case GREEN:
			blockImg = assets.manager.get(Assets.greenBlock);
			break;
		case BLACK:
			blockImg = assets.manager.get(Assets.blackBlock);
			break;
		default:
			blockImg = assets.manager.get(Assets.nullBlock);
			break;
		}

        return new Sprite(blockImg);
	}
	
	private double getOffsetX() {
        return Math.sin(Math.toRadians(widthIndex * 6.0));
	}
	
	private double getOffsetY() {
        return Math.cos(Math.toRadians(widthIndex * 6.0));
	}
	
	public double getHeight() {
		double[] size = getBlockSize(heightIndex);
		return size[0];
	}

	public double getWidth() {
		double[] size = getBlockSize(heightIndex);
		return size[1];
	}

	public float getPositionX() {
		double centre = (Gdx.graphics.getWidth() / 2.0);
		double centreMargin = 115 + additionalOffset;
		double widthOffset = (getWidth()/2 * Math.cos(Math.toRadians(widthIndex * 6)));
		double positionX = centre + (centreMargin*getOffsetX()) - widthOffset;
		return (float) positionX;
	}

	public float getPositionY() {
		double centre = (Gdx.graphics.getHeight() / 2.0);
		double centreMargin = 115  + additionalOffset;
		double widthOffset = (getWidth()/2 * Math.sin(Math.toRadians(widthIndex * 6)));
		double positionY = centre + (centreMargin*getOffsetY()) + widthOffset;
		return (float) positionY;
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
		return colour.toString();
	}
	
	public String getColourString() {
		return colour.toString();
	}
	
	public colour getColour() {
		return colour;
	}

	public void rotate() {
		direction += 1;
	}

	protected void setOffset(float os) {
		additionalOffset = os;
	}

}
