#!/bin/sh
set -x
PACKAGE_NAME="twidor"
PACKAGE_VERSION=$(sed -n 's/^version=//p' ../src/Twidor.properties)
SOURCE_DIR=../dist
TEMP_DIR="./tmp"
BUILD_DIR=../dist/lib

if [ -d $TEMP_DIR/$$ ]; then
    echo ERROR: temp dir alread exists: $TEMP_DIR/$$
    exit 1
fi
$TEMP_DIR=$TEMP_DIR/$$
mkdir -p $TEMP_DIR/debian/DEBIAN

mkdir -p $TEMP_DIR/debian/DEBIAN
mkdir -p $TEMP_DIR/debian/lib
mkdir -p $TEMP_DIR/debian/usr/bin
mkdir -p $TEMP_DIR/debian/usr/share/applications
mkdir -p $TEMP_DIR/debian/usr/share/$PACKAGE_NAME
mkdir -p $TEMP_DIR/debian/usr/share/doc/$PACKAGE_NAME
mkdir -p $TEMP_DIR/debian/usr/share/common-licenses/$PACKAGE_NAME

echo "Package: $PACKAGE_NAME" > $TEMP_DIR/debian/DEBIAN/control
echo "Version: $PACKAGE_VERSION" >> $TEMP_DIR/debian/DEBIAN/control
cat control >> $TEMP_DIR/debian/DEBIAN/control

cp *.desktop $TEMP_DIR/debian/usr/share/applications/
cp copyright $TEMP_DIR/debian/usr/share/common-licenses/$PACKAGE_NAME/

cp $BUILD_DIR/*.jar $TEMP_DIR/debian/usr/share/$PACKAGE_NAME/
cp $PACKAGE_NAME $TEMP_DIR/debian/usr/bin/

echo "$PACKAGE_NAME ($PACKAGE_VERSION) stretch; urgency=low" > changelog
echo "  * Rebuild" >> changelog
echo " -- Rich Murphey  `date -R`" >> changelog
gzip -9c changelog > $TEMP_DIR/debian/usr/share/doc/$PACKAGE_NAME/changelog.gz

cp ../src/icon.gif $TEMP_DIR/debian/usr/share/$PACKAGE_NAME/
chmod 0664 $TEMP_DIR/debian/usr/share/$PACKAGE_NAME/*.gif

PACKAGE_SIZE=`du -bs $TEMP_DIR/debian | cut -f 1`
PACKAGE_SIZE=$((PACKAGE_SIZE/1024))
echo "Installed-Size: $PACKAGE_SIZE" >> $TEMP_DIR/debian/DEBIAN/control

# chown -R root $TEMP_DIR/debian/
# chgrp -R root $TEMP_DIR/debian/

(cd $TEMP_DIR/; fakeroot dpkg --build debian)
mv -f $TEMP_DIR/debian.deb $SOURCE_DIR/$PACKAGE_NAME-$PACKAGE_VERSION.deb
rm -rf $TEMP_DIR changelog
