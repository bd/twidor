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
 * TwidorConstants.java, the file where we make a whole bunch of silly things
 * static. Like Color. And Title. Bleh.
 * How dare you write Easily Maintained code!
 *
 * Revisions:
 *		0.5	17 July 2003
 *		Completed Tutor
 *		0.1	22 May 2003
 * 		Created interface TwidorConstants
 * </pre>
 * @author <a href="mailto:visyz@cc.gatech.edu">James Fusia</a>
 * @version Version 0.5; 17 July 2003
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public interface TwidorConstants {

	/**
	 * Debug Variable
	 */
	public static final boolean bDEBUG = false;

	/**
	 * Window Attributes
	 */
	public static final String windowTitle = "Twidor: The Twiddler Tutor!";
	public static final int windowX = 640;
	public static final int windowY = 400;
	public static final int twiddlerX = 120;
	public static final Color windowBackground = Color.white;
	public static final boolean windowResizable = true;

	/**
	 * button attributes
	 */
	public static final int buttonX = (twiddlerX - 30) / 6;
	public static final int buttonY = windowY * 2 / 15; // 2/3 of 1/4 of 4/5 of windowY
	public static final Color buttonBackground = Color.getHSBColor(0.f, 0.f, 0.95f); // light gray
	public static final Color buttonHighlight = Color.getHSBColor(0.16f, 1.0f, 1.0f); // light yellow
	public static final Color mccHighlight = Color.getHSBColor(0.8333f, 1.0f, 1.0f); // light yellow
	public static final Color twiddlerBackground = Color.getHSBColor(0.f, 0.f, 1.f); // dark grey

	public static final Color lightRed    = Color.getHSBColor(0.0000f, 1.f, .7f);
	public static final Color lightBlue   = Color.getHSBColor(0.6000f, 1.f, 1.f);
	public static final Color lightGreen  = Color.getHSBColor(0.3333f, 1.f, .7f);

	/**
	 * fonts
	 */
	public static final Font FONT_DIALOG = new Font("RobotoCondensed", Font.BOLD, 12);
	public static final Font FONT_KEYPAD = new Font("RobotoCondensed", Font.BOLD, 15);
	public static final Font FONT_TEXT = new Font("RobotoMono", Font.BOLD, 20);
	public static final Font FONT_LABEL = new Font("Roboto", Font.PLAIN, 20);

	/**
	 * character colors
	 */
	public static final Color TEXT_DEFAULT = Color.BLACK;
	public static final Color TEXT_ERROR = Color.getHSBColor(0.f, 1.f, .7f);
	public static final Color TEXT_GOOD = Color.getHSBColor(0.f, 0.f, .7f);
	public static final Color TEXT_BLINK = Color.BLUE;
	public static final Color TEXT_BACKGROUND = Color.WHITE;
	public static final Color TEXT_CURSOR = Color.BLUE;
	public static final String CURSOR = "_";

	public static Border noBorder = BorderFactory.createEmptyBorder(0,0,0,0);
	public static Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
	public static Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK, 1, true);

	/**
	 * Files that are searched for by the program when none are specified
	 */
	public static final String DEFAULT_KEYMAP = "keymap.txt";
	public static final String DEFAULT_LESSON = "lessons.txt";
	public static final boolean DEFAULT_THUMB_ORIENTATION = true;
	public static final boolean DEFAULT_FINGER_ORIENTATION = true;

	/**
	 * In-program settings
	 */
	/* Menu stuff: Twidor */
	public static final String QUIT_TEXT = "Quit";

	/* Tutor */
	public static final String HIGHLIGHT_HINT_TEXT = "Highlight Hint";
	public boolean HIGHLIGHT_HINT = true;
	public static final String HIGHLIGHT_KEYPRESS_TEXT = "Highlight Keypress";
	public boolean HIGHLIGHT_KEYPRESS = true;
	public static final String HIGHLIGHT_ERRORS_TEXT = "Highlight Errors";
	public boolean HIGHLIGHT_ERRORS = true;

	/* Twiddler */
	public static final String TWIDDLER_SHOW_TEXT = "Show Keyboard";
	public boolean TWIDDLER_SHOW = true;
	public static final String TWIDDLER_MIRROR_TEXT = "Horizontal Reverse Keyboard";
	public boolean TWIDDLER_MIRROR = false;
	public static final String TWIDDLER_SHOW_LETTERS_TEXT = "Show Labels on Keyboard";
	public boolean TWIDDLER_SHOW_LETTERS = true;
	public static final String TWIDDLER_SHOW_THUMB_TEXT = "Show Thumb Buttons";
	public boolean TWIDDLER_SHOW_THUMB = true;
	public static final String TWIDDLER_MIRROR_THUMB_TEXT = "Horizontal Reverse Thumb Buttons";
	public boolean TWIDDLER_MIRROR_THUMB = false;

	public static final String MACRO_REGEXP = "\"\\w*\"";

	/**
	 * For consistency when accessing the KeyElement button Vector.
	 */
	public static final int FINGER_OFFSET = 3;
	public static final int INDEX_OFFSET = 0;
	public static final int MIDDLE_OFFSET =  3;
	public static final int RING_OFFSET = 6;
	public static final int PINKY_OFFSET = 9;
	public static final int THUMB_OFFSET = 12;

	public static final int B_NUM = 0;
	public static final int B_ALT = 1;
	public static final int B_CTRL = 2;
	public static final int B_SHIFT = 3;

	public static final int B_LEFT = 0;
	public static final int B_MIDDLE = 1;
	public static final int B_RIGHT = 2;

	/**
	 * And because they might change...
	 */
	public static final int KEY_BACKSPACE = 8;
	public static final int KEY_TAB = 9;
	public static final int KEY_ENTER = 13;
	public static final int KEY_SPACE = 32;
	public static final int KEY_DELETE = 127;
	/* Note: keyboards emit 10 for enter key. */
	public static final int KEY_EOL = 10;

	public static final int C = 0;
	public static final int F = 1;
	public static final int IF = 2;
	public static final int INF = 3;

}// end interface TwidorConstants
