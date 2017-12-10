/*  -*- indent-tabs-mode: t; tab-width: 4; c-basic-offset: 4 -*-
Twidor: the twiddler typing tutor.
Copyright (C) 2005	James Fusia

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
import java.util.Vector;
import java.net.URL;
public class FingerPanel extends JPanel implements TwiddlerSubPanel, TwidorConstants {

	/**
	 * The Array of JPanels that make up the buttons on our 'face'.
	 * For changing the background to highlighted color blah.
	 */
	private Vector myButtons;

	/**
	 * default constructor
	 */
	private FingerPanel () {
	}// end FingerPanel ()

	/**
	 * add a label to a key in the keyboard display
         * string must be three chara for top middle and bottom of label.
	 */
        private void add_label ( JPanel panel, Color foreground, Font font, String text ) {
		if( font == null )
			font = FONT_KEYPAD;
		if( foreground == null )
			foreground = TEXT_DEFAULT;
		JLabel label;
		label = new JLabel(text);
		label.setFont(font);
		label.setForeground(foreground);
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBorder(noBorder);
		panel.add(label);
	}// end add_label ()

	/**
	 * add a label to a key in the keyboard display
         * string must be three chara for top middle and bottom of label.
	 */
        private void add_long_label ( JPanel panel, String text ) {
            for (int i = 0; i < 3; i++) {
		    add_label( panel, TEXT_DEFAULT, FONT_KEYPAD, text.substring(i, i+1));
            }
	}// end add_long_label ()

	/**
	 * add one row of buttons for specified <finger>
	 * @param int the which finger we are (0-3; index-pinky)
	 * @param boolean the orientation
	 * @param KeyMap the KeyMap to write on it
	 */
	public FingerPanel (boolean orient, KeyMap keys, boolean visibleKeys) {
		if (bDEBUG) System.out.println("FingerPanel: creating panel");
		initButtons();
		setBackground(twiddlerBackground);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		/* horizontal direction to arrange the keys */
		ComponentOrientation keyOrient = ComponentOrientation.RIGHT_TO_LEFT;
		if (orient) {
			keyOrient = ComponentOrientation.LEFT_TO_RIGHT;
		}

		{ // Above finger 0: add key for chording: green, blue, red boxes
			JPanel panel = new JPanel();
			panel.setComponentOrientation( keyOrient );
			panel.setLayout(new GridLayout(0, 6, 1, 3));
			panel.setBackground(twiddlerBackground);
			for (int col = 0; col < 6; col++) {
				JPanel subPanel = new JPanel();
				subPanel.setBackground(twiddlerBackground);
				Color color = twiddlerBackground;
				if (col == 0) {
					color = lightRed;
				}
				else if (col == 2) {
					color = lightBlue;
				}
				else if (col == 4) {
					color = lightGreen;
				}

				JLabel label = new JLabel("xx");
				label.setFont(FONT_DIALOG);
				label.setForeground(color);
				label.setBackground(color);
				label.setBorder(noBorder);
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setOpaque(true);
				subPanel.add(label);
				panel.add(subPanel);
			}
			add(panel);
		}
		{
			JPanel panel = new JPanel();
			panel.setComponentOrientation( keyOrient );
			panel.setLayout(new GridLayout(0, 6, 1, 3));
			panel.setBackground(twiddlerBackground);

			for (int finger = 0; finger < 4; finger++) { // four rows, one per finger
				for (int col = 0; col < 6; col++) {			 // three button columns, and three chord columns
					Vector buttons = new Vector(16,0);
					for (int x = 0; x < 16; x++) {
						buttons.add(x, new KeyStatus());
					}
					((KeyStatus)buttons.elementAt(finger * FINGER_OFFSET + (int)(col / 2))).setStatus(true);
					JPanel subPanel = new JPanel();
					if (col % 2 == 1) { // chord column
						subPanel.setBackground(twiddlerBackground);
						subPanel.setLayout(new GridLayout(3, 1));
						if (finger != 0 && visibleKeys) {
							for (int buttonRow = 0; buttonRow < 3; buttonRow++) {
								((KeyStatus)buttons.elementAt(INDEX_OFFSET + buttonRow)).setStatus(true);
								KeyElement myButton = keys.getKey(buttons);
								if (myButton != null) {
									Color color = Color.YELLOW;
									if (buttonRow == 0) {
										color = lightRed;
									}
									else if (buttonRow == 1) {
										color  = lightBlue;
									}
									else if (buttonRow == 2) {
										color  = lightGreen;
									}
									JLabel label = new JLabel();
									label.setFont(FONT_KEYPAD);
									label.setHorizontalAlignment(JLabel.CENTER);
									label.setBorder(noBorder);
									label.setForeground( color );
									String displayLetter = myButton.displayLetter();
									if( displayLetter.length() == 1 ) {
										label.setText(myButton.displayLetter().toUpperCase());
									} else if (displayLetter.length() <= 3) {
										label.setFont(FONT_MACRO);
										label.setText(displayLetter);
									} else {
										label.setFont(FONT_MACRO);
										label.setText(displayLetter.substring(0,2));
									}
									subPanel.add(label);
								} else {
									add_label( subPanel, twiddlerBackground, FONT_KEYPAD, "");
								}
								((KeyStatus)buttons.elementAt(INDEX_OFFSET + buttonRow)).setStatus(false);
							}
						} else {
							add_label( subPanel, twiddlerBackground,  FONT_KEYPAD, "z");
						}
					} else {		// button column
						subPanel.setBackground(buttonBackground);
						subPanel.setLayout(new GridLayout(3, 1));
						subPanel.setBorder(buttonBorder);
						subPanel.add(new JLabel()); // empty top row (label is in middle)
						KeyElement myButton = keys.getKey(buttons);
						if (myButton != null && visibleKeys) {
							String displayLetter = myButton.displayLetter();
							if ((myButton.getNumber() == KEY_SPACE) || (myButton.getLetter().equals(" "))) {
								displayLetter = "SP";
							} else if ((myButton.getNumber() == KEY_BACKSPACE) || (myButton.getLetter().equals("\b"))) {
								displayLetter = "BS";
							} else if ((myButton.getNumber() == KEY_DELETE) || (myButton.getLetter().equals("\177"))) {
								displayLetter = "DEL";
							} else if ((myButton.getNumber() == KEY_ENTER) || (myButton.getLetter().equals("\r"))) {
								displayLetter = "ENT";
							} else if ((myButton.getNumber() == KEY_EOL) || (myButton.getLetter().equals("\n"))) {
								displayLetter = "NL";
							} else if ((myButton.getNumber() == KEY_TAB) || (myButton.getLetter().equals("\t"))) {
								displayLetter = "TAB";
							} else {
								displayLetter = displayLetter.toUpperCase();
							}
							if (displayLetter.length() > 1) {
								add_label( subPanel, TEXT_DEFAULT,  FONT_MACRO, displayLetter);
							} else {
								add_label( subPanel, TEXT_DEFAULT,  FONT_KEYPAD, displayLetter);
							}
						}
						else {
							subPanel.add(new JLabel());
						}
						/* We want to keep the "Buttons" around to 'highlight' */
						getButtons().add(subPanel);
					}
					panel.add(subPanel);
				}
			}
			add(panel);
		}
		if (bDEBUG) System.out.println("FingerPanel: panel created");
	}// end FingerPanel (boolean, KeyMap)

	private ImageIcon loadIcon (String file) {
		URL location;
		location = this.getClass().getResource(file);
		return new ImageIcon(location);
	}// end loadIcon (String)

	/**
	 * Quick internal accessor since I was confusing myself by accessing it directly
	 * @return Vector my button
	 */
	public Vector getButtons () {
		return myButtons;
	}// end getMyButton ()

	/**
	 * Quick internal accessor to initialize my buttons
	 */
	private void initButtons () {
		myButtons = new Vector();
	}// end setButtons ()


	/* --==<( TwiddlerSubPanel Requirement )>==-- */
	/**
	 * method for highlighting a certain button to a certain color
	 * @param int which button (0-2)
	 * @param Color what color you want it to go to
	 */
	public void highlight (int which, Color hColor) {
		if (bDEBUG) System.out.println("FingerPanel: highlight button " + which);
		try {
			((JPanel)getButtons().elementAt(which)).setBackground(hColor);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			if (bDEBUG) System.out.println("FingerPanel: array oob");
		}
	}// end highlight (Color)

	/* --==<( TwiddlerSubPanel Requirement )>==-- */
	/**
	 * method for clearing the background of the buttons
	 */
	public void clear () {
		for (int i = 0; i < getButtons().size(); i++) {
			((JPanel)getButtons().elementAt(i)).setBackground(buttonBackground);
		}
	}// end clear ()

}// end class FingerPanel
