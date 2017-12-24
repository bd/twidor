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
 * FingerPanel.java, a class for making the management of the finger pictures
 * easier. Close cousin to ThumbPanel.
 * 
 * Revisions:
 * 		0.5	17 July 2003
 * 		Completed Tutor
 * 		0.2	06 June 2003
 * 		Lots of bugfixes. Almost Final.
 * 		0.1	29 May 2003
 * 		Created class FingerPanel
 * </pre>
 * @author <a href="mailto:visyz@cc.gatech.edu">James Fusia</a>
 * @version Version 0.5; 17 July 2003
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.Vector;
import java.util.HashMap;
import java.net.URL;
import java.lang.Math;

public class FingerPanel extends TwiddlerSubPanel implements  TwidorConstants {

	/**
	 * The Array of JPanels that make up the buttons on our 'face'.
	 * For changing the background to highlighted color blah.
	 */
	private Vector <JPanel> myButtons;

	/**
	 * default constructor
	 */
	private FingerPanel () {
	}

	/**
	 * add a label to a key in the keyboard display
         * string must be three chara for top middle and bottom of label.
	 */
	private void add_key ( JPanel panel, Color text_color, Font font, String text, Border border ) {
		if( border == null )
			border = blackBorder;
		if( text_color == null )
			text_color = TEXT_DEFAULT;

		JLabel label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBorder(border);
		label.setBackground( buttonBackground );
		label.setForeground( text_color );
		if (text != null) {
			String keyLabel = text.substring(0,Math.min(3,text.length()));
			if( font == null ) {
				if (keyLabel.length() == 1) {
					font = FONT_LABEL;
				} else if (keyLabel.length() == 2) {
					font = FONT_LABEL2;
				} else if (keyLabel.length() > 2) {
					font = FONT_MACRO;
				}
				label.setFont(font);
				label.setText(keyLabel);
			}
		}
		panel.add(label);
	}

	/**
	 * add one row of buttons for specified <finger>
	 * @param int the which finger we are (0-3; index-pinky)
	 * @param boolean the orientation
	 * @param KeyMap the KeyMap to write on it
	 */
	public FingerPanel (boolean orient, KeyMap keys, boolean visibleKeys, boolean show2KeyChords, boolean show_MCC ) {
		if (bDEBUG) System.out.println("FingerPanel: creating panel");
		initButtons();
		setBackground(twiddlerBackground);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		/* horizontal direction to arrange the keys */
		ComponentOrientation keyOrient = ComponentOrientation.RIGHT_TO_LEFT;
		if (! orient) {
			keyOrient = ComponentOrientation.LEFT_TO_RIGHT;
		}

		{
			JPanel panel = new JPanel();
			panel.setComponentOrientation( keyOrient );
			panel.setLayout(new GridLayout(0, (show2KeyChords && visibleKeys) ? 12 : 3, 1, 4));
			panel.setBackground(twiddlerBackground);

			for (int finger = 0; finger < 4; finger++) { // four rows, one per finger
				for (int fingerCol = 0; fingerCol < 3; fingerCol++) {			 // three button columns, and three chord columns
					if ( visibleKeys && show2KeyChords ) {
						// chord map
						Vector <JPanel> subPanels = new Vector <JPanel> ();
						boolean has_chords = false;
						for (int chordCol = 0; chordCol < 3; chordCol++) {
							JPanel subPanel = new JPanel();
							subPanel.setComponentOrientation( keyOrient );
							subPanel.setLayout(new GridLayout(4, 1, 1, 1));
							subPanel.setBackground(twiddlerBackground);
							Border border = redBorder; // chordCol == 0
							if (chordCol == 1) {
								border = blueBorder;
							}
							else if (chordCol == 2) {
								border = greenBorder;
							}
							for (int chordFinger = 0; chordFinger < 4; chordFinger++) { // anchor finger
								if ((finger == chordFinger) && (fingerCol == chordCol)) {
									KeyElement keyElement = keys.getKeyByButtons(KeyElement.buttonMask(finger, fingerCol));
									add_key( subPanel, null, null, keyElement.getLabel(), border );
								}
								else if (finger > chordFinger) {
									add_key( subPanel, twiddlerBackground, null, "z", emptyBorder);
								} else {
									int buttons = KeyElement.buttonMask(finger, fingerCol);
									buttons |= KeyElement.buttonMask(chordFinger, chordCol);
									KeyElement keyElement = keys.getKeyByButtons(buttons);
									if (keyElement == null) {
										add_key( subPanel, twiddlerBackground, FONT_KEYPAD, "", emptyBorder);
									}
									else if ( (! show_MCC) &&
											  ( (keyElement.getLabel().length() > 1) ) ) { 
										add_key( subPanel, twiddlerBackground, FONT_KEYPAD, "", emptyBorder);
									} else {
										has_chords = true;
										add_key( subPanel, null, null, keyElement.getLabel(), border );
									}
								}
							}
							subPanels.add(subPanel);
						}
						for (JPanel jp : subPanels) {
							if(has_chords) {
								panel.add(jp);
							} else {
								JPanel p = new JPanel();
								p.setBackground(twiddlerBackground);
								panel.add(p);
							}
						}
					}
					{			// single button keymap
						int buttons = KeyElement.buttonMask(finger, fingerCol);
						JPanel subPanel = new JPanel();
						subPanel.setBackground(buttonBackground);
						subPanel.setLayout(new GridLayout(3, 1));
						// Color color = keyRed;
						Border border = thickRedBorder;
						if (fingerCol == 1) {
							// color  = keyBlue;
							border = thickBlueBorder;
						} else if (fingerCol == 2) {
							// color  = keyGreen;
							border = thickGreenBorder;
						}
						subPanel.setBorder(border);
						subPanel.add(new JLabel()); // empty top row (label is in middle)
						KeyElement keyElement = keys.getKeyByButtons(buttons);
						if ( visibleKeys && keyElement != null) {
							add_key( subPanel, TEXT_DEFAULT, null, keyElement.getLabel(), emptyBorder);
						} else {
							add_key( subPanel, buttonBackground, FONT_LABEL, "  ", emptyBorder);
						}
						/* We want to keep the "Buttons" around to 'highlight' */
						getButtons().add(subPanel);
						panel.add(subPanel);
					}
				}
			}
			add(panel);
		}
		if (bDEBUG) System.out.println("FingerPanel: panel created");
	}

	private ImageIcon loadIcon (String file) {
		URL location;
		location = this.getClass().getResource(file);
		return new ImageIcon(location);
	}

	/**
	 * Quick internal accessor since I was confusing myself by accessing it directly
	 * @return Vector my button
	 */
	public Vector <JPanel> getButtons () {
		return myButtons;
	}

	/**
	 * Quick internal accessor to initialize my buttons
	 */
	private void initButtons () {
		myButtons = new Vector <JPanel> ();
	}


	/* --==<( TwiddlerSubPanel Requirement )>==-- */
	/**
	 * method for highlighting a certain button to a certain color
	 * @param int which button (0-2)
	 * @param Color what color you want it to go to
	 */
	public void highlight (int which, Color hColor) {
		if (bDEBUG) System.out.println("FingerPanel: highlight button " + which);
		try {
			(getButtons().elementAt(which)).setBackground(hColor);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			if (bDEBUG) System.out.println("FingerPanel: array oob");
		}
	}

	/* --==<( TwiddlerSubPanel Requirement )>==-- */
	/**
	 * method for clearing the background of the buttons
	 */
	public void clear () {
		for (int i = 0; i < getButtons().size(); i++) {
			(getButtons().elementAt(i)).setBackground(buttonBackground);
		}
	}

}
