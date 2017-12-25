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
	private KeyMap keyMap;
	private Vector <TwiddlerSubPanel> panelList;
    private FingerPanel fingerPanel;
	private TwidorPreference pref;
	/**
	 * default constructor
	 */
	public TwiddlerPanel (KeyMap newMap, TwidorPreference p) {
		if (bDEBUG) System.out.println("TwiddlerPanel: creating panel");

		keyMap = newMap;
		pref = p;

		setBackground(twiddlerBackground);
		setBorder(margin);

		initPanels();
		/* general doodlings with the JPanel */
		setLayout(new GridLayout(5, 1));
		reOrient();

		if (bDEBUG) System.out.println("TwiddlerPanel: panel created");
	}



	/**
	 * accessor for the JPanels we contain
	 * @return Vector the vector of panels we contain
	 */
	public Vector <TwiddlerSubPanel> getPanels () {
		return panelList;
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
		KeyElement keyPress = keyMap.getKey(key);
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

	void setKeyMap (KeyMap keymap) {
		keyMap = keymap;
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
		if (pref.show_thumb_board) {
			getPanels().addElement(new ThumbPanel(keyMap, pref.thumb_left_to_right, pref.show_thumb_board));
		}

		fingerPanel = new FingerPanel(keyMap, pref.fingerboard_left_to_right, pref.show_keyboard,
									  pref.show_SCC, pref.show_MCC);
		getPanels().addElement(fingerPanel);

		for (int i = 0; i < getPanels().size(); i++) {
			this.add(getPanels().elementAt(i));
		}
		if (pref.show_keyboard) {
			setVisible(true);
		}
		if (bDEBUG) System.out.println("TwiddlerPanel: rearrangement complete");
	}

}
