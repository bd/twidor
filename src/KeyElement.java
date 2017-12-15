/*	-*- indent-tabs-mode: t; tab-width: 4; c-basic-offset: 4 -*-
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
 * KeyElement.java, a class for making matching keys to letters sooooooo much
 * easier.
 * 
 * Revisions:
 *		0.5	17 July 2003
 *		Completed Tutor
 *		0.2	06 June 2003
 *		Bugs Stomped. Final Version.
 *		0.1	23 May 2003
 *		Created class KeyElement
 * </pre>
 * @author <a href="mailto:visyz@cc.gatech.edu">James Fusia</a>
 * @version Version 0.5; 06 July 2003
 */
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

public class KeyElement extends java.lang.Object implements TwidorConstants {

	/**
	 * the button map and the letter we represent
	 */
	private String macro;		// unicode characters
	private int keycode;		// a USB HID Keyboard scan code
	private int buttons; // boolean keyboard and thumboard button status

	private static final Map<Integer,String> labelByKeycode;
	static {
		labelByKeycode = new HashMap<Integer,String>();
		labelByKeycode.put(KEYCODE_BACKSPACE,		"BS");
		labelByKeycode.put(KEYCODE_TAB,				"TAB");
		labelByKeycode.put(KEYCODE_ENTER,			"ENT");
		labelByKeycode.put(KEYCODE_LEFTSHIFT,		"SFT");
		labelByKeycode.put(KEYCODE_LEFTCTRL,		"CTL");
		labelByKeycode.put(KEYCODE_LEFTALT,			"ALT");
		labelByKeycode.put(KEYCODE_PAUSE,			"PAU");
		labelByKeycode.put(KEYCODE_CAPSLOCK,		"CLK");
		labelByKeycode.put(KEYCODE_ESC,				"ESC");
		labelByKeycode.put(KEYCODE_SPACE,			"SPC");
		labelByKeycode.put(KEYCODE_PAGEUP,			"PUP");
		labelByKeycode.put(KEYCODE_PAGEDOWN,		"PDN");
		labelByKeycode.put(KEYCODE_END,				"END");
		labelByKeycode.put(KEYCODE_HOME,			"HOM");
		labelByKeycode.put(KEYCODE_LEFT,			"LFT");
		labelByKeycode.put(KEYCODE_UP,				"UP");
		labelByKeycode.put(KEYCODE_RIGHT,			"RGT");
		labelByKeycode.put(KEYCODE_DOWN,			"DWN");
		labelByKeycode.put(KEYCODE_INSERT,			"INS");
		labelByKeycode.put(KEYCODE_DELETE,			"DEL");
		labelByKeycode.put(KEYCODE_LEFTMETA,		"CMD");
		labelByKeycode.put(KEYCODE_RIGHTMETA,		"RCM");
		labelByKeycode.put(KEYCODE_KPASTERISK,		"N*");
		labelByKeycode.put(KEYCODE_KPPLUS,			"N+");
		labelByKeycode.put(KEYCODE_KPMINUS,			"N-");
		labelByKeycode.put(KEYCODE_KPDOT,			"N.");
		labelByKeycode.put(KEYCODE_KPSLASH,			"N/");
		labelByKeycode.put(KEYCODE_KP1,				"N1");
		labelByKeycode.put(KEYCODE_KP2,				"N2");
		labelByKeycode.put(KEYCODE_KP3,				"N3");
		labelByKeycode.put(KEYCODE_KP4,				"N4");
		labelByKeycode.put(KEYCODE_KP5,				"N5");
		labelByKeycode.put(KEYCODE_KP6,				"N6");
		labelByKeycode.put(KEYCODE_KP7,				"N7");
		labelByKeycode.put(KEYCODE_KP8,				"N8");
		labelByKeycode.put(KEYCODE_KP9,				"N9");
		labelByKeycode.put(KEYCODE_KP0,				"N0");
		labelByKeycode.put(KEYCODE_NUMLOCK,			"NLK");
		labelByKeycode.put(KEYCODE_SCROLLLOCK,		"SLK");
		labelByKeycode.put(KEYCODE_F1,				"F1");
		labelByKeycode.put(KEYCODE_F2,				"F2");
		labelByKeycode.put(KEYCODE_F3,				"F3");
		labelByKeycode.put(KEYCODE_F4,				"F4");
		labelByKeycode.put(KEYCODE_F5,				"F5");
		labelByKeycode.put(KEYCODE_F6,				"F6");
		labelByKeycode.put(KEYCODE_F7,				"F7");
		labelByKeycode.put(KEYCODE_F8,				"F8");
		labelByKeycode.put(KEYCODE_F9,				"F9");
		labelByKeycode.put(KEYCODE_F10,				"F10");
		labelByKeycode.put(KEYCODE_F11,				"F11");
		labelByKeycode.put(KEYCODE_F12,				"F12");
	}

	private static final Map<String, String> labelByMacro;
	static {
		labelByMacro = new HashMap<String, String>();
		labelByMacro.put(String.valueOf(UNICODE_BACKSPACE),		"BS");
		labelByMacro.put(String.valueOf(UNICODE_SPACE),			"SP");
		labelByMacro.put(String.valueOf(UNICODE_DELETE),		"DEL");
		labelByMacro.put(String.valueOf(UNICODE_ENTER),			"ENT");
		labelByMacro.put(String.valueOf(UNICODE_RETURN),		"NL");
		labelByMacro.put(String.valueOf(UNICODE_TAB),			"TAB");
		labelByMacro.put(String.valueOf(UNICODE_ESCAPE),		"ESC");
	}

	/**
	 * default constructor
	 */
	public KeyElement () {
		buttons = 0;
		setKeycode(-1);
	}// end KeyElement

	/**
	 * default constructor
	 * @param String the letter/macro to set
	 */
	public KeyElement (String macro) {
		this();
		setMacro(macro);
	}// end KeyElement (String)

	/**
	 * default constructor
	 * @param int the integer value of the element
	 */
	public KeyElement (int keycode) {
		this();
		setKeycode(keycode);
	}// end KeyElement (int)


	/**
	 * set the letter or macro of this KeyElement.
	 * @param String the new letter/macro
	 */
	public void setMacro (String m) {
		macro = m;
		keycode = -1;
	}// end setMacro (string)

	/**
	 * set the letter or macro of this KeyElement.
	 * @param String the new letter/macro
	 */
	public String getMacro() {
		return  macro;
	}// end setMacro (string)

	/**
	 * modifier for the numeric value of this key
	 * @param int the value to set
	 */
	public void setKeycode (int k) {
		keycode = k;
		macro = null;
	}// end setKeycode (int)

	/**
	 * accessor for the numeric value of this key
	 * @return int the numeric value
	 */
	public int getKeycode () {
		return keycode;
	}// end getKeycode ()

	/**
	 * accessor for the value of this key
	 * @return char the character this keycode matches
	 */
	public String shortLabel () {
		if ( keycode != -1 ) {
			if ( labelByKeycode.containsKey( keycode ) )
				return labelByKeycode.get( keycode );
			return String.valueOf(keycode);
		}
		else if ( macro != null ) {
			if ( labelByMacro.containsKey( macro ))
				return labelByMacro.get( macro );
			return macro;
		}
		return "ERROR";
	}// end getChar ()

	/**
	 * get a specific button
	 * @param int the button to request
	 * @return boolean the status of the button
	 */
	public boolean getButton (int button_index) {
		return ((buttons & (1<<button_index)) != 0);
	}// end getButton (int)

	/**
	 * get a specific button
	 * @param int the button to request
	 */
	public void setButton (int button_index) {
		buttons |= (1<<button_index);
	}// end getButton (int)

	/**
	 * get a specific button
	 * @return int the bitmap of all buttons
	 */
	public int getButtons () {
		return buttons;
	}// end getButtons ()

	public static int createButtons (int button_index) {
		return (1<<button_index);
	}// end createButtons (int)

	public static String buttonsToString (int buttons) {
		String ret = "";
		if( (buttons & (1<<(THUMB_OFFSET + B_NUM))) != 0)
			ret += "N";
		else
			ret += " ";
		if( (buttons & (1<<(THUMB_OFFSET + B_ALT))) != 0) 
			ret += "A";
		else
			ret += " ";
		if( (buttons & (1<<(THUMB_OFFSET + B_CTRL))) != 0)
			ret += "C";
		else
			ret += " ";
		if( (buttons & (1<<(THUMB_OFFSET + B_SHIFT))) != 0)
			ret += "S";
		else
			ret += " ";
		ret += " ";

		for (int finger = 0; finger < 4; finger++) {
			if( (buttons & (1<<((finger * FINGER_OFFSET) + B_LEFT))) != 0) {
				ret += "L";					
			} else if( (buttons & (1<<((finger * FINGER_OFFSET) + B_MIDDLE))) != 0) {
				ret += "M";					
			} else if( (buttons & (1<<((finger * FINGER_OFFSET) + B_RIGHT))) != 0) {
				ret += "R";
			} else {
				ret += "O";
			}
		}
		return ret;
	}// end createButtons (int)

	public boolean match (int k, char m) {
		return match(k, String.valueOf(m));
	}
	public boolean match (int k, String m) {
		return ((keycode == k) || ((macro != null) && macro.equals(m)));
	}

	/**
	 * Function for returning this KeyElement in an easy-to-debug format
	 * @return String the text version of this KeyElement
	 */
	public String toString () {
		String ret = buttonsToString( buttons );
		ret += " ";
		ret += String.format("%4x", buttons );
		if (getKeycode() != -1) {
			ret += " keycode: ";
			if ( labelByKeycode.containsKey( keycode ) ){
				ret += labelByKeycode.get( keycode );
			} else {
				ret += getKeycode();
			}
		}
		if (getMacro() != null) {
			ret += " macro: ";
			if ( labelByMacro.containsKey( macro )) {
				ret += labelByMacro.get( macro );
			} else {
				ret += getMacro();
			}
		}
		return ret;
	}// end toString ()

}// end class KeyElement
