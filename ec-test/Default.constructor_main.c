#include "Default.constructor_main.h"

void constructor_1010422701_main() {

  __onEnter(); /*va1*/
  num stra = /*cd1*/ create_c_1085510111_MyString$1("Str1");
  /*va1*/ num strb = /*cd1*/ create_c_1085510111_MyString$2("Str2a\"", " str2b");
  /*st*/ /*fc2 null */ printf("%s, %s\n",
                              /* switch from fc5 to te4*/
                              ((c_1085510111_MyString_cm *)useObject(/*te8*/ stra)->classmodel)->asStr(/*te8*/ stra),
                              /* switch from fc5 to te4*/
                              ((c_1085510111_MyString_cm *)useObject(/*te8*/ strb)->classmodel)->asStr(/*te8*/ strb));
  /*st*/ /*fc2 null */ testStrEqual(
      "stra", "Str1", /* switch from fc5 to te4*/
      ((c_1085510111_MyString_cm *)useObject(/*te8*/ stra)->classmodel)->asStr(/*te8*/ stra));
  /*st*/ /*fc2 null */ testStrEqual(
      "strb", "Str2a\" str2b", /* switch from fc5 to te4*/
      ((c_1085510111_MyString_cm *)useObject(/*te8*/ strb)->classmodel)->asStr(/*te8*/ strb));

  __onExit();
}
