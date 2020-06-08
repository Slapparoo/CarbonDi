

all : maven core

# preprecess
# gcc  -xc -E if.ec -o if.preproc

maven :
	mvn clean package

core :
	cd core;make;cd ..

test : all mvntest ectest
#	make -C core test

mvntest :
	mvn test

ectest :
	sh ./compile_ectest.sh

gencore :
	sh ./generate_core.sh

deploycore : 
	@if [ -d core.old ]; then echo "core.old exists manually remove"; exit 1; fi 
	@if [ -d core ]; then mv core core.old; fi
	@if [ -d coregen ]; then mv coregen core; fi

restorecore : gencore
	mv core coregen.old
	mv core.old core
