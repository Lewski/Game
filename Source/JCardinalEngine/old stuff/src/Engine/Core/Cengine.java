package Engine.Core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import Engine.Core.UI.Label;
import Engine.Core.UI.UserInterface;
import Engine.Core.graphics.Screen;
import Engine.Core.graphics.Sprite;
import Engine.Core.graphics.entity.character.Player;
import Engine.Core.graphics.map.Map;
import Engine.Core.graphics.map.RandomMap;
import Engine.Core.graphics.map.tile.Natural;
import Engine.Core.graphics.map.tile.Structure;
import Engine.Core.graphics.map.tile.Tile;
import Game.Stats;
import Game.StructuresPanel;
import Game.Building.Structures;

public class Cengine extends Canvas implements Runnable {

	public static String title = "Testing Cardinal Engine";
	public static int width = 600;
	public static int height = width / 16 * 9;
	public static int scale = 2;
	
	public Thread thread;
	public JFrame frame;
	private boolean running = false;
	

	public Screen screen;
	public UserInterface ui;
	
	public KeyboardInput keyInput;
	public MouseInput mouseInput;
	public MouseMove mouseMove;
	
	public Map map;
	private Player player;
	private Structure house1;
	
	private Stats statsPanel;
	private StructuresPanel structuresPanel;
	
	private Natural tree1;
	private Tile tree2;
	private Natural tree3;
	
	private Tile selectedTile;
	
	private Label playerLabel;


	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Cengine() {
		
		Dimension size = new Dimension((int) (width * scale),(int) (height * scale));
		setPreferredSize(size);
		
		frame = new JFrame();
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
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
		
		selectedTile = new Tile(Sprite.selectedTile);
		
		map = new RandomMap(128,128);
		
		player = new Player(keyInput);
		player.x = (map.width / 2) * 8;
		player.y = (map.height / 2) * 8;
		playerLabel = new Label("Lewski", 0, 0);
		playerLabel.color = 0xff00aaff;
		
		
		house1 = new Structure(Sprite.house1);
		
		tree1 = new Natural(Sprite.tree1);
		tree2 = new Natural(Sprite.tree2);
		tree3 = new Natural(Sprite.tree3);
	
		
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

	public void run() {
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1_000_000_000.0 / 60.0;
		double delta = 0;
		
		int frames = 0;
		int updates = 0;
		
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
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				
				frame.setTitle(title + "   FPS: " + frames + "   |   UPS: " + updates );
				
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
		
	}
	
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
		house1.render(5,5,screen);
		tree1.render(9, 4, screen);
		tree2.render(15, 8, screen);
		tree3.render(16, 3, screen);
		
		selectedTile.render(((mouseMove.mouseX + xScroll) >> 3)-1, (mouseMove.mouseY + yScroll - 2) >> 3, screen);
		
		player.render(screen);
		playerLabel.render(screen);
		
		statsPanel.render();
		structuresPanel.render();
		
		for(int i = 0; i < pixels.length; i ++){
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		{// All graphics here
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
			g.setColor(new Color(20,20,20));
			g.setFont(new Font("Verdana", 0, 50));
			//g.drawString("Player X: " + player.x + ", Player Y: " + player.y, 200, 200);
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
