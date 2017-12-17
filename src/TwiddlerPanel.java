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
 * TwiddlerPanel.java, the class that defines how the Twiddler face looks.
 *
 * Revisions:
 *		0.5	17 July 2003
 *		Completed Tutor
 * 		0.2	06 June 2003
 * 			Should be nearly ready.
 * 		0.1	29 May 2003
 * 			Created class TwiddlerPanel
 * </pre>
 * @author <a href="mailto:visyz@cc.gatech.edu">James Fusia</a>
 * @version Version 0.5; 17 July 2003
 */
import java.awt.*;
import javax.swing.*;
import java.util.Vector;
public class TwiddlerPanel extends TwiddlerSubPanel implements TwidorConstants {
	/**
	 * internal variables
	 */
	private KeyMap myKeyMap;
	private boolean thumbOrientation;
	private boolean fingerOrientation;
	private boolean showThumbMap;
	private boolean showThumbBoard;
	private boolean showFingerMap;
	private boolean show2KeyChords = true;
	private boolean showTwiddler;
	private Vector <TwiddlerSubPanel> panelList;
    private FingerPanel fingerPanel;
	/**
	 * default constructor
	 */
	public TwiddlerPanel (KeyMap newMap, boolean thumb, boolean finger) {
		if (bDEBUG) System.out.println("TwiddlerPanel: creating panel");

		setKeyMap(newMap);
		setThumbOrientation(thumb);
		setFingerOrientation(finger);
		setThumbKeysVisible(TWIDDLER_SHOW);
		setThumbBoardVisible(TWIDDLER_SHOW_THUMB);
		setFingerKeysVisible(TWIDDLER_SHOW);
		setBackground(twiddlerBackground);
		setBorder(margin);
		setTwiddlerVisible(true);

		initPanels();
		/* general doodlings with the JPanel */
		setLayout(new GridLayout(5, 1));
		reOrient();

		if (bDEBUG) System.out.println("TwiddlerPanel: panel created");
	}

	/**
	 * accessor for thumb orientation
	 * @return boolean the current thumb orientation
	 */
	public boolean getThumbOrientation () {
		return thumbOrientation;
	}

	/**
	 * accessor for finger orientation
	 * @return boolean the current finger orientation
	 */
	public boolean getFingerOrientation () {
		return fingerOrientation;
	}

	/**
	 * accessor for thumb keys
	 * @return boolean the current key visability
	 */
	public boolean getThumbKeysVisible () {
		return showThumbMap;
	}

	/**
	 * accessor for thumb board visibility
	 * @return boolean the current thumb board visability
	 */
	public boolean getThumbBoardVisible () {
		return showThumbBoard;
	}

	/**
	 * accessor for finger keys
	 * @return boolean the current key visability
	 */
	public boolean getFingerKeysVisible () {
		return showFingerMap;
	}

	/**
	 * accessor for the Twiddler itself
	 * @return boolean the current visibility
	 */
	public boolean getTwiddlerVisible () {
		return showTwiddler;
	}

	/**
	 * accessor for the current keymap
	 * @return KeyMap the current keymap
	 */
	public KeyMap getKeyMap () {
		return myKeyMap;
	}

	/**
	 * accessor for the JPanels we contain
	 * @return Vector the vector of panels we contain
	 */
	public Vector <TwiddlerSubPanel> getPanels () {
		return panelList;
	}

	/**
	 * modifier for thumb orientation
	 * @param boolean the desired thumb orientation
	 */
	public void setThumbOrientation (boolean newOrientation) {
		thumbOrientation = newOrientation;
	}

	/**
	 * modifier for finger orientation
	 * @param boolean the desired finger orientation
	 */
	public void setFingerOrientation (boolean newOrientation) {
		fingerOrientation = newOrientation;
	}

	/**
	 * modifier for thumb key visibility
	 * @param boolean the new status
	 */
	public void setThumbKeysVisible (boolean status) {
		showThumbMap = status;
	}

	/**
	 * modifier for thumb board visibility
	 * @param boolean the new status
	 */
	public void setThumbBoardVisible (boolean status) {
		showThumbBoard = status;
	}

	/**
	 * modifier for finger key visiblity
	 * @param boolean the new status
	 */
	public void setFingerKeysVisible (boolean status) {
		showFingerMap = status;
	}

	/**
	 * modifier for twiddler visibility
	 * @param boolean the new status
	 */
	public void setTwiddlerVisible (boolean status) {
		showTwiddler = status;
	}

	/**
	 * modifier for display of 2-key chords
	 * @param boolean the new status
	 */
	public void set2keyChordsVisible (boolean status) {
		show2KeyChords = status;
	}

	/**
	 * modifier for the current keymap
	 * @param KeyMap the desired KeyMap
	 */
	public void setKeyMap (KeyMap newMap) {
		myKeyMap = newMap;
	}

	/**
	 * initializer for the panel list
	 */
	private void initPanels () {
		panelList = new Vector <TwiddlerSubPanel> ();
	}

	/**
	 * highlights the keys for a given character
	 * @param String the character to highlight
	 */
	public void highlight (String key) {
		KeyElement keyPress = getKeyMap().getKey(key);
		if (keyPress != null) {
			highlight(keyPress);
		}
		else {
			if (bDEBUG) System.out.println("TwiddlerPanel: Can't highlight " + key);
		}
	}

	/**
	 * highlights the keys for the given KeyElement
	 * @param KeyElement the key to highlight
	 */
	public void highlight (KeyElement key) {
		Color hColor;
		if (key == null) {
			if (bDEBUG) System.out.println("TwiddlerPanel: Can't highlight key.");
			return;
		}
		if (fingerPanel == null) {
			if (bDEBUG) System.out.println("TwiddlerPanel: null fingerPanel. Can't highlight key.");
			return;
		}
		try {
			if (key.getMacro().length() > 1) {
				hColor = mccHighlight;
			} else {
				hColor = buttonHighlight;
			}
			for (int finger = 0; finger < 4; finger++) {
				for (int column = 0; column < 3; column++) {
					if (key.getFinger(finger, column)) {
						fingerPanel.highlight(finger * FINGER_OFFSET + column, hColor);
					}
				}
			}
			for (int thumb = 0; thumb < 4; thumb++) {
				if (key.getThumb(thumb)) {
					(getPanels().elementAt(0)).highlight(thumb, hColor);
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			if (bDEBUG) System.out.println("TwiddlerPanel: array oob");
		}
	}

	/**
	 * clears all possibly highlighted keys
	 */
	public void clear () {
		for (int i = 0; i < getPanels().size(); i++) {
			(getPanels().elementAt(i)).clear();
		}
	}

	/**
	 * called whenever you want to do a redraw of the Twiddler display;
	 * i.e. anytime you modify the Finger/Thumb Orientation or KeyMap.
	 */
	public void reOrient () {
		if (bDEBUG) System.out.println("TwiddlerPanel: rearranging twiddler layout");
		setVisible(false);
		removeAll();
		setBackground(twiddlerBackground);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		setMinimumSize(new Dimension(twiddlerX, windowY));
		getPanels().clear();
		if (getThumbBoardVisible()) {
			getPanels().addElement(new ThumbPanel(getThumbOrientation(), getKeyMap(), getThumbKeysVisible()));
		}

		fingerPanel = new FingerPanel(getFingerOrientation(), getKeyMap(), getFingerKeysVisible(), show2KeyChords);
		getPanels().addElement(fingerPanel);

		for (int i = 0; i < getPanels().size(); i++) {
			this.add(getPanels().elementAt(i));
		}
		if (getTwiddlerVisible()) {
			setVisible(true);
		}
		if (bDEBUG) System.out.println("TwiddlerPanel: rearrangement complete");
	}

}
