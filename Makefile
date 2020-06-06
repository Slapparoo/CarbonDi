

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

deploycore : gencore
	mv c-bin c-bin.old
	mv c-gen c-bin

restorecore : gencore
	mv c-bin c-gen.old
	mv c-bin.old c-bin
