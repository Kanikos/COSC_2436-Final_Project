package com.kanikos.game.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Spritesheet {
	public final Sprite[] SPRITES;
	public final int WIDTH, HEIGHT;
	
	public Spritesheet(String path) {
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File(path));
			image.flush();
		} 
		catch(Exception e) { e.printStackTrace(); }
		
		WIDTH = image.getWidth() / Sprite.DIMENSIONS;
		HEIGHT = image.getHeight() / Sprite.DIMENSIONS;
		
		SPRITES = new Sprite[WIDTH * HEIGHT];
		
		for(int y = 0; y < HEIGHT; y++) {
			int yPos = y * Sprite.DIMENSIONS;
			
			for(int x = 0; x < WIDTH; x++) {
				int xPos = x * Sprite.DIMENSIONS;
				
				int[] spritePixels = new int[Sprite.DIMENSIONS * Sprite.DIMENSIONS];
				image.getRGB(xPos, yPos, Sprite.DIMENSIONS, Sprite.DIMENSIONS, spritePixels, 0, Sprite.DIMENSIONS);
				
				SPRITES[(y * WIDTH) + x] = new Sprite(spritePixels);
			}
		}
	}
}
