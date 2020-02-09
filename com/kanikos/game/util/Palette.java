package com.kanikos.game.util;

import com.kanikos.game.serial.Deserializer;
import com.kanikos.game.serial.Serializer;

public class Palette {
	public static final int LIMIT = 4;
	
	private final int ERROR_COLOR = 0xFFFF00FF;
	private final int[] COLOR_PALETTE = new int[LIMIT];
	private final int[] GRAY_SCALE = {
			0xFFFFFFFF, 	// WHITE
			0xFF7E7E7E,		// LIGHT GRAY
			0xFF3F3F3F,		// DARK GRAY
			0xFF000000		// BLACK
	};

	public Palette(int... colors) {
		changePallet(colors);
	}
	
	public void changePallet(int... colors) {
		for(int i = 0; i < LIMIT; i++) {
			COLOR_PALETTE[i] = colors[i];
		}
	}
	
	public void changeColor(int index, int color) {
		COLOR_PALETTE[index] = color;
	}
	
	public int convertToColor(int grayScale) {
		int color = ERROR_COLOR;
		
		for(int i = 0; i < LIMIT; i++) {
			if(grayScale == GRAY_SCALE[i]) {
				color = COLOR_PALETTE[i];
				break;
			}
		}
		
		return color;
	}
	
	public int getColor(int index) {
		return COLOR_PALETTE[index];
	}
	
	public void serialize(Serializer serializer) {
		serializer.writeInts(COLOR_PALETTE);
	}
	
	// overloaded methods
	public Palette(Deserializer deserializer) {
		this(deserializer.readInts());
	}
	
	public Palette() {
		this(0xFFFFFFFF, 0xFF7E7E7E, 0xFF3F3F3F, 0xFF000000);
	}
	
	public void changePallet(Deserializer deserializer) {
		changePallet(deserializer.readInts());
	}
}
