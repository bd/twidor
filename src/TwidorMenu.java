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
 * This class is here to automate the Menu switching and flipping
 * and flopping and other fish-like features.
 *
 * Revisions:
 *		0.5	17 July 2003
 *		Completed Tutor
 * 		0.1	17 June 2003
 * 		Created class TwidorMenu
 * </pre>
 * @author <a href="mailto:visyz@cc.gatech.edu">James Fusia</a>
 * @version Version 0.5; 17 July 2003
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class TwidorMenu extends JMenuBar implements TwidorConstants {

	/**
	 * internal variables
	 */
	EventHandler myEventHandler;
	Vector <JMenuItem> Tutor, Twiddler;
	ButtonGroup Lesson;
	Vector <JRadioButtonMenuItem> lessonButtons;

	/**
	 * default constructor
	 */
	private TwidorMenu () {
		if (bDEBUG) System.out.println("TwidorMenu: New MenuBar Created");
	}

	/**
	 * default constructor
	 */
	public TwidorMenu (TwidorPreference pref, EventHandler events, int lessonCount) {
		this();

		JMenu menu;
		JMenuItem jmItem;
		JCheckBoxMenuItem cbItem;
		JRadioButtonMenuItem rbItem;
		myEventHandler = events;

		menu = new JMenu("File");
		jmItem = jmenuItem(LOAD_KEYMAP_TEXT);
		menu.add(jmItem);
		jmItem = jmenuItem(LOAD_LESSON_TEXT);
		menu.add(jmItem);
		jmItem = jmenuItem(SAVE_KEYLOG_TEXT);
		menu.add(jmItem);
		jmItem = jmenuItem(QUIT_TEXT);
		menu.add(jmItem);
		add(menu);

		Twiddler = new Vector<>();
		menu = new JMenu("View");
		addJcheckItem( menu, Twiddler, TWIDDLER_SHOW_KEYBOARD_TEXT, pref.show_keyboard);
		addJcheckItem( menu, Twiddler, TWIDDLER_SHOW_KEY_LABELS_TEXT, pref.show_key_labels);
		addJcheckItem( menu, Twiddler, TWIDDLER_SHOW_THUMB_BOARD_TEXT, pref.show_thumb_board);
		addJcheckItem( menu, Twiddler, TWIDDLER_SHOW_SCC_TEXT, pref.show_SCC);
		addJcheckItem( menu, Twiddler, TWIDDLER_SHOW_MCC_TEXT, pref.show_MCC);
		addJcheckItem( menu, Twiddler, TWIDDLER_SHOW_LETTERS_ONLY_TEXT, pref.show_letters_only);
		addJcheckItem( menu, Twiddler, TWIDDLER_FINGERBOARD_LEFT_TO_RIGHT_TEXT, pref.fingerboard_left_to_right);
		addJcheckItem( menu, Twiddler, TWIDDLER_THUMB_LEFT_TO_RIGHT_TEXT, pref.thumb_left_to_right);

		add(menu);

		Lesson = new ButtonGroup();
		lessonButtons = new Vector<>();
		menu = new JMenu("Lessons");
		for (int i = 1; i <= lessonCount; i++) {
			rbItem = jradioItem("Lesson " + i, (i == pref.lesson_number));
			Lesson.add(rbItem);
			lessonButtons.add(rbItem);
			menu.add(rbItem);
		}
		add(menu);

		menu = new JMenu("Keymaps");
		for (int i = 0; i < KEYMAPS.length; i++) {
			jmItem = jmenuItem(KEYMAPS[i]);
			menu.add(jmItem);
		}
		add(menu);

		menu = new JMenu("Help");
		jmItem = jmenuItem("Documentation");
		menu.add(jmItem);
		jmItem = jmenuItem("About");
		menu.add(jmItem);
		add(menu);

		if (bDEBUG) System.out.println("TwidorMenu: Finished Creating");
	}

	/**
	 * helper function for creating menu items.
	 * @param String the text of the item
	 * @return JMenuItem the completed item.
	 */
	private JMenuItem jmenuItem (String text) {
		JMenuItem toReturn = new JMenuItem(text);
		toReturn.addActionListener(myEventHandler);
		return toReturn;
	}

	/**
	 * helper function for creating menu items.
	 * @param String the text of the item
	 * @param boolean the default value of the item
	 * @return JCheckBoxMenuItem the completed item
	 */
	private JCheckBoxMenuItem jcheckItem (String text, boolean status) {
		JCheckBoxMenuItem toReturn = new JCheckBoxMenuItem(text, status);
		toReturn.addItemListener(myEventHandler);
		return toReturn;
	}

	private void addJcheckItem (JMenu menu, Vector <JMenuItem> menuVec, String text, boolean status) {
		JMenuItem jmItem = jcheckItem(text, status);
		menuVec.add(jmItem);
		menu.add(jmItem);
	}

	/**
	 * helper function for creating radio menu items
	 * @param String the text of the item
	 * @param boolean the default value of the item
	 * @return JRadioButtonMenuItem the completed item
	 */
	private JRadioButtonMenuItem jradioItem (String text, boolean status) {
		JRadioButtonMenuItem toReturn = new JRadioButtonMenuItem(text, status);
		toReturn.setActionCommand(text);
		toReturn.setSelected(status);
		toReturn.addActionListener(myEventHandler);
		return toReturn;
	}

	public void makeSelectedLesson (String lesson) {
		JRadioButtonMenuItem temp;
		for (int i = 0; i < lessonButtons.size(); i++) {
			temp = (JRadioButtonMenuItem)lessonButtons.elementAt(i);
			if (temp.getActionCommand().equals(lesson)) {
				temp.doClick();
				return;
			}
		}
	}
}
