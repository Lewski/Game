package Game.Map;

import java.util.Random;

import Engine.Core.Noise.SimplexNoise;
import Engine.Core.graphics.map.Map;
import Engine.Core.graphics.map.tile.Tile;

public class NaturalMap extends Map{

	private static Random random = new Random();
	
	public NaturalMap(int width, int height) {
		super(width, height);
	}

	protected void generateMap(){
		
		SimplexNoise noise = new SimplexNoise(2);
		
		for(int y = 0; y < height; y ++){
			for(int x = 0; x < width; x ++){
				
				float id = noise.OctaveNoise2D(4, 1, 0.005f, x, y);
				
				int tileIndex = 0;
				
				if(id > 0.0f){
					tileIndex = random.nextInt(4);
				}else{
					tileIndex = random.nextInt(4) + 4;
				}
					
				
				if(tileIndex == 0) tiles[x + y * width] = Tile.grass1;
				if(tileIndex == 1) tiles[x + y * width] = Tile.grass2;
				if(tileIndex == 2) tiles[x + y * width] = Tile.grass3;
				if(tileIndex == 3) tiles[x + y * width] = Tile.grass4;
				
				if(tileIndex == 4) tiles[x + y * width] = Tile.stone1;
				if(tileIndex == 5) tiles[x + y * width] = Tile.stone2;
				if(tileIndex == 6) tiles[x + y * width] = Tile.stone3;
				if(tileIndex == 7) tiles[x + y * width] = Tile.stone4;
					
				//System.out.println(noise.RawNoise2D(x, y));
				
			}
		}
	}
	
}
