package Engine.Core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMove implements MouseMotionListener {

	public int mouseX;
	public int mouseY;
	
	public void update(){
		//System.out.println(mouseX);
	}
	
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX() >> 1;
		mouseY = e.getY() >> 1;
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX() >> 1;
		mouseY = e.getY() >> 1;
	}
	
}