package com.kanikos.game.graphics;

import com.kanikos.game.level.Tile;
import com.kanikos.game.util.Palette;

public class Sprite {
	// the width and height of the sprite in pixels
	public static final int DIMENSIONS = 16;
	
	private final int[] sprite;
	
	public Sprite(int[] sprite) {
		this.sprite = sprite;
	}
	
	public void render(Palette palette, int[] pixels, int dimensions,  Tile tile, int xPos, int yPos) {
		int pixel;
		
		for(int y = 0; y < DIMENSIONS; y++) {
			int yPX = tile.flipY() ? DIMENSIONS - 1 - y : y;
			int viewportY = yPos + y;
			
			for(int x = 0; x < DIMENSIONS; x++) {
				int xPX = tile.flipX() ? DIMENSIONS - 1 - x : x;
				int viewportX = xPos + x;
				
				
				if(tile.flipD()) {
					pixel = sprite[(xPX * DIMENSIONS) + yPX];
				}
				else {
					pixel = sprite [(yPX * DIMENSIONS) + xPX];
				}
				
				pixel = palette.convertToColor(pixel);
				pixels[(viewportY * dimensions) + viewportX] = pixel;
			}
		}
	}
	
	// overloaded methods
	public Sprite(int color) {
		sprite = new int[DIMENSIONS * DIMENSIONS];
		
		for(int i = 0; i < sprite.length; i++) {
			sprite[i] = color; 
		}
	}
	
	public void render(Palette palette, int[] pixels, int dimensions, short serializedTile, int xPos, int yPos) {
		render(palette, pixels, dimensions, new Tile(serializedTile), xPos, yPos);
	}
}
