#define DEBUG 1
#include "Default.typedef_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    typedef_1351761986_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}