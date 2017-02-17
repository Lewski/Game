package Engine.Core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener{
	
	private boolean[] buttons = new boolean[10];
	public boolean leftMouse, rightMouse;
	
	public void update(){
		
		leftMouse = buttons[MouseEvent.BUTTON1];
		rightMouse = buttons[MouseEvent.BUTTON2];
		
	}
	
	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		buttons[e.getButton()] = true;
	}

	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;
	}
	

}
