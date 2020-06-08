LIBNAME=Core
CC=clang
SRCDIR=src/main/ec

rm -fr coregen
mkdir coregen

cp core/*.c coregen

mkdir coregen/test
cp core/test/*.c coregen/test

for ff in  `ls -v $SRCDIR/*.ec`
do
    filename=$(basename -- ${ff%.*})

    $CC -Wno-invalid-pp-token -xc --include=$SRCDIR/Core.macro.h -E $SRCDIR/${filename}.ec > /tmp/${filename}.ec
    java -jar target/ec-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp/${filename}.ec -ODcoregen -CD${PWD} -nolib -nogen -incsig
    rm /tmp/${filename}.ec
done


cp $SRCDIR/Core.macro.h coregen
mkdir coregen/include
cp core/include/* coregen/include
mv coregen/*.h coregen/include
# @FIXME
cp core/include/Core.Core_main.h coregen/include
cp core/Makefile coregen

rm coregen/Core.Core_main.run.c

cd coregen; make; make test; cd ..

mkdir coregen/doc
mv coregen/*.md coregen/doc
