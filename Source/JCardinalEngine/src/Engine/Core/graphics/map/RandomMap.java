package Engine.Core.graphics.map;

import java.util.Random;

import Engine.Core.graphics.map.tile.Tile;

public class RandomMap extends Map {

	private static final Random random = new Random();
	
	public RandomMap(int width, int height) {
		super(width, height);
	}

	protected void generateMap(){
		for(int y = 0; y < height; y ++){
			for(int x = 0; x < width; x ++){
				
				int randomTileIndex = random.nextInt(8);
				
				if(randomTileIndex == 0) tiles[x + y * width] = Tile.grass1;
				if(randomTileIndex == 1) tiles[x + y * width] = Tile.grass2;
				if(randomTileIndex == 2) tiles[x + y * width] = Tile.grass3;
				if(randomTileIndex == 3) tiles[x + y * width] = Tile.grass4;
				
				if(randomTileIndex == 4) tiles[x + y * width] = Tile.stone1;
				if(randomTileIndex == 5) tiles[x + y * width] = Tile.stone2;
				if(randomTileIndex == 6) tiles[x + y * width] = Tile.stone3;
				if(randomTileIndex == 7) tiles[x + y * width] = Tile.stone4;
			}
		}
	}
}
