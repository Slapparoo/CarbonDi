#include "Default.loopArray_main.h"

void loopArray_1241149816_main() {

  __onEnter();
  num numbers = create_c_2106303_Array$1(10, ((c_2106303_Boxing_cm *)getc_2106303_Boxing_cm())->i8_, sizeof(i8));
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 0L) /*te8*/ = 's';
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 1) /*te8*/ = 't';
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 2) /*te8*/ = 'r';
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 3) /*te8*/ = 'i';
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 4) /*te8*/ = 'n';
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 5) /*te8*/ = 'g';
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 6) /*te8*/ = '\n';
  /*st*/ /*fc2 null */ printf(
      "numbers %s",
      /*te14a*/ ((c_2106303_Array_cm *)useObject(/*te8*/ numbers)->classmodel)->get_values(/*te8*/ numbers));
  /*va1*/ u64 len = /*fc2 null */ strlen(
      /*te14a*/ ((c_2106303_Array_cm *)useObject(/*te8*/ numbers)->classmodel)->get_values(/*te8*/ numbers));
  /*st*/ /*fc2 null */ testi64Equal("numbers length 1", 7, /*te8*/ len);
  /*la1*/ u64 al$ = ((c_2106303_Array_cm *)useObject(/*te8*/ numbers)->classmodel)->get_length(/*te8*/ numbers);
  for (u64 i$ = 0; i$ < al$; i$++) {
    i8 *a__$a = (i8 *)((c_2106303_Array_cm *)useObject(/*te8*/ numbers)->classmodel)->get(/*te8*/ numbers, i$);
    {

      __onEnter();
      if (/*oxa*/ /*te8*/ *a__$a > /*oxb*/ 20) {

        __onEnter(); /*st*/ /*fc2 null */
        printf("loop %u %c\n", /*te8*/ *a__$a, /*te8*/ *a__$a);

        __onExit();
      }

      /*Ax4*/ /*te8*/ *a__$a /*te8*/ = 0;

      __onExit();
    }
  }
  /*st*/ /*fc2 null */ printf(
      "numbers %s\n",
      /*te14a*/ ((c_2106303_Array_cm *)useObject(/*te8*/ numbers)->classmodel)->get_values(/*te8*/ numbers));
  /*va1*/ u64 len2 = /*fc2 null */ strlen(
      /*te14a*/ ((c_2106303_Array_cm *)useObject(/*te8*/ numbers)->classmodel)->get_values(/*te8*/ numbers));
  /*st*/ /*fc2 null */ testi64Equal("numbers length 2", 0, /*te8*/ len2);

  __onExit();
}
