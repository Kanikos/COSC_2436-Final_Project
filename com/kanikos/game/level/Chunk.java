package com.kanikos.game.level;

import com.kanikos.game.graphics.Sprite;
import com.kanikos.game.graphics.Spritesheet;
import com.kanikos.game.serial.Deserializer;
import com.kanikos.game.serial.Serializer;
import com.kanikos.game.util.Coordinate;
import com.kanikos.game.util.Palette;

public class Chunk {
	public static final int WIDTH = 16, HEIGHT = 11;
	
	public Palette palette = new Palette();
	
	public Tile[] tiles = new Tile[WIDTH * HEIGHT];
	public Tile defaultTile = new Tile((short) 0);
	
	public Chunk(Deserializer deserializer) {
		load(deserializer);
	}
	
	public Chunk() {}
	
	public void render(Spritesheet spritesheet, int[] pixels, int dimensions) {
		for(int y = 0; y < HEIGHT; y++) {
			int yPos = y * Sprite.DIMENSIONS;
			
			for(int x = 0; x < WIDTH; x++) {
				int xPos = x * Sprite.DIMENSIONS;
				
				Tile tile = tiles[(y * WIDTH) + x];
				
				if(tile == null) {
					continue;
				}
				
				spritesheet.SPRITES[tile.getID()].render(palette, pixels, dimensions, tile, xPos, yPos);
			}
		}
	}
	
	public void load(Deserializer deserializer) {
		palette.changePallet(deserializer);
		
		for(int i = 0; i < WIDTH * HEIGHT; i++) {
			tiles[i] = new Tile(deserializer.readShort());
		}
	}
	
	public boolean isWriteableAt(int x, int y, int spriteID) {
		Tile tile = tiles[(y * WIDTH) + x];
		
		return (tile == null) || (tile.getID() != spriteID);
	}
	
	public void setTile(int x, int y, short spriteID) {
		tiles[(y * WIDTH) + x] = new Tile(spriteID);
	}
	
	public void serialize(Serializer serializer) {
		palette.serialize(serializer);
		
		for(Tile t: tiles) {
			t.serialize(serializer);
		}
	}
	
	// overloaded methods
	public boolean isEmptyAt(Coordinate coordinate, int spriteID) {
		int tileX = coordinate.x / Sprite.DIMENSIONS;
		int tileY = coordinate.y / Sprite.DIMENSIONS;
		
		return isWriteableAt(tileX, tileY, spriteID);
	}
	
	public void setTile(Coordinate coordinate, short spriteID) {
		int tileX = coordinate.x / Sprite.DIMENSIONS;
		int tileY = coordinate.y / Sprite.DIMENSIONS;
		
		setTile(tileX, tileY, spriteID);
	}
}
