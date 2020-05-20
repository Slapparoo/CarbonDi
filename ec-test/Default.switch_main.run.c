#define DEBUG 1
#include "Default.switch_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    switch_618461089_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}