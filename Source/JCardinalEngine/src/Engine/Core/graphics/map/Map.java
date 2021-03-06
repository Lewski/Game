package Engine.Core.graphics.map;

import Engine.Core.graphics.Screen;
import Engine.Core.graphics.map.tile.Tile;

public class Map {

	public int width;
	public int height;
	
	protected Tile[] tiles;
	
	public Map(int width, int height){
		this.width = width;
		this.height = height;
		
		tiles = new Tile[width * height];
		
		generateMap();
	}
	
	public Map(String path){
		loadMap(path);
	}
	
	protected void generateMap(){
		
	}
	
	private void loadMap(String path){
		
	}
	
	public void update(){
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen){
		
		screen.xPos = xScroll;
		screen.yPos = yScroll;
		
		int x0 = xScroll >> 3;
		int x1 = (xScroll + screen.width + 8) >> 3;
		int y0 = yScroll >> 3;
		int y1 = (yScroll + screen.height + 8) >> 3;
		
		for(int y = y0; y < y1; y ++){
			for(int x = x0; x < x1; x ++){
			
				if(x < 0 || y < 0 || x >= width || y >= height){
					Tile.voidTile.render(x, y, screen);
				}else if(tiles[x + y * width] == null){
					Tile.voidTile.render(x, y, screen);
				}else{
					tiles[x + y * width].render(x, y, screen);
				}
				
				
			}
		}
	}
	
	public Tile getTile(int x, int y){
		
		Tile v = Tile.voidTile;
		
		if(x < 0 || y < 0 || x >= width || y >= height){
			
			return v;
		}
		
		/*
		if(tiles[x + y * width] == 0) return Tile.grass1;
		if(tiles[x + y * width] == 1) return Tile.grass2;
		if(tiles[x + y * width] == 2) return Tile.grass3;
		if(tiles[x + y * width] == 3) return Tile.grass4;
		*/
		return Tile.voidTile;
	}
	
	
}
