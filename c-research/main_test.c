#include <stdio.h>
#include <setjmp.h>
#include <types.h>

static jmp_buf buf;

void second() {
    printf("second\n");         // prints
    if (1) { 
        longjmp(buf,1);             // jumps back to where setjmp was called - making setjmp now return 1
    }
}

void first() {
    second();
    printf("first\n");          // does not print
}

int main() {   
    __onEnter();

    num name = String_create("main\n");

    if (!setjmp(buf))
        first();                // when executed, setjmp returned 0
    else                        // when longjmp jumps back, setjmp returns 1
        
        printf("%s", getStringClassModel()->asStr(name));       // prints

    __onExit();
    __onFinalExit();
    return 0;
}