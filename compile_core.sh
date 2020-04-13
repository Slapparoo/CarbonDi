#mvn clean compile
mkdir c-bin 2> /dev/null
mkdir c-bin/obj 2> /dev/null
mkdir c-bin/gen 2> /dev/null
echo "rm ec-bin/gen/*"
rm c-bin/gen/* 2> /dev/null
echo "rm c-bin/obj/*"
rm c-bin/obj/* 2> /dev/null

LIBNAME=Core

for f in src/main/ec/*.ec
do
echo "/usr/lib/jvm/java-11-openjdk-amd64/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_35lbmltlo5sxoyz655ps47hy1.argfile ec.lang.BasicWalk $f c-bin"
/usr/lib/jvm/java-11-openjdk-amd64/bin/java -Dfile.encoding=UTF-8 @/tmp/cp_35lbmltlo5sxoyz655ps47hy1.argfile ec.lang.BasicWalk $f c-bin/gen
done

