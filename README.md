## Twidor - a typing tutor for the Twiddler keyboard

This is typing tutor for the [Twiddler chording keyboard](https://twiddler.tekgear.com/).

This is a modified version based on work by the original author,  [Evan Dower's](https://github.com/evantd).
This version differs from Evans in the input keymap file format.
This version reads CSV keymaps exported from
the [official twidler tuner web app](https://twiddler.tekgear.com/tuner/edit.xhtml).

To generate a keymap suitable for input, one may:
* open https://twiddler.tekgear.com/tuner/edit.xhtml,
* select 'Edit Configuration' for a given configuration file,
* with the configuration file open, select Export, and then CSV.
* download the CSV file, and change the filename to keymap.txt, and
* place keymap.txt in the same direcory as the Twidor java .class files.
  
## Downloads

A windows executable is available here:

[https://github.com/rich-murphey/twidor/releases](https://github.com/rich-murphey/twidor/releases)

The executable release bundles only one keymap, the [Backspice keymap](https://raw.githubusercontent.com/AlexBravo/Twiddler/master/Backspice2%20cheat%20sheet.txt).

There is not yet any provision for loading other keymaps,
although the capabilty to parse other maps exists, and loading
others may be included in a future release

Please note: This is a beta pre-release. It has not been
sufficiently tested to be declared stable.

## Authors

Evan Dower wrote Twidor.  Rich Murphey just modified the input file
format to accept the twidler tuner web app CSV format.
