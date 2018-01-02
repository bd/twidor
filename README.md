[//]: # (Copyright C 2017  Carey Richard Murphey. This file is released under the terms of the GNU General Public License version 2.)
<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/twiddler.jpg" width="15%" align="right"> 
# Twidor - teaches typing on the Twiddler

Twidor teaches typing on the
[Twiddler](https://twiddler.tekgear.com), a chording keyboard shown on the right.
A chord is formed by pressing several keys together, like playing a "chord" on a piano. 

## Getting Started

See [How to Install](#how-to-install) for links to downloads for Windows, Linux and OSX and others.

<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/Twidor_single.png"
width="30%" align="right"> 
When you start Twidor, it will show a visual keyboard layout beside the first typing lesson. Labels in the layout show the characters sent by each key on the Twiddler.

Four thumb keys are on top. Below, rows from top to bottom correspond to index, middle, ring and pinky fingers. Columns with green, blue and red borders match colors on the Twiddler's physical keys.  

Red highlights identify the next letter of the lesson, "e", and the key that send the letter "e".

Text entered by the user is shown below. Incorrect letters appear darker.

Hit <kbd>ENTER</kbd> at the end of a line to go to the next sentence. The words per minute (WPM) and average error rate (AER) are updated when <kbd>ENTER</kbd> is pressed.

# Using Twidor

<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/Twidor_SCC.png" width="30%" align="right"> The following sections discuss various menu options and user interface features of Twidor.
As discussed in the section, [Training Methodology](#training-methodology), the keyboard layout and highlighting work best as temporariy aids for users to initially learn the leyboard layout.  As soon as is practical, user's may benfit from transitioning to typing without these aids. 

### Highlighting Chords

By default, Twidor will highlight chords.  A "chord" is two or more keys pressed at the same time, like playing a "chord" on a piano.

In the lesson shown on the right, the letter "m" is formed by the "SP" (space) and "g" keys.


### View | Show chords

<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/Twidor_SCC_full.png" width="30%" align="right"> Twidor will optionally show a map of the two-key chords, when the menu item <kbd>View | Show chords</kbd> is selected.
This expands the keyboard layout to display additional sections of keys as shown on the right. 

This way of depicting 2-key chords follows a popular convention. In each smaller grid, the top row shows a bullet (•) key which is the "anchor".  The 2-key chords are composed of the the anchor key in the top row plus one of the keys below.  The key label below shows the letter that the chord sends.  

Let's consider typing the letter "m".

First we locate "m" in they layout.  "m" is found in a small grid on the top left.  This grid is enlarged in the figure below.

The first key of the cord is the anchor, labeled with the bullet (•) in the top row.  This "anchor" key is shared by all of the 2-key chords in the grid. Here, the anchor is on the index finger, left column.  On the Twiddler, this physical key is labeled "SP".

<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/Twidor_chord_map.png" width="25%" align="right">  The small box labeled "m" shows the location of the second key of the chord, relative to the small grid: ring finger, middle column.  On the Twiddler, this physical key is labeled "g".

Here are some of the two-key chords on the left column of keys:
* <kbd>DEL + SP</kbd>, index and middle fingers, sends "o".
* <kbd>BS  + SP</kbd>, index and ring fingers, sends "p".
* <kbd>NL  + SP</kbd>, index and pinky fingers, sends "q".

### View | Show multiple character chords

A chord on the Twiddler can send several letters such as "ed" or "ing".  These are called multiple character chords (MCCs).

By default, Twidor does not highlight multiple character chords,
but rather only highlights single letters as shown above in
"Getting Started".  This default is intended to help users who
are just beginning. \[[Lyons04a, 04b](#references)\] has shown that learning is faster when the incremental amount of learning material smaller.

When <kbd>View | Show multiple character chords</kbd> is selected, Twidor highlights MCCs.  

<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/Twidor_MCC.png" width="30%" align="right"> For example, given the text "ed", shown on the right, Twidor will highlight the chord that sends "ed", rather than just "e".  Note that this is different from the layout shown above in "Getting Started", where the option was not enabled and only "e" is highlighted.

If you wish to learn all available chords, select this option.  Twidor will show red highlighted keys for the longest matching chord.  For example, given the text, "the", Twidor will highlight the chord that sends "the", rather than "th" or "t".

When you enable both "show chords" and "show multiple character chords", it further expands the keyboard layout to include labels for multiple character 2-key chords.

Note that this option affects only the red highlighted "hints".  Regardless of this setting, the Twiddler can send multiple character chords, and Twidor will accept MCCs as input.

### Keymaps | Backspice, TabSpace, Typemax

By default, Twidor loads the the default keymap that comes factory installed on a new Twiddler.   The <kbd>Keymaps</kbd> menu selects alternate keymap layouts.

There are a number of keymaps that have become popular over the years since the Twiddler was first introduced.  A few of these are bundled with Twidor. Users may select the Backspice, Default, TabSpace, or Typemax layouts under <kbd>Keymaps</kbd>.

### File | Load Keymap

Arbitrary keymap files can be loaded by the user. To load a custom keymap, export it from the 
the [Twiddler Tuner](https://twiddler.tekgear.com/tuner/edit.xhtml) and load it as follows:
* open https://twiddler.tekgear.com/tuner/edit.xhtml,
* import a keymap.cfg if not already present there.
* select 'Edit Configuration' for a given configuration file,
* with the configuration file open, select Export, and then CSV.
* download the CSV file.
* In Twidor, select <kbd>File | Load Keymap</kbd> and select the CSV file.

### Lessons | Lesson 1..9

Menu items <kbd>Lessons | Lession 1..7</kbd> teach subsets of the alphabet, varying from smaller to larger subsets, starting with the letters a–h in lesson 1. The set of phrases varies, by random selection, each time a lessons loaded.

Lessons 8 and 9, borrowed from GNU Typist, provide random exerpts from longer texts with capitalization, numbers and special characters.

### Overview of Menus

Menu options include:
* <kbd>File | Load Keymap</kbd> imports a CSV keymap exported by the [Twiddler Tuner](https://twiddler.tekgear.com/tuner/).
* <kbd>File | Load Lesson</kbd> imports training text from a file.
* <kbd>View | Show..</kbd> toggles show/hide key labels, chords and MCCs, and flips right-to-left orientation.
* <kbd>Lessons | Lesson 1..9</kbd> loads the selected lesson text.
* <kbd>Keymaps | Backspace, etc.</kbd> loads certain popular keymaps: Backspice, Default_V5, TabSpace, or Typemax.
* <kbd>Help | About</kbd> shows the Twidor version number.

### Limitations

* Keymap labels are shortened to the first three letters, which is currently sufficient for all of the popular keymaps.
* The visual keymap does not show the mouse buttons.
* Lessons 1-7 are tailored to the Default keymap. Specifically, lesson one uses only single-key chords of the Default keymap.  Other keymaps will require chords in lesson one.
* Twidor silently ignores input characters that are not in the current keymap.

# How to Install

Download the releases from here:

[https://github.com/rich-murphey/twidor/releases](https://github.com/rich-murphey/twidor/releases)

On windows, download and run the Twidor-setup.exe installer.

On Debian or Ubuntu, download the twidor-x.x.deb and install it.  For example:

    wget https://github.com/rich-murphey/twidor/releases/download/v2.6/twidor-2.6.deb
    dpkg -i twidor-2.6.deb
    twidor

On other Linux, OSX, and Unix variants, install openjdk-8-jre, download Twidor.jar
and invoke it, using, for example:

     wget https://github.com/rich-murphey/twidor/releases/download/v2.6/Twidor.jar
     java -jar Twidor.jar

Feedback and reports of issues are
welcome in the [github issue tracker](https://github.com/rich-murphey/twidor/issues).


# How to Build

To compile and build Twidor.jar and the Debian package (.deb), one may use:

    sudo apt install git openjdk-8-jdk ant make fakeroot
    git clone https://github.com/rich-murphey/twidor.git
    cd twidor
    make

One option for debugging Twidor is use [Eclipse](http://www.eclipse.org/downloads/). In Eclipse, select <kbd>File | Open | New Project</kbd>, then select "Java Project from Existing Ant Buildfile", click <kbd>Next</kbd>, click <kbd>Browse</kbd>, select file twidor/build.xml, and click <kbd>Finish</kbd>. 

# Training Methodology

Regarding the amount of time required for training, [Lyons 2004a] states, "faster typists would reach 60 WPM, the rate of our expert, after 10,000 phrases (approximately 80 sessions or 27 hours) while the slower typists could achieve 45 WPM." Twidor is the tool that they developed to collect data for their studies of learning and perferformance.

Lyons studied the effect of a user's inability to see the Twiddler keyboard ("blind typing"), and found that it correlates with a statistically significant improvement in "typing rate or reduced error rate" [Lyons04a, 369-370].  He suggests that users can process the training information faster when not required to process the additional visual information of watching the physical keyboard. These results suggest that performance can improve moderately when physical keyboard is not visible to the user. 

Lyons also states, "We examined how our participants learned to chord, showing most of the speed increase associated
with learning occurs during the in-air time interval." In-air refers to the time between releasing one key and pressing the next.  This suggests that the user's efforts to absorb and recall key assignment information during the transition are a key to speed increases.

Lyons found that the "highlighting-off group’s effort to
find and remember keys and key combinations improved their learning.
Twidor can show a keyboard layout and can highlight key
labels. However, these studies show that, while the visual keyboard
and highlighting keys may help users initially, disabling them 
can accelerate progress toward expert typing rates.

# Other Relevant Projects

The [original Twidor source code and documentation](http://wearables.cc.gatech.edu/projects/twidor/) at Georgia Tech.

[Twidlit](https://github.com/pushkarkp/twidlit) is a a tutor and companion for The Twiddler keyboard. It
is intended to assist in all aspects of learning to twiddle and
developing a personal chord mapping. Like Twidor, Twidlit is
written in Java.

[twiddler_layout](https://github.com/ben-horner/twiddler_layout) is a command line tool for editing Twiddler keyboard layouts, also written in Java.

The [Backspice keymap](https://github.com/AlexBravo/Twiddler) by [Alex Bravo](https://plus.google.com/+AlexBravo).

The [TabSpace 3 layout](http://ivanwfr.github.io/Twiddler3-Layout/) discusses a range of layout issues, including n-gram occurrence frequency and ranking the dexterity required for various multi-key chords.

The [Typemax layout](https://github.com/lancegatlin/typemax)
maximizes typing speed by emphasizing efficient single character
chord transitions (stride). The Typemax github repo has discussions of
[Basic Layout Design](https://github.com/lancegatlin/typemax/blob/master/basic_layout_design.md),
including issues of stride and n-gram clustering, stutter,
separation of vowels and consonants on separate fingers, using
mouse buttons as letter keys, and many other design issues.

The [Twiddler 3 Google Group](https://groups.google.com/forum/?hl=en#!forum/twiddler-3) has links to various resources.

# References

\[Clawson05\]
The Impacts of Limited Visual Feedback on Mobile Text Entry for
the Twiddler and Mini-QWERTY Keyboards. James Clawson, Kent
Lyons, Thad Starner, and Edward Clarkson. Proceedings of
ISWC 2005. Osaka, Japan. November 2005.
[full text.](https://pdfs.semanticscholar.org/70c3/995e2487921b8a08bec07977f8cc161655fa.pdf)

\[Lyons04a\]
Expert Chording Text Entry on the Twiddler One-Handed Keyboard,
Kent Lyons, Thad Starner, Daniel Plaisted,
James Fusia, Amanda Lyons, Aaron Drew, E. W. Looney, 
2012 16th International Symposium on Wearable Computers (2004)
Arlington, Virginia, Oct. 31, 2004 to Nov. 3, 2004.
[full text.](https://www.researchgate.net/publication/27521297_Twiddler_Typing_One-Handed_Chording_Text_Entry_for_Mobile_Phones)

\[Lyons04b\]
Twiddler Typing: One-Handed Chording Text Entry for Mobile
Phones, Kent Lyons, Thad Starner, Daniel Plaisted, James Fusia,
Amanda Lyons, Aaron Drew, E. W. Looney. Proceeding CHI '04
Proceedings of the SIGCHI Conference on Human Factors in
Computing Systems, Pages
671-678. [full text](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.4.3606&rep=rep1&type=pdf)

\[Lyons06a\]
Experimental Evaluations of the Twiddler One-Handed Chording
Mobile Keyboard. Kent Lyons, Brian Gane, and Thad
Starner. Journal Human-Computer Interaction archive Volume 21
Issue 4, November 2006 Pages
343-392. [full text](https://pdfs.semanticscholar.org/70c3/995e2487921b8a08bec07977f8cc161655fa.pdf)

\[Lyons06b\]
Mobile Text Entry, Kent Loyons, [Lecture slides.](https://wiki.cc.gatech.edu/ccg/_media/classes/7470/7470-f06/mobile-text-entry.pdf?id=classes%3A7470%3A7470-f06%3Apowerpoint_slides&cache=cache)

# Acknowledgements

[James Gibson Fusia](http://wearables.cc.gatech.edu/people/james/)
is the original author of Twidor.

[Evan Dower](https://github.com/evantd) made
the source code available on github.

[Rich Murphey](https://github.com/rich-murphey) wrote further enhancements including GUI layout, 1- and 2-key chord display, 
support for macros, alternate keymaps, additional lessons, and various GUI options. He released Debian and windows installers, added build files and this documentation.

Simon Baldwin wrote lessons 8 and 9 as part of [GNU Typist](https://www.gnu.org/software/gtypist/index.html), which are redistributed as permitted by the GPL.
