#define DEBUG 1
#include "Default.constructor_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    constructor_1010422701_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}