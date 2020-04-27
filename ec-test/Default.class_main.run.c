#define DEBUG 1
#include "Default.class_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    class_697575275_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}