#define DEBUG 1
#include "Default.static_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    static_615452379_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}