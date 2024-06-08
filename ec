#!/bin/sh
BASEDIR=$(dirname "$0")
JAVA=`which java`
CC=clang
#CC=cc
ECDIR=`realpath ${BASEDIR}`
RUN=false
VERBOSE=false
TMPDIR=/tmp/eccomp
KEEPTMP=false
CLEANTMP=false

usage() {
    echo ec lang compiler
    echo "usage: `basename $0` [-r|--run] [-k|--keep] [-c|--clean] <filename>"
    exit 1
}

if [ $# -lt 1 ]; then 
    usage
fi

while [ "$1" != "" ]; do
    case $1 in
        -r | --run )            RUN=true
                                ;;
        -k | --keep )           KEEPTMP=true
                                ;;
        -c | --clean )          CLEANTMP=true
                                ;;
        * )                     filename=$1
    esac
    shift
done

if [ ! -f ${filename} ]; then
    echo file not found ${filename}
    usage
fi

FULLNAME=`realpath ${filename}`
WORKINGDIR=$(dirname "${FULLNAME}")
FILENAME=`basename ${filename}`
EXTENSION=${FILENAME##*.}
a=`expr length ${FILENAME}` 
b=`expr length ${EXTENSION}`
len=`expr ${a} - ${b} - 1`

FF=`expr substr ${FILENAME} 1 ${len}`

if [ "${CLEANTMP}" = "true" ]; then   
    rm -rf ${TMPDIR}
fi

if [ ! -f ${ECDIR}/target/ec-1.0-SNAPSHOT-jar-with-dependencies.jar ]; then
    echo CarbonDi jar not found doing a quick compile...
    cd ${ECDIR}
    make maven
    cd ${WORKINGDIR}
fi

if [ -d ${TMPDIR} ]; then
    echo temp dir ${TMPDIR} already exists.
    exit 1
fi

mkdir -p ${TMPDIR}

if  [ ! -d ${TMPDIR} ]; then
    echo [Error] creating temp dir ${TMPDIR}.
    exit 1
fi

# run the c pre=processor over it prior to EC -> C 
${CC} -Wno-invalid-pp-token -xc -CC --include=${ECDIR}/core/include/Core.macro.h -E ${FULLNAME} > ${TMPDIR}/${FILENAME}
# EC to C compile
${JAVA} -jar ${ECDIR}/target/ec-1.0-SNAPSHOT-jar-with-dependencies.jar ${TMPDIR}/${FILENAME} -OD${TMPDIR} -CD${ECDIR}  -CC${CC} -CO'-std=gnu11 -O3 -g' -CF -norun 
# TODO seperate out the c compile from the java

( mv ${TMPDIR}/Default.${FF}_main ${WORKINGDIR}) > /dev/null

echo [created] ${WORKINGDIR}/Default.${FF}_main
if [ "$RUN" = "true" ]; then
    echo [run] ${WORKINGDIR}/Default.${FF}_main
    ${WORKINGDIR}/Default.${FF}_main
fi

if [ "${KEEPTMP}" != "true" ]; then   
    rm -rf ${TMPDIR}
fi


