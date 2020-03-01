package com.kanikos.game.entity;

import java.awt.Color;

import com.kanikos.game.graphics.Sprite;
import com.kanikos.game.util.Palette;

public class Entity {
	public static final byte 
		DIR_NORTH	= 0b0001,
		DIR_EAST	= 0b0010,
		DIR_SOUTH	= 0b0100,
		DIR_WEST	= 0b1000
	;
	
	// the entities sprite(s), the sprite to be rendered is dictated by the direction variable
	protected Palette palette;
	protected Sprite[] sprites = new Sprite[4];
	protected byte direction = 0;
	
	// the x and y position, relative to the entire level, in pixels
	protected int x = 0, y = 0;
	
	// stats 
	protected int health, attack, defense, speed  = 2;
	
	// temp constructor
	public Entity() {
		final int[] colors = {
			Color.RED.getRGB(),		// NORTH
			Color.GREEN.getRGB(), 	// SOUTH
			Color.BLUE.getRGB(), 	// EAST
			Color.YELLOW.getRGB()	// WEST
		};
		palette = new Palette(colors);
		
		for(short i = 0; i <= 0xFF; i += 0x55) {
			sprites[i / 0x55] = new Sprite((byte) i);
		}
	}
	
	public void move(byte direction) {
		if((direction & DIR_NORTH) == DIR_NORTH) {
			this.direction = 0;
			y -= speed;
		}
		
		if((direction & DIR_SOUTH) == DIR_SOUTH) {
			this.direction = 1;
			y += speed;
		}
		
		if((direction & DIR_EAST) == DIR_EAST) {
			this.direction = 2;
			x += speed;
		}
		
		if((direction & DIR_WEST) == DIR_WEST) {
			this.direction = 3;
			x -= speed;
		}
	}
	
	public void render() {
		sprites[direction].render(palette, x, y, (byte) 0);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
