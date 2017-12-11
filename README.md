[//]: # (Copyright C 2017  Carey Richard Murphey. This file is released under the terms of the GNU General Public License version 2.)

## Twidor - a typing tutor for the Twiddler chording keyboard
<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/Twidor_screenshot.png"
width="50%" align="right">
Twidor is a typing tutor for the [Twiddler one-handed chording keyboard](https://twiddler.tekgear.com/).  A "chord" is a keystroke using two, three or four buttons pressed simultaneously. 

Twidor was originally written by researchers studying
[Twiddler learning rates and performance](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.4.3606&rep=rep1&type=pdf). Their
research suggests that learners may achieve faster typing speeds on single-handed chording keyboards than two-handed QWERTY keyboards given equal amount of practice.  In article [2] below, Lyons states, "faster typists would reach
60 WPM, the rate of our expert, after 10,000 phrases
(approximately 80 sessions or 27 hours) while the slower typists
could achieve 45 WPM."

## The Visual Key Map

By default, Twidor loads the the
[Backspice keymap](https://raw.githubusercontent.com/AlexBravo/Twiddler/master/Backspice2%20cheat%20sheet.txt).
Users may select others in the <kbd>Keymaps</kbd> menu, or by loading a custom keymap generated by the 
the [official Twiddler layout editor](https://twiddler.tekgear.com/tuner/edit.xhtml).

Each 4x3 array is composed of four horizontal rows, one for each finger, and green/blue/red columns corresponding to left, middle and right keys on the Twiddler. 

Each large button shows the letter sent by a single-button keystroke.

## Chord - several keys pressed together

A chord is formed by pressing several keys together, like playing a "chord" on a piano.

<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/Twidor_chord_map.png"
width="30%" align="right"> Each small 4x3 array shows letters sent by two-buttons chords.  The orientation mirrors that of the larger 4x3 array: one row for each finger, and green/blue/red for left, middle and right columns.

The first button of the chord is the large button to the immediate left.  

The second button of the chord is one of the small buttons which show the letters sent by the chord.

Here are some two-button chords whose first button is the <kbd>I</kbd> key:
* <kbd>I + S</kbd> sends "is".
* <kbd>I + N</kbd> sends "in".
* <kbd>I + SP</kbd> sends "C".
* <kbd>I + H</kbd> sends "Y".

## Usage

Hit <kbd>ENTER</kbd> at the end of a line to go to the next sentence.

Menu options include:
* <kbd>File | Load Keymap</kbd> imports a CSV keymap exported by the [Twiddler Tuner](https://twiddler.tekgear.com/tuner/).
* <kbd>File | Load Lesson</kbd> imports training text from a file.
* <kbd>Keyboard | Show..</kbd> toggles show/hide key labels and flips right-to-left orientation.
* <kbd>Hints | Highlight...</kbd> toggles show/hide buttons that show the chord for the next letter of the lesson.
* <kbd>Keymaps</kbd> loads certain keymaps: Backspice, Default_V5, TabSpace, or Typemax.

To load a custom keymap, users may:

* open https://twiddler.tekgear.com/tuner/edit.xhtml,
* import a keymap.cfg if not already present there.
* select 'Edit Configuration' for a given configuration file,
* with the configuration file open, select Export, and then CSV.
* download the CSV file.
* In Twidor, select <kbd>File | Load Keymap</kbd> and select the CSV file.

## How to Install

Download the releases from here:

[https://github.com/rich-murphey/twidor/releases](https://github.com/rich-murphey/twidor/releases)

On windows, download and run the Twidor-setup.exe installer.

On Linux and others, download Twidor.jar from the above link,
install Java, and invoke the application using javaw. For
example, on Debian or Ubuntu, one may use:

    sudo apt install openjdk-8-jre
    javaw -Dawt.useSystemAAFontSettings=on -Dswing.aatext=true -jar Twidor.jar Twidor

Feedback and reports of issues are
welcome [here](https://github.com/rich-murphey/twidor/issues).

## Limitations

* Labels for macro keys are shortened to the first three
  letters. This is currently not an issue because current
  keymaps have no more than 2-letter macros in 2-button chords.
* Up/down/right/left arrows key labels are not shown, since current lessons do not use them.
* For Typemax, while the keyboards does not show mouse buttons,
  mapped mouse buttons do work for training purposes.

## How to Build

To compile and build Twidor.jar, one may use:

    sudo apt install git openjdk-8-jdk ant
    git clone https://github.com/rich-murphey/twidor.git
    cd twidor
    ant

## Other Relevant Projects

The [original Twidor source code and documentation](http://wearables.cc.gatech.edu/projects/twidor/) at Georgia Tech.

[Twidlit](https://github.com/pushkarkp/twidlit) is a a tutor and companion for The Twiddler keyboard. It
is intended to assist in all aspects of learning to twiddle and
developing a personal chord mapping. Like Twidor, Twidlit is
written in Java.

[twiddler_layout](https://github.com/ben-horner/twiddler_layout) is a command line tool for editing Twiddler keyboard layouts, also written in Java.

The [Backspice keymap](https://github.com/AlexBravo/Twiddler) by [Alex Bravo](https://plus.google.com/+AlexBravo).

The [TabSpace 3 layout](http://ivanwfr.github.io/Twiddler3-Layout/) discusses a range of layout issues, including ngram occurrence frequency and ranking the dexterity required for various multi-key chords.

The [Typemax layout](https://github.com/lancegatlin/typemax)
maximizes typing speed by emphasizing efficent single character
chord transitions (stride). The Typemax github repo has discussions of
[Basic Layout Design](https://github.com/lancegatlin/typemax/blob/master/basic_layout_design.md),
including issues of stride and ngram clustering, stutter,
separation of vowels and consonants on separate fingers, using
mouse buttons as letter keys, and many other desing issues.

The [Twiddler 3 Google Group](https://groups.google.com/forum/?hl=en#!forum/twiddler-3) has links to various resources.

## References

[1] Expert Chording Text Entry on the Twiddler One-Handed Keyboard,
Kent Lyons, Thad Starner, Daniel Plaisted,
James Fusia, Amanda Lyons, Aaron Drew, E. W. Looney, 
2012 16th International Symposium on Wearable Computers (2004)
Arlington, Virginia, Oct. 31, 2004 to Nov. 3, 2004.
[full text.](https://www.researchgate.net/publication/27521297_Twiddler_Typing_One-Handed_Chording_Text_Entry_for_Mobile_Phones)

[2] Twiddler Typing: One-Handed Chording Text Entry for Mobile
Phones, Kent Lyons, Thad Starner, Daniel Plaisted, James Fusia,
Amanda Lyons, Aaron Drew, E. W. Looney. Proceeding CHI '04
Proceedings of the SIGCHI Conference on Human Factors in
Computing Systems, Pages
671-678. [full text](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.4.3606&rep=rep1&type=pdf)

[3] Experimental Evaluations of the Twiddler One-Handed Chording
Mobile Keyboard. Kent Lyons, Brian Gane, and Thad
Starner. Journal Human-Computer Interaction archive Volume 21
Issue 4, November 2006 Pages
343-392. [full text](https://pdfs.semanticscholar.org/70c3/995e2487921b8a08bec07977f8cc161655fa.pdf)

[4] The Impacts of Limited Visual Feedback on Mobile Text Entry for
the Twiddler and Mini-QWERTY Keyboards. James Clawson, Kent
Lyons, Thad Starner, and Edward Clarkson. Proceedings of
ISWC 2005. Osaka, Japan. November 2005.
[full text.](https://pdfs.semanticscholar.org/70c3/995e2487921b8a08bec07977f8cc161655fa.pdf)

[5] Mobile Text Entry, Kent Loyons, [Lecture slides.](https://wiki.cc.gatech.edu/ccg/_media/classes/7470/7470-f06/mobile-text-entry.pdf?id=classes%3A7470%3A7470-f06%3Apowerpoint_slides&cache=cache)

## Acknowledgements

[James Gibson Fusia](http://wearables.cc.gatech.edu/people/james/)
is the original author of Twidor.

[Evan Dower](https://github.com/evantd) made
the source code available on github.

[Rich Murphey](https://github.com/rich-murphey) modified Twidor
to load [Twiddler v3 keyboard layouts](https://twiddler.tekgear.com/tuner/edit.xhtml),
released a simplified windows installer, added build files and
documentation, rewrote keypad display, rewrote layout to support
macros and alternate keymaps, and added options such as thumbpad
orientation and thumbpad labels visibility.
