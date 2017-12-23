[//]: # (Copyright C 2017  Carey Richard Murphey. This file is released under the terms of the GNU General Public License version 2.)
## Twidor - a typing tutor for the Twiddler keyboard
<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/twiddler.jpg" width="15%" align="right"> 

Twidor teaches typing on the
[Twiddler chording keyboard](https://twiddler.tekgear.com).
A chord is formed by pressing several keys together, like playing a "chord" on a piano. There are 
[downloads for Windows, Linux and OSX](https://github.com/rich-murphey/twidor/releases).
 
Twidor was originally written by researchers studying
[chording keyboard learning and performance](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.4.3606&rep=rep1&type=pdf). Their
research suggests that learners may achieve faster typing speeds on single-handed chording keyboards than two-handed QWERTY keyboards given equal amount of practice.  In article [2] below, Lyons states, "faster typists would reach
60 WPM, the rate of our expert, after 10,000 phrases
(approximately 80 sessions or 27 hours) while the slower typists
could achieve 45 WPM."

## The Keyboard Layout

<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/Twidor_single.png"
width="30%" align="right">
Twidor shows a visual keyboard layout and lesson text. Labels in the layout show the characters sent by each button.

Four thumb buttons are on top. Below, rows from top to bottom correspond to index, middle, ring and pinky fingers. Columns with green, blue and red borders match the coloring on the Twiddler's physical buttons.  

Twidor highlights in red the next letter of the lesson, "e", and the button that send the letter "e".

Text entered by the user is shown below. Incorrect letters appear darker.

## Chords

<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/Twidor_SCC.png"
width="30%" align="right">
A "chord" is two or more buttons pressed at the same time, like playing a "chord" on a piano.

In the lesson shown on the right, the letter "m" is formed by the "SP" (space) and "g" buttons.

Twidor will optionally show a map of the two-button chords, when the menu item <kbd>View | Show chords</kbd> is selected.

## View | Show chords

When <kbd>View | Show chords</kbd> is selected, an expanded key-map is shown, containing 2-button chords.
<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/Twidor_chord_map.png" width="40%" align="right">

Each small button shows the letter sent by a two-button chord.  

Let's consider typing the letter "m".

The first button of the chord for "m" is small box labeled "m".  The position of the first button is relative to the array of small buttons.  This is the button under the ring finger, middle column.  On the twiddler, that button is labeled "g".

<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/Twidor_SCC_full.png" width="30%" align="right"> The second button of the chord is the large box to the immediate right, labeled "SP".  The location of the first button is relative to the array of large buttons.  This is the button under the index finger, left column.

Here are some of the two-button chords on the left column of buttons:
* <kbd>DEL + SP</kbd>, index and middle fingers, sends "o".
* <kbd>BS  + SP</kbd>, index and ring fingers, sends "p".
* <kbd>NL  + SP</kbd>, index and pinky fingers, sends "q".

## View | Show multiple character chords

Typing a single chord on the Twidller can send more than one letter, for example, "ed" or "ing".  These are called multiple character chords (MCCs).  

By default, Twidor does not highlight MCCs, but rather only highlights single letters as shown above in "Keyboard Layout".  This default is intended to help users who are just beginning. Lyons [2,3] has shown that learning is faster when the incremental amount of learning material smaller.

When <kbd>View | Show multiple character chords</kbd> is selected, Twidor highlights MCCs.  

<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/Twidor_MCC.png" width="30%" align="right"> For example, given the text "ed", shown on the right. Twidor highlights the chord that sends "ed", rather than just "e".  Note that this is different from the keymap shown above in "The Keyboard Layout", where the option was not selected, and only "e" is highlighted.

If you wish to learn all available chords, select this option.  Twidor will show red highlighted buttons for the longest possible chorrd that matches the lesson text.  For example, given the text, "the", Twidor will highlight the chord that sends "the", rather than "th" or "t".

Note that this option affects only the red highlighted "hints".  Regardless, the Twiddler can send MCCs, and Twidor accepts input MCCs.

## Alternate Keymaps

By default, Twidor loads the the default keymap that comes factory installed on a new Twiddler.  

There are a number of keymaps that have become popular over the years since the Twiddler was first introduced.  A few of these are bundled with Twidor. Users may select the Backspice, Default, TabSpace, or Typemax layouts in the <kbd>Keymaps</kbd> menu.

Arbitrary keymap files can be loaded by the user. To load a custom key-map, export it from the 
the [Twiddler Tuner](https://twiddler.tekgear.com/tuner/edit.xhtml) and load it as follows:
* open https://twiddler.tekgear.com/tuner/edit.xhtml,
* import a keymap.cfg if not already present there.
* select 'Edit Configuration' for a given configuration file,
* with the configuration file open, select Export, and then CSV.
* download the CSV file.
* In Twidor, select <kbd>File | Load Keymap</kbd> and select the CSV file.

## Other Usage

Hit <kbd>ENTER</kbd> at the end of a line to go to the next sentence. The words per minute (WPM) and average error rate (AER) are updated when <kbd>ENTER</kbd> is pressed.

Lessons 1-7 each present a random set of phrases. The lessons progress through various subsets of the alphabet (e.g. letters a–h in lesson 1), progressing to larger subsets in later lessons. 

Lessons 8 and 9, borrowed from GNU Typist, provide longer texts with capitalization, numbers and special characters.

Menu options include:
* <kbd>File | Load Keymap</kbd> imports a CSV key-map exported by the [Twiddler Tuner](https://twiddler.tekgear.com/tuner/).
* <kbd>File | Load Lesson</kbd> imports training text from a file.
* <kbd>View | Show..</kbd> toggles show/hide key labels and flips right-to-left orientation.
* <kbd>View | Highlight...</kbd> toggles show/hide which keys to press to send the next letter of the lesson.
* <kbd>Keymaps</kbd> loads certain key-maps: Backspice, Default_V5, TabSpace, or Typemax.

## How to Install

Download the releases from here:

[https://github.com/rich-murphey/twidor/releases](https://github.com/rich-murphey/twidor/releases)

On windows, download and run the Twidor-setup.exe installer.

On Debian or Ubuntu, download the twidor-x.x.deb. To install and run it one may use:

    dpkg -i twidor-x.x.deb
    twidor

On other Linux, OSX, and unix variants, download Twidor.jar from the above link,
install openjdk-8-jre, and invoke the application using:

    java -jar Twidor.jar

Feedback and reports of issues are
welcome [here](https://github.com/rich-murphey/twidor/issues).

## Limitations

* Key-Map labels are shortened to the first three letters, which is currently sufficient for all of the popular key-maps.
* The visual key-map does not show the mouse buttons.
* Lessons 1-7 are tailored to the Deafult key-map. Specifically, lesson one uses only single button keys of the Default key-map.  Other key-maps will require chords in lesson one.

## How to Build

To compile and build Twidor.jar and the debian package (.deb), one may use:

    sudo apt install git openjdk-8-jdk ant make fakeroot
    git clone https://github.com/rich-murphey/twidor.git
    cd twidor
    make

## Other Relevant Projects

The [original Twidor source code and documentation](http://wearables.cc.gatech.edu/projects/twidor/) at Georgia Tech.

[Twidlit](https://github.com/pushkarkp/twidlit) is a a tutor and companion for The Twiddler keyboard. It
is intended to assist in all aspects of learning to twiddle and
developing a personal chord mapping. Like Twidor, Twidlit is
written in Java.

[twiddler_layout](https://github.com/ben-horner/twiddler_layout) is a command line tool for editing Twiddler keyboard layouts, also written in Java.

The [Backspice key-map](https://github.com/AlexBravo/Twiddler) by [Alex Bravo](https://plus.google.com/+AlexBravo).

The [TabSpace 3 layout](http://ivanwfr.github.io/Twiddler3-Layout/) discusses a range of layout issues, including n-gram occurrence frequency and ranking the dexterity required for various multi-key chords.

The [Typemax layout](https://github.com/lancegatlin/typemax)
maximizes typing speed by emphasizing efficient single character
chord transitions (stride). The Typemax github repo has discussions of
[Basic Layout Design](https://github.com/lancegatlin/typemax/blob/master/basic_layout_design.md),
including issues of stride and n-gram clustering, stutter,
separation of vowels and consonants on separate fingers, using
mouse buttons as letter keys, and many other design issues.

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
macros and alternate key-maps, and added options such as thumb pad
orientation and thumb pad labels visibility.

Lessons 8 and 9 were written by Simon Baldwin as part of [GNU Typist](https://www.gnu.org/software/gtypist/index.html), and are redistributed as permitted by the GPL.  
