package Game.Building;

import java.util.ArrayList;

import Engine.Core.graphics.Sprite;
import Engine.Core.graphics.map.tile.Structure;

public abstract class Structures {
	
	public static ArrayList<Structure> buildings = new ArrayList<Structure>();
	
	public static void init(){
		buildings.add(new Structure(Sprite.house1));
		buildings.add(new Structure(Sprite.building1));
	}
	
}
