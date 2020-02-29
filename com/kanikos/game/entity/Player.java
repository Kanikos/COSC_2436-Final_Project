package com.kanikos.game.entity;

import com.kanikos.game.input.Key;
import com.kanikos.game.input.KeyboardInput;

public class Player extends Entity {
	public KeyboardInput keyboard;
	
	public Player() {
		keyboard = new KeyboardInput(KeyboardInput.DEFAULT_BINDINGS);
	}
	
	public void update() {
		byte direction = 0;
		
		for(Key key: keyboard.getBindings()) {
			if(key.isPressed()) {
				direction |= key.getFlag();
			}
		}
		
		move(direction);
	}
}
