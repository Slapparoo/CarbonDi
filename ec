#!/bin/sh 
BASEDIR=$(dirname "$0")
JAVA=/usr/lib/jvm/java-11-openjdk-amd64/bin/java
CC=clang
ECDIR=`realpath $BASEDIR`


$CC -Wno-invalid-pp-token -xc --include=${ECDIR}/core/include/Core.macro.h -E $1.ec > /tmp/$1.ec
$JAVA -jar $ECDIR/target/ec-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp/$1.ec -OD/tmp -CD${ECDIR}  -CCclang -CO'-std=gnu11 -O3 -g' -CF -clean -norun

( mv /tmp/Default.${1}_main .) > /dev/null

