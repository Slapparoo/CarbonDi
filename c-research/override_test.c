#include <stdio.h>
#include <stdarg.h>

typedef void* pointer;
typedef void (*basic_function)();

struct tt1 {
    int (*new$1)(int);
    int (*new$2)(int, int);
} tt1;

void first_override(int calltype, ...) {
    printf("override\n");
    va_list parameters;

    switch (calltype) {
        case 1 : 
            
            va_start (parameters, calltype);
            int p1 = va_arg (parameters, int);
            int p2 = va_arg (parameters, int);
            double p3 = va_arg (parameters, double);
            va_end (parameters);

            printf("params %i, %i, %f\n", p1, p2, p3);
        break;
    }
}

void first_override$1(int p1, int p2, double p3) {
      printf("params %i, %i, %f\n", p1, p2, p3);
}

void callFunction(void(*funct)()) {
    printf("callFunction\n");   
    funct();
}

void callFunction2(basic_function funct) {
    printf("callFunction2\n");   
    funct();
}

void callFunction3(pointer funct) {
    printf("callFunction3.1\n");   
    if (funct == NULL) {
        return;
    }
    printf("callFunction3.2\n");   

    basic_function f =funct;
    f();
}

void first() {
    // function x(void(int));
    // x = { print $a; };  // annoymous param
    // x = (a){ print a; }; // named param
    // function x(void(int, int, int));
    // function x(void(..)); = x(void(Object[]));
    // function x(void(int..)); = x(void(int[]));
    // function x(int(int)) = (a){ return a;};
    // function x(void(int)) = { print $a;};
    // function x(void(int)) = { print $a;};
    printf("first\n");   
}

int main() {   
    int a = 20;

    pointer f = first;
    callFunction(f);
    callFunction2(f);
    callFunction3(f);
    callFunction3(NULL);

    first_override(1, a, 10, 3.2);
    first_override$1(a, 11, 4.2);
    return 0;
}