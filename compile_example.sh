#!/bin/sh 

rm -rf c-lang
mkdir -p c-lang/obj
mkdir -p c-lang/examples/obj


JAVA=/usr/lib/jvm/java-11-openjdk-amd64/bin/java
CC=clang

$CC -Wno-invalid-pp-token -xc --include=core/include/Core.macro.h -E examples/$1.ec > c-lang/$1.ec
$JAVA -jar target/ec-1.0-SNAPSHOT-jar-with-dependencies.jar c-lang/$1.ec -ODc-lang -CD${PWD} -CCclang -CO'-std=gnu11 -O3 -g' -CF

# rm -f c-lang/$1.ec
# $JAVA @java.argfile ec.lang.BasicWalk examples/$1.ec c-lang -CCclang -CO'-std=gnu11 -O3 -g' -CF
# $JAVA @java.argfile ec.lang.BasicWalk examples/$1.ec c-lang -CCclang -CO'-std=gnu17 -O3 -g' -CF -clean
