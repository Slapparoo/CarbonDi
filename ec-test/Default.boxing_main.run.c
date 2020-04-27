#define DEBUG 1
#include "Default.boxing_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    boxing_124813988_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}