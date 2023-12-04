package geometris;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
	public AssetManager manager = new AssetManager();
	
	public static final AssetDescriptor<Texture> boundaryCircle =
			new AssetDescriptor<Texture>("circle.png", Texture.class);
	
	public static final AssetDescriptor<Texture> cyanBlock =
			new AssetDescriptor<Texture>("cyan.png", Texture.class);
	public static final AssetDescriptor<Texture> purpleBlock =
			new AssetDescriptor<Texture>("purple.png", Texture.class);
	public static final AssetDescriptor<Texture> magentaBlock =
			new AssetDescriptor<Texture>("magenta.png", Texture.class);
	public static final AssetDescriptor<Texture> orangeBlock =
			new AssetDescriptor<Texture>("orange.png", Texture.class);
	public static final AssetDescriptor<Texture> yellowBlock =
			new AssetDescriptor<Texture>("yellow.png", Texture.class);
	public static final AssetDescriptor<Texture> greenBlock =
			new AssetDescriptor<Texture>("green.png", Texture.class);
	public static final AssetDescriptor<Texture> blackBlock =
			new AssetDescriptor<Texture>("black.png", Texture.class);
	
	public void load() {
		manager.load(boundaryCircle);
		manager.load(cyanBlock);
		manager.load(purpleBlock);
		manager.load(magentaBlock);
		manager.load(orangeBlock);
		manager.load(yellowBlock);
		manager.load(greenBlock);
	}
	
	public void dispose() {
		manager.dispose();
	}
}
