#define DEBUG 1
#include "Default.DynamicArray_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    DynamicArray_322617305_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}