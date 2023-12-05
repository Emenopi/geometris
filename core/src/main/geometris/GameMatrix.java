package geometris;

public class GameMatrix extends Matrix {

	// Constructor	
	public GameMatrix(int h, int w, Geometris geo) {
		this.geometris = geo;
		matrixHeight = h;
		matrixWidth = w;
		
		matrix = new Block[matrixHeight][matrixWidth];
		float addBlockOffset = 0;
		for (int i = 0; i < matrixHeight; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				matrix[i][j] = new Block(i, j, colour.CYAN, addBlockOffset, geometris);
			}
			addBlockOffset += matrix[i][0].getHeight() + 4;
		}
	}


	public void main(String[] args) {
	}
}
