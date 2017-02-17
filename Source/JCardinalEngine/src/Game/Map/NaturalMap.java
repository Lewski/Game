package Game.Map;

import Engine.Core.Noise.SimplexNoise;
import Engine.Core.graphics.map.Map;

public class NaturalMap extends Map{

	
	
	public NaturalMap(int width, int height) {
		super(width, height);
	}

	protected void generateMap(){
		
		SimplexNoise noise = new SimplexNoise();
		
		for(int y = 0; y < height; y ++){
			for(int x = 0; x < width; x ++){
				
				System.out.println(noise.RawNoise2D(x, y));
				
			}
		}
	}
	
}
