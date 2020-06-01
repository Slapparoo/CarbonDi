LIBNAME=Core

rm -f c-bin/gen
mkdir c-bin/gen

for f in  `ls -v src/main/ec/*.ec`
do
echo "/usr/lib/jvm/java-11-openjdk-amd64/bin/java -Dfile.encoding=UTF-8 @java.argfile ec.lang.BasicWalk $f c-bin"
/usr/lib/jvm/java-11-openjdk-amd64/bin/java -Dfile.encoding=UTF-8 @java.argfile ec.lang.BasicWalk $f c-bin/gen -nolib -nogen -incsig
done


mkdir c-bin/gen/include
cp c-bin/include/* c-bin/gen/include
mv c-bin/gen/*.h c-bin/gen/include
# @FIXME
cp c-bin/include/Core.Core_main.h c-bin/gen/include
cp c-bin/Makefile c-bin/gen

cd c-bin/gen; make; cd ../..

