#include "Default.array_main.h"

num getNumbers(num howMany) {

  u64 entry$ = __onEnter();
  num result = create_c_2106303_Array$1(10, ((c_2106303_Boxing_cm *)getc_2106303_Boxing_cm())->i8_, sizeof(i8));
  return __exitReturn_ref_un(/*te8*/ result, entry$);
}

num getOtherNumbers() {

  u64 entry$ = __onEnter();
  num result = create_c_2106303_Array$1(10, ((c_2106303_Boxing_cm *)getc_2106303_Boxing_cm())->i8_, sizeof(i8));
  /*va1*/ i8 otherNos = /*te8*/ result;
  return __exitReturn_ref_un(/*te8*/ otherNos, entry$);
}

void array_695922764_main() {

  __onEnter();
  num numbers = create_c_2106303_Array$1(10, ((c_2106303_Boxing_cm *)getc_2106303_Boxing_cm())->i8_, sizeof(i8));
  num anarray = create_c_2106303_Array$1(10, ((c_2106303_Boxing_cm *)getc_2106303_Boxing_cm())->i8_, sizeof(i8));
  num anarray2 = create_c_2106303_Array$1(10, ((c_2106303_Boxing_cm *)getc_2106303_Boxing_cm())->i8_, sizeof(i8));
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 0L) /*te8*/ = 's';
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 1) /*te8*/ = 't';
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 2) /*te8*/ = 'r';
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 3) /*te8*/ = 'i';
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 4) /*te8*/ = 'n';
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 5) /*te8*/ = 'g';
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 6) /*te8*/ = '\n';
  /*va1*/ i8 otherNumbers = /*te8*/ numbers;
  /*Ax4*/ /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(otherNumbers)->classmodel)->get(otherNumbers, 0) /*te8*/ =
      'S';
  /*va1*/ num moreNumbers = /*fc2 null */ getNumbers(3);
  /*va1*/ num someMoreNumbers = /*fc2 null */ getOtherNumbers();
  num anumber = /*at3*/ *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 0);
  /*va1*/ pointer values2 =
      /*te14a*/ ((c_2106303_Array_cm *)useObject(/*te8*/ numbers)->classmodel)->get_values(/*te8*/ numbers);
  num names = create_c_2106303_RefArray$1(2);
  /*Ax3*/ ((c_2106303_RefArray_cm *)getc_2106303_RefArray_cm())
      ->setObject(names, 0, /*se*/ create_c_2106303_String$2("Some name", true));
  /*Ax3*/ ((c_2106303_RefArray_cm *)getc_2106303_RefArray_cm())
      ->setObject(names, 1, /*se*/ create_c_2106303_String$2("Another name", true));
  /*st*/ /*fc2 null */ testStrEqual(
      "names[0]", "Some name",
      /* switch from fc5 to te4*/
      ((c_2106303_Array_cm *)useObject(
           /*te4*/ *((num *)((c_2106303_RefArray_cm *)getc_2106303_RefArray_cm())->get(names, 0)))
           ->classmodel)
          ->asStr(/*te4*/ *((num *)((c_2106303_RefArray_cm *)getc_2106303_RefArray_cm())->get(names, 0))));
  /*st*/ /*fc2 null */ testStrEqual(
      "names[1]", "Another name",
      /* switch from fc5 to te4*/
      ((c_2106303_Array_cm *)useObject(
           /*te4*/ *((num *)((c_2106303_RefArray_cm *)getc_2106303_RefArray_cm())->get(names, 1)))
           ->classmodel)
          ->asStr(/*te4*/ *((num *)((c_2106303_RefArray_cm *)getc_2106303_RefArray_cm())->get(names, 1))));
  /*st*/ /*fc2 null */ testStrEqual(
      "numbers", "String\n",
      /*te14a*/ ((c_2106303_Array_cm *)useObject(/*te8*/ numbers)->classmodel)->get_values(/*te8*/ numbers));
  /*st*/ /*fc2 null */ testStrEqual("numbers", "String\n", /*te8*/ values2);

  __onExit();
}
