/*
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
        private void add_label ( JPanel panel, Color color, String text ) {
            JLabel label;
            label = new JLabel(text);
            label.setFont(FONT_DIALOG);
            label.setForeground(color);
            label.setHorizontalAlignment(JLabel.CENTER);
            panel.add(label);
	}// end add_label ()

	/**
	 * add a label to a key in the keyboard display
         * string must be three chara for top middle and bottom of label.
	 */
        private void add_long_label ( JPanel panel, String text ) {
            JLabel label;
            for (int i = 0; i < 3; i++) {
                add_label( panel, TEXT_DEFAULT, text.substring(i, i+1));
            }
	}// end add_long_label ()


	/**
	 * default constructor
	 * @param int the which finger we are (0-3; index-pinky)
	 * @param boolean the orientation
	 * @param KeyMap the KeyMap to write on it
	 */
	public FingerPanel (int finger, boolean orient, KeyMap keys, boolean visibleKeys) {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		JPanel panel;
		Vector lookup;

		if (bDEBUG) System.out.println("FingerPanel: creating panel");
		// setPreferredSize(new Dimension(twiddlerX, (int)(windowY / 5)));
		initButtons();

		/* How to arrange the keys) */
		if (orient) {
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		else {
			setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}

		setLayout(gridbag); /* 6w x 4h grid */
		setBackground(twiddlerBackground);

		constraints.fill = GridBagConstraints.BOTH;

		constraints.gridwidth = 1;
		constraints.gridheight = GridBagConstraints.RELATIVE;
		constraints.weightx = 1;
		constraints.weighty = 1;

		/* Row 1: Labels or Nothing */
		for (int i = 0; i < 6; i++) {
			panel = new JPanel();
                        Font font = new Font("Monospaced", Font.BOLD, 6);
			panel.setBackground(twiddlerBackground);
			if (finger == 0) {
                            Color color = twiddlerBackground;
                            if (i == 0) {
                                color = lightRed;
                            }
                            else if (i == 2) {
                                color = lightBlue;
                            }
                            else if (i == 4) {
                                color = lightGreen;
                            }
                            JLabel label = new JLabel("XX");
                            label.setFont(font);
                            label.setForeground(color);
                            label.setBackground(color);
                            label.setHorizontalAlignment(JLabel.CENTER);
                            label.setOpaque(true);
                            panel.add(label);
			}
			if (i == 5) {
				constraints.gridwidth = GridBagConstraints.REMAINDER;
			}

			gridbag.setConstraints(panel, constraints);
			add(panel);
		}

		constraints.gridwidth = 1;
		constraints.gridheight = GridBagConstraints.REMAINDER;
		constraints.weightx = 1;
		constraints.weighty = 3;

		for (int i = 0; i < 6; i++) {
			Vector buttons = new Vector(16,0);
			for (int x = 0; x < 16; x++) {
				buttons.add(x, new KeyStatus());
			}
			((KeyStatus)buttons.elementAt(finger * FINGER_OFFSET +
							      (int)(i / 2))).setStatus(true);
			panel = new JPanel();
			if (i % 2 == 1) {
				/* Labels */
				panel.setBackground(twiddlerBackground);
				panel.setLayout(new GridLayout(3, 1));
				if (i == 5) {
					constraints.gridwidth = GridBagConstraints.REMAINDER;
				}
				if (finger != 0 && visibleKeys) {
					for (int j = 0; j < 3; j++) {
						((KeyStatus)buttons.elementAt(INDEX_OFFSET + j)).setStatus(true);
						KeyElement myButton = keys.getKey(buttons);
						if (myButton != null) {
							JLabel label = new JLabel();
							label.setFont(FONT_DIALOG);
							label.setHorizontalAlignment(JLabel.CENTER);

							/* set the text, and the color */
							if (myButton.displayLetter().length() > 1) {
								label.setText("y");
								label.setForeground(twiddlerBackground);
							}
							else {
                                                            Color color = Color.YELLOW;
                                                            if (j == 0) {
                                                                color = lightRed;
                                                            }
                                                            else if (j == 1) {
                                                                color  = lightBlue;
                                                            }
                                                            else if (j == 2) {
                                                                color  = lightGreen;
                                                            }
                                                            label.setForeground( color );
                                                            String displayLetter = myButton.displayLetter().toUpperCase();
                                                            if( displayLetter.length() == 1 ) {
                                                                    label.setText(myButton.displayLetter().toUpperCase());
                                                                } else {
                                                                    label.setText("+");
                                                                    label.setForeground(twiddlerBackground);
                                                                }

							}

							panel.add(label);
						} else {
                                                    add_label( panel, twiddlerBackground, "n");
                                                }
						((KeyStatus)buttons.elementAt(INDEX_OFFSET +
								j)).setStatus(false);
					}
				}
				else {
					JLabel label = new JLabel("z");
					label.setFont(FONT_DIALOG);
					label.setHorizontalAlignment(JLabel.CENTER);
					label.setForeground(twiddlerBackground);
					panel.add(label);
				}
			}
			else {
				/* Button */
				//panel.setPreferredSize(new Dimension(buttonX, buttonY));
				panel.setBackground(buttonBackground);
				panel.setLayout(new GridLayout(3, 1));
				panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				KeyElement myButton = keys.getKey(buttons);
				if (myButton != null && visibleKeys) {
					if ((myButton.getNumber() == KEY_SPACE) ||
                                            (myButton.getLetter().equals(" "))) {
                                            add_long_label( panel, "SP ");
					}
					else if ((myButton.getNumber() == KEY_BACKSPACE) ||
                                                 (myButton.getLetter().equals("\b"))) {
                                            add_long_label( panel, "BS ");
					}
					else if ((myButton.getNumber() == KEY_DELETE) ||
                                                 (myButton.getLetter().equals("\177"))) {
                                            add_long_label( panel, "DEL");
					}
					else if ((myButton.getNumber() == KEY_ENTER) ||
                                                 (myButton.getLetter().equals("\r"))) {
                                            add_long_label( panel, "ENT");
					}
					else if ((myButton.getNumber() == KEY_EOL) ||
                                                 (myButton.getLetter().equals("\n"))) {
                                            add_long_label( panel, "NL ");
					}
					else if ((myButton.getNumber() == KEY_TAB) ||
                                                 (myButton.getLetter().equals("\t"))) {
                                            add_long_label( panel, "TAB");
					}
					else {
                                            add_long_label( panel, " " + myButton.displayLetter().toUpperCase() + " "); // letter
					}
				}
				else {
					panel.add(new JLabel());
				}
			}
			gridbag.setConstraints(panel, constraints);
			if (i % 2 == 0) {
				/* We want to keep the "Buttons" around to 'highlight' */
				getButtons().add(panel);
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
