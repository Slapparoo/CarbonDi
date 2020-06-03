#include "Core.Core_main.h"

void someMethod() {
  printf("Message 1\n");
  throwException("error here (this message is ment to be here if you see this thats is good)");
  printf("Message 2\n");
}

/**
 * This has been superceded, but still partially relevant
 */ 

int main() {
  if (!setjmp(*catchException())) {
    someMethod();
    printf("normal path\n");
  } else {
    afterCatchException();
  }

  __onFinalExit();
  return 0;
}
