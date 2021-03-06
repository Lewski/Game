package Game;

import java.util.ArrayList;

import Engine.Core.Cengine;
import Engine.Core.UI.Button;
import Engine.Core.UI.Label;
import Engine.Core.UI.Panel;
import Engine.Core.UI.UserInterface;
import Engine.Core.UI.uiSprite;
import Engine.Core.graphics.Sprite;
import Engine.Core.graphics.entity.character.Worker;
import Engine.Core.graphics.map.tile.Structure;
import Game.Building.Structures;

public class StructuresPanel {
	
	public boolean visible;
	
	public UserInterface ui;
	public Cengine engine;
	
	int xPos, yPos;
	
	int buttonSize = 36;
	int buttonPadding = 1;
	
	int buttonsX = 8;
	int buttonsY = 2;
	
	int currentRow = 0;
	
	//UI
	
	Structures structures;
	ArrayList<Button> panelButtons = new ArrayList<Button>();
	
	Panel itemsPanel;
	
	Button buildingsPageUP;
	Button buildingsPageDown;
	
	public StructuresPanel(int xPos, int yPos, Cengine engine){
		
		this.engine = engine;
		this.ui = engine.ui;
		
		this.xPos = xPos;
		this.yPos = yPos;
		
		itemsPanel = new Panel(294, 78, xPos, yPos, uiSprite.panel);
		
		buildingsPageUP = new Button(itemsPanel.x + itemsPanel.width + 1, ui.height - 76, 20,35, engine.mouseInput, engine.mouseMove);
		buildingsPageDown = new Button(itemsPanel.x + itemsPanel.width + 1, ui.height - 39, 20,35, engine.mouseInput, engine.mouseMove);
	
		buildingsPageUP.icon = uiSprite.upArrow;
		buildingsPageDown.icon = uiSprite.downArrow;

		for(int i = currentRow * buttonsX; i < Structures.buildings.size(); i ++){
			
			if(i >= buttonsX * buttonsY) break;
			
			int y = i / buttonsX;
			int x = i - (y * buttonsX);

			panelButtons.add(new Button((x * buttonSize) + xPos + 3, (y * buttonSize) + yPos + 3,buttonSize,buttonSize,engine.mouseInput, engine.mouseMove));
			panelButtons.get(x + y * buttonsX).image = Structures.buildings.get(x + y * buttonsX).sprite;
		}
		
	}
	public void update(){
		
		if(engine.keyInput.toggleStructuresPanel){
			visible = !visible;
		}
		
		if(visible){
			buildingsPageUP.update();
			buildingsPageDown.update();
			
			for(Button b : panelButtons){
				b.update();
			}
		}
	}
	
	public void render(){
		if(visible){
			
			itemsPanel.render(ui);
			
			for(Button b : panelButtons){
				b.render(ui);
			}

			buildingsPageUP.render(ui);
			buildingsPageDown.render(ui);
		}
	}
}
