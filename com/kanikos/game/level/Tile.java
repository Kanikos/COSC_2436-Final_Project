package com.kanikos.game.level;

import com.kanikos.game.graphics.Sprite;
import com.kanikos.game.graphics.Spritesheet;
import com.kanikos.game.serial.Deserializer;
import com.kanikos.game.util.Palette;

public class Tile {
	private short tile;
	
	public Tile(Deserializer deserializer) {
		tile = deserializer.readShort();
	}
	
	/**
	 * @param spritesheet
	 * 		the spritesheet to use
	 * 
	 * @param x
	 * 		the tiles x position, relative to chunk, in tiles
	 *
	 * @param y
	 * 		the tiles y position, relative to chunk, in tiles
	 */
	public void render(Spritesheet spritesheet, Palette palette, int x, int y, int xOffset, int yOffset) {
		// tile info 
		short id = getID();
		byte transformation = getTransformation();
		
		// convert the tile x and y to pixel values one
		x *= Sprite.DIMENSIONS;
		y *= Sprite.DIMENSIONS;
		
		// add the offset the player adds
		x += xOffset;
		y += yOffset;
		
		// render the tile
		spritesheet.render(palette, id, x, y, transformation);
	}
	
	public short getID() {
		return (short) (tile & 0xFF);
	}
	
	public byte getTransformation() {
		return (byte) ((tile >> Byte.SIZE) & 3);
	}
}
