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
 * KeyMap.java, a class for loading and storing of a KeyMap from the
 * 'standard' Twiddler1 format.
 *
 * Revisions:
 * 		0.5	17 July 2003
 * 		Completed Tutor
 * 		0.2	06 June 2003
 * 		Need to implement keymap file parsing.
 *		0.1	23 May 2003
 * 		Created class KeyMap
 * </pre>
 * @author <a href="mailto:visyz@cc.gatech.edu">James Fusia</a>
 * @version Version 0.5; 17 July 2003
 */
import java.io.*;
import java.util.*;
public class KeyMap implements TwidorConstants {

	/**
	 * the keymap, as we see it. a Vector of KeyElements (buttons + map)
	 */
	private Vector <KeyElement> keylist;

	private static final HashMap<String, Character> unicodeByTag;
	static {
		unicodeByTag = new HashMap<String, Character>();
		unicodeByTag.put("<Backspace>",		UNICODE_BACKSPACE);
		unicodeByTag.put("<Tab>",			UNICODE_TAB);
		unicodeByTag.put("<Return>",		UNICODE_RETURN);
		unicodeByTag.put("<Enter>",			UNICODE_ENTER);
		unicodeByTag.put("<Delete>",		UNICODE_DELETE);
		unicodeByTag.put("<Escape>",		UNICODE_ESCAPE);
	}

	private static final HashMap<Character, String> labelByUnicode;
	static {
		labelByUnicode = new HashMap<Character, String>();
		labelByUnicode.put(UNICODE_BACKSPACE,	"BS");
		labelByUnicode.put(UNICODE_TAB,			"TAB");
		labelByUnicode.put(UNICODE_RETURN,		"RET");
		labelByUnicode.put(UNICODE_ENTER,		"ENT");
		labelByUnicode.put(UNICODE_DELETE,		"DEL");
		labelByUnicode.put(UNICODE_ESCAPE,		"ESC");
	}

	private static final HashMap<String, Integer> keycodeByTag;
	static {
		keycodeByTag = new HashMap<String, Integer>();
		keycodeByTag.put("<LeftArrow>",		KEYCODE_LEFT);
		keycodeByTag.put("<DownArrow>",		KEYCODE_DOWN);
		keycodeByTag.put("<RightArrow>",	KEYCODE_RIGHT);
		keycodeByTag.put("<UpArrow>",		KEYCODE_UP);
		keycodeByTag.put("<PageDown>",		KEYCODE_PAGEDOWN);
		keycodeByTag.put("<PageUp>",		KEYCODE_PAGEUP);
		keycodeByTag.put("<End>",			KEYCODE_END);
		keycodeByTag.put("<Home>",			KEYCODE_HOME);
		keycodeByTag.put("<Insert>",		KEYCODE_INSERT);
		keycodeByTag.put("<NumLock>",		KEYCODE_NUMLOCK);
		keycodeByTag.put("<CapsLock>",		KEYCODE_CAPSLOCK);
		keycodeByTag.put("<ScrollLock>",	KEYCODE_SCROLLLOCK);
		keycodeByTag.put("<F1>",			KEYCODE_F1);
		keycodeByTag.put("<F2>",			KEYCODE_F2);
		keycodeByTag.put("<F3>",			KEYCODE_F3);
		keycodeByTag.put("<F4>",			KEYCODE_F4);
		keycodeByTag.put("<F5>",			KEYCODE_F5);
		keycodeByTag.put("<F6>",			KEYCODE_F6);
		keycodeByTag.put("<F7>",			KEYCODE_F7);
		keycodeByTag.put("<F8>",			KEYCODE_F8);
		keycodeByTag.put("<F9>",			KEYCODE_F9);
		keycodeByTag.put("<F10>",			KEYCODE_F10);
		keycodeByTag.put("<F11>",			KEYCODE_F11);
		keycodeByTag.put("<F12>",			KEYCODE_F12);
	}

	// USB HID modifier masks

	private static final HashMap<String, Integer> modifierByTag;
	static {
		modifierByTag = new HashMap<String, Integer>();
		modifierByTag.put("<Left Ctrl>",		KEYMOD_LCTRL);
		modifierByTag.put("<Left Shift>",		KEYMOD_LSHIFT);
		modifierByTag.put("<Left Alt>",			KEYMOD_LALT);
		modifierByTag.put("<Left GUI>",			KEYMOD_LMETA);
		modifierByTag.put("<Ctrl>",				KEYMOD_LCTRL);
		modifierByTag.put("<Shift>",			KEYMOD_LSHIFT);
		modifierByTag.put("<Alt>",				KEYMOD_LALT);
		modifierByTag.put("<GUI>",				KEYMOD_LMETA);
		modifierByTag.put("<Right Ctrl>",		KEYMOD_RCTRL);
		modifierByTag.put("<Right Shift>",		KEYMOD_RSHIFT);
		modifierByTag.put("<Right Alt>",		KEYMOD_RALT);
		modifierByTag.put("<Right GUI>",		KEYMOD_RMETA);
	}
	

	/**
	 * default constructor
	 */
	private KeyMap () {
		keylist = new Vector <KeyElement> ();
	}

	/**
	 * default constructor
	 * @param String the file to read the keymap from
	 */
	public KeyMap (String source) {
		this();
		readKeyMap(source);
	}

	/**
	 * returns the index in the keymap of a given letter
	 * @param letter the keyboard letter of the given key
	 * @return the index of the letter in the keymap
	 */
	public KeyElement getKey (String macro) {
		for (KeyElement key : getKeylist()) {
			if ( key.match(0, macro) ) {
				return key;
			}
		}
		return null;
	}

	public KeyElement getKey (char c) {
		return getKey(String.valueOf(c));
	}

	public KeyElement getKey (int keycode, String macro, int mod) {
		for (KeyElement key : getKeylist()) {
			if ( key.match(keycode, macro, mod) ) {
				return key;
			}
		}
		return null;
	}

	/**
	 * returns the index in the keymap of a given letter
	 * @param letter the keyboard letter of the given key
	 * @return the index of the letter in the keymap
	 */
	public KeyElement getKey (int keycode) {
		for (KeyElement key : getKeylist()) {
			if ( key.getKeycode() == keycode ) {
				return key;
			}
		}
		return null;
	}

	/**
	 * Gets the Key matching the KeyElement button vector set
	 * @param Vector of KeyStatus to match against
	 * @return KeyElement the requested KeyElement
	 */
	public KeyElement getKeyByButtons (int buttons) {
		for (KeyElement key : getKeylist()) {
			if ( key.getButtons() == buttons ) {
				return key;
			}
		}
		return null;
	}

	/**
	 * Function for testing whether or not the KeyMap appears valid
	 * @return boolean the validity of the keymap
	 */
	public boolean appearsValid () {
		if (getKeylist().size() >= 26) {
			return true;
		}
		return false;
	}

	/**
	 * gets the internal keylist
	 * @return Vector the known keymap
	 */
	private Vector <KeyElement> getKeylist () {
		return keylist;
	}

	/**
	 * matches the largest chunk out of the given string to a keyelement
	 * in the keymap
	 * @param String sentence/phrase to match
	 * @return String the key that matches the most
	 */
	public KeyElement matchLargestChunk (String sentence) {
		KeyElement match = null;
		for (KeyElement key : getKeylist()) {
			String macro = key.getMacro();
			if ( (macro != null) && sentence.regionMatches(0, macro, 0, macro.length())) {
				if (match == null) {
					match = key;
				} else if (key.getMacro().length() > match.getMacro().length()) {
					match = key;
				}
			}
		}
		return match;
	}

	public KeyElement find (int k, String m, int mod) {
		for (KeyElement key : getKeylist()) {
			if(  key.match ( k, m, mod ) ) {
				return key;
			}
		}
		return null;
	}
	
	/**
	 * Adds the KeyElement to the KeyMap
	 * @param KeyElement the desired key to add
	 * @return boolean true if add succeded, false if add failed.
	 */
	public boolean addKey (KeyElement key) {
		return keylist.add(key);
	}

	/**
	 * sets the new keymap
	 * @param String the source file
	 */
	public void readKeyMap (String source) {
		FileReader frFile = null;
		InputStream iStream = null;
		InputStreamReader isReader = null;
		BufferedReader brBuffer = null;
		boolean finished = false;
		String temp;
		int test;

		if (bDEBUG) System.out.println("KeyMap: reading file " + source);
		// gotta open it
		try {
			frFile = new FileReader(source);
			brBuffer = new BufferedReader(frFile);
		} catch (FileNotFoundException e) {
			iStream = this.getClass().getResourceAsStream(source);
			if (iStream != null) {
				isReader = new InputStreamReader(iStream);
				brBuffer = new BufferedReader(isReader);
			} else {
				System.out.println("Could not load keymap. (" + source + " not found)");
				System.exit(1);
			}
		} catch (Exception e) {
		}
		try {
			while (brBuffer.ready()) {
				temp = brBuffer.readLine();
				temp = remove_comment(temp, "#");
				temp = remove_comment(temp, ";");
				temp = remove_comment(temp, "!");
				temp = remove_comment(temp, "//");
				/* Comments removed */
				test = temp.indexOf(',');
				if (test == -1) {
					if (bDEBUG) System.out.println("Discarding line (=)");
				}
				else {
					parseLine(temp);
				}
			}
		}
		catch (IOException e) {
			if (bDEBUG) System.out.println("KeyMap: IO Error while reading " + source);
		}
		catch (Exception e) {
			if (bDEBUG) System.out.println("KeyMap: General Error: " + source);
		}

		try {
			brBuffer.close();
			if (iStream == null) {
				frFile.close();
			} else {
				isReader.close();
				iStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (bDEBUG) {
			for (KeyElement key : getKeylist()) {
				System.out.println("map: " + key);
			}
		}
	}

	/**
	 * function to remove comments
	 * @param String the line to parse
	 * @param String the comment String
	 * @return String the string sans comment
	 */
	private String remove_comment (String toParse, String comment) {
		int test;
		if ((test = toParse.indexOf(comment)) != -1) {
			if (bDEBUG) System.out.println("Removing Comment (" + comment + ")");
			return toParse.substring(0,test);
		}
		return toParse;
	}

	/**
	 * function to quickly convert letters to their appropriate button
	 * @param char the character to look at
	 * @return int the value of this character
	 */
	private int finger_button (char columnCode) {
		switch (columnCode) {
		case 'L':	case 'l':
			return B_LEFT;
		case 'M':	case 'm':
			return B_MIDDLE;
		case 'R':	case 'r':
			return B_RIGHT;
		default:
			return -1;
		}
	}

	/**
	 * parses a keymap line and attempts to make a button/letter
	 * association out of it.
	 * @param String the string to parse
	 */
	private void parseLine(String line) {
	    String token;
	    int pos1, pos2;
	    KeyElement keyElement = new KeyElement();
	    

		String fields[] = line.split("\",\"", 2);
		if ( (fields.length != 2) ||
			 (fields[0].charAt(0) != '"') ||
			 (fields[1].indexOf('"') == -1) ||
			 (fields.length != 2) )
			{
				if (bDEBUG) {
					System.out.println("Not a valid entry");
				}
				return;
			}
		
		// line: "  NA RMOO","<Right Alt><Shift><UpArrow></Shift></Right Alt>"
		// chord:  NA RMOO
		String chord = fields[0].substring(1, fields[0].length());
		// keystrokes: <Right Alt><Shift><UpArrow></Shift></Right Alt>
		// Note: this ignores anything after the trailing double quote.
		String keystrokes = fields[1].substring(0, fields[1].lastIndexOf('"'));
		if( chord.compareTo("Chord") == 0 ) {
			return;
		}

		// modifiers:  NA
		String modifiers = chord.substring(0, 4);
		// keys:RMOO
		String keys = chord.substring(5, 9);

		if (modifiers.indexOf('N') > 0) {
			keyElement.setThumb(B_NUM);
		}
		if (modifiers.indexOf('A') > 0) {
			keyElement.setThumb(B_ALT);
		}
		if (modifiers.indexOf('C') > 0) {
			keyElement.setThumb(B_CTRL);
		}
		if (modifiers.indexOf('S') > 0) {
			keyElement.setThumb(B_SHIFT);
		}

		/* Finger Modifiers */
		for (int finger = 0; finger < 4; finger++) {
			int column = finger_button(keys.charAt(finger));
			if (column != -1) {
				keyElement.setFinger(finger, column);
			}
		}

		/* And what the chord produces */
		String macro = ""; // keystrokes after converting tags to ASCII characters
		int keycode = -1;
		int begin = 0;
		while( begin < keystrokes.length() ) {
			String rest = keystrokes.substring(begin);

			int tagEnd = keystrokes.indexOf('>', begin);
			int tagNext = keystrokes.indexOf('<', begin + 1);
			if( keystrokes.startsWith("<", begin) &&
				( tagEnd > begin ) &&
				( (tagNext < 0 ) || ( tagNext > tagEnd ) )
				) {
				String tag = keystrokes.substring(begin, tagEnd + 1);
				
				if( modifierByTag.containsKey( tag ) ) {
					keyElement.setModifier( modifierByTag.get( tag ));
				}
				else if( unicodeByTag.containsKey( tag ) ) {
					macro += unicodeByTag.get( tag );
				}
				else if ( keycodeByTag.containsKey( tag ) ) {
					keycode = keycodeByTag.get( tag );
				}
				begin = tagEnd + 1;
				continue;
			}

			// c = keystrokes.charAt(begin);
			// if( Character.isAlphabetic( c ) ) {
			// if( (keyElement.getButtons() & B_CTRL) != 0) {
			// 	if( c >= 'a' && c <= 'z' ) {
			// 		c = c - 'a' + 1;
			// 	}
			// 	else if( c >= 'A' && c <= 'Z' ) {
			// 		c = c - 'A' + 1;
			// 	}
			// }
			// else if( (keyElement.getButtons() & (B_ALT | B_GUI)) != 0) {
			// 	c |= 0x80;	// set the high bit
			// }

			macro += keystrokes.charAt(begin);
			begin += 1;
		}
		if( macro.length() > 0 ) {
			keyElement.setMacro(macro);
		} else if ( keycode != -1 ) {
			keyElement.setKeycode(keycode);
		} else {
			if (bDEBUG) System.out.println("invalid key: " + chord + "\t" + keystrokes);
		}
		if ( ! addKey(keyElement) && bDEBUG ) {
			System.out.println("duplicate key:" + chord + "\t" + keystrokes);
		}
	}

	/**
	 * debugging main
	 * @param String [] the arguments from the command line
	 */
	public static void main (String[] argv) {
		KeyMap test = new KeyMap(DEFAULT_KEYMAP);
		System.out.println(test.getKeylist().size());
		for (KeyElement key : test.getKeylist()) {
			System.out.println(key.toString());
		}

		System.out.println("getKey test");

		KeyElement check = test.getKey("a");
		if (check == null) {
			System.out.println("ERROR: key not found by macro: a");
			return;
		}
		System.out.println(check.toString());

		KeyElement doublecheck = test.getKey(check.getButtons());
		if (doublecheck == null) {
			System.out.println("ERROR: key not found by buttons: " + test);
			return;
		}
		System.out.println(doublecheck.toString());
	}

}
