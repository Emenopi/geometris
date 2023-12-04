package geometris;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import geometris.Matrix.colour;

public class Block {
	Assets assets;
	Sprite blockSprite;
	double[] blockSize = new double[2];
	
	float rotatedHeight;
	float rotatedWidth;
	int widthIndex;
	int heightIndex;
	float additionalOffset;
	
	colour colour;
	
	
	public Block(int hIndex, int wIndex, colour col, float offset, Geometris geo) {
		assets = geo.assets;
		widthIndex = wIndex;
		heightIndex = hIndex;
		colour = col;
		additionalOffset = offset;
	}
	
	private void resizeBlock() {
		double[] size = getBlockSize(heightIndex, widthIndex);
		float newHeight = (float) size[0];
		float newWidth = (float) size[1];
		blockSprite.setOrigin(newWidth/3, newHeight/2);
		blockSprite.setSize(newWidth, newHeight);
		
	}
	
	protected double[] getBlockSize(int hIndex, int wIndex) {
		double [] size = new double[2];
		
		double minBlockWidth = 12;
		double minBlockHeight = 9;
		
		double widthScaleFactor = (hIndex + 1) / 8.0;
		double heightScaleFactor = (hIndex + 1) / 17.5;
		
		double blockWidth = minBlockHeight + (minBlockWidth * widthScaleFactor);
		double blockHeight = minBlockHeight + (minBlockHeight * heightScaleFactor);
		
		size[0] = blockHeight;
		size[1] = blockWidth;
		
		return size;
		
	}
	
	protected Sprite getBlockSprite(colour colour) {	
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
			blockImg = assets.manager.get(Assets.blackBlock);
			break;
		}
		
		Sprite sprite = new Sprite(blockImg);
		sprite.flip(false, true);
		return sprite;
	}
	
	private double getOffsetX() {
		double offset = Math.sin(Math.toRadians(widthIndex * 6));
		return offset;
	}
	
	private double getOffsetY() {
		double offset = Math.cos(Math.toRadians(widthIndex* 6));
		return offset;
	}
	
	public float getPositionX() {
		double centre = (Gdx.graphics.getWidth() / 2);
		double centreMargin = 115 + additionalOffset;
		double positionX;
		double defaultPositionX = centre - rotatedWidth/5;
		positionX = defaultPositionX+(centreMargin*getOffsetX());
		return (float) positionX;
	}
	
	public float getPositionY() {
		double centre = (Gdx.graphics.getHeight() / 2);
		double centreMargin = 115  + additionalOffset;
		double positionY;
		double defaultPositionY = centre - rotatedHeight/5;
		positionY = defaultPositionY-(centreMargin*getOffsetY());
		return (float) positionY;
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
	
	public double getHeight() {
		double[] size = getBlockSize(heightIndex, widthIndex);
		return size[0];
	}
	
	public String getColour() {
		return colour.toString();
	}
	
}
