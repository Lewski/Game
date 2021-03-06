package Engine.Core.UI;

import Engine.Core.graphics.Screen;

public class Label {

	public String text = "Label";
	public int color = 0xffffffff;
	public uiSprite[] sprites;
	public int xPos, yPos;
	
	public Label(String text, int x, int y){
		this.text = text;
		this.xPos = x;
		this.yPos = y;
	}
	
	public void render(Screen screen){
		screen.renderText(xPos, yPos, text, color);
	}
	
	public void render(UserInterface ui){
		ui.renderLabel(xPos, yPos, text, color);
	}
	
}
