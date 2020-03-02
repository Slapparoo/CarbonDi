#ifndef __TYPES_H__
#define __TYPES_H__

#include "stdio.h"

typedef struct String {
    char* ch;
} String;

typedef struct stdout1 {
    int (*print)(const char *, ...);
} stdout1;

typedef struct stderr1 {
    int (*print)(const char *, ...);
} stderr1;

stdout1 out;
stderr1 err;

int main () {

    out.print = printf;
    err.print = printf;

    String ch = {"val"};
    // ch.ch = "val";
    
    out.print("%s, %d\n", ch, 5);
    err.print("%s, %d\n", ch, 6);
    return 0;
};

#endif