LIBNAME=Core

rm -fr coregen
mkdir coregen

cp core/*.c coregen

mkdir coregen/test
cp core/test/*.c coregen/test

for f in  `ls -v src/main/ec/*.ec`
do
/usr/lib/jvm/java-11-openjdk-amd64/bin/java -Dfile.encoding=UTF-8 @java.argfile ec.lang.BasicWalk $f coregen -nolib -nogen -incsig
done


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
