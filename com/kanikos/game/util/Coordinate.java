package com.kanikos.game.util;

public class Coordinate {
	public int x, y;
	
	public Coordinate(int x, int y) {
		setCoordinates(x, y);
	}
	
	public void setCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		
//		/* java 8 version */
//		Integer[] array = {new Integer(x), new Integer(y)};
//		return String.format("x: %03d\tY: %03d", array);
		
		return String.format("X: %03d\tY: %03d", x, y);
	}
}
