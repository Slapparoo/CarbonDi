#include "Default.file_main.h"

/*fd1*/ int filesize(pointer fp) {

  u64 entry$ = __onEnter(); /*va1*/
  int prev = /*fc2 null */ ftell(/*te8*/ fp);
  /*st*/ /*fc2 null */ fseek(/*te8*/ fp, 0, /*te8*/ SEEK_END);
  /*va1*/ int sz = /*fc2 null */ ftell(/*te8*/ fp);
  /*st*/ /*fc2 null */ fseek(/*te8*/ fp, /*te8*/ prev, /*te8*/ SEEK_SET);
  return __exitReturn_int_un(/*te8*/ sz, entry$);
}

/*fd1*/ num fileread(num filename) {

  u64 entry$ = __onEnter(); /*va1*/
  pointer fp = /*fc2 null */ fopen(
      /*te14a1*/ ((c_2106303_String_cm *)useObject(/*te8*/ filename)->classmodel)->asStr(/*te8*/ filename), "r");
  if (/*oxa*/ /*te8*/ fp == /*oxb*/ null) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[openfile] error opening file.");

    __onExit();
  }

  /*va1*/ u64 size = /*fc1*/ filesize(/*te8*/ fp);
  /*va1*/ u64 szp1 = /*oxa*/ /*te8*/ size + /*oxb*/ 1;
  num buffer = create_c_2106303_Array$1(szp1, ((c_2106303_Boxing_cm *)getc_2106303_Boxing_cm())->i8_, sizeof(i8));
  /*va1*/ num result = /*fc2 null */ fread(
      /*te14a*/ ((c_2106303_Array_cm *)useObject(/*te8*/ buffer)->classmodel)->get_values(/*te8*/ buffer), 1,
      /*te8*/ size, /*te8*/ fp);
  /*st*/ /*fc2 null */ fclose(/*te8*/ fp);
  if (/*oxa*/ /*te8*/ result != /*oxb*/ /*te8*/ size) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[readfile] error reading file.");

    __onExit();
  }

  /*rx1*/ return __exitReturn_ref_un(/*te8*/ buffer, entry$);
}

void file_531600087_main() {

  __onEnter();
  num content = /*fc1*/ fileread(/*se*/ create_c_2106303_String$2("Default.file_main.c", true));
  /*st*/ /*fc2 null */ printf(
      "file read content\n %s\n",
      /*te14a*/ ((c_2106303_Array_cm *)useObject(/*te8*/ content)->classmodel)->get_values(/*te8*/ content));

  __onExit();
}
