package Engine.Core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMove implements MouseMotionListener {

	public int mouseX;
	public int mouseY;

	public boolean isDragging;
	
	public void update(){
		//System.out.println(mouseX);
	}
	
	public void mouseDragged(MouseEvent e) {
		isDragging = true;
		mouseX = (int) ((e.getX() / Cengine.scale) * (Cengine.width / ((double) Cengine.frame.getContentPane().getWidth() / (double) Cengine.scale)));
		mouseY = (int) ((e.getY() / Cengine.scale) * (Cengine.width / ((double) Cengine.frame.getContentPane().getWidth() / (double) Cengine.scale)));
	}

	public void mouseMoved(MouseEvent e) {
		isDragging = false;
		mouseX = (int) ((e.getX() / Cengine.scale) * (Cengine.width / ((double) Cengine.frame.getContentPane().getWidth() / (double) Cengine.scale)));
		mouseY = (int) ((e.getY() / Cengine.scale) * (Cengine.width / ((double) Cengine.frame.getContentPane().getWidth() / (double) Cengine.scale)));
	}
	
}