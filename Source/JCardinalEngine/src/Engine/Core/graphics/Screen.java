package Engine.Core.graphics;

import java.awt.Color;
import java.util.Formatter;
import java.util.Random;

import Engine.Core.UI.uiSprite;
import Engine.Core.graphics.map.tile.Structure;
import Engine.Core.graphics.map.tile.Tile;

public class Screen {

	public int width;
	public int height;
	
	public int xPos = 0;
	public int yPos = 0;
	
	public int brightness = 0xffffff;
	
	public int[] pixels;
	
	private Random random = new Random();
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		
		pixels = new int[width * height];
		
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i ++){
			pixels[i] = 0;
		}
	}
	
	public void renderSelection(int xStart,int yStart,int xEnd,int yEnd){
		xStart -= xPos;
		yStart -= yPos;
		
		xEnd -= xPos;
		yEnd -= yPos;
		
		
		//top left
		for(int y = 0; y < 4; y++){
			int yActual = y + yStart;
			for(int x = 0; x < 4; x++){
				int xActual = x + xStart;
				
				if(xActual < -Sprite.selectedTile.SIZE || xActual >= width || yActual < -Sprite.selectedTile.SIZE || yActual >= height) break;
					drawPixel(xActual, yActual, Sprite.selectedTile.pixels[x + y * Sprite.selectedTile.SIZE]);
		
			}
		}
		
		
		//top right
		for(int y = 0; y < 4; y++){
			int yActual = y + yStart;
			for(int x = 4; x < 8; x++){
				int xActual = x + xEnd;
				
				if(xActual < -Sprite.selectedTile.SIZE || xActual >= width || yActual < -Sprite.selectedTile.SIZE || yActual >= height) break;
					drawPixel(xActual, yActual, Sprite.selectedTile.pixels[x + y * Sprite.selectedTile.SIZE]);
		
			}
		}
		
		
		
		//bottom right
		for(int y = 4; y < 8; y++){
			int yActual = y + yEnd;
			for(int x = 4; x < 8; x++){
				int xActual = x + xEnd;
				
				if(xActual < -Sprite.selectedTile.SIZE || xActual >= width || yActual < -Sprite.selectedTile.SIZE || yActual >= height) break;
					drawPixel(xActual, yActual, Sprite.selectedTile.pixels[x + y * Sprite.selectedTile.SIZE]);
		
			}
		}
		
		
		//button left
		for(int y = 4; y < 8; y++){
			int yActual = y + yEnd;
			for(int x = 0; x < 4; x++){
				int xActual = x + xStart;
				
				if(xActual < -Sprite.selectedTile.SIZE || xActual >= width || yActual < -Sprite.selectedTile.SIZE || yActual >= height) break;
					drawPixel(xActual, yActual, Sprite.selectedTile.pixels[x + y * Sprite.selectedTile.SIZE]);
		
			}
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile){
		
		xp -= xPos;
		yp -= yPos;
		
		for(int y = 0; y < tile.sprite.SIZE; y++){
			int yActual = y + yp;
			for(int x = 0; x < tile.sprite.SIZE; x++){
				int xActual = x + xp;
				
				if(xActual < -tile.sprite.SIZE || xActual >= width || yActual < -tile.sprite.SIZE || yActual >= height) break;
					drawPixel(xActual, yActual, tile.sprite.pixels[x + y * tile.sprite.SIZE]);
		
			}
		}
	}
	
	public void renderEdge(int xp, int yp, Sprite edgeSprite, int edge){
		xp -= xPos;
		yp -= yPos;
		
		int depth = 3;
		
		if(edge == 0){
			
			for(int y = 0; y < depth; y++){
				int yActual = y + yp;
				for(int x = 0; x < edgeSprite.SIZE; x++){
					int xActual = x + xp;

					if(xActual < -edgeSprite.SIZE || xActual >= width || yActual < -edgeSprite.SIZE || yActual >= height) break;
						drawPixel(xActual, yActual, edgeSprite.pixels[x + y * edgeSprite.SIZE]);
			
				}
			}
		}else if(edge == 1){
			
			for(int y = 0; y < edgeSprite.SIZE; y++){
				int yActual = y + yp;
				for(int x = edgeSprite.SIZE - depth; x < edgeSprite.SIZE; x++){
					int xActual = x + xp;

					if(xActual < -edgeSprite.SIZE || xActual >= width || yActual < -edgeSprite.SIZE || yActual >= height) break;
						drawPixel(xActual, yActual, edgeSprite.pixels[x + y * edgeSprite.SIZE]);
			
				}
			}
		}else if(edge == 2){
			
			for(int y = edgeSprite.SIZE - depth; y < edgeSprite.SIZE; y++){
				int yActual = y + yp;
				for(int x = 0; x < edgeSprite.SIZE; x++){
					int xActual = x + xp;

					if(xActual < -edgeSprite.SIZE || xActual >= width || yActual < -edgeSprite.SIZE || yActual >= height) break;
						drawPixel(xActual, yActual, edgeSprite.pixels[x + y * edgeSprite.SIZE]);
			
				}
			}
		}
		else if(edge == 3){
			
			for(int y = 0; y < edgeSprite.SIZE; y++){
				int yActual = y + yp;
				for(int x = 0; x < depth; x++){
					int xActual = x + xp;

					if(xActual < -edgeSprite.SIZE || xActual >= width || yActual < -edgeSprite.SIZE || yActual >= height) break;
						drawPixel(xActual, yActual, edgeSprite.pixels[x + y * edgeSprite.SIZE]);
			
				}
			}
		}
		
		
		
		
	}
	
	public void renderStructure(int xp, int yp, Structure tile){
		
		xp = xp << 3;
		yp = yp << 3;
		
		xp -= xPos;
		yp -= yPos;
		
		for(int y = 0; y < tile.sprite.SIZE; y++){
			int yActual = y + yp;
			for(int x = 0; x < tile.sprite.SIZE; x++){
				int xActual = x + xp;
				
				if(xActual < -tile.sprite.SIZE || xActual >= width || yActual < -tile.sprite.SIZE || yActual >= height) break;
					drawPixel(xActual, yActual, tile.sprite.pixels[x + y * tile.sprite.SIZE]);
		
			}
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite){
		xp -= xPos;
		yp -= yPos;
		
		for(int y = 0; y < 8; y++){
			int yActual = y + yp;
			for(int x = 0; x < 8; x++){
				int xActual = x + xp;
				
				drawPixel(xActual, yActual, sprite.pixels[x + y * 8]);
		
			}
		}
	}
	
	public void renderText(int xp, int yp, String text, int color){
		xp -= xPos;
		yp -= yPos;
		
		
		for(int i = 0; i < text.length(); i ++){
			
			if(text.charAt(i) == ' '){
				xp += 8;
				i++;
			}
			xp += 8;
			
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
		}
	}

	
	
	public boolean drawPixel(int x, int y, int color){
		
		int fuzzyEdgeDepth = 4;
		
		if(x < 0 || x >= width)
			return false;
		if(y < 0  || y >= height)
			return false;
		/*
		if(x < random.nextInt(fuzzyEdgeDepth) || x >= width - random.nextInt(fuzzyEdgeDepth) )
			return false;
		if(y < random.nextInt(fuzzyEdgeDepth)  || y >= height - random.nextInt(fuzzyEdgeDepth) )
			return false;
		*/
		if(color == 0xffff00ff)
			return false;
		
		pixels[x + y * width] = color;
		return true;
	}
	
	
}
