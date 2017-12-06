## Twidor - a typing tutor for the Twiddler mobile keyboard
<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/Twidor_screenshot.png"
width="50%" align="right">
Twidor is a typing tutor for the [Twiddler one-handed keyboard](https://twiddler.tekgear.com/).

Twidor was originally written by researchers studying
[Twiddler learning rates and performance](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.4.3606&rep=rep1&type=pdf).

Lyons [2] states, "faster typists would reach
60 wpm, the rate of our expert, after 10,000 phrases
(approximately 80 sessions or 27 hours) while the slower typists
could achieve 45 wpm. Lyons [3] states, "We found that users initially had a faster average typing
rate with multitap; however, after 4 sessions the difference became negligible, and
by the 8th session participants typed faster with chording on the Twiddler." Lyons [3] also states, "lack of visual
feedback does not hinder expert typing speed."

## How to Install

Please note, the current release includes only a single keyboard layout,
the [Backspice keymap](https://raw.githubusercontent.com/AlexBravo/Twiddler/master/Backspice2%20cheat%20sheet.txt).

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

## How to Build

To compile and build Twidor.jar, one may use:

    sudo apt install git openjdk-8-jdk ant
    git clone https://github.com/rich-murphey/twidor.git
    cd twidor
    ant

## Road-map

In a future release, Twidor will be able to load other keymaps.
This will include the capability to read keymaps in the CSV format exported from
the[official [Twiddler layout editor](https://twiddler.tekgear.com/tuner/edit.xhtml).

To generate a keymap suitable for input, one may:

* open https://twiddler.tekgear.com/tuner/edit.xhtml,
* select 'Edit Configuration' for a given configuration file,
* with the configuration file open, select Export, and then CSV.
* download the CSV file, and change the filename to keymap.txt, and
* place keymap.txt in the same directory as the Twidor Java .class files.
  
## Other Relevant Projects

The [original Twidor source code and documentation](http://wearables.cc.gatech.edu/projects/twidor/) at Georgia Tech.

[Twidlit](https://github.com/pushkarkp/twidlit) is a a tutor and companion for The Twiddler keyboard. It
is intended to assist in all aspects of learning to twiddle and
developing a personal chord mapping. Like Twidor, Twidlit is
written in Java.

[twiddler_layout](https://github.com/ben-horner/twiddler_layout) is a command line tool for editing Twiddler keyboard layouts, also written in Java.

The [Backspice keymap](https://github.com/AlexBravo/Twiddler) by [Alex Bravo](https://plus.google.com/+AlexBravo).

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

[Evan Dower](https://github.com/evantd) collaborated and made
the source code available on github.

[Rich Murphey](https://github.com/rich-murphey) modified Twidor
to support [Twiddler v3 keyboard layouts](https://twiddler.tekgear.com/tuner/edit.xhtml),
released a simplified windows installer, added build files
and documentation, and continued development.
