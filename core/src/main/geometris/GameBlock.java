package geometris;

import geometris.Matrix.colour;

public class GameBlock extends Block{
	
	public GameBlock(int hIndex, int wIndex, colour col, float offset, Geometris geo) {
		assets = geo.assets;
		widthIndex = wIndex;
		heightIndex = hIndex;
		colour = col;
		additionalOffset = offset;
	}
	
}
