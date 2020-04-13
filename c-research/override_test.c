#include <stdio.h>
#include <stdarg.h>

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


void first() {
    printf("first\n");   
}

int main() {   
    // __onEnter();
    int a = 20;

    first_override(1, a, 10, 3.2);
    first_override$1(a, 11, 4.2);
    // __onExit();
    // __onFinalExit();
    return 0;
}