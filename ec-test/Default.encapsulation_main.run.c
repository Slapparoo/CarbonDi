#define DEBUG 1
#include "Default.encapsulation_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    encapsulation_2089542503_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}