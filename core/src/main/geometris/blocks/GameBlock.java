package main.geometris.blocks;
<<<<<<< HEAD

import main.geometris.GameScreen;
import main.geometris.Geometris;
import main.geometris.blocks.Block;
import main.geometris.blocks.Matrix.colour;
=======

import main.geometris.GameScreen;
import main.geometris.Geometris;
import main.geometris.blocks.Block;
import main.geometris.blocks.Matrix;
import main.geometris.blocks.Matrix.colour;
import main.geometris.GameScreen;

>>>>>>> main

public class GameBlock extends Block {
	final boolean isActive = false;
	private final colour colour;
	GameScreen game;
	
	public GameBlock(int hIndex, int wIndex, colour col, GameScreen game) {
		this.game = game;
		this.geometris = game.geometris;
		int widthIndex = wIndex;
		heightIndex = hIndex;
		colour = col;
		super.colour = col;
		this.radius = 115;
		this.direction = 0;
		geometris.assets.load();
		geometris.assets.manager.finishLoading();
	}

	public colour getColour() {
		return this.colour;
	}
}
