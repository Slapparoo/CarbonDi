#define DEBUG 1
#include "Default.array_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    array_695922764_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}