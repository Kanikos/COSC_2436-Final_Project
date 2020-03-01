package com.kanikos.game.graphics;

import com.kanikos.game.Game;
import com.kanikos.game.comp.Frame;
import com.kanikos.game.util.Palette;

public class Sprite {
	// sprite standard width and height
	public static final int DIMENSIONS = 16;
	
	// variables determines how to transform the sprite
	public static final byte TRANSFORMATION_MASK = 0b111;
	public static final byte
		FLIP_X = 0b001,
		FLIP_Y = 0b010,
		FLIP_D = 0b100
	;
	
	private byte[] sprite;
	
	public Sprite(int[] spritesheet, int spritesheetWidth, int xOffset, int yOffset) {
		sprite = new byte[DIMENSIONS * DIMENSIONS];
		
		xOffset *= DIMENSIONS;
		yOffset *= DIMENSIONS;
		
		int mask = 0xFF;
		int xPos, yPos;
		for(int y = 0; y < DIMENSIONS; y++) {
			yPos = y + yOffset;
			
			for(int x = 0; x < DIMENSIONS; x++) {
				xPos = x + xOffset;
				
				sprite[(y * DIMENSIONS) + x] = (byte) (spritesheet[(yPos * spritesheetWidth) + xPos] & mask);
			}
		}
	}
	
	public Sprite(byte color) {
		sprite = new byte[DIMENSIONS * DIMENSIONS];
		
		for(int i = 0; i < DIMENSIONS * DIMENSIONS; i++) {
			sprite[i] = color;
		}
	}
	
	public void render(Palette palette, int xOffset, int yOffset, byte transformation) {
		int xPos, yPos;
		
		for(int y = 0; y < DIMENSIONS; y++) {
			yPos = y + yOffset;
			
			for(int x = 0; x < DIMENSIONS; x++) {
				xPos = x + xOffset;
				
				if(xPos < 0 || xPos >= Game.WIDTH_PX || yPos < 0 || yPos >= Game.HEIGHT_PX) {
					continue;
				}
				
				Frame.viewportPixels[(yPos * Game.WIDTH_PX) + xPos] = palette.colorize(getPixel(x, y, transformation));
			}
		}
	}
	
	private byte getPixel(int x, int y, byte transformation) {
		int xPos = ((transformation & FLIP_X) == FLIP_X) ? DIMENSIONS - 1 - x : x;
		int yPos = ((transformation & FLIP_Y) == FLIP_Y) ? DIMENSIONS - 1 - y : y;
			
		if((transformation & FLIP_D) == FLIP_D) {
			return sprite[(xPos * DIMENSIONS) + yPos];
		}
		
		return sprite[(yPos * DIMENSIONS) + xPos];
	}
}