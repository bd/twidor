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
 * TypingPanel.java, because I figured "Everything else has it's own class,
 * why not this one, too!".
 *
 * Revisions:
 *		0.5	17 July 2003
 *		Completed Tutor
 * 		0.1	10 June 2003
 * 		Created class TypingPanel
 * </pre>
 * @author <a href="mailto:visyz@cc.gatech.edu">James Fusia</a>
 * @version Version 0.5; 17 July 2003
 */
import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import java.lang.String;
import java.lang.Math;
/**
 * @author rich
 *
 */
public class TypingPanel extends TwiddlerSubPanel implements TwidorConstants {

	/**
	 * internal variables
	 */
	Vector <JLabel> lessonTextLabels;
	Vector <JLabel> enteredTextLabels;
	String sentenceText;

	Vector Typed;           // characters typed by user
	int current;            // cursor on typed text
	int highlight_len;		// length of highlighted text
	boolean finished;
	int min_display_length = 40;
	JTable table;
	/**
	 * default constructor
	 */
	public TypingPanel () {
		enteredTextLabels = new Vector <JLabel> ();
		lessonTextLabels = new Vector <JLabel> ();
		String sentenceText = "";
		Typed = new Vector();
		setCurrent(0);
		setEntered(false);
		setBackground(TEXT_BACKGROUND);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(margin);
		setVisible(true);
		if (bDEBUG) System.out.println("TypingPanel: Created New Panel");
	}

	/**
	 * Modifier for the current JLabel in the typing panel
	 * @param int the new value to use as 'current'
	 */
	public void setCurrent (int thing) {
		if (thing <= 0) {
			current = 0;
		}
		else {
			current = thing;
		}
	}

	/**
	 * Private function to determine some whacky stupid things
	 * @param boolean the new value to set
	 */
	private void setEntered (boolean value) {
		finished = value;
	}

	/**
	 * Accessor for the current JLabel in the typing panel
	 * @return int the value of the current JLabel
	 */
	public int getCurrent () {
		return current;
	}

	/**
	 * Accessor for the finished variable
	 * @return boolean the finished variable
	 */
	private boolean getEntered () {
		return finished;
	}

	public String getSentenceText() {
		return sentenceText;
	}

	private void setSentenceText(String sentenceText) {
		this.sentenceText = sentenceText;
	}
	/**
	 * Called when we want to display a message
	 */
	public void displayMessage (String message) {
		setVisible(false);
		removeAll();
		JLabel myMessage = new JLabel(message);
		JPanel temp = new JPanel();
		temp.setAlignmentY(Component.CENTER_ALIGNMENT);
		temp.add(myMessage);
		temp.setBackground(TEXT_BACKGROUND);
		add(temp);
		setBackground(TEXT_BACKGROUND);
		setVisible(true);
	}

	public void displaySentence (String sentence) {
		setVisible(false);
		setSentenceText(sentence);
		enteredTextLabels.clear();
		Typed.clear();
		setCurrent(0);
		setEntered(false);
		removeAll();
		if (sentence == null) {
			return;
		}

		lessonTextLabels.clear();
		JPanel sentence_panel = new JPanel();
		sentence_panel.setAlignmentY(CENTER_ALIGNMENT);
		sentence_panel.setFont(FONT_TEXT);
		sentence_panel.setBackground(TEXT_BACKGROUND);
		FlowLayout layout = (FlowLayout)sentence_panel.getLayout();
		layout.setHgap(0);
		for (int i = 0; i < sentence.length(); i++) {
			JPanel subPanel = new JPanel();
			subPanel.setLayout(new GridLayout(2, 1));
			subPanel.setBorder(noBorder);
			subPanel.setBackground(TEXT_BACKGROUND);
			String letter = String.valueOf(sentence.charAt(i));
			JLabel jlabel = new JLabel(letter, javax.swing.SwingConstants.CENTER);
			jlabel.setBorder(noBorder);
			jlabel.setFont(FONT_TEXT);
			jlabel.setBackground(TEXT_BACKGROUND);
			lessonTextLabels.add( jlabel );
			subPanel.add( jlabel );
			jlabel = new JLabel("", javax.swing.SwingConstants.CENTER);
			jlabel.setFont(FONT_TEXT);
			jlabel.setBackground(TEXT_BACKGROUND);
			subPanel.add( jlabel );
			enteredTextLabels.add( jlabel );
			sentence_panel.add( subPanel );
		}
		add(sentence_panel);
                validate();
		setVisible(true);
	}
	public void highlight (KeyElement key) {
		if (getCurrent() < 0) {
			setCurrent(0);
		}
		highlight_len = key.getMacro().length();
		for( int i = getCurrent(); i < Math.min(lessonTextLabels.size(), getCurrent() + highlight_len); i++ ) {
			JLabel label = lessonTextLabels.elementAt(i);
			label.setForeground(TEXT_HIGHLIGHT);
		}
	}
	public void remove_highlight () {
		if (getCurrent() < 0) {
			setCurrent(0);
		}
		for( int i = getCurrent(); i < Math.min(lessonTextLabels.size(), getCurrent() + highlight_len); i++ ) {
			JLabel label = lessonTextLabels.elementAt(i);
			label.setForeground(TEXT_DEFAULT);
		}
	}

	public void charTyped (KeyElement typed) {
		if (getCurrent() < 0) {
			setCurrent(0);
		}
		remove_highlight();
		if (typed.match(KEYCODE_BACKSPACE, UNICODE_BACKSPACE) ||
			typed.match(KEYCODE_DELETE, UNICODE_DELETE)
			) {
			setCurrent(getCurrent() - 1);
			JLabel label = enteredTextLabels.elementAt(getCurrent());
			label.setForeground(TEXT_DEFAULT);
			label.setText("");
			return;
		}
		setVisible(false);
		if (typed.match(KEYCODE_ENTER, "\n") ||
			typed.match(KEYCODE_ENTER, "\r")
			) {
			/* Enter only matters if we're allowing errors and the sentence is finished */
			if (getCurrent() >= getSentenceText().length()) {
				setEntered(true);
			}
		} 
		else if (getCurrent() < getSentenceText().length()) {
			/* Treat it like a normal character */
			JLabel label = enteredTextLabels.elementAt(getCurrent());
			label.setForeground(TEXT_DEFAULT);
			String text = typed.getMacro();
			if( typed.getThumb(B_SHIFT) && Character.isLowerCase(text.charAt(0)))
				text = text.toUpperCase();
			label.setText(text);
			String toMatch = sentenceText.substring(getCurrent());
			if (toMatch.startsWith(typed.getMacro())) {
				label.setForeground(TEXT_GOOD);
			} else {
				label.setForeground(TEXT_ERROR);
			}
			setCurrent(getCurrent() + 1);
		}
		setVisible(true);
	}

	/**
	 * Called to check and see if the sentence is complete
	 */
	public boolean sentenceComplete () {
		return getEntered();
		// return (getCurrent() >= getSentenceText().length());
	}

}
