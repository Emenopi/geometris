package geometris;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import java.util.Objects;

public class Geometris extends Game {
	double clock;
	SpriteBatch batch;
	Assets assets;
	AssetManager assetManager;
	ShapeRenderer innerCircle;
	GameMatrix gameMatrix;
	ActiveBlockMatrix activeBlockMatrix;
	String activeColour;
	Texture boundaryCircle;

	ActiveBlockMatrix abm15;
	ActiveBlockMatrix abm30;
	ActiveBlockMatrix abm45;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		assets = new Assets();
		assetManager = new AssetManager();
		assets.load();
		assets.manager.finishLoading();
		boundaryCircle = assets.manager.get(Assets.boundaryCircle);
		
		innerCircle = new ShapeRenderer();
		
		gameMatrix = new GameMatrix(15, 60, this);
		activeColour = getActiveColour();

		activeBlockMatrix = new ActiveBlockMatrix(activeColour, this);
	}
	
	private String getActiveColour() {
		int randomInt = (int) Math.floor(Math.random() * 6);
		String colour;
		switch(randomInt) {
		case 0:
			colour = "CYAN";
			break;
		case 1:
			colour = "PURPLE";
			break;
		case 2:
			colour = "MAGENTA";
			break;
		case 3:
			colour = "ORANGE";
			break;
		case 4:
			colour = "YELLOW";
			break;
		case 5:
			colour = "GREEN";
			break;
		default:
			colour = "CYAN";
			break;
		}
	return colour;
	}

	@Override
	public void render () {
		clock += Gdx.graphics.getDeltaTime();
		if (clock > 1) {
			activeBlockMatrix.rotate();
			clock = 0;
		}

		float boundaryCircleWidth = 819;
		float boundaryCircleHeight = 819;
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float screenCentre = screenWidth / 2;
		
		double boundaryCircleInnerRadius = (boundaryCircleWidth/2) * 0.88;
		float innerCircleRadius = (float) (boundaryCircleInnerRadius/3.2);
		
		int boundaryCircleBorderX = (int) ((screenWidth - boundaryCircleWidth) /2);
		int boundaryCircleBorderY = (int) ((screenHeight - boundaryCircleHeight) /2);
		
		
		ScreenUtils.clear(0, 0, 0, 0);
		
		innerCircle.setColor(Color.FIREBRICK);
		innerCircle.begin(ShapeType.Filled);
		innerCircle.circle(screenCentre, screenCentre, innerCircleRadius);
		innerCircle.end();
		
		batch.begin();
		batch.draw(boundaryCircle, boundaryCircleBorderX, boundaryCircleBorderY, boundaryCircleWidth, boundaryCircleHeight);
		if (assets.manager.update()) {
			for (int i = 0; i < gameMatrix.matrixHeight; i++) {
				for (int j = 0; j < gameMatrix.matrixWidth; j++) {
					gameMatrix.getBlockSprite(i, j).draw(batch);
				}
			}
		}
		
		//activeBlockMatrix.matrix[0][0].getBlockSprite().draw(batch);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
					activeBlockMatrix.getBlockSprite(i, j).draw(batch);
			}
		}

		batch.end();		
		
	}
	
	public AssetManager getAssetManager() { 
		return assetManager;
	}
	
	@Override
	public void resize(int width, int height) {
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		boundaryCircle.dispose();
		assetManager.dispose();
	}
}
