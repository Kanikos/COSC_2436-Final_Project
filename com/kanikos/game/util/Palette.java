package com.kanikos.game.util;

public class Palette {
	public static final int LIMIT = 4;
	private static final int INCREMENT = 0x55;
	
	private final int ERROR_COLOR = 0xFFFF00FF;
	private final int[] COLOR_PALETTE;
	private final int[] GRAY_SCALE = {
			0xFF000000,		// BLACK
			0xFF555555,		// DARK GRAY
			0xFFAAAAAA,		// LIGHT GRAY
			0xFFFFFFFF 		// WHITE
	};

	public Palette(int[] palette) {
		COLOR_PALETTE = palette;
	}
	
	public int colorize(byte grayScale) {
		int index = grayScale / INCREMENT;
		
		if(index < 0 || index > LIMIT) {
			return ERROR_COLOR;
		}
		
		return COLOR_PALETTE[grayScale / INCREMENT];
	}
}
