#!/bin/sh

VALGRIND=valgrind
JAVA=/usr/lib/jvm/java-11-openjdk-amd64/bin/java
CC=clang

(
echo "rm c-lang/*"
rm ec-test/*
echo "rm c-lang/obj/*"
rm ec-test/obj/*
mkdir ec-test/obj
 ) 2> /dev/null

FRS=0


for ff in ec-test/tests/*
do
    filename=$(basename -- ${ff%.*})

    $CC -Wno-invalid-pp-token -xc --include=core/include/Core.macro.h -E ec-test/tests/${filename}.ec > ec-test/${filename}.ec
    $JAVA -jar target/ec-1.0-SNAPSHOT-jar-with-dependencies.jar ec-test/${filename}.ec -ODec-test -CD${PWD} -CCclang -CO'-std=gnu11 -O3 -g' -CF -clean > /dev/null

    if [ -e ec-test/Default.${filename}_main ]
    then
        ( $VALGRIND --track-origins=yes --error-exitcode=2 --leak-check=full ec-test/Default.${filename}_main 2>  ec-test/${filename}.valgrind.txt ) > /dev/null
        RS=$?
        if [ $RS -ne 0 ]
        then 
            echo "[Error] valgrind ${filename}.ec result $RS"
            FRS=$RS
        else 
            echo "Ok ${filename}.ec"
        fi
    else 
        echo "[error] no main (compile error) ${filename}.ec"
    fi
done

exit $FRS