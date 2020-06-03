Installation
===========

Alpha release 0.1, things will change (for the better we hope).

Only tested on linux and WSL Amd x86_64 elf. (there is no assembler so it should be platform independent)

Prerequisites
------

__Required__
* Java 8 JDK (OpenJDk is fine)
* C Compiler (don't get mixed up between C and C++) either clang or GCC, possibly other must support -std=gnu11
clang is currently preferred
  * gcc > 7.4.0 `apt-get install clang`
  * clang > 6.0.0 `apt-get install clang`
* valgrind `sudo apt-get install valgrind`
* maven `sudo apt-get install maven`

__Optional__
* clang-format `sudo apt install clang-format`
* visual studio code `@see https://linuxize.com/post/how-to-install-visual-studio-code-on-ubuntu-18-04/`

Build Core support library
-------
The core support library is C (some coded in C, some coded in EC)

- change the compiler in Makefile if required

```
cd c-bin
make
```

Build the Compiler
----
`mvn clean compile`

Compile and run one of the examples
----

-- java.argfile

`./compile if`

compiles examples/if.ec to c-lang/Default.if_main

Misc
-----
`mvn test`
`./compile_ectest`

Generate the core Library
---

This will generate the signatures, headers and c files, to /c-bin/gen
you still need to manually copy them into their respective homes and run make. 
```
c-bin
c-bin/include
```
__Changes here can have a significant impact.__

`./generate_core.sh`