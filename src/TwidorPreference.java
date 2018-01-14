/*  -*- indent-tabs-mode: t; tab-width: 4; c-basic-offset: 4 -*-
Twidor: the twiddler typing tutor.
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
 * TwidorPreferences.java, persist user selected options: keymap, lesson number, and view options.
 * </pre>
 * @author Carey Richard Murphey
 */
import java.io.*;
import java.util.prefs.Preferences;

public class TwidorPreference implements TwidorConstants {

	private Preferences pref;
	public boolean show_keyboard;
	public boolean show_SCC;
	public boolean show_MCC;
	public boolean show_key_labels;
	public boolean show_thumb_board;
	public boolean show_letters_only;
	public boolean thumb_left_to_right;
	public boolean fingerboard_left_to_right;
	public int lesson_number;
	public String keymap_filename;

	/**
	 * Default Constructor.
	 */
	public TwidorPreference ()
	{
		load();
	}

	public void load() {
		// Retrieve the user preference
		pref = Preferences.userNodeForPackage(Twidor.class);
		// pref.put(PREF_NAME, newValue);
		// String propertyValue = pref.get(PREF_NAME, defaultValue); // "a string"

		show_keyboard = pref.getBoolean(TWIDDLER_SHOW_KEYBOARD_TEXT, true);
		show_SCC = pref.getBoolean(TWIDDLER_SHOW_SCC_TEXT, false);
		show_MCC = pref.getBoolean(TWIDDLER_SHOW_MCC_TEXT, false);
		show_letters_only = pref.getBoolean(TWIDDLER_SHOW_LETTERS_ONLY_TEXT, true);

		show_key_labels = pref.getBoolean(TWIDDLER_SHOW_KEY_LABELS_TEXT, true);
		show_thumb_board = pref.getBoolean(TWIDDLER_SHOW_THUMB_BOARD_TEXT, true);

		fingerboard_left_to_right = pref.getBoolean(TWIDDLER_FINGERBOARD_LEFT_TO_RIGHT_TEXT, false);
		thumb_left_to_right = pref.getBoolean(TWIDDLER_THUMB_LEFT_TO_RIGHT_TEXT, false);
		lesson_number = pref.getInt(TWIDDLER_LESSON_NUMBER_TEXT, 1);
		keymap_filename = pref.get("keymap", DEFAULT_KEYMAP);
	}

	public void store()
	{
		pref.putBoolean(TWIDDLER_SHOW_KEYBOARD_TEXT, show_keyboard);
		pref.putBoolean(TWIDDLER_SHOW_SCC_TEXT, show_SCC);
		pref.putBoolean(TWIDDLER_SHOW_MCC_TEXT, show_MCC);
		pref.putBoolean(TWIDDLER_FINGERBOARD_LEFT_TO_RIGHT_TEXT, fingerboard_left_to_right);
		pref.putBoolean(TWIDDLER_SHOW_KEY_LABELS_TEXT, show_key_labels);
		pref.putBoolean(TWIDDLER_SHOW_THUMB_BOARD_TEXT, show_thumb_board);
		pref.putBoolean(TWIDDLER_THUMB_LEFT_TO_RIGHT_TEXT, thumb_left_to_right);
		pref.putInt(TWIDDLER_LESSON_NUMBER_TEXT, lesson_number);
		pref.put("keymap", keymap_filename);
	}
}
