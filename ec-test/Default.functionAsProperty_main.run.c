#define DEBUG 1
#include "Default.functionAsProperty_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    functionAsProperty_1565957364_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}