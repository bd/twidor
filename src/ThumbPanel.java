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
 * ThumbPanel.java, a class for making the management of the thumb buttons
 * that much easier. See also FingerPanel.
 *
 * Revisions:
 *		0.5	17 July 2003
 *		Completed Tutor
 * 		0.2	06 June 2003
 * 			Should be almost finished. We'll see when I get GUI going.
 * 		0.1	29 May 2003
 * 			Created class FingerPanel
 * </pre>
 * @author <a href="mailto:visyz@cc.gatech.edu">James Fusia</a>
 * @version Version 0.5; 17 July 2003
 */
import java.awt.*;
import javax.swing.*;
import java.util.Vector;
public class ThumbPanel extends TwiddlerSubPanel implements  TwidorConstants {

	/**
	 * internal variables
	 */
	private Vector myButtons;

	/**
	 * default constructor
	 */
	private ThumbPanel () {
	}// end ThumbPanel ()

	/**
	 * default constructor
	 * @param boolean the orientation
	 * @param KeyMap the keymap to implement
	 */
	public ThumbPanel (boolean orient, KeyMap keys, boolean visibleKeys) {
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setAlignmentY(Component.CENTER_ALIGNMENT);
		GridBagLayout gridbag = new GridBagLayout();
		setLayout(gridbag);
		// setPreferredSize(new Dimension(twiddlerX, (int)(windowY / 5)));
		// setMaximumSize(new Dimension(twiddlerX, (int)(windowY / 5)));
		GridBagConstraints constraints = new GridBagConstraints();
                
		initButtons();
		if (orient) {
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		else {
			setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}
		if (bDEBUG) System.out.println("ThumbPanel: creating panel");

		String[] labels;
		if (visibleKeys) {
			labels = new String[]{"Num", "Alt", "Ctrl", "Shft"};
		} else {
			labels = new String[]{"    ", "    ", "    ", "    "};
		}
		setBackground(twiddlerBackground);
		button(3, gridbag, false,  constraints, labels[3]);
		filler(   gridbag, false, constraints);
		filler(   gridbag, false, constraints);
		button(0, gridbag, true, constraints, labels[0]);

		filler(   gridbag, false,  constraints);
		button(2, gridbag, false, constraints, labels[2]);
		button(1, gridbag, false, constraints, labels[1]);
		filler(   gridbag, true, constraints);

		if (bDEBUG) System.out.println("ThumbPanel: panel created");
	}// end ThumbPanel (boolean)

	/**
	 * Quick function to make it easier to use the myButtons variable
	 */
	private void initButtons () {
		myButtons = new Vector(4, 0);
		for (int i = 0; i < 4; i++) {
			myButtons.add(null);
		}
	}// end initButtons ()

	/**
	 * Quick function to return the button vector
	 * @return Vector the buttons this panel holds
	 */
	public Vector getButtons () {
		return myButtons;
	}// end getButtons ()

	/**
	 * quick helper function to add filler boxes
	 * @param GridBagLayout the layout we're using
	 * @param GridBagConstraints the constraints we have to use
	 */
	private void filler (GridBagLayout gridbag, boolean is_end, GridBagConstraints constraints) {
		JPanel panel = new JPanel();
		panel.setBackground(twiddlerBackground);
		if ( is_end ) {
			constraints.gridwidth = GridBagConstraints.REMAINDER;
		} else {
			constraints.gridwidth = 1;
		}
		gridbag.setConstraints(panel, constraints);
		add(panel);
	}// end filler (GridBagLayout, GridBagConstraints)

	/**
	 * quick helper function to add labels
	 * @param String the label to add
	 * @param GridBagLayout the layout we use
	 * @param GridBagConstraints the constraints we're under
	 */
	private void label (String label, GridBagLayout gridbag, boolean is_end, GridBagConstraints constraints) {
		JPanel panel = new JPanel();
		JLabel jlabel = new JLabel(label, JLabel.CENTER);
		jlabel.setFont(FONT_DIALOG);
		jlabel.setForeground(Color.BLACK);
		jlabel.setBorder(noBorder);
		panel.setBackground(twiddlerBackground);
		panel.add(jlabel);
		if ( is_end ) {
			constraints.gridwidth = GridBagConstraints.REMAINDER;
		} else {
			constraints.gridwidth = 1;
		}
		gridbag.setConstraints(panel, constraints);
		add(panel);
	}// end label (String, GridBagLayout, GridBagConstraints)

	/**
	 * quick helper function to add buttons
	 * @param int the button number
	 * @param GridBagLayout the layout we're using
	 * @param GridBagConstraints the constraints we use
	 */
	private void button (int number, GridBagLayout gridbag, boolean is_end, GridBagConstraints constraints, String label) {
		JPanel panel = new JPanel();
		if( label != null ) {
			JLabel jlabel = new JLabel(label, JLabel.CENTER);
			jlabel.setFont(FONT_KEYPAD);
			jlabel.setForeground(Color.BLACK);
			panel.add(jlabel);
		}
                
		panel.setBackground(buttonBackground);
		panel.setBorder(buttonBorder);
		getButtons().setElementAt(panel, number);
		if ( is_end ) {
			constraints.gridwidth = GridBagConstraints.REMAINDER;
		} else {
			constraints.gridwidth = 1;
		}
		gridbag.setConstraints(panel, constraints);
		add(panel);
	}// end button (int, GridBagLayout, GridBagConstraints)

	/* --==<( TwiddlerSubPanel Requirement )>==-- */
	/**
	 * highlighting method, for highlighting a key
	 * @param int which key to highlight
	 * @param Color what color to use
	 */
	public void highlight (int which, Color color) {
		if (bDEBUG) System.out.println("ThumbPanel: highlighting button " + which);
		try {
			((JPanel)getButtons().elementAt(which)).setBackground(color);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			if (bDEBUG) System.out.println("ThumbPanel: array oob");
		}
	}// end highlight (int, Color)
	
	/* --==<( TwiddlerSubPanel Requirement )>==-- */
	/**
	 * clearing method, for restoring the button to it's default color
	 */
	public void clear () {
		if (bDEBUG) System.out.println("ThumbPanel: clearing buttons");
		for (int i = 0; i < getButtons().size(); i++) {
			((JPanel)getButtons().elementAt(i)).setBackground(buttonBackground);
		}
	}// end clear ()

}// end class THumbPanel
