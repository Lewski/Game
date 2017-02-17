package Engine.Core.graphics.map.tile;

import Engine.Core.graphics.Screen;
import Engine.Core.graphics.Sprite;
import Engine.Core.graphics.TileType;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);
		
		type = TileType.GRASS;

	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 3, y << 3, this);
	}

}
