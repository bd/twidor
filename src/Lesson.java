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
 * Lesson.java, the internal representation of each lesson.
 *
 * Revisions:
 * 			0.1	11 August 2005
 * 			Created class Lesson
 * </pre>
 * @author <a href="mailto:visyz@cc.gatech.edu">James Fusia</a>
 * @version Version 0.5; 11 August 2005
 */
import java.util.*;
import java.io.*;
public class Lesson implements TwidorConstants {
	/**
	 * internal variables
	 */
	private String fileName; // where we read our sentences from
	private int lessonNumber; // our lesson number, in order

	private Vector <String> lessonSentences; // array of sentences to show
	private Vector <String> trash;
	private int currentSentence; // index sentences shown
	private int totalSentences; // number of sentences to show

	/**
	 * default constructor
	 */
	private Lesson () {
		fileName = "";
		lessonNumber = -1;
		lessonSentences = new Vector <String> ();
		trash = new Vector <String> ();
		currentSentence = 0;
		totalSentences = 0;
	}

	/**
	 * default constructor
	 * @param String the file to read sentences from
	 */
	public Lesson (String file) {
		this();
		fileName = file;
	}

	/**
	 * Accessors
	 */
	public String getLessonName () {
		return "Lesson " + getLessonNumber();
	}

	public int getLessonNumber () {
		return lessonNumber;
	}

	public boolean isComplete () {
		if (currentSentence >= totalSentences)
			return true;
		return false;
	}

	public String getSentence () {
		if (lessonSentences.isEmpty()) {
			lessonSentences.addAll(trash);
			trash.clear();
		}
		int victim = (int)(Math.random() * (double)lessonSentences.size());
		String sentence = lessonSentences.elementAt(victim);
		lessonSentences.removeElementAt(victim);
		trash.add(sentence);
		currentSentence++;
		return sentence;
	}

	public int getSentenceNumber () {
		return currentSentence;
	}

	/**
	 * Modifiers
	 */
	public void setLessonNumber (int number) {
		lessonNumber = number;
	}

	public void setLessonTotal (int count) {
		totalSentences = count;
	}

	private void readFile (String path) {
		BufferedReader bReader;
		File file = new File(path);

		if ( file.exists() ) {
			readFile( file );
		} else {
			InputStream iStream = this.getClass().getResourceAsStream(path);
			if (iStream != null) {
				readFile (new BufferedReader(new InputStreamReader(iStream)));
			} else {
				System.out.println("Could not load " + getLessonName() + ". (" + path + " not found)");
			}
		}
	}

	// return True on error
	private boolean readFile (File file) {
		try {
			readFile (new BufferedReader(new FileReader(file)));
		} catch (FileNotFoundException e) {
			System.out.println("Could not load " + getLessonName() + ". (" + file + " not found)");
			return true;
		}
		return false;
	}
	/**
	 * Function for reading a file of Sentences and parsing them all into
	 * an array.
	 * @param String the name of the file to read
	 */
	private void readFile (BufferedReader bReader) {
		try {
			while (bReader.ready()) {
				String line = bReader.readLine();
				if (line.startsWith("#")) {
					continue; /* ignore comments. */
				}
				lessonSentences.addElement(bReader.readLine());
			}
		} catch (IOException e) {
			if (bDEBUG) System.out.println("Lesson: IO Error");
		}
		try {
			bReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setLessonTotal( lessonSentences.size() );

		if (bDEBUG)
			System.out.println("Lesson: " + lessonSentences.size()
							   + " sentences read");
	}

	public void reloadSentences () {
		lessonSentences.clear();
		trash.clear();
		readFile(fileName);
		currentSentence = 0;
	}

}
