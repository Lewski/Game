package Game.Map;

import java.util.ArrayList;
import java.util.Random;

import Engine.Core.Noise.SimplexNoise;
import Engine.Core.graphics.Screen;
import Engine.Core.graphics.Sprite;
import Engine.Core.graphics.TileType;
import Engine.Core.graphics.map.Map;
import Engine.Core.graphics.map.tile.Natural;
import Engine.Core.graphics.map.tile.Tile;

public class NaturalMap extends Map{

	private static Random random = new Random();
	
	private static ArrayList<Natural> trees = new ArrayList<Natural>();
	
	public NaturalMap(int width, int height) {
		super(width, height);
	}

	protected void generateMap(){
		generateTiles();
	}
	
	private void generateTiles(){
		
		SimplexNoise noise = new SimplexNoise(55);
		SimplexNoise treeNoise = new SimplexNoise(5868);
		
		for(int y = 0; y < height; y ++){
			for(int x = 0; x < width; x ++){
				
				float id = noise.OctaveNoise2D(4, 1, .008f, x, y);
				float treeId = treeNoise.OctaveNoise2D(8, 1, .008f, x, y);
				
				int tileIndex = 0;
				int treeIndex = 0;
				
				if(id > 0.3f){
					tileIndex = random.nextInt(4) + 4;
				}else{
					tileIndex = random.nextInt(4);
				}
				
				if(treeId > 0.2f && id <= 0.3f){
					treeIndex = random.nextInt(100);
					
					Natural newTree = new Natural(Sprite.tree1);
					
					newTree.xPos = x;
					newTree.yPos = y;
					
					if(treeIndex > 40) newTree.sprite = Sprite.tree2;
					if(treeIndex > 98) newTree.sprite = Sprite.tree3;
					
					
					trees.add(newTree);

				}
				
				
				if(tileIndex == 0) tiles[x + y * width] = Tile.grass1;
				if(tileIndex == 1) tiles[x + y * width] = Tile.grass2;
				if(tileIndex == 2) tiles[x + y * width] = Tile.grass3;
				if(tileIndex == 3) tiles[x + y * width] = Tile.grass4;
				
				if(tileIndex == 4) tiles[x + y * width] = Tile.stone1;
				if(tileIndex == 5) tiles[x + y * width] = Tile.stone2;
				if(tileIndex == 6) tiles[x + y * width] = Tile.stone3;
				if(tileIndex == 7) tiles[x + y * width] = Tile.stone4;
				
			}
		}
	}
	
	
	public void render(int xScroll, int yScroll, Screen screen){
		
		screen.xPos = xScroll;
		screen.yPos = yScroll;
		
		int x0 = xScroll >> 3;
		int x1 = (xScroll + screen.width + 8) >> 3;
		int y0 = yScroll >> 3;
		int y1 = (yScroll + screen.height + 8) >> 3;
		
		for(int y = y0; y < y1; y ++){
			for(int x = x0; x < x1; x ++){
			
				if(x < 0 || y < 0 || x >= width || y >= height){
					Tile.voidTile.render(x, y, screen);
				}else if(tiles[x + y * width] == null){
					Tile.voidTile.render(x, y, screen);
				}else{
					tiles[x + y * width].render(x, y, screen);
				}
			}
		}
		
		
		//System.out.println(trees.size());
		
		
		//modify stone
		for(int y = 0; y < height; y ++){
			for(int x = 0; x < width; x ++){

				if(x < 0 || y < 0 || x >= width || y >= height) break;
				
				Tile checkingTile = tiles[x + y * width];
				
				if(checkingTile.type == TileType.STONE){
				

					//check top
					if(y > 0){
						if(tiles[x + (y-1) * width].type != TileType.STONE){
							screen.renderEdge(x << 3,y << 3,Sprite.stoneEdge, 0);
						}
					}
					//check left
					if(x > 0){
						if(tiles[(x-1) + y * width].type != TileType.STONE){
							screen.renderEdge(x << 3,y << 3,Sprite.stoneEdge, 3);
						}
					}
					
					//check right
					if(x < width-1){
						if(tiles[(x+1) + y * width].type != TileType.STONE){
							screen.renderEdge(x << 3,y << 3,Sprite.stoneEdge, 1);
						}
					}
					//check bottom
					if(y < height-1){
						if(tiles[x + (y+1) * width].type != TileType.STONE){
							screen.renderEdge(x << 3,y << 3,Sprite.stoneEdge, 2);
						}
					}
				}
			}
		}
		
		
		for(Natural tree : trees){
			tree.render(screen);
		}
		
	}
	
}
