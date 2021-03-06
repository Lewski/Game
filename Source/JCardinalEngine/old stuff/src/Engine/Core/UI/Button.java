package Engine.Core.UI;

import Engine.Core.MouseInput;
import Engine.Core.MouseMove;
import Engine.Core.audio.SoundEffect;
import Engine.Core.graphics.Sprite;

public class Button {

	int x, y;
	public int width, height;
	
	private uiSprite n = uiSprite.buttonNormal;
	private uiSprite h = uiSprite.buttonHighlight;
	private uiSprite p = uiSprite.buttonPressed;
	
	public uiSprite buttonSegments = n;
	
	public boolean highlighted;
	public boolean pressed;
	
	private MouseMove mouseMove;
	private MouseInput mouseInput;
	
	public Sprite image;
	public uiSprite icon;
	
	public Button(int x, int y, int w, int h, MouseInput mi, MouseMove mm){
	
		this.width = w;
		this.height= h;
		
		this.x = x;
		this.y = y;
		
		mouseMove = mm;
		mouseInput = mi;
		
	}
	
	public void update(){
		
		highlighted = false;
		pressed = false;
		
		if(mouseMove.mouseX >= x && mouseMove.mouseX < x + width){
			if(mouseMove.mouseY >= y && mouseMove.mouseY < y + height){
				highlighted = true;
			}
		}

		buttonSegments = n;
		
		if(highlighted){
			
			buttonSegments = h;
			
			if(mouseInput.leftMouse){
				buttonSegments = p;
				
				pressed = true;
			}
			
		}
		
	}
	
	public void render(UserInterface ui){
		
		ui.renderButton(x,y,this);
	}
	
}
