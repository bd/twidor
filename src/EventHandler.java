/*  -*- indent-tabs-mode: t; tab-width: 4; c-basic-offset: 4 -*-
Twidor: the twiddler typing tutor.
Copyright (C) 2005	James Fusia
Copyright (C) 2017	Carey Richard Murphey

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
USA.
 */
/**
 * CCG: Twidor- The Twiddler Tutor!
 * <pre>
 * EventHandler.java, the general event manager for Twidor.
 *
 * Revisions:
 * 			0.5	17 July 2003
 * 			Completed Tutor
 * 			0.1	22 May 2003
 * 			Created class EventHandler
 * </pre>
 * @author <a href="mailto:visyz@cc.gatech.edu">James Fusia</a>
 * @version Version 0.5; 17 July 2003
 */
import java.awt.event.*;
import javax.swing.*;
public class EventHandler implements ActionListener, ItemListener, KeyListener, WindowListener, TwidorConstants {

	/**
	 * internal variables
	 */
	private Twidor theTutor;

	/**
	 * Default Constructor.
	 * @param Twidor the tutor we manage
	 */
	public EventHandler (Twidor tutor) {
		theTutor = tutor;
	}

	/**
	 * Default accessor for internal variable
	 * @return Twidor my tutor
	 */
	public Twidor myTutor () {
		return theTutor;
	}

// ActionListener Dependencies

	/**
	 * Invoked when an action is performed.
	 * @param ActionEvent to be interpreted
	 */
	public void actionPerformed (ActionEvent e) {
		if (bDEBUG) System.out.println("EventHandler: Action Performed.");
		myTutor().menuOption(e.getActionCommand());
	}

// WindowListener Dependencies

	/**
	 * Invoked when the window is set active.
	 * @param WindowEvent to be interpreted
	 */
	public void windowActivated (WindowEvent e) {
	}

	/**
	 * Invoked when dispose is called on a window.
	 * @param WindowEvent to be interpreted
	 */
	public void windowClosed (WindowEvent e) {
		myTutor().twidorQuit();
	}

	/**
	 * Invoked when the window is closed from the menu.
	 * @param WindowEvent to be interpreted
	 */
	public void windowClosing (WindowEvent e) {
		myTutor().twidorQuit();
	}

	/**
	 * Invoked when a window is unselected.
	 * @param WindowEvent to be interpreted
	 */
	public void windowDeactivated (WindowEvent e) {
	}

	/**
	 * Invoked when a window is un-minimized.
	 * @param WindowEvent to be interpreted
	 */
	public void windowDeiconified (WindowEvent e) {
	}

	/**
	 * Invoked when a window is minimized.
	 * @param WindowEvent to be interpreted
	 */
	public void windowIconified (WindowEvent e) {
	}

	/**
	 * Invoked when a window is first made visible.
	 * @param WindowEvent to be interpreted
	 */
	public void windowOpened (WindowEvent e) {
	}

// KeyListener Dependencies

	/**
	 * Invoked when a key has been pressed.
	 * @param KeyEvent to be interpreted
	 */
	public void keyPressed (KeyEvent e) {
	}

	/**
	 * Invoked when a key has been released.
	 * @param KeyEvent to be interpreted
	 */
	public void keyReleased (KeyEvent e) {
	}

	/**
	 * Invoked when a key has been typed.
	 * @param KeyEvent to be interpreted
	 */
	public void keyTyped (KeyEvent e) {
            if (bDEBUG) System.out.println("EventHandler: " + e);
            char c = e.getKeyChar(); //  a unicode character
            if ( c != KeyEvent.CHAR_UNDEFINED  ) {
		myTutor().charTyped(String.valueOf( c), System.currentTimeMillis());
            }
	}

	// ItemListener Dependencies
	
	/**
	 * Invoked when an item has been selected or deselected
	 * @param ItemEvent to be interpreted
	 */
	public void itemStateChanged (ItemEvent e) {
		if (bDEBUG) System.out.println("EventHandler: Menu Item changed state");
		if (e.getItem() instanceof JCheckBoxMenuItem) {
			myTutor().booleanOption(((JCheckBoxMenuItem)e.getItem()).getText(),
									((JCheckBoxMenuItem)e.getItem()).getState());
		}
		else {
			if (bDEBUG) System.out.println("EventHandler: Menu " + e.paramString());
		}
	}

}
