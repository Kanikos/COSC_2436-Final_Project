package com.kanikos.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.kanikos.game.entity.Entity;

public class KeyboardInput implements KeyListener {
	// testing thing only
	public static final Key[] DEFAULT_BINDINGS = {
			new Key(KeyEvent.VK_A, KeyEvent.VK_LEFT, Entity.DIR_WEST),
			new Key(KeyEvent.VK_D, KeyEvent.VK_RIGHT, Entity.DIR_EAST),
			new Key(KeyEvent.VK_W, KeyEvent.VK_UP, Entity.DIR_NORTH),
			new Key(KeyEvent.VK_S, KeyEvent.VK_DOWN, Entity.DIR_SOUTH)		
	};
	
	private Key[] bindings;
	
	public KeyboardInput(Key...bindings) {
		this.bindings = bindings;
	}
	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		for(Key key: bindings) {
			if(key.equals(keycode)) {
				key.setPressed(true);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		for(Key key: bindings) {
			if(key.equals(keycode)) {
				key.setPressed(false);
			}
		}
	}

	public Key[] getBindings() {
		return bindings;
	}
	
	// does nothing, however it has to be implemented 
	public void keyTyped(KeyEvent e) {}
}
