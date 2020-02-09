package com.kanikos.game.level;

import com.kanikos.game.serial.Serializer;

/**
 * 	<p>
 * 		Explicitly stores two variables:
 * 	</p>
 * 
 * 	<ul>
 * 		<li>
 * 			sprite ID that this tile represents 
 * 		</li>
 * 	
 * 		<li>
 * 			flags that govern which properties this tile has
 * 		</li>
 * 	</ul>
 * 
 * <hr> </hr>
 * 
 * 	<p>
 * 		serialized form anatomy: 0x01_02
 * 	</p>
 * 		
 * 	<ul>
 * 		<li>
 * 			01: holds the flags
 * 		</li>
 * 
 * 		<li>
 * 			02: holds the sprite index this tile represents
 * 		</li>
 * 	</ul>
 */
public class Tile {	
	// flags that detail tile properties	
	public static final short 
		FLAG_FLIPX = (short) 0b0000001_00000000,
		FLAG_FLIPY = (short) 0b0000010_00000000,
		FLAG_FLIPD = (short) 0b0000100_00000000,
		FLAG_SOLID = (short) 0b0001000_00000000
	;
	
	
	private short serializedForm = 0;
		
	public Tile(short serializedForm) {
		this.serializedForm = serializedForm;
	}
	
	public void serialize(Serializer serializer) {
		serializer.writeShort(serializedForm);
	}
	
	public void setID(short spriteID) {
		spriteID &= 0x00FF;
		
		serializedForm &= 0xFF00;
		serializedForm |= spriteID;
	}
	
	public void setFlags(short flags) {
		flags &= 0xFF00;
		serializedForm ^= flags;
	}
	
	public short getID() {
		return (short) (serializedForm & 0xFF);
	}
	
	public boolean isFlagSet(short FLAG) {
		return (serializedForm & FLAG) == FLAG;
	}
	
	// wrappers
	public boolean isSolid() {
		return isFlagSet(FLAG_SOLID);
	}
	
	public boolean flipX() {
		return isFlagSet(FLAG_FLIPX);
	}
	
	public boolean flipY() {
		return isFlagSet(FLAG_FLIPY);
	}
	
	public boolean flipD() {
		return isFlagSet(FLAG_FLIPD);
	}
 }
