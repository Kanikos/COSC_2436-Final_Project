package com.kanikos.game.entity;

public class Entity {
	public static final byte 
		DIR_NORTH	= 0b0001,
		DIR_EAST	= 0b0010,
		DIR_SOUTH	= 0b0100,
		DIR_WEST	= 0b1000
	;
			
	
	// the x and y position in pixels
	protected int x = 0, y = 0;
	
	public void move(byte direction) {
		if((direction & DIR_NORTH) == DIR_NORTH) {
			y--;
		}
		
		if((direction & DIR_SOUTH) == DIR_SOUTH) {
			y++;
		}
		
		if((direction & DIR_EAST) == DIR_EAST) {
			x++;
		}
		
		if((direction & DIR_WEST) == DIR_WEST) {
			x--;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
