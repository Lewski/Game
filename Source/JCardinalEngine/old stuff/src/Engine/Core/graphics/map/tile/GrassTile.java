package Engine.Core.graphics.map.tile;

import Engine.Core.graphics.Screen;
import Engine.Core.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);

	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 3, y << 3, this);
	}

}
