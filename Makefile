

all : maven core

maven :
	mvn clean compile

core :
	cd c-bin;make;cd ..

test :
	mvn test

ectest :
	./compile_ectest

gencore :
	sh ./generate_core.sh

