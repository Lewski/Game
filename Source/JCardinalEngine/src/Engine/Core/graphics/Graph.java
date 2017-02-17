package Engine.Core.graphics;

import java.util.ArrayList;

import Engine.Core.UI.UserInterface;

public class Graph {

	int xPos, yPos;
	public int width, height;
	
	int timeRange = 1;//second
	
	public int plotColor = 0xff00ffff;
	public int backColor = 0xff000000;
	
	public ArrayList<Double> values = new ArrayList<Double>();

	public Graph(int x, int y, int w, int h){
		this.xPos = x;
		this.yPos = y;
		this.width = w;
		this.height = h;
	}
	
	public void render(UserInterface ui){
		ui.renderGraph(xPos, yPos, this);
	}
	
	public void update(){
		
		if(values.size() > width)
			clearValues();
		
	}
	
	public void clearValues(){
		values.clear();
	}
	
	public double minValue(){
		
		double min = Double.MAX_VALUE;
		
		for(Double d : values){
			if(d < min)
				min = d;
		}
		
		return min;
	}
	
public double maxValue(){
		
		double max = Double.MIN_VALUE;
		
		for(Double d : values){
			if(d > max)
				max = d;
		}
		
		return max;
		
	}
	
	public void addValue(double value){
		values.add(value);
	}
	
}
