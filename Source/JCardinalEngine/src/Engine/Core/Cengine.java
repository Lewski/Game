package Engine.Core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import Engine.Core.UI.Label;
import Engine.Core.UI.UserInterface;
import Engine.Core.graphics.Graph;
import Engine.Core.graphics.Screen;
import Engine.Core.graphics.Sprite;
import Engine.Core.graphics.entity.character.Player;
import Engine.Core.graphics.map.Map;
import Engine.Core.graphics.map.tile.Tile;
import Game.Stats;
import Game.StructuresPanel;
import Game.Building.Structures;
import Game.Map.NaturalMap;

public class Cengine extends Canvas implements Runnable {

	public static String title = "Testing Cardinal Engine";
	public static int width = 600;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	public Thread thread;
	public static JFrame frame;
	private boolean running = false;
	
	public Screen screen;
	public UserInterface ui;
	
	public Graph workerCountGraph;
	
	public KeyboardInput keyInput;
	public MouseInput mouseInput;
	public MouseMove mouseMove;
	
	public Map map;
	
	private Player player;
	
	private Stats statsPanel;
	private StructuresPanel structuresPanel;

	private Tile selectedTile;

	private Label playerLabel;


	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Cengine() {
		
		Dimension size = new Dimension((int) (width * scale),(int) (height * scale));
		setPreferredSize(size);
		
		frame = new JFrame();
		frame.add(this);
		//frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
		// Transparent 16 x 16 pixel cursor image.
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		// Create a new blank cursor.
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
		// Set the blank cursor to the JFrame.
		frame.getContentPane().setCursor(blankCursor);
		
		
		
		screen = new Screen(width, height);
		ui = new UserInterface(screen);
		
		keyInput = new KeyboardInput();
		mouseInput = new MouseInput();
		mouseMove = new MouseMove();
		
		addKeyListener(keyInput);
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseMove);
		
		Structures.init();
		
		statsPanel = new Stats(this);
		statsPanel.visible = true;
		structuresPanel = new StructuresPanel(77, ui.height - 79, this);
		structuresPanel.visible = true;
		
		workerCountGraph = new Graph(600,100, 300,100);
		
		selectedTile = new Tile(Sprite.selectedTile);
		
		map = new NaturalMap(256,256);

		player = new Player(keyInput);
		player.x = (map.width / 2) * 8;
		player.y = (map.height / 2) * 8;
		playerLabel = new Label("Lewski", 0, 0);
		playerLabel.color = 0xff00aaff;
	
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop(){
		running = false;
		try{
			thread.join();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}

	int frames;
	int updates;
	
	public int fps = 0;
	public int ups = 0;
	
	public void run() {
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1_000_000_000.0 / 60.0;
		double delta = 0;
		
		frames = 0;
		updates = 0;
		
		requestFocus();
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta > 1){
				update();
				updates++;
				delta--;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 100){
				timer += 100;
			
				fps = frames * 10;
				
				frames = 0;
				updates = 0;
				
			}
		}
	}

	public void update(){
		
		keyInput.update();
		mouseInput.update();
		mouseMove.update();
		
		statsPanel.update();
		structuresPanel.update();
		
		player.update();
		playerLabel.xPos = player.x;
		playerLabel.yPos = player.y;
		
		//workerCountGraph.addValue(fps);
		//workerCountGraph.update();
		
	}
	
	int xStart;
	int yStart;
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3); //triple buffering
			return;
		}
		
		screen.clear();
		
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;

		
		map.render(xScroll, yScroll, screen);

		//selectedTile.render(((mouseMove.mouseX + xScroll) >> 3),((mouseMove.mouseY + yScroll) >> 3), screen);
		
		if(!mouseMove.isDragging){
			xStart = ((mouseMove.mouseX + xScroll) >> 3) << 3;
			yStart = ((mouseMove.mouseY + yScroll) >> 3) << 3;
		}
		
		int xEnd = ((mouseMove.mouseX + xScroll) >> 3) << 3;
		int yEnd = ((mouseMove.mouseY + yScroll) >> 3) << 3;
		
		screen.renderSelection(xStart, yStart, xEnd, yEnd);
		
		player.render(screen);
		playerLabel.render(screen);
		
		statsPanel.render();
		structuresPanel.render();
		
		
		int cursorX = mouseMove.mouseX;//(int) ((int) mouseMove.mouseX * (width / ((double)frame.getContentPane().getWidth() / (double)scale)));
		int cursorY = mouseMove.mouseY;//(int) ((int) mouseMove.mouseY * (height / ((double)frame.getContentPane().getHeight() / (double)scale)));
		
		//Cursor
		for(int y = 0; y < 8; y ++){
			for(int x = 0; x < 8; x ++){
				screen.drawPixel((cursorX - (x - 4)), (cursorY - (y - 4)), Sprite.cursor.pixels[x + y * 8]);
			}
		}
		
		for(int i = 0; i < pixels.length; i ++){
			pixels[i] = screen.pixels[i];
			
		}

		Graphics g = bs.getDrawGraphics();
		{// All graphics here
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
			g.setColor(new Color(20,20,20));
		}
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String [] args){
		
		Cengine engine = new Cengine();
		engine.frame.setTitle(engine.title);

		
		engine.start();
		
	}
	
}
