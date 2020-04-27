#include "Default.DynamicArray_main.h"

void DynamicArray_322617305_main() {

  __onEnter(); /*st*/ /*fc2 null */
  debug_println("start %s", "here");
  /*va1*/ u64 n = 1;
  /*va1*/ i8 a = 50;
  /*va1*/ num myArray = /*cd1*/ create_c_1085510111_NewDynamicArray$1(
      /*te14*/ ((c_2106303_Boxing_cm *)getc_2106303_Boxing_cm())->get_i8_(), /*te8*/ n);
  /*va1*/ pointer myValue = /*fc2 null */ EC_ADDRESS(/*te8*/ a);
  /*st*/ /*te8*/ a++;
  if (100 > 0) {
    for (num a__$a = 0; a__$a < 100; a__$a++) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addHead(/*te8*/ myArray, /*te8*/ myValue);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("loop %i", /*te8*/ a);

      __onExit();
    }

  } else if (100 < 0) {
    num a__$a = 100 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addHead(/*te8*/ myArray, /*te8*/ myValue);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("loop %i", /*te8*/ a);

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf("after addHead capacity=%lu\n",
                              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ myArray)->data)->capacity);
  /*va1*/ i8 b = 0;
  if (-100 > 0) {
    for (num a__$a = 0; a__$a < -100; a__$a++) {

      __onEnter(); /*va1*/
      pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeHead(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("remove loop %lu %i", /*te8*/ a__$a, /*fc2 null */ EC_VALUE_i8(/*te8*/ b));

      __onExit();
    }

  } else if (-100 < 0) {
    num a__$a = -100 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*va1*/
      pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeHead(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("remove loop %lu %i", /*te8*/ a__$a, /*fc2 null */ EC_VALUE_i8(/*te8*/ b));

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf("after removehdead capacity=%lu\n",
                              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ myArray)->data)->capacity);
  if (100 > 0) {
    for (num a__$a = 0; a__$a < 100; a__$a++) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addTail(/*te8*/ myArray, /*te8*/ myValue);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("loop %i", /*te8*/ a);

      __onExit();
    }

  } else if (100 < 0) {
    num a__$a = 100 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addTail(/*te8*/ myArray, /*te8*/ myValue);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("loop %i", /*te8*/ a);

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf("after addtail capacity=%lu\n",
                              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ myArray)->data)->capacity);
  if (-100 > 0) {
    for (num a__$a = 0; a__$a < -100; a__$a++) {

      __onEnter(); /*va1*/
      pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeTail(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("remove loop %lu %i", /*te8*/ a__$a, /*fc2 null */ EC_VALUE_i8(/*te8*/ b));

      __onExit();
    }

  } else if (-100 < 0) {
    num a__$a = -100 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*va1*/
      pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeTail(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("remove loop %lu %i", /*te8*/ a__$a, /*fc2 null */ EC_VALUE_i8(/*te8*/ b));

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf("after remove tail capacity=%lu\n",
                              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ myArray)->data)->capacity);
  if (100 > 0) {
    for (num a__$a = 0; a__$a < 100; a__$a++) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addHead(/*te8*/ myArray, /*te8*/ myValue);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("loop %i", /*te8*/ a);

      __onExit();
    }

  } else if (100 < 0) {
    num a__$a = 100 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addHead(/*te8*/ myArray, /*te8*/ myValue);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("loop %i", /*te8*/ a);

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf("after addHead capacity=%lu\n",
                              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ myArray)->data)->capacity);
  if (-100 > 0) {
    for (num a__$a = 0; a__$a < -100; a__$a++) {

      __onEnter(); /*va1*/
      pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeTail(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("remove loop %lu %i", /*te8*/ a__$a, /*fc2 null */ EC_VALUE_i8(/*te8*/ b));

      __onExit();
    }

  } else if (-100 < 0) {
    num a__$a = -100 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*va1*/
      pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeTail(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("remove loop %lu %i", /*te8*/ a__$a, /*fc2 null */ EC_VALUE_i8(/*te8*/ b));

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf("after remove tail capacity=%lu\n",
                              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ myArray)->data)->capacity);
  if (100 > 0) {
    for (num a__$a = 0; a__$a < 100; a__$a++) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addHead(/*te8*/ myArray, /*te8*/ myValue);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("loop %i", /*te8*/ a);

      __onExit();
    }

  } else if (100 < 0) {
    num a__$a = 100 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addHead(/*te8*/ myArray, /*te8*/ myValue);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("loop %i", /*te8*/ a);

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf("after addHead capacity=%lu\n",
                              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ myArray)->data)->capacity);
  if (-100 > 0) {
    for (num a__$a = 0; a__$a < -100; a__$a++) {

      __onEnter(); /*va1*/
      pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeTail(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("remove loop %lu %i", /*te8*/ a__$a, /*fc2 null */ EC_VALUE_i8(/*te8*/ b));

      __onExit();
    }

  } else if (-100 < 0) {
    num a__$a = -100 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*va1*/
      pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeTail(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("remove loop %lu %i", /*te8*/ a__$a, /*fc2 null */ EC_VALUE_i8(/*te8*/ b));

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf("after remove tail capacity=%lu\n",
                              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ myArray)->data)->capacity);
  if (100 > 0) {
    for (num a__$a = 0; a__$a < 100; a__$a++) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addTail(/*te8*/ myArray, /*te8*/ myValue);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("loop %i", /*te8*/ a);

      __onExit();
    }

  } else if (100 < 0) {
    num a__$a = 100 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addTail(/*te8*/ myArray, /*te8*/ myValue);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("loop %i", /*te8*/ a);

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf("after addTail capacity=%lu\n",
                              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ myArray)->data)->capacity);
  if (-100 > 0) {
    for (num a__$a = 0; a__$a < -100; a__$a++) {

      __onEnter(); /*va1*/
      pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeHead(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("remove loop %lu %i", /*te8*/ a__$a, /*fc2 null */ EC_VALUE_i8(/*te8*/ b));

      __onExit();
    }

  } else if (-100 < 0) {
    num a__$a = -100 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*va1*/
      pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeHead(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;
      /*st*/ /*fc2 null */ debug_println("remove loop %lu %i", /*te8*/ a__$a, /*fc2 null */ EC_VALUE_i8(/*te8*/ b));

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf("after remove head capacity=%lu\n",
                              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ myArray)->data)->capacity);
  if (50 > 0) {
    for (num a__$a = 0; a__$a < 50; a__$a++) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addTail(/*te8*/ myArray, /*te8*/ myValue);
      /*st*/ /*te8*/ a++;

      __onExit();
    }

  } else if (50 < 0) {
    num a__$a = 50 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addTail(/*te8*/ myArray, /*te8*/ myValue);
      /*st*/ /*te8*/ a++;

      __onExit();
    }
  }
  if (100 > 0) {
    for (num a__$a = 0; a__$a < 100; a__$a++) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addTail(/*te8*/ myArray, /*te8*/ myValue);
      /*va1*/ pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeHead(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;

      __onExit();
    }

  } else if (100 < 0) {
    num a__$a = 100 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addTail(/*te8*/ myArray, /*te8*/ myValue);
      /*va1*/ pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeHead(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf("after remove head capacity=%lu\n",
                              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ myArray)->data)->capacity);
  if (100 > 0) {
    for (num a__$a = 0; a__$a < 100; a__$a++) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addHead(/*te8*/ myArray, /*te8*/ myValue);
      /*va1*/ pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeTail(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;

      __onExit();
    }

  } else if (100 < 0) {
    num a__$a = 100 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addHead(/*te8*/ myArray, /*te8*/ myValue);
      /*va1*/ pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeTail(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf("after remove head capacity=%lu\n",
                              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ myArray)->data)->capacity);
  if (100 > 0) {
    for (num a__$a = 0; a__$a < 100; a__$a++) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addTail(/*te8*/ myArray, /*te8*/ myValue);
      /*va1*/ pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeTail(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;

      __onExit();
    }

  } else if (100 < 0) {
    num a__$a = 100 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addTail(/*te8*/ myArray, /*te8*/ myValue);
      /*va1*/ pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeTail(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf("after remove head capacity=%lu\n",
                              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ myArray)->data)->capacity);
  if (100 > 0) {
    for (num a__$a = 0; a__$a < 100; a__$a++) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addHead(/*te8*/ myArray, /*te8*/ myValue);
      /*va1*/ pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeHead(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;

      __onExit();
    }

  } else if (100 < 0) {
    num a__$a = 100 * -1 - 1;
    for (; a__$a >= 0; a__$a--) {

      __onEnter(); /*Ax2*/ /*te14b1*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
          ->addHead(/*te8*/ myArray, /*te8*/ myValue);
      /*va1*/ pointer b =
          /* switch from fc5 to te4*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ myArray)->classmodel)
              ->removeHead(/*te8*/ myArray);
      /*st*/ /*te8*/ a++;

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf("after remove head capacity=%lu\n",
                              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ myArray)->data)->capacity);

  __onExit();
}
