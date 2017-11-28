## Twidor - a typing tutor for the Twiddler keyboard

This is a slightly modified version of [Evan Dower's](https://github.com/evantd) Twidor
typing tutor for the [Twiddler keyboard](https://twiddler.tekgear.com/).

Please note: This version is not yet stable.

This version differs from Evans in the input keymap file format.
This version reads CSV keymaps exported from
the [official twidler tuner web app](https://twiddler.tekgear.com/tuner/edit.xhtml).

As an example, one may:
* open https://twiddler.tekgear.com/tuner/edit.xhtml,
* select 'Edit Configuration' for a given configuration file,
* with the configuration file open, select Export, and then CSV.
* download the CSV file, and change the filename to keymap.txt, and
* place keymap.txt in the same direcory as the Twidor java .class files.
  
## Current Bugs

Pressing <enter> at the end of a line fails to present the next
line of the lesson.

<space>, <backspace> and <enter> key labels are not displayed.

## Authors

Evan Dower wrote Twidor.  Rich Murphey just modified the input file
format to accept the twidler tuner web app CSV format.
