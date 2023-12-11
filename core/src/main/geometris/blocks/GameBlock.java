package geometris.blocks;

import geometris.Geometris;
import geometris.blocks.Block;
import geometris.blocks.Matrix.colour;

public class GameBlock extends Block {
	final boolean isActive = false;
	
	public GameBlock(int hIndex, int wIndex, colour col, Geometris geo) {
		assets = geo.assets;
		widthIndex = wIndex;
		heightIndex = hIndex;
		colour = col;
		this.radius = 115;
		this.direction = 0;
	}
}
