#define DEBUG 1
#include "Default.if_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    if_1622897654_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}