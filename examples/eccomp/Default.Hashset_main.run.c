#define DEBUG 1
#include "Default.Hashset_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    Hashset_1863523751_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}