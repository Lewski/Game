package Engine.Core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

	private boolean[] keys = new boolean[120];
	private boolean[] holdKeys = new boolean[120];
	private boolean[] pastKeys = new boolean[120];
	
	public boolean up, down, left, right;
	public boolean addWorker, subWorker;
	
	public boolean toggleStructuresPanel;
	
	public void update(){

		holdKeys[KeyEvent.VK_UP] = true;
		holdKeys[KeyEvent.VK_W] = true;
		holdKeys[KeyEvent.VK_DOWN] = true;
		holdKeys[KeyEvent.VK_S] = true;
		holdKeys[KeyEvent.VK_LEFT] = true;
		holdKeys[KeyEvent.VK_A] = true;
		holdKeys[KeyEvent.VK_RIGHT] = true;
		holdKeys[KeyEvent.VK_D] = true;
		
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		
		addWorker = keys[KeyEvent.VK_PAGE_UP];
		subWorker = keys[KeyEvent.VK_PAGE_DOWN];
		
		toggleStructuresPanel = keys[KeyEvent.VK_B];
		
		for(int i = 0; i < keys.length; i ++){
			if(pastKeys[i] == true && holdKeys[i] != true)
				keys[i] = false;
			
			pastKeys[i] = true;
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
