package mygdx.geometris;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Geometris extends Game {
	SpriteBatch batch;
	Texture boundaryCircle;
	ShapeRenderer innerCircle;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		boundaryCircle = new Texture("circle.png");
		
		innerCircle = new ShapeRenderer();
	}

	@Override
	public void render () {
		float boundaryCircleWidth = 819;
		float boundaryCircleHeight = 819;
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float screenCentre = screenWidth / 2;
		
		double boundaryCircleInnerRadius = (boundaryCircleWidth/2) * 0.88;
		float innerCircleRadius = (float) (boundaryCircleInnerRadius/4);
		
		int boundaryCircleBorderX = (int) ((screenWidth - boundaryCircleWidth) /2);
		int boundaryCircleBorderY = (int) ((screenHeight - boundaryCircleHeight) /2);
		
		
		ScreenUtils.clear(0, 0, 0, 0);
		batch.begin();
		batch.draw(boundaryCircle, boundaryCircleBorderX, boundaryCircleBorderY, boundaryCircleWidth, boundaryCircleHeight);
		batch.end();
		
		innerCircle.setColor(Color.FIREBRICK);
		innerCircle.begin(ShapeType.Filled);
		innerCircle.circle(screenCentre, screenCentre, innerCircleRadius);
		innerCircle.end();
	}
	
	@Override
	public void resize(int width, int height) {
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		boundaryCircle.dispose();
	}
}
