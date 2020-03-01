package com.kanikos.game.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.kanikos.game.comp.Frame;

public class FocusManager implements MouseListener {
	public void mouseEntered(MouseEvent e) {
		System.out.println("Entered");
		Frame.canvas.requestFocus();
	}
	
	public void mousePressed(MouseEvent e) {
		System.out.println("pressed");
		mouseEntered(e);
	}
	
	public void mouseExited(MouseEvent e) {
		System.out.println("exited");
	}
	public void mouseClicked(MouseEvent e) {}
 	public void mouseReleased(MouseEvent e) {}
}
