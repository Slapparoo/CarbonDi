#include "Default.switch_main.h"

void switch_618461089_main() {

  __onEnter(); /*va1*/
  i64 exact = 0;
  /*va1*/ i64 ranged = 0;
  /*va1*/ i64 defaults = 0;

  for (num a__$a = 0; a__$a < 20; a__$a++) {

    __onEnter();
    switch (/*te8*/ a__$a) {

    case 10: /*st*/ /*te8*/
      exact++;
      /*st*/ break;

    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 16:
    case 17:
    case 18:
    case 19:
    case 20: /*st*/ /*te8*/
      ranged++;
      /*st*/ break;

    default: /*st*/ /*te8*/
      defaults++;
      /*st*/ break;
    }

    __onExit();
  }

  /*st*/ /*fc2 null */ testi64Equal("exact", /*te8*/ exact, 1);
  /*st*/ /*fc2 null */ testi64Equal("ranged", /*te8*/ ranged, 9);
  /*st*/ /*fc2 null */ testi64Equal("defaults", /*te8*/ defaults, 10);
  /*st*/ /*fc2 null */ printf("exact=%li, ranged=%li, defaults=%li\n", /*te8*/ exact, /*te8*/ ranged, /*te8*/ defaults);

  __onExit();
}
