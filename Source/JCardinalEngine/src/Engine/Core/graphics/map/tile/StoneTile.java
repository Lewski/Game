package Engine.Core.graphics.map.tile;

import Engine.Core.graphics.Sprite;
import Engine.Core.graphics.TileType;

public class StoneTile extends Tile {
	
	public StoneTile(Sprite sprite) {
		super(sprite);
		
		type = TileType.STONE;
		
	}

}
