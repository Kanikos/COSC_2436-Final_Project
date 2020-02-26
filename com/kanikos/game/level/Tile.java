package com.kanikos.game.level;

import com.kanikos.game.graphics.Sprite;
import com.kanikos.game.serial.Deserializer;

public class Tile {
	public static final byte FLAG_SOLID = 0b1000;
	
	public final byte flags, spriteID;
	public final int x, y;
	
	public Tile(Deserializer deserializer, int x, int y) {
		short serializedForm = deserializer.readShort();
		
		flags = (byte) ((serializedForm >> Byte.SIZE) & 0xFF);
		spriteID = (byte) (serializedForm & 0xFF);
		
		this.x = x;
		this.y = y;
	}
	
	public byte getSpriteID() {
		return spriteID;
	}
	
	public byte getTransformations() {
		return (byte) (flags & Sprite.TRANSFORMATION_MASK);
	}
	
	public boolean isSolid() {
		return (flags & FLAG_SOLID) == FLAG_SOLID;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
