

all : maven core

maven :
	mvn clean compile

core :
	cd core;make;cd ..

test :
	mvn test

ectest :
	./compile_ectest

gencore :
	sh ./generate_core.sh

deploycore : 
	@if [ -d core ]; then mv core core.old; fi
	@if [ -d coregen ]; then mv coregen core; fi

restorecore : gencore
	mv core coregen.old
	mv core.old core
