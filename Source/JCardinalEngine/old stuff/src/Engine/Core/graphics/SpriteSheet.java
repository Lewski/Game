package Engine.Core.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	public final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet environmentTiles = new SpriteSheet("/Sprite Sheets/EnvironmentSpriteSheet.png", 32);
	public static SpriteSheet trees = new SpriteSheet("/Sprite Sheets/TreeSpriteSheet.png", 256);
	public static SpriteSheet player = new SpriteSheet("/Sprite Sheets/PlayerSpriteSheet.png", 32);
	public static SpriteSheet buildings = new SpriteSheet("/Sprite Sheets/Buildings.png", 256);
	
	public SpriteSheet(String path, int size){
		
		this.path = path;
		this.SIZE = size;
		
		pixels = new int[size * size];
	
		load();
		
	}
	
	private void load(){
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			
			int w = image.getWidth();
			int h = image.getHeight();
			
			image.getRGB(0, 0, w, h, pixels, 0, w);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
