package Engine.Core.UI;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class uiSpriteSheet {

	private String path;
	public final int SIZE;
	public int[] pixels;
	
	public static uiSpriteSheet gui = new uiSpriteSheet("/Sprite Sheets/UISpriteSheet.png", 32);
	public static uiSpriteSheet font = new uiSpriteSheet("/Sprite Sheets/LettersSpriteSheet.png", 64);
	public static uiSpriteSheet icons = new uiSpriteSheet("/Sprite Sheets/icons.png", 32);
	
	public uiSpriteSheet(String path, int size) {
		
		this.path = path;
		this.SIZE = size;
		
		pixels = new int[size * size];
	
		load();
		
	}
	
	private void load(){
		try {
			BufferedImage image = ImageIO.read(uiSpriteSheet.class.getResource(path));
			
			int w = image.getWidth();
			int h = image.getHeight();
			
			image.getRGB(0, 0, w, h, pixels, 0, w);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
