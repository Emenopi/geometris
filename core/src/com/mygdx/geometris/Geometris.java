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
	Matrix gameMatrix;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		boundaryCircle = new Texture("circle.png");
		
		innerCircle = new ShapeRenderer();
		
		gameMatrix = new Matrix(15, 60);
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
		for (int i = 0; i < gameMatrix.matrixHeight; i++) {
			for (int j = 0; j < gameMatrix.matrixWidth; j++) {
				gameMatrix.getBlockSprite(i, j).draw(batch);
			}
		}
		//gameMatrix.matrix[0][0].draw(batch);
		//blockSprite = new Sprite(gameMatrix.matrix[0][0].getBlockImg());
		//blockSprite.draw(batch);
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
