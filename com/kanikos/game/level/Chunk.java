package com.kanikos.game.level;

import com.kanikos.game.graphics.Spritesheet;
import com.kanikos.game.serial.Deserializer;
import com.kanikos.game.util.Palette;

public class Chunk {
	public static final int WIDTH = 16, HEIGHT = 11;

	private Palette palette;
	private Tile[] tiles;
	
	public Chunk(Deserializer deserializer) {
		palette = new Palette(deserializer);
		
		// import tiles from the lvl file
		tiles = new Tile[WIDTH * HEIGHT]; 
		for(int i = 0; i < (WIDTH * HEIGHT); i++) {
			tiles[i] = new Tile(deserializer);
		}
	}
	
	public void render(Spritesheet spritesheet, int xOffset, int yOffset) {
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x ++) {
				tiles[(y * WIDTH) + x].render(spritesheet, palette, x, y, xOffset, yOffset);
			}
		}
	}
}
