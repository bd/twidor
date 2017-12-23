
VERSION=`cat src/VERSION`

dist/twidor-$VERSION.deb: dist/lib/Twidor.jar
	cd pkg; ./packagedeb.sh

dist/lib/Twidor.jar: src/*.java src/lesson*.txt src/*.csv src/Twidor.properties
	ant

clean:
	ant clean
