package main.geometris.blocks;

import main.geometris.game.GameScreen;
import main.geometris.blocks.Matrix.colour;

public class GameBlock extends Block {
	final boolean isActive = false;
	GameScreen game;

	public GameBlock(int hIndex, int wIndex, colour col, GameScreen game) {
		this.game = game;
		this.geometris = game.geometris;
		widthIndex = wIndex;
		heightIndex = hIndex;
		colour = col;
		this.radius = 115;
		this.direction = 0;
		geometris.assets.load();
		geometris.assets.manager.finishLoading();
	}
}