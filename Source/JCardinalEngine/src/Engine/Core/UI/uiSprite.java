package Engine.Core.UI;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Engine.Core.graphics.SpriteSheet;

public class uiSprite {

	public final int SIZE;
	private int x,y;
	public int[] pixels;
	private uiSpriteSheet sheet;
	
	public static uiSprite panel = new uiSprite(8, 0, 0, uiSpriteSheet.gui);
	
	public static uiSprite buttonNormal = new uiSprite(8,2,0, uiSpriteSheet.gui);
	public static uiSprite buttonHighlight = new uiSprite(8,3,0, uiSpriteSheet.gui);
	public static uiSprite buttonPressed = new uiSprite(8,2,1, uiSpriteSheet.gui);
	
	public static uiSprite upArrow = new uiSprite(8,1,0, uiSpriteSheet.icons);
	public static uiSprite downArrow = new uiSprite(8,0,0, uiSpriteSheet.icons);
	
	public static uiSprite zero = new uiSprite(8, 4, 6, uiSpriteSheet.font);
	public static uiSprite one = new uiSprite(8, 5, 6, uiSpriteSheet.font);
	public static uiSprite two = new uiSprite(8, 6, 6, uiSpriteSheet.font);
	public static uiSprite three = new uiSprite(8, 7, 6, uiSpriteSheet.font);
	public static uiSprite four = new uiSprite(8, 0, 7, uiSpriteSheet.font);
	public static uiSprite five = new uiSprite(8, 1, 7, uiSpriteSheet.font);
	public static uiSprite six = new uiSprite(8, 2, 7, uiSpriteSheet.font);
	public static uiSprite seven = new uiSprite(8, 3, 7, uiSpriteSheet.font);
	public static uiSprite eight = new uiSprite(8, 4, 7, uiSpriteSheet.font);
	public static uiSprite nine = new uiSprite(8, 5, 7, uiSpriteSheet.font);
	
	
	
	public static uiSprite a_cap = new uiSprite(8, 0, 0, uiSpriteSheet.font);
	public static uiSprite b_cap = new uiSprite(8, 2, 0, uiSpriteSheet.font);
	public static uiSprite c_cap = new uiSprite(8, 4, 0, uiSpriteSheet.font);
	public static uiSprite d_cap = new uiSprite(8, 6, 0, uiSpriteSheet.font);
	public static uiSprite e_cap = new uiSprite(8, 0, 1, uiSpriteSheet.font);
	public static uiSprite f_cap = new uiSprite(8, 2, 1, uiSpriteSheet.font);
	public static uiSprite g_cap = new uiSprite(8, 4, 1, uiSpriteSheet.font);
	public static uiSprite h_cap = new uiSprite(8, 6, 1, uiSpriteSheet.font);
	public static uiSprite i_cap = new uiSprite(8, 0, 2, uiSpriteSheet.font);
	public static uiSprite j_cap = new uiSprite(8, 2, 2, uiSpriteSheet.font);
	public static uiSprite k_cap = new uiSprite(8, 4, 2, uiSpriteSheet.font);
	public static uiSprite l_cap = new uiSprite(8, 6, 2, uiSpriteSheet.font);
	public static uiSprite m_cap = new uiSprite(8, 0, 3, uiSpriteSheet.font);
	public static uiSprite n_cap = new uiSprite(8, 2, 3, uiSpriteSheet.font);
	public static uiSprite o_cap = new uiSprite(8, 4, 3, uiSpriteSheet.font);
	public static uiSprite p_cap = new uiSprite(8, 6, 3, uiSpriteSheet.font);
	public static uiSprite q_cap = new uiSprite(8, 0, 4, uiSpriteSheet.font);
	public static uiSprite r_cap = new uiSprite(8, 2, 4, uiSpriteSheet.font);
	public static uiSprite s_cap = new uiSprite(8, 4, 4, uiSpriteSheet.font);
	public static uiSprite t_cap = new uiSprite(8, 6, 4, uiSpriteSheet.font);
	public static uiSprite u_cap = new uiSprite(8, 0, 5, uiSpriteSheet.font);
	public static uiSprite v_cap = new uiSprite(8, 2, 5, uiSpriteSheet.font);
	public static uiSprite w_cap = new uiSprite(8, 4, 5, uiSpriteSheet.font);
	public static uiSprite x_cap = new uiSprite(8, 6, 5, uiSpriteSheet.font);
	public static uiSprite y_cap = new uiSprite(8, 0, 6, uiSpriteSheet.font);
	public static uiSprite z_cap = new uiSprite(8, 2, 6, uiSpriteSheet.font);

	public static uiSprite a_low = new uiSprite(8, 1, 0, uiSpriteSheet.font);
	public static uiSprite b_low = new uiSprite(8, 3, 0, uiSpriteSheet.font);
	public static uiSprite c_low = new uiSprite(8, 5, 0, uiSpriteSheet.font);
	public static uiSprite d_low = new uiSprite(8, 7, 0, uiSpriteSheet.font);
	public static uiSprite e_low = new uiSprite(8, 1, 1, uiSpriteSheet.font);
	public static uiSprite f_low = new uiSprite(8, 3, 1, uiSpriteSheet.font);
	public static uiSprite g_low = new uiSprite(8, 5, 1, uiSpriteSheet.font);
	public static uiSprite h_low = new uiSprite(8, 7, 1, uiSpriteSheet.font);
	public static uiSprite i_low = new uiSprite(8, 1, 2, uiSpriteSheet.font);
	public static uiSprite j_low = new uiSprite(8, 3, 2, uiSpriteSheet.font);
	public static uiSprite k_low = new uiSprite(8, 5, 2, uiSpriteSheet.font);
	public static uiSprite l_low = new uiSprite(8, 7, 2, uiSpriteSheet.font);
	public static uiSprite m_low = new uiSprite(8, 1, 3, uiSpriteSheet.font);
	public static uiSprite n_low = new uiSprite(8, 3, 3, uiSpriteSheet.font);
	public static uiSprite o_low = new uiSprite(8, 5, 3, uiSpriteSheet.font);
	public static uiSprite p_low = new uiSprite(8, 7, 3, uiSpriteSheet.font);
	public static uiSprite q_low = new uiSprite(8, 1, 4, uiSpriteSheet.font);
	public static uiSprite r_low = new uiSprite(8, 3, 4, uiSpriteSheet.font);
	public static uiSprite s_low = new uiSprite(8, 5, 4, uiSpriteSheet.font);
	public static uiSprite t_low = new uiSprite(8, 7, 4, uiSpriteSheet.font);
	public static uiSprite u_low = new uiSprite(8, 1, 5, uiSpriteSheet.font);
	public static uiSprite v_low = new uiSprite(8, 3, 5, uiSpriteSheet.font);
	public static uiSprite w_low = new uiSprite(8, 5, 5, uiSpriteSheet.font);
	public static uiSprite x_low = new uiSprite(8, 7, 5, uiSpriteSheet.font);
	public static uiSprite y_low = new uiSprite(8, 1, 6, uiSpriteSheet.font);
	public static uiSprite z_low = new uiSprite(8, 3, 6, uiSpriteSheet.font);
	
	public uiSprite(int size, int x, int y, uiSpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		
		load();
	}
	
	public uiSprite(int size, int color){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	public uiSprite(String filePath){
		
		int size = 0;
		
		try {
			BufferedImage image = ImageIO.read(uiSpriteSheet.class.getResource(filePath));
			
			int w = image.getWidth();
			int h = image.getHeight();
			
			size = w;
			
			pixels = new int[size * size];
			
			image.getRGB(0, 0, w, h, pixels, 0, w);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			size = 0;
		}
		
		SIZE = size;
		
		
	}
	
	private void setColor(int color){
		for(int i = 0; i < SIZE * SIZE; i++){
			pixels[i] = color;
		}
	}
	
	private void load(){
		for(int y = 0; y < SIZE; y ++){
			for(int x = 0; x < SIZE; x++){
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
	
	public static uiSprite getLetter(char letter){
		
		if(letter == '0') return zero;
		if(letter == '1') return one;
		if(letter == '2') return two;
		if(letter == '3') return three;
		if(letter == '4') return four;
		if(letter == '5') return five;
		if(letter == '6') return six;
		if(letter == '7') return seven;
		if(letter == '8') return eight;
		if(letter == '9') return nine;
		
		if(letter == 'a') return a_low;
		if(letter == 'b') return b_low;
		if(letter == 'c') return c_low;
		if(letter == 'd') return d_low;
		if(letter == 'e') return e_low;
		if(letter == 'f') return f_low;
		if(letter == 'g') return g_low;
		if(letter == 'h') return h_low;
		if(letter == 'i') return i_low;
		if(letter == 'j') return j_low;
		if(letter == 'k') return k_low;
		if(letter == 'l') return l_low;
		if(letter == 'm') return m_low;
		if(letter == 'n') return n_low;
		if(letter == 'o') return o_low;
		if(letter == 'p') return p_low;
		if(letter == 'q') return q_low;
		if(letter == 'r') return r_low;
		if(letter == 's') return s_low;
		if(letter == 't') return t_low;
		if(letter == 'u') return u_low;
		if(letter == 'v') return v_low;
		if(letter == 'w') return w_low;
		if(letter == 'x') return x_low;
		if(letter == 'y') return y_low;
		if(letter == 'z') return z_low;
		
		
		if(letter == 'A') return a_cap;
		if(letter == 'B') return b_cap;
		if(letter == 'C') return c_cap;
		if(letter == 'D') return d_cap;
		if(letter == 'E') return e_cap;
		if(letter == 'F') return f_cap;
		if(letter == 'G') return g_cap;
		if(letter == 'H') return h_cap;
		if(letter == 'I') return i_cap;
		if(letter == 'J') return j_cap;
		if(letter == 'K') return k_cap;
		if(letter == 'L') return l_cap;
		if(letter == 'M') return m_cap;
		if(letter == 'N') return n_cap;
		if(letter == 'O') return o_cap;
		if(letter == 'P') return p_cap;
		if(letter == 'Q') return q_cap;
		if(letter == 'R') return r_cap;
		if(letter == 'S') return s_cap;
		if(letter == 'T') return t_cap;
		if(letter == 'U') return u_cap;
		if(letter == 'v') return v_cap;
		if(letter == 'W') return w_cap;
		if(letter == 'X') return x_cap;
		if(letter == 'Y') return y_cap;
		if(letter == 'Z') return z_cap;
	
		return x_low;
		
	}
	
	
}
