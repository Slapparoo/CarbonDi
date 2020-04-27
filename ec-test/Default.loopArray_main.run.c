#define DEBUG 1
#include "Default.loopArray_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    loopArray_1241149816_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}