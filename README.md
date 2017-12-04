## Twidor - a typing tutor for the Twiddler mobile keyboard
<img src="https://raw.githubusercontent.com/rich-murphey/twidor/master/web.assets/Twidor_screenshot.png"
width="50%" align="right">
Twidor is a typing tutor for the [Twiddler one-handed keyboard](https://twiddler.tekgear.com/).

Twidor was originally written for research on [learning rates and keyboard
performance](https://www.researchgate.net/publication/27521297_Twiddler_Typing_One-Handed_Chording_Text_Entry_for_Mobile_Phones) by
the [Contextual Computing Group](https://wiki.cc.gatech.edu/ccg/classes/7470/7470-f06/projects_ii)
at the Georgia Institute of Technology.

Note that, the current release includes only a single keyboard layout,
the [Backspice keymap](https://raw.githubusercontent.com/AlexBravo/Twiddler/master/Backspice2%20cheat%20sheet.txt).

This is a beta release because it has received limited testing.
Feedback and reports of issues are
welcome [here](https://github.com/rich-murphey/twidor/issues).

## How to Install

Download the releases from here:

[https://github.com/rich-murphey/twidor/releases](https://github.com/rich-murphey/twidor/releases)

On windows, download and run the Twidor-setup.exe installer.

On Linux and others, download Twidor.jar from the above link,
install Java, and invoke the application using javaw. For
example, on Debian or Ubuntu, one may use:

    sudo apt install openjdk-8-jre
    javaw -jar Twidor.jar Twidor

## How to Build

To compile and build Twidor.jar, one may use:

    sudo apt install git openjdk-8-jdk ant
    git clone https://github.com/rich-murphey/twidor.git
    cd twidor
    ant

## Road-map

The current release includes only one keyboard layout, the [Backspice keymap](https://raw.githubusercontent.com/AlexBravo/Twiddler/master/Backspice2%20cheat%20sheet.txt).

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

[Twidlit](https://github.com/pushkarkp/twidlit) is a a tutor and
companion for The Twiddler keyboard. It is intended to assist in
all aspects of learning to twiddle and developing a personal
chord mapping.

## Resources

Expert Chording Text Entry on the Twiddler One-Handed Keyboard,
Kent Lyons, Thad Starner, Daniel Plaisted,
James Fusia, Amanda Lyons, Aaron Drew, E. W. Looney, 
2012 16th International Symposium on Wearable Computers (2004)
Arlington, Virginia, Oct. 31, 2004 to Nov. 3, 2004.
[full text.](https://www.researchgate.net/publication/27521297_Twiddler_Typing_One-Handed_Chording_Text_Entry_for_Mobile_Phones)

Mobile Text Entry, Kent Loyons, [Lecture slides.](https://wiki.cc.gatech.edu/ccg/_media/classes/7470/7470-f06/mobile-text-entry.pdf?id=classes%3A7470%3A7470-f06%3Apowerpoint_slides&cache=cache)

Experimental Evaluations of the Twiddler One-Handed Chording
Mobile Keyboard. Kent Lyons, Brian Gane, and Thad Starner. HCI
Journal.

The Impacts of Limited Visual Feedback on Mobile Text Entry for
the Twiddler and Mini-QWERTY Keyboards. James Clawson, Kent
Lyons, Thad Starner, and Edward Clarkson. Proceedings of
ISWC 2005. Osaka, Japan. November 2005.

## Acknowledgements

[James Gibson Fusia](http://wearables.cc.gatech.edu/people/james/),
is the original author of Twidor.

[Evan Dower](https://github.com/evantd) collaborated and made
the source code available on github.

[Rich Murphey](https://github.com/rich-murphey) modified Twidor
to support [Twiddler v3 keyboard layouts](https://twiddler.tekgear.com/tuner/edit.xhtml),
released a simplified windows installer, and added build files
and documentation.
