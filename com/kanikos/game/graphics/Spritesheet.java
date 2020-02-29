package com.kanikos.game.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import com.kanikos.game.level.Tile;
import com.kanikos.game.util.Palette;

public class Spritesheet {
	private Sprite[] sprites;
	private int width, height;
	
	public Spritesheet(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(path));
		}
		catch(Exception e) { e.printStackTrace(); }
		
		// expand the 2 indexed image so each pixel takes up a complete byte
		int[] data = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
		
		width = image.getWidth() / Sprite.DIMENSIONS;
		height = image.getHeight() / Sprite.DIMENSIONS;
		sprites = new Sprite[width * height];
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				sprites[(y * width) + x] = new Sprite(data, image.getWidth(), x, y);
			}
		}
	}
	
	public void render(Palette palette, int spriteID, int x, int y, byte transformation) {
		sprites[spriteID].render(palette, x, y, transformation);
	}
}
