package Engine.Core.graphics.entity;

import java.util.Random;
import java.util.logging.Level;

import Engine.Core.graphics.Screen;

public class Entity {

	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update(){
		
	}
	
	public void render(Screen screen){
		
	}
	
	public void remove(){
		removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
	}
	
}
