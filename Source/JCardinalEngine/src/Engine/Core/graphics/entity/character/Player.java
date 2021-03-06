package Engine.Core.graphics.entity.character;

import Engine.Core.KeyboardInput;
import Engine.Core.graphics.Screen;
import Engine.Core.graphics.Sprite;

public class Player extends Character{

	private KeyboardInput input;
	
	public Player(KeyboardInput input){
		this.input = input;
	}
	
	public Player(int x, int y, KeyboardInput input){
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update(){
		
		int xa = 0, ya = 0;
		
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
		
		if(xa !=0 || ya != 0) move (xa, ya);
		
	}
	
	public void render(Screen screen){
		if(dir == 0) screen.renderPlayer(x, y, Sprite.playerBack);
		if(dir == 1) screen.renderPlayer(x, y, Sprite.playerRight);
		if(dir == 2) screen.renderPlayer(x, y, Sprite.playerFront);
		if(dir == 3) screen.renderPlayer(x, y, Sprite.playerLeft);

	}
}
