LIBNAME=Core

rm -fr c-gen
mkdir c-gen

cp c-bin/*.c c-gen

mkdir c-gen/test
cp c-bin/test/*.c c-gen/test

for f in  `ls -v src/main/ec/*.ec`
do
/usr/lib/jvm/java-11-openjdk-amd64/bin/java -Dfile.encoding=UTF-8 @java.argfile ec.lang.BasicWalk $f c-gen -nolib -nogen -incsig
done


mkdir c-gen/include
cp c-bin/include/* c-gen/include
mv c-gen/*.h c-gen/include
# @FIXME
cp c-bin/include/Core.Core_main.h c-gen/include
cp c-bin/Makefile c-gen

rm c-gen/Core.Core_main.run.c

cd c-gen; make; make test; cd ..

