#define DEBUG 1
#include "Default.classProperties_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    classProperties_1828354306_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}