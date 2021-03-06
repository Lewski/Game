package Game;

import java.util.ArrayList;

import Engine.Core.Cengine;
import Engine.Core.UI.Button;
import Engine.Core.UI.Label;
import Engine.Core.UI.Panel;
import Engine.Core.UI.UserInterface;
import Engine.Core.UI.uiSprite;
import Engine.Core.graphics.entity.character.Worker;

public class Stats {

	public boolean visible;
	public UserInterface ui;
	public Cengine engine;
	
	private ArrayList<Worker> workers = new ArrayList<Worker>();
	
	public static int numberOfWorkers = 0;
	public static int money = 300;

	
	
	//UI
	Panel infoPanel;

		//money
	Label moneyLabelTitle = new Label("Money",10, 32);
	Label moneyLabel = new Label("0", 10, 43);
		//workers
	Label workersLabel = new Label("Workers",10,10);
	Label workerCount = new Label("0", 10,21);
	
	
	public Stats(Cengine engine){
		
		this.engine = engine;
		this.ui = engine.ui;
		
		
		infoPanel = new Panel(75, ui.height - 2,1,1,uiSprite.panel);
		
		
		workersLabel.color = 0xffff8800;
		moneyLabelTitle.color = 0xffff8800;
	}
	public void update(){
		if(engine.keyInput.addWorker)
			addWorker();
		
		if(engine.keyInput.subWorker)
			removeWorker();
		
		for(Worker w : workers){
			w.update();
		}
		
		money = engine.fps;
		moneyLabel.text = "FPS " + money;
	}
	
	public void render(){
		if(visible){
			
			for(Worker w : workers){
				w.render(engine.screen);
			}
			
			
			infoPanel.render(ui);
			
			moneyLabelTitle.render(ui);
			moneyLabel.render(ui);
			
			workersLabel.render(ui);
			workerCount.render(ui);
		}
	}
	
	
private void addWorker(){
		
		workers.add(new Worker());
		numberOfWorkers++;
		
		workerCount.text = numberOfWorkers + "";
		
	}
	
	private void removeWorker(){
		if(workers.size() > 0){
			workers.remove(0);
			numberOfWorkers--;
			workerCount.text = numberOfWorkers + "";
		}
	}
	
	
}
