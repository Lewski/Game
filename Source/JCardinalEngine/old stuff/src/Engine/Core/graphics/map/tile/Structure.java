package Engine.Core.graphics.map.tile;

import Engine.Core.graphics.Screen;
import Engine.Core.graphics.Sprite;

public class Structure extends Tile {
	
	int price = 20;
	
	public Structure(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderStructure(x << 3, y << 3, this);
	}

	
}
