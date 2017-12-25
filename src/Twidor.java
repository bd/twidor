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
 * Twidor.java, the GUI of the program. Get Lots of glue, and a couple rolls
 * of ducttape.
 *
 * Revisions:
 *		0.5	17 July 2003
 *		Completed Tutor
 * 		0.1	22 May 2003
 * 			Created class Twidor
 * </pre>
 * @author <a href="mailto:visyz@cc.gatech.edu">James Fusia</a>
 * @version Version 0.5; 17 July 2003
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.io.*;
import java.awt.Font;
import java.util.Properties;
import java.util.prefs.Preferences;

public class Twidor extends JFrame implements TwidorConstants {

	/**
	 * internal variables
	 */
	private EventHandler myEventHandler;
	private TwidorMenu myMenuBar;
	private TwiddlerPanel myTwiddler;
	private TypingPanel myTypingPanel;
	private StatsPanel myStatsPanel;
	private InfoPanel myInfoPanel;
	private KeyMap myKeyMap;
	private boolean acceptInput; 
	private boolean showStats;
	private LessonParser myLessonPlan;
	private Lesson currentLesson;
	private String currentSentence;
	private JFileChooser fc;
	private java.io.PrintWriter keylog;
	private TwidorPreference pref;

	static public Properties prop;

	/**
	 * Default Constructor.
	 */
	public Twidor () {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("RobotoMono-Bold.ttf")));
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("RobotoMono-Light.ttf")));
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("RobotoMono-Regular.ttf")));
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("RobotoCondensed-Bold.ttf")));
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("Roboto-Regular.ttf")));
		} catch(IOException e) {
			e.printStackTrace();
		} catch(FontFormatException e) {
			e.printStackTrace();
		}

		prop = new Properties();
		InputStream input = null;
		try {
			input = this.getClass().getResourceAsStream("Twidor.properties");
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// Retrieve the user preference
		pref = new TwidorPreference();

		ignoreInput(true);
		showingStats(false);
		/* JFrame Settings */
		setMinimumSize(new Dimension(windowX, windowY));
		setTitle(windowTitle);
		setBackground(windowBackground);
		setResizable(windowResizable);

		/* Root Panel Settings */
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		setEventHandler();
		setKeyMap(pref.keymap_filename);
		setLessonPlan(DEFAULT_LESSON);
		setTwidorMenu();
		setTwiddlerPanel();
		setTypingPanel();
		setStatsPanel();
		setInfoPanel();
		setTwidorIcon();

		contentPane.add(getTwiddlerPanel(), BorderLayout.WEST);

		JPanel CenterPane = new JPanel();
		CenterPane.setLayout(new GridLayout(0, 1));
		CenterPane.add(getInfoPanel());
		CenterPane.add(getTypingPanel());
		CenterPane.add(getStatsPanel());
		CenterPane.setBackground(TEXT_BACKGROUND);
		CenterPane.setVisible(true);

		contentPane.add(CenterPane, BorderLayout.CENTER);
		pack();
		/* Show it all */
		setVisible(true);
		setLesson("Lesson " + String.valueOf(pref.lesson_number));
		ignoreInput(false);
		fc = new JFileChooser("."); // this retains user's choice of directory across 'Load' menu invocations
	}

// EventHandler stuff
	/**
	 * Sets the EventHandler for the System
	 */
	private void setEventHandler() {
		myEventHandler = new EventHandler(this);
		addWindowListener(myEventHandler);
		addKeyListener(myEventHandler);
	}

	/**
	 * Accessor for the EventHandler
	 * @return EventHandler for the system
	 */
	private EventHandler getEventHandler () {
		return myEventHandler;
	}

// KeyMap stuff
	/**
	 * Sets the Keymap for the system
	 * @param String the path of the keymap file
	 */
	private void setKeyMap (String path) {
		pref.keymap_filename = path;
		myKeyMap = new KeyMap(path);
		if (myKeyMap.appearsValid()) {
			if (bDEBUG) System.out.println("Keymap Loaded");
		}
		else {
			if (bDEBUG) System.out.println("Keymap Loading Failed");
		}
	}

	private void setKeylog (File file) {
		try {
			keylog = new java.io.PrintWriter(new java.io.FileOutputStream( file, true /* append = true */)); 
		} catch (FileNotFoundException e) {
			System.out.println("Could not save keylog. " + file + " not found.");
		}
	}

	/**
	 * Accessor for the KeyMap
	 * @return KeyMap the current keymap
	 */
	private KeyMap getKeyMap () {
		return myKeyMap;
	}

// TwidorMenu stuff
	/**
	 * Sets the JMenuBar for the options
	 */
	private void setTwidorMenu () {
		myMenuBar = new TwidorMenu(pref, getEventHandler(), getLessonPlan().getLessonCount());
		setJMenuBar(myMenuBar);
	}

	/**
	 * Accessor for the TwidorMenu
	 * @return TwidorMenu the system's menubar
	 */
	private TwidorMenu getTwidorMenu () {
		return myMenuBar;
	}

// TwiddlerPanel stuff
	/**
	 * Sets the TwiddlerPanel for the system
	 * @param boolean the Thumb Orientation
	 * @param boolean the Finger Orientation
	 */
	private void setTwiddlerPanel ()
	{
		if (bDEBUG) System.out.println("Adding TwiddlerPanel");
		myTwiddler = new TwiddlerPanel(getKeyMap(), pref );
	}

	/**
	 * Accessor for the TwiddlerPanel
	 * @return TwiddlerPanel the TwiddlerPanel
	 */
	private TwiddlerPanel getTwiddlerPanel () {
		return myTwiddler;
	}

// TypingPanel stuff
	/**
	 * Sets the TypingPanel up
	 */
	private void setTypingPanel () {
		if (bDEBUG) System.out.println("Adding TypingPanel");
		myTypingPanel = new TypingPanel();
	}

	/**
	 * Accessor for the TypingPanel
	 * @return TypingPanel the typing panel
	 */
	private TypingPanel getTypingPanel () {
		return myTypingPanel;
	}

// StatsPanel stuff
	/**
	 * Set up the StatsPanel
	 */
	private void setStatsPanel () {
		if (bDEBUG) System.out.println("Adding StatsPanel");
		myStatsPanel = new StatsPanel();
	}

	/**
	 * Accessor for the StatsPanel
	 * @return StatsPanel the stats panel
	 */
	private StatsPanel getStatsPanel () {
		return myStatsPanel;
	}

// InfoPanel stuff
	/**
	 * Set up the InfoPanel
	 */
	private void setInfoPanel () {
		if (bDEBUG) System.out.println("Adding InfoPanel");
		myInfoPanel = new InfoPanel();
	}

	/**
	 * Accessor for the InfoPanel
	 * @return InfoPanel the panel
	 */
	private InfoPanel getInfoPanel () {
		return myInfoPanel;
	}

// Twidor Icon stuff
	/**
	 * Load the ImageIcon from a file. Whee.
	 */
	private void setTwidorIcon () {
		URL location = this.getClass().getResource("icon.gif");
		ImageIcon temp = new ImageIcon(location);
		setIconImage(temp.getImage());
	}

// LessonParser stuff
	/**
	 * Loads the Lesson Parser and parses the lesson file
	 * @param String the source file the lesson parser should use
	 */
	private void setLessonPlan (String source) {
		myLessonPlan = new LessonParser(source);
	}

	/**
	 * Accessor for the Lessons system
	 * @return LessonParser the lessons
	 */
	private LessonParser getLessonPlan () {
		return myLessonPlan;
	}

// Lesson stuff
	/**
	 * Sets the current lesson from the set of lessons
	 * @param String the name of the lesson to set
	 */
	private void setLesson (String lesson) {
		LessonParser lpTemp = getLessonPlan();
		Lesson lTemp;
		for (int i = 0; i < lpTemp.getLessonCount(); i++) {
			lTemp = lpTemp.getLesson(i);
			if (lTemp.getLessonName().equals(lesson)) {
				pref.lesson_number = i + 1;
				currentLesson = lTemp;
				currentLesson.reloadSentences();
				getStatsPanel().reset();
				nextSentence();
				return;
			}
		}
		if (bDEBUG) System.out.println("Twidor: Unmatched lesson name: " + lesson);
	}

	/**
	 * Sets the current lesson from the set of lessons
	 * @param String the name of the lesson to set
	 */
	private void loadSingleLesson (String path) {
		currentLesson = new Lesson(path);
		// int lesson_num = getLessonPlan().getLessonCount() + 1;
		// lesson.setLessonNumber( lesson_num );
		currentLesson.reloadSentences();
		getStatsPanel().reset();
		nextSentence();
		return;
	}

	/**
	 * gets the current lesson
	 * @return Lesson the current lesson
	 */
	private Lesson getLesson () {
		return currentLesson;
	}

// Misc stuff

	/**
	 * gets the current sentence
	 * @return String the current sentence
	 */
	public String getSentence () {
		return currentSentence;
	}

	/**
	 * updates the current sentence, also checks if we need to
	 * switch Lessons.
	 */
	public void nextSentence () {
		/* next sentence in this lesson */
		currentSentence = getLesson().getSentence();
		getTypingPanel().displaySentence(getSentence());
		getStatsPanel().nextSentence(getSentence());
		doHighlighting();
		getInfoPanel().setTitle(getLesson().getLessonName() + ": Sentence " +
								getLesson().getSentenceNumber());
		pack();
	}

	/**
	 * updates the current lesson
	 */
	public void nextLesson () {
		int next = getLesson().getLessonNumber() + 1;
		if (next > getLessonPlan().getLessonCount())
			next--;
		pref.lesson_number = next;
		getTwidorMenu().makeSelectedLesson("Lesson " + next);
		//setLesson("Lesson " + next);
	}

	/**
	 * show the statistics. woo!
	 */
	public void showStats () {
		getTypingPanel().displayMessage("Press any key to continue");
		getStatsPanel().showStats();
		getInfoPanel().setTitle(getLesson().getLessonName() + ": Complete");
	}

	/**
	 * Does the highlighting.
	 */
	public void doHighlighting () {
		getTwiddlerPanel().clear();
		int begin = getTypingPanel().getCurrent();
		KeyElement match = null;
		if (begin < getSentence().length()) {
			String remainder = getSentence().substring(begin);

			int limit = 0;
			if ( ! pref.show_MCC ) limit = 1;
			match = getKeyMap().matchLargestChunk(remainder, limit);
			if ( match == null ) {
				if(Character.isUpperCase(remainder.charAt(0))) {
					match = getKeyMap().getKey(remainder.substring(0,1).toLowerCase());
					if ( match != null ) {
						match = new KeyElement(match); // copy before modifying it
						match.setThumb(B_SHIFT);
					}
				}
			}
		} else {
			match = getKeyMap().getKey(UNICODE_RETURN); // highlight ENTER when at end of line.
		}
		getTwiddlerPanel().highlight(match);
		getTypingPanel().highlight(match);
	}
	/**
	 * sets the Input flag (whether we are recording or not)
	 * @param boolean the new status
	 */
	private void ignoreInput (boolean input) {
		acceptInput = input;
	}

	/**
	 * gets the Input flag
	 * @return boolean whether or not we are recording
	 */
	private boolean ignoreInput () {
		return acceptInput;
	}

	/**
	 * @param boolean the new status
	 */
	private void showingStats (boolean input) {
		showStats = input;
	}

	/**
	 * @return boolean whether or not we go to the next lesson
	 */
	private boolean showingStats () {
		return showStats;
	}

	public static void openWebpage(String uri) {
		java.awt.Desktop desktop = java.awt.Desktop.isDesktopSupported() ? java.awt.Desktop.getDesktop() : null;
		if (desktop != null && desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
			try {
				desktop.browse(java.net.URI.create(uri));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Accessor for the EventHandler to inform the Tutor a key has been
	 * pressed.
	 * @param char the key pressed
	 * @param long the system time when it was pressed
	 */
	public void charTyped (String macro, long time) {
		String sentence = getSentence();
		KeyElement typed = getKeyMap().getKey(macro);
                                                                                                                                   		if ( (typed == null) &&
			 (Character.isUpperCase(macro.charAt(0)))
			 ) {
			typed = getKeyMap().getKey(macro.toLowerCase());
			if ( typed != null ) {
				typed = new KeyElement(typed); // copy before modifying it
				typed.setThumb(B_SHIFT);
			}
		}
		if (typed == null) {
			if (bDEBUG) System.out.println("Really big problem with character typed.");
			return;
		}

		if (bDEBUG) System.out.println("Accepting input");

		/* Register the keypress */
		getStatsPanel().charTyped(typed, time);
		getTypingPanel().charTyped(typed);

		/* Determine if we need to change sentences */
		if (getTypingPanel().sentenceComplete()) {
			if (getLesson().isComplete()) {
				if (!showingStats()) {
					showStats();
					showingStats(true);
				} else {
					nextLesson();
					showingStats(false);
				}
			} else {
				nextSentence();
			}
		}
		doHighlighting();
	}

	public void reOrient () {
		setVisible(false);
		getTwiddlerPanel().reOrient();
		getTypingPanel().remove_highlight();
		doHighlighting();
		pack();
		setVisible(true);
	}

	/**
	 * function for effecting menubar based changes
	 * @param String the MenuItem that was selected
	 * @param boolean its new status
	 */
	public void booleanOption (String option, boolean status) {
		if (bDEBUG) System.out.println("Changing " + option + ":" + status);

		if (option.equals(TWIDDLER_SHOW_KEYBOARD_TEXT)) {
			pref.show_keyboard = status;
		}
		else if (option.equals(TWIDDLER_SHOW_SCC_TEXT)) {
			pref.show_SCC = status;
		}
		else if (option.equals(TWIDDLER_SHOW_KEY_LABELS_TEXT)) {
			pref.show_key_labels = status;
		}
		else if (option.equals(TWIDDLER_FINGERBOARD_LEFT_TO_RIGHT_TEXT)) {
			pref.fingerboard_left_to_right = status;
		}
		else if (option.equals(TWIDDLER_SHOW_THUMB_BOARD_TEXT)) {
			pref.show_thumb_board = status;
		}
		else if (option.equals(TWIDDLER_SHOW_MCC_TEXT)) {
			pref.show_MCC = status;
		}
		else if (bDEBUG) System.out.println("Unhandled option");

		reOrient();
	}

	/**
	 * function for effecting menubar based changes
	 * @param String the menu option that was selected
	 */
	public void menuOption (String option) {
		if (bDEBUG) System.out.println("Option " + option);
		if (option.equals(QUIT_TEXT)) {
			twidorQuit();
		}
		else if (option.equals(LOAD_KEYMAP_TEXT)) {
			int choice = fc.showDialog(this, LOAD_KEYMAP_TEXT);
			if (choice == JFileChooser.APPROVE_OPTION) {
				try {
					setKeyMap(fc.getSelectedFile().getCanonicalPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
				getTwiddlerPanel().setKeyMap(getKeyMap());
				reOrient();
			}
		}
		else if (option.equals(LOAD_LESSON_TEXT)) {
			int choice = fc.showDialog(this, LOAD_LESSON_TEXT);
			if (choice == JFileChooser.APPROVE_OPTION) {
				try {
					loadSingleLesson(fc.getSelectedFile().getCanonicalPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else if (option.equals(SAVE_KEYLOG_TEXT)) {
			int choice = fc.showDialog(this, SAVE_KEYLOG_TEXT);
			if (choice == JFileChooser.APPROVE_OPTION) {
				setKeylog(fc.getSelectedFile());
			}
		}
		else if (option.startsWith("Lesson")) {
			setLesson(option);
		}
		else if (option.equals("Documentation")) {
			openWebpage("https://github.com/rich-murphey/twidor");
			return;
		}
		else if (option.equals("About")) {
			About a = new About();
			a.setVisible(true);
		}
		else {
			for (int i = 0; i < KEYMAPS.length; i++) {
				if (option.equals(KEYMAPS[i])) {
					setKeyMap(option + ".csv");
					getTwiddlerPanel().setKeyMap(getKeyMap());
					reOrient();
				}
			}
		}
	}

	/**
	 * function for cleaning up and closing and stuff
	 */
	public void twidorQuit () {
		if (bDEBUG) System.out.println("Exiting Twidor.");

		// persist user preferences
		pref.store();

		setVisible(false);
		// insert stats saving stuff here.
		getStatsPanel().save();
		dispose();
		System.exit(0);
	}

	/**
	 * Good god. The Main.
	 */
	public static void main (String[] argv) {
		Twidor tutor = new Twidor();
	}
}
