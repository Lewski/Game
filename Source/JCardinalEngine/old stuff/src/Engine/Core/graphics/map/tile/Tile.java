package Engine.Core.graphics.map.tile;

import Engine.Core.graphics.Screen;
import Engine.Core.graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;
	
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile grass1 = new GrassTile(Sprite.grass1);
	public static Tile grass2 = new GrassTile(Sprite.grass2);
	public static Tile grass3 = new GrassTile(Sprite.grass3);
	public static Tile grass4 = new GrassTile(Sprite.grass4);
	
	public static Tile stone1 = new Tile(Sprite.stone1);
	public static Tile stone2 = new Tile(Sprite.stone2);
	public static Tile stone3 = new Tile(Sprite.stone3);
	public static Tile stone4 = new Tile(Sprite.stone4);
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 3, y << 3, this);
	}
	
	public boolean collide(){
		return false;
	}
	
}
