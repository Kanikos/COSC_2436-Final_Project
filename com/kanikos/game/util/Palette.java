package com.kanikos.game.util;

import com.kanikos.game.serial.Deserializer;

public class Palette {
	public static final int LIMIT = 4;
	private static final int MASK = 0xFF;
	private static final int INCREMENT = 0x55;
	
	// default palette
	public static final int ERROR_COLOR = 0xFFFF00FF;
	public static final int[] GRAY_SCALE 	= {
			0xFF000000,
			0xFF555555,
			0xFFAAAAAA,
			0xFFFFFFFF
	};
	
	private int[] palette;
	
	public Palette(Deserializer deserializer) {
		palette = deserializer.readInts();
	}
	
	public Palette(int...colors) {
		palette = colors;
	}
	
	public int colorize(int grayScale) {
		int index = (grayScale & MASK) / INCREMENT;
		
		if(index < 0 || index > LIMIT || palette == null) {
			return ERROR_COLOR;
		}
		
		return palette[index];
	}
	
	public static int getStandardColor(int grayScale) {
		int index = (grayScale & MASK) / INCREMENT;
		
		if(index < 0 || index > LIMIT) {
			return ERROR_COLOR;
		}
		
		return GRAY_SCALE[index];
	}
}
