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
	public static final Color buttonHighlight = Color.getHSBColor(0.3333f, .3f, 1.0f); // light yellow
	public static final Color mccHighlight = Color.getHSBColor(0.3333f, .3f, 1.0f); // light yellow
	public static final Color twiddlerBackground = Color.getHSBColor(0.f, 0.f, 1.f); // dark grey

	public static final Color keyRed    	= Color.getHSBColor(0.0000f, 1.f, .7f);
	public static final Color keyBlue   	= Color.getHSBColor(0.6000f, 1.f, 1.f);
	public static final Color keyGreen  	= Color.getHSBColor(0.3333f, 1.f, .7f);
	public static Border thickRedBorder 	= BorderFactory.createLineBorder(keyRed, 2, true);
	public static Border thickBlueBorder 	= BorderFactory.createLineBorder(keyBlue, 2, true);
	public static Border thickGreenBorder 	= BorderFactory.createLineBorder(keyGreen, 2, true);
	public static Border redBorder	 	= BorderFactory.createLineBorder(keyRed, 1, true);
	public static Border blueBorder 	= BorderFactory.createLineBorder(keyBlue, 1, true);
	public static Border greenBorder 	= BorderFactory.createLineBorder(keyGreen, 1, true);

	/**
	 * fonts
	 */
	public static final Font FONT_DIALOG 	= new Font("RobotoCondensed", Font.BOLD, 12);
	public static final Font FONT_MACRO 	= new Font("RobotoCondensed", Font.BOLD, 12);
	public static final Font FONT_KEYPAD 	= new Font("RobotoCondensed", Font.BOLD, 15);
	public static final Font FONT_LABEL2 	= new Font("RobotoCondensed", Font.BOLD, 17);
	public static final Font FONT_TEXT	 	= new Font("Roboto", Font.PLAIN, 20);
	public static final Font FONT_LABEL 	= new Font("Roboto", Font.PLAIN, 22);

	/**
	 * character colors
	 */
	public static final Color TEXT_DEFAULT 		= Color.BLACK;
	public static final Color TEXT_ERROR 		= Color.getHSBColor(0.f, 1.f, .7f);
	public static final Color TEXT_GOOD 		= Color.getHSBColor(0.f, 0.f, .7f);
	public static final Color TEXT_HIGHLIGHT	= Color.getHSBColor(0.3333f, 1.f, .7f);
	public static final Color TEXT_BLINK 		= Color.BLUE;
	public static final Color TEXT_BACKGROUND 	= Color.WHITE;

	public static Border noBorder	 	= BorderFactory.createEmptyBorder(0,0,0,0);
	public static Border margin 		= BorderFactory.createEmptyBorder(0,3,3,3);
	public static Border lineBorder 	= BorderFactory.createLineBorder(Color.BLACK);
	public static Border buttonBorder 	= BorderFactory.createLineBorder(Color.BLACK, 1, true);

	// Kemap menu items. Filename is <name>.csv.
	public static final String[] KEYMAPS = new String[]{
		"Backspice",
		"Default_V5",
		"TabSpace",
		"Typemax"};

	/**
	 * Files that are searched for by the program when none are specified
	 */
	public static final String DEFAULT_KEYMAP = KEYMAPS[0] + ".csv";
	public static final String DEFAULT_LESSON = "lessons.txt";
	public static final boolean DEFAULT_THUMB_ORIENTATION = true;
	public static final boolean DEFAULT_FINGER_ORIENTATION = true;

	/**
	 * In-program settings
	 */
	/* Menu stuff: Twidor */
	public static final String LOAD_KEYMAP_TEXT = "Load CSV Keymap";
	public static final String LOAD_LESSON_TEXT = "Load Lesson";
	public static final String SAVE_KEYLOG_TEXT = "Save Keylog File";
	public static final String QUIT_TEXT = "Quit";

	/* Twiddler */
	public static final String TWIDDLER_SHOW_TEXT = "Show Key Map";
	public boolean TWIDDLER_SHOW = true;
	public static final String TWIDDLER_SHOW_2KEY_TEXT = "Show chords";
	public boolean TWIDDLER_SHOW_2KEY = false;
	public static final String TWIDDLER_LIMIT_1KEY_TEXT = "Single letters only";
	public boolean TWIDDLER_LIMIT_1KEY = true;
	public static final String TWIDDLER_LIMIT_2KEY_TEXT = "Double letters only";
	public boolean TWIDDLER_LIMIT_2KEY = false;

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
	public static final int BUTTONS_MAX = 19;
	public static final int FINGER_OFFSET = 3;
	public static final int INDEX_OFFSET = 0;
	public static final int MIDDLE_OFFSET =  3;
	public static final int RING_OFFSET = 6;
	public static final int PINKY_OFFSET = 9;
	public static final int THUMB_OFFSET = 12;
	public static final int MOUSE_OFFSET = 16;

	// thumb buttons
	public static final int B_NUM	= 0;
	public static final int B_ALT	= 1;
	public static final int B_CTRL	= 2;
	public static final int B_SHIFT	= 3;

	public static final int B_LEFT = 0;
	public static final int B_MIDDLE = 1;
	public static final int B_RIGHT = 2;

	// certain unicode characters
	public static final char UNICODE_BACKSPACE	= 8;
	public static final char UNICODE_TAB		= 9;
	public static final char UNICODE_RETURN		= 10;
	public static final char UNICODE_ENTER		= 13;
	public static final char UNICODE_SPACE		= 32;
	public static final char UNICODE_ESCAPE		= 27;
	public static final char UNICODE_DELETE		= 127;
	
	/**
	 * USB HID Keyboard scan codes
	 * See https://gist.github.com/MightyPork/6da26e382a7ad91b5496ee55fdc73db2
	 */

	public static final int KEYCODE_ENTER		= 0x28; // Keyboard Return (ENTER)
	public static final int KEYCODE_ESC			= 0x29; // Keyboard ESCAPE
	public static final int KEYCODE_BACKSPACE	= 0x2a; // Keyboard DELETE (Backspace)
	public static final int KEYCODE_TAB			= 0x2b; // Keyboard Tab
	public static final int KEYCODE_SPACE		= 0x2c; // Keyboard Spacebar
	public static final int KEYCODE_MINUS		= 0x2d; // Keyboard - and _
	public static final int KEYCODE_EQUAL		= 0x2e; // Keyboard = and +
	public static final int KEYCODE_LEFTBRACE	= 0x2f; // Keyboard [ and {
	public static final int KEYCODE_RIGHTBRACE	= 0x30; // Keyboard ] and }
	public static final int KEYCODE_BACKSLASH	= 0x31; // Keyboard \ and |
	public static final int KEYCODE_HASHTILDE	= 0x32; // Keyboard Non-US # and ~
	public static final int KEYCODE_SEMICOLON	= 0x33; // Keyboard ; and :
	public static final int KEYCODE_APOSTROPHE	= 0x34; // Keyboard ' and "
	public static final int KEYCODE_GRAVE		= 0x35; // Keyboard ` and ~
	public static final int KEYCODE_COMMA		= 0x36; // Keyboard , and <
	public static final int KEYCODE_DOT			= 0x37; // Keyboard . and >
	public static final int KEYCODE_SLASH		= 0x38; // Keyboard / and ?
	public static final int KEYCODE_CAPSLOCK	= 0x39; // Keyboard Caps Lock
	public static final int KEYCODE_SCROLLLOCK	= 0x47; // Keyboard Scroll Lock
	public static final int KEYCODE_PAUSE		= 0x48; // Keyboard Pause
	public static final int KEYCODE_INSERT		= 0x49; // Keyboard Insert
	public static final int KEYCODE_HOME		= 0x4a; // Keyboard Home
	public static final int KEYCODE_PAGEUP		= 0x4b; // Keyboard Page Up
	public static final int KEYCODE_DELETE		= 0x4c; // Keyboard Delete Forward
	public static final int KEYCODE_END			= 0x4d; // Keyboard End
	public static final int KEYCODE_PAGEDOWN	= 0x4e; // Keyboard Page Down
	public static final int KEYCODE_RIGHT		= 0x4f; // Keyboard Right Arrow
	public static final int KEYCODE_LEFT		= 0x50; // Keyboard Left Arrow
	public static final int KEYCODE_DOWN		= 0x51; // Keyboard Down Arrow
	public static final int KEYCODE_UP			= 0x52; // Keyboard Up Arrow
	public static final int KEYCODE_NUMLOCK		= 0x53; // Keyboard Num Lock and Clear
	public static final int KEYCODE_KPSLASH		= 0x54; // Keypad /
	public static final int KEYCODE_KPASTERISK	= 0x55; // Keypad *
	public static final int KEYCODE_KPMINUS		= 0x56; // Keypad -
	public static final int KEYCODE_KPPLUS		= 0x57; // Keypad +
	public static final int KEYCODE_KPENTER		= 0x58; // Keypad ENTER
	public static final int KEYCODE_KP1			= 0x59; // Keypad 1 and End
	public static final int KEYCODE_KP2			= 0x5a; // Keypad 2 and Down Arrow
	public static final int KEYCODE_KP3			= 0x5b; // Keypad 3 and PageDn
	public static final int KEYCODE_KP4			= 0x5c; // Keypad 4 and Left Arrow
	public static final int KEYCODE_KP5			= 0x5d; // Keypad 5
	public static final int KEYCODE_KP6			= 0x5e; // Keypad 6 and Right Arrow
	public static final int KEYCODE_KP7			= 0x5f; // Keypad 7 and Home
	public static final int KEYCODE_KP8			= 0x60; // Keypad 8 and Up Arrow
	public static final int KEYCODE_KP9			= 0x61; // Keypad 9 and Page Up
	public static final int KEYCODE_KP0			= 0x62; // Keypad 0 and Insert
	public static final int KEYCODE_KPDOT		= 0x63; // Keypad . and Delete
	public static final int KEYCODE_F1			= 0x3a; // Keyboard F1
	public static final int KEYCODE_F2			= 0x3b; // Keyboard F2
	public static final int KEYCODE_F3			= 0x3c; // Keyboard F3
	public static final int KEYCODE_F4			= 0x3d; // Keyboard F4
	public static final int KEYCODE_F5			= 0x3e; // Keyboard F5
	public static final int KEYCODE_F6			= 0x3f; // Keyboard F6
	public static final int KEYCODE_F7			= 0x40; // Keyboard F7
	public static final int KEYCODE_F8			= 0x41; // Keyboard F8
	public static final int KEYCODE_F9			= 0x42; // Keyboard F9
	public static final int KEYCODE_F10			= 0x43; // Keyboard F10
	public static final int KEYCODE_F11			= 0x44; // Keyboard F11
	public static final int KEYCODE_F12			= 0x45; // Keyboard F12
	public static final int KEYCODE_F13			= 0x68; // Keyboard F13
	public static final int KEYCODE_F14			= 0x69; // Keyboard F14
	public static final int KEYCODE_F15			= 0x6a; // Keyboard F15
	public static final int KEYCODE_F16			= 0x6b; // Keyboard F16
	public static final int KEYCODE_F17			= 0x6c; // Keyboard F17
	public static final int KEYCODE_F18			= 0x6d; // Keyboard F18
	public static final int KEYCODE_F19			= 0x6e; // Keyboard F19
	public static final int KEYCODE_F20			= 0x6f; // Keyboard F20
	public static final int KEYCODE_F21			= 0x70; // Keyboard F21
	public static final int KEYCODE_F22			= 0x71; // Keyboard F22
	public static final int KEYCODE_F23			= 0x72; // Keyboard F23
	public static final int KEYCODE_F24			= 0x73; // Keyboard F24
	public static final int KEYCODE_OPEN		= 0x74; // Keyboard Execute
	public static final int KEYCODE_HELP		= 0x75; // Keyboard Help
	public static final int KEYCODE_PROPS		= 0x76; // Keyboard Menu
	public static final int KEYCODE_FRONT		= 0x77; // Keyboard Select
	public static final int KEYCODE_STOP		= 0x78; // Keyboard Stop
	public static final int KEYCODE_AGAIN		= 0x79; // Keyboard Again
	public static final int KEYCODE_UNDO		= 0x7a; // Keyboard Undo
	public static final int KEYCODE_CUT			= 0x7b; // Keyboard Cut
	public static final int KEYCODE_COPY		= 0x7c; // Keyboard Copy
	public static final int KEYCODE_PASTE		= 0x7d; // Keyboard Paste
	public static final int KEYCODE_FIND		= 0x7e; // Keyboard Find
	public static final int KEYCODE_MUTE		= 0x7f; // Keyboard Mute
	public static final int KEYCODE_VOLUMEUP	= 0x80; // Keyboard Volume Up
	public static final int KEYCODE_VOLUMEDOWN	= 0x81; // Keyboard Volume Down
	public static final int KEYCODE_LEFTCTRL	= 0xe0; // Keyboard Left Control
	public static final int KEYCODE_LEFTSHIFT	= 0xe1; // Keyboard Left Shift
	public static final int KEYCODE_LEFTALT		= 0xe2; // Keyboard Left Alt
	public static final int KEYCODE_LEFTMETA	= 0xe3; // Keyboard Left GUI
	public static final int KEYCODE_RIGHTCTRL	= 0xe4; // Keyboard Right Control
	public static final int KEYCODE_RIGHTSHIFT	= 0xe5; // Keyboard Right Shift
	public static final int KEYCODE_RIGHTALT	= 0xe6; // Keyboard Right Alt
	public static final int KEYCODE_RIGHTMETA	= 0xe7; // Keyboard Right GUI

	public static final int KEYMOD_LCTRL		= 0x01;
	public static final int KEYMOD_LSHIFT		= 0x02;
	public static final int KEYMOD_LALT			= 0x04;
	public static final int KEYMOD_LMETA		= 0x08; // GUI
	public static final int KEYMOD_RCTRL		= 0x10;
	public static final int KEYMOD_RSHIFT		= 0x20;
	public static final int KEYMOD_RALT			= 0x40;
	public static final int KEYMOD_RMETA		= 0x80;

	// etc
	public static final int C = 0;
	public static final int F = 1;
	public static final int IF = 2;
	public static final int INF = 3;

}
