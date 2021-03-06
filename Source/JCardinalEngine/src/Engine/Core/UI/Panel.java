package Engine.Core.UI;

import Engine.Core.graphics.Screen;

public class Panel {

	public int x, y;
	public int width, height;
	
	
	public uiSprite panelSegments = uiSprite.panel;
	
	public Panel(int w, int h, int x, int y, uiSprite panelSprite){
		this.width = w;
		this.height= h;
		
		this.x = x;
		this.y = y;
		
		panelSegments = panelSprite;
	}
	
	public void render(UserInterface ui){
		ui.renderPanel(x,y,this);
	}
	
	
}
