package com.kanikos.game.level;

import com.kanikos.game.serial.Deserializer;

public class Level {
	private Chunk[] chunks;
	private byte width, height;
	
	public Level(String path) {
		Deserializer deserializer = new Deserializer(path);
		
		width = deserializer.readByte();
		height = deserializer.readByte();
		
		for(int i = 0; i < (width * height); i++) {
			chunks[i]= new Chunk(deserializer);
		}
	}
}
