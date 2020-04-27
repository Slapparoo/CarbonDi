#define DEBUG 1
#include "Default.classMethods_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    classMethods_49504825_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}