package Engine.Core.UI;

import Engine.Core.graphics.Screen;

public class UserInterface {

	public int width;
	public int height;
	
	Screen screen;
	
	public UserInterface(Screen screen){
		this.width = screen.width;
		this.height = screen.height;
		this.screen = screen;
	}
	
	public void renderPanel(int xp, int yp, Panel panel){
		
		//top left corner
		for(int y = 0; y < 3; y++){
			int yActual = y + yp;
			for(int x = 0; x < 3; x++){
				int xActual = x + xp;
				drawPixel(xActual,yActual, panel.panelSegments.pixels[x + y * 8]);
			}
		}
		
		//top right corner
		for(int y = 0; y < 3; y++){
			int yActual = y + yp;
			for(int x = 0; x < 3; x++){
				int xActual = x + xp + panel.width - 3;
				drawPixel(xActual,yActual, panel.panelSegments.pixels[(x+5) + y * 8]);
			}
		}
		
		//bottom left corner
		for(int y = 0; y < 3; y++){
			int yActual = y + yp + panel.height - 3;
			for(int x = 0; x < 3; x++){
				int xActual = x + xp;
				drawPixel(xActual,yActual, panel.panelSegments.pixels[x + (y+5) * 8]);
			}
		}
		
		//bottom right corner
		for(int y = 0; y < 3; y++){
			int yActual = y + yp + panel.height - 3;
			for(int x = 0; x < 3; x++){
				int xActual = x + xp + panel.width - 3;
				drawPixel(xActual,yActual, panel.panelSegments.pixels[(x+5) + (y+5) * 8]);
			}
		}
		
		//edges
		//top
		for(int x = 3; x < panel.width - 3; x++){
			int xActual = xp + x;
			
				drawPixel(xActual, yp, panel.panelSegments.pixels[3 + 0 * 8]);
				drawPixel(xActual, yp+1, panel.panelSegments.pixels[3 + 1 * 8]);
				drawPixel(xActual, yp+2, panel.panelSegments.pixels[3 + 2 * 8]);
				
		}
		
		//bottom
		for(int x = 3; x < panel.width - 3; x++){
			int xActual = xp + x;
			
				drawPixel(xActual, yp - 3 + panel.height, panel.panelSegments.pixels[3 + 5 * 8]);
				drawPixel(xActual, yp - 2 + panel.height, panel.panelSegments.pixels[3 + 6 * 8]);
				drawPixel(xActual, yp - 1 + panel.height, panel.panelSegments.pixels[3 + 7 * 8]);
				
		}
		
		//left
		for(int y = 3; y < panel.height - 3; y++){
			int yActual = yp + y;
			
				drawPixel(xp, yActual, panel.panelSegments.pixels[0 + 3 * 8]);
				drawPixel(xp+1, yActual, panel.panelSegments.pixels[1 + 3 * 8]);
				drawPixel(xp+2, yActual, panel.panelSegments.pixels[2 + 3 * 8]);
				
		}
		
		//right

		for(int y = 3; y < panel.height - 3; y++){
			int yActual = yp + y;
			
				drawPixel(xp - 3 + panel.width, yActual, panel.panelSegments.pixels[5 + 3 * 8]);
				drawPixel(xp - 2 + panel.width, yActual, panel.panelSegments.pixels[6 + 3 * 8]);
				drawPixel(xp - 1 + panel.width, yActual, panel.panelSegments.pixels[7 + 3 * 8]);
				
		}
		
		
		for(int y = 3; y < panel.height - 3; y++){
			int yActual = y + yp;
			for(int x = 3; x < panel.width - 3; x++){
				int xActual = x + xp;
				
				drawPixel(xActual,yActual, panel.panelSegments.pixels[3 + 3 * 8]);
				
			}
		}

	}
	
public void renderButton(int xp, int yp, Button button){
		
		//top left corner
		for(int y = 0; y < 3; y++){
			int yActual = y + yp;
			for(int x = 0; x < 3; x++){
				int xActual = x + xp;
				drawPixel(xActual,yActual, button.buttonSegments.pixels[x + y * 8]);
			}
		}
		
		//top right corner
		for(int y = 0; y < 3; y++){
			int yActual = y + yp;
			for(int x = 0; x < 3; x++){
				int xActual = x + xp + button.width - 3;
				drawPixel(xActual,yActual, button.buttonSegments.pixels[(x+5) + y * 8]);
			}
		}
		
		//bottom left corner
		for(int y = 0; y < 3; y++){
			int yActual = y + yp + button.height - 3;
			for(int x = 0; x < 3; x++){
				int xActual = x + xp;
				drawPixel(xActual,yActual, button.buttonSegments.pixels[x + (y+5) * 8]);
			}
		}
		
		//bottom right corner
		for(int y = 0; y < 3; y++){
			int yActual = y + yp + button.height - 3;
			for(int x = 0; x < 3; x++){
				int xActual = x + xp + button.width - 3;
				drawPixel(xActual,yActual, button.buttonSegments.pixels[(x+5) + (y+5) * 8]);
			}
		}
		
		//edges
		//top
		for(int x = 3; x < button.width - 3; x++){
			int xActual = xp + x;
			
				drawPixel(xActual, yp, button.buttonSegments.pixels[3 + 0 * 8]);
				drawPixel(xActual, yp+1, button.buttonSegments.pixels[3 + 1 * 8]);
				drawPixel(xActual, yp+2, button.buttonSegments.pixels[3 + 2 * 8]);
				
		}
		
		//bottom
		for(int x = 3; x < button.width - 3; x++){
			int xActual = xp + x;
			
				drawPixel(xActual, yp - 3 + button.height, button.buttonSegments.pixels[3 + 5 * 8]);
				drawPixel(xActual, yp - 2 + button.height, button.buttonSegments.pixels[3 + 6 * 8]);
				drawPixel(xActual, yp - 1 + button.height, button.buttonSegments.pixels[3 + 7 * 8]);
				
		}
		
		//left
		for(int y = 3; y < button.height - 3; y++){
			int yActual = yp + y;
			
				drawPixel(xp, yActual, button.buttonSegments.pixels[0 + 3 * 8]);
				drawPixel(xp+1, yActual, button.buttonSegments.pixels[1 + 3 * 8]);
				drawPixel(xp+2, yActual, button.buttonSegments.pixels[2 + 3 * 8]);
				
		}
		
		//right

		for(int y = 3; y < button.height - 3; y++){
			int yActual = yp + y;
			
				drawPixel(xp - 3 + button.width, yActual, button.buttonSegments.pixels[5 + 3 * 8]);
				drawPixel(xp - 2 + button.width, yActual, button.buttonSegments.pixels[6 + 3 * 8]);
				drawPixel(xp - 1 + button.width, yActual, button.buttonSegments.pixels[7 + 3 * 8]);
				
		}
		
		for(int y = 3; y < button.height - 3; y++){
			int yActual = y + yp;
			for(int x = 3; x < button.width - 3; x++){
				int xActual = x + xp;

				drawPixel(xActual,yActual, button.buttonSegments.pixels[3 + 3 * 8]);
		
			}
		}
		
		if(button.image != null){
			
			int imageSize = button.image.SIZE;
			
			int buttonCenterX = button.x + button.width / 2;
			int buttonCenterY = button.y + button.height / 2;
			
			for(int y = 0; y < imageSize; y++){
				int yActual = buttonCenterY + (y - imageSize / 2);
				for(int x = 0; x < imageSize; x++){
					int xActual =  buttonCenterX + (x - imageSize / 2);
	
					if(button.image.pixels[x + y * imageSize] == 0xffff00ff)
						drawPixel(xActual,yActual, button.buttonSegments.pixels[3 + 3 * 8]);
					else{
						drawPixel(xActual,yActual, button.image.pixels[x + y * imageSize]);
					}
				}
			}
		}else if(button.icon != null){			
			int imageSize = button.icon.SIZE;
			
			int buttonCenterX = button.x + button.width / 2;
			int buttonCenterY = button.y + button.height / 2;
			
			
			
			for(int y = 0; y < imageSize; y++){
				int yActual = buttonCenterY + (y - imageSize / 2);
				for(int x = 0; x < imageSize; x++){
					int xActual =  buttonCenterX + (x - imageSize / 2);

					if(button.icon.pixels[x + y * imageSize] == 0xffff00ff)
						drawPixel(xActual,yActual, button.buttonSegments.pixels[3 + 3 * 8]);
					else{
						drawPixel(xActual,yActual, button.icon.pixels[x + y * imageSize]);
					}
				}
			}
		}
	}
	
	public void renderLabel(int xp, int yp, String text, int color){
		
		for(int i = 0; i < text.length(); i ++){
			
			if(text.charAt(i) == ' '){
				xp += 8;
				i++;
			}
			
			for(int y = 0; y < 8; y++){
				int yActual = y + yp;
				for(int x = 0; x < 8; x++){
					int xActual = x + xp;
					
					int renderColor = uiSprite.getLetter(text.charAt(i)).pixels[x + y * 8];
					
					if(renderColor != 0xffff00ff)
						renderColor = color;
					
					drawPixel(xActual, yActual, renderColor);
			
				}
			}
			
			xp += 8;
		}
	}
	
	
	private boolean drawPixel(int x, int y, int color){
		
		if(x < 0 || x >= width)
			return false;
		if(y < 0  || y >= height)
			return false;

		if(color == 0xffff00ff)
			return false;
		
		screen.pixels[x + y * width] = color;
		return true;
	}
	
	
}
