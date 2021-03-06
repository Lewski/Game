package Engine.Core.graphics.entity.character;

import java.util.Random;

import Engine.Core.graphics.Screen;
import Engine.Core.graphics.Sprite;

public class Worker extends Character {

	int destinationX = 100;
	int destinationY = 100;
	
	private static Random random = new Random();
	
	public Worker(){
		
	}
	
	public void update(){
		int xa = 0;
		int ya = 0;
		
		int xDiff = destinationX - this.x;
		int yDiff = destinationY - this.y;
		
		if(xDiff == 0 && yDiff == 0)
			setNewDestination(random.nextInt(512),random.nextInt(512));
		
		if(xDiff > 0) xa ++;
		if(xDiff < 0) xa --;
		if(yDiff > 0) ya ++;
		if(yDiff < 0) ya --;
		
		if(xa !=0 || ya != 0) move (xa, ya);
		
	}
	
	private void setNewDestination(int x, int y){
		
		destinationX = x;
		destinationY = y;
		
	}
	
	public void render(Screen screen){
		if(dir == 0) screen.renderPlayer(x, y, Sprite.playerBack);
		if(dir == 1) screen.renderPlayer(x, y, Sprite.playerRight);
		if(dir == 2) screen.renderPlayer(x, y, Sprite.playerFront);
		if(dir == 3) screen.renderPlayer(x, y, Sprite.playerLeft);

	}
	
	
}
