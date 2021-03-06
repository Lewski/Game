package Engine.Core.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	public final int SIZE;
	private int x,y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite voidSprite = new Sprite(8, 0xff000000);
	
	public static Sprite selectedTile = new Sprite("/Sprite Sheets/selectedTile.png");
	public static Sprite cursor = new Sprite("/Sprite Sheets/cursor.png");
	
	public static Sprite house1 = new Sprite(32, 1, 0, SpriteSheet.buildings);
	public static Sprite building1 = new Sprite(32, 0, 0, SpriteSheet.buildings);
	
	public static Sprite tree1 = new Sprite(32, 0, 0, SpriteSheet.trees);
	public static Sprite tree2 = new Sprite(32, 1, 0, SpriteSheet.trees);
	public static Sprite tree3 = new Sprite(32, 2, 0,SpriteSheet.trees);
	
	public static Sprite playerFront = new Sprite(8, 0, 0, SpriteSheet.player);
	public static Sprite playerBack = new Sprite(8, 0, 1, SpriteSheet.player);
	public static Sprite playerRight = new Sprite(8, 0, 2, SpriteSheet.player);
	public static Sprite playerLeft = new Sprite(8, 0, 3, SpriteSheet.player);
	
	public static Sprite grass1 = new Sprite(8, 0, 1, SpriteSheet.environmentTiles);
	public static Sprite grass2 = new Sprite(8, 0, 0, SpriteSheet.environmentTiles);
	public static Sprite grass3 = new Sprite(8, 0, 2, SpriteSheet.environmentTiles);
	public static Sprite grass4 = new Sprite(8, 0, 3, SpriteSheet.environmentTiles);
	
	public static Sprite stone1 = new Sprite(8, 1, 0, SpriteSheet.environmentTiles);
	public static Sprite stone2 = new Sprite(8, 1, 1, SpriteSheet.environmentTiles);
	public static Sprite stone3 = new Sprite(8, 1, 2, SpriteSheet.environmentTiles);
	public static Sprite stone4 = new Sprite(8, 1, 3, SpriteSheet.environmentTiles);
	public static Sprite stoneEdge = new Sprite(8, 2, 0, SpriteSheet.environmentTiles);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		
		load();
	}
	
	public Sprite(int size, int color){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	public Sprite(String filePath){
		
		int size = 0;
		
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(filePath));
			
			int w = image.getWidth();
			int h = image.getHeight();
			
			size = w;
			
			pixels = new int[size * size];
			
			image.getRGB(0, 0, w, h, pixels, 0, w);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			size = 0;
		}
		
		SIZE = size;
		
		
	}
	
	private void setColor(int color){
		for(int i = 0; i < SIZE * SIZE; i++){
			pixels[i] = color;
		}
	}
	
	private void load(){
		for(int y = 0; y < SIZE; y ++){
			for(int x = 0; x < SIZE; x++){
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
