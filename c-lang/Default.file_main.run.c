#define DEBUG 1
#include "Default.file_main.h"

int main() {
  int res = 0;
  if (!setjmp(*catchException())) {
    file_531600087_main();
  } else {
    afterCatchException();
    res = 1;
  }
  __onFinalExit();
  return res;
}