package com.kanikos.game;

import com.kanikos.game.comp.Frame;
import com.kanikos.game.graphics.Sprite;
import com.kanikos.game.graphics.Spritesheet;
import com.kanikos.game.level.Chunk;

public class Game {
	/* TOOD
	 *	[   ] Dialog box  to toggle debug mode (level editor, property editor, etc) || separate level editor or something 
	 *	[   ] ?
	 */
	// frame settings 
	public static final String TITLE = "ASM 2";
	
	public static final int WIDTH_TL = Chunk.WIDTH, HEIGHT_TL = Chunk.HEIGHT;
	public static final int SCALE = 5;
	
	public static final int WIDTH_PX = WIDTH_TL * Sprite.DIMENSIONS;
	public static final int HEIGHT_PX = HEIGHT_TL * Sprite.DIMENSIONS;
	
	public static final int WIDTH_SL = WIDTH_PX * SCALE;
	public static final int HEIGHT_SL = HEIGHT_PX * SCALE;
	
	// game loop settings 
	public static final byte END_WIN = 0;
	public static final byte END_LOS = 1;

	public static final long REFRESH_RATE = 1000000000L / 60L;
	
	public static boolean running = true;
	public static byte endCondition = -1;
	
	public Game() {
		Spritesheet test = new Spritesheet("res/graphics/spritesheet.png");
		
		Frame.initialize();
		
		long referenceTime = System.nanoTime();
		while(running) {
			if((System.nanoTime() - referenceTime) >= REFRESH_RATE) {
				referenceTime = System.nanoTime();
				
				Frame.render();
			}
		}
	}
	
	public static void main(String[] asm) {
		new Game();
	}
}
