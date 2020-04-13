#include "types.h"

void someMethod() {
  printf("Message 1\n");
  throwException("error here");
  printf("Message 2\n");
}

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
