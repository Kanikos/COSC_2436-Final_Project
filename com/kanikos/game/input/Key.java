package com.kanikos.game.input;

public class Key {
	private int primaryKey, secondaryKey;
	private boolean pressed = false;
	private byte flag;
	
	public Key(int primaryKey, int secondaryKey, byte flag) {
		this.primaryKey = primaryKey;
		this.secondaryKey =secondaryKey;
		this.flag = flag;
	}
	
	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}
	
	public boolean isPressed() {
		return pressed;
	}
	
	public byte getFlag() {
		return flag;
	}
	
	public boolean equals(int keycode) {
		return (keycode == primaryKey || keycode == secondaryKey);
	}
}
