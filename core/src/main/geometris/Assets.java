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
	public static final AssetDescriptor<Texture> cyanBlockActive =
			new AssetDescriptor<Texture>("cyan_full.png", Texture.class);
	public static final AssetDescriptor<Texture> purpleBlock =
			new AssetDescriptor<Texture>("purple.png", Texture.class);
	public static final AssetDescriptor<Texture> purpleBlockActive =
			new AssetDescriptor<Texture>("purple_full.png", Texture.class);
	public static final AssetDescriptor<Texture> magentaBlock =
			new AssetDescriptor<Texture>("magenta.png", Texture.class);
	public static final AssetDescriptor<Texture> magentaBlockActive =
			new AssetDescriptor<Texture>("magenta_full.png", Texture.class);
	public static final AssetDescriptor<Texture> orangeBlock =
			new AssetDescriptor<Texture>("orange.png", Texture.class);
	public static final AssetDescriptor<Texture> orangeBlockActive =
			new AssetDescriptor<Texture>("orange_full.png", Texture.class);
	public static final AssetDescriptor<Texture> yellowBlock =
			new AssetDescriptor<Texture>("yellow.png", Texture.class);
	public static final AssetDescriptor<Texture> yellowBlockActive =
			new AssetDescriptor<Texture>("yellow_full.png", Texture.class);
	public static final AssetDescriptor<Texture> greenBlock =
			new AssetDescriptor<Texture>("green.png", Texture.class);
	public static final AssetDescriptor<Texture> greenBlockActive =
			new AssetDescriptor<Texture>("green_full.png", Texture.class);
	public static final AssetDescriptor<Texture> nullBlock =
			new AssetDescriptor<Texture>("null.png", Texture.class);
	
	public void load() {
		manager.load(boundaryCircle);
		manager.load(cyanBlock);
		manager.load(cyanBlockActive);
		manager.load(purpleBlock);
		manager.load(purpleBlockActive);
		manager.load(magentaBlock);
		manager.load(magentaBlockActive);
		manager.load(orangeBlock);
		manager.load(orangeBlockActive);
		manager.load(yellowBlock);
		manager.load(yellowBlockActive);
		manager.load(greenBlock);
		manager.load(greenBlockActive);
		manager.load(nullBlock);
	}
	
	public void dispose() {
		manager.dispose();
	}
}
