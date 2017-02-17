package Engine.Core.graphics.map.tile;

import Engine.Core.graphics.Screen;
import Engine.Core.graphics.Sprite;

public class Structure {
	
	int price = 20;
	
	public Sprite sprite;
	
	public int xPos, yPos;
	
	public Structure(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(Screen screen){
		screen.renderStructure(xPos, yPos, this);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderStructure(x, y, this);
	}

	
}
