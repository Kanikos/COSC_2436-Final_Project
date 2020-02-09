package com.kanikos.game.comp;

import java.awt.Dimension;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

import com.kanikos.game.Game;
import com.kanikos.game.graphics.Sprite;

public class Frame {
	private static boolean initialized = false;
	
	private static JFrame frame;
	private static Canvas canvas;
	
	private static BufferedImage viewport;
	private static int[] viewportPixels;
	
	public static void initialize() {
		if(initialized) {
			return;
		}
		
		frame = new JFrame(Game.TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension d = new Dimension(Game.WIDTH_SL, Game.HEIGHT_SL);
		
		canvas = new Canvas();
		canvas.setPreferredSize(d);
		frame.add(canvas);
		
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas.createBufferStrategy(3);
		
		viewport = new BufferedImage(Game.WIDTH_PX, Game.HEIGHT_PX, BufferedImage.TYPE_INT_RGB);
		viewportPixels = ((DataBufferInt) viewport.getRaster().getDataBuffer()).getData();
	}
	
	public static void render() {
		// clears the screen 
		for(int i = 0; i < viewportPixels.length; i++) {
			viewportPixels[i] = 0xFF000000;
		}
		
		// draws the viewport to the screen 
		BufferStrategy bs = canvas.getBufferStrategy();
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(viewport, 0, 0, Game.WIDTH_SL, Game.HEIGHT_SL, null);
		bs.show();
		g.dispose();
	}
}
