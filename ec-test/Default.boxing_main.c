#include "Default.boxing_main.h"

void boxing_124813988_main() {

  __onEnter(); /*va1*/
  i64 unboxed = /* csf */ 0x1100100;
  /*va1*/ num boxed1 = /*cd1*/ create_c_2106303_I64$1(/*te8*/ unboxed);
  /*va1*/ i64 unboxed1 =
      /*te14a*/ ((c_2106303_I64_cm *)useObject(/*te8*/ boxed1)->classmodel)->get_value(/*te8*/ boxed1);
  /*va1*/ num boxed2 = /*te8*/ boxed1;
  /*va1*/ i64 unboxed2 =
      /*te14a*/ ((c_2106303_I64_cm *)useObject(/*te8*/ boxed2)->classmodel)->get_value(/*te8*/ boxed2);
  /*va1*/ i64 unboxed3 =
      /*te14a*/ ((c_2106303_I64_cm *)useObject(/*te8*/ boxed2)->classmodel)->get_value(/*te8*/ boxed2);
  /*va1*/ num boxed3 = /*cd1*/ create_c_2106303_I64$1(241L);
  /*st*/ /*fc2 null */ printf(
      "\n%s, %li, %li, %li\n",
      /*te14a1*/ ((c_2106303_I64_cm *)useObject(/*te8*/ boxed1)->classmodel)->asStr(/*te8*/ boxed1), /*te8*/ unboxed1,
      /*te8*/ unboxed2,
      /*te14a*/ ((c_2106303_I64_cm *)useObject(/*te8*/ boxed3)->classmodel)->get_value(/*te8*/ boxed3));
  /*va1*/ num str1 = /*cd1*/ create_c_2106303_String$1(
      /*te14a1*/ ((c_2106303_I64_cm *)useObject(/*te8*/ boxed1)->classmodel)->asStr(/*te8*/ boxed1));
  /*va1*/ num str2 = /*cd1*/ create_c_2106303_String$1("String2");
  /*va1*/ num str3 = /*se*/ create_c_2106303_String$2("String3", true);
  /*st*/ /*fc2 null */ printf(
      "\n%s\n%s\n%s\n", /*te14a1*/ ((c_2106303_String_cm *)useObject(/*te8*/ str1)->classmodel)->asStr(/*te8*/ str1),
      /*te14a1*/ ((c_2106303_String_cm *)useObject(/*te8*/ str2)->classmodel)->asStr(/*te8*/ str2),
      /*te14a1*/ ((c_2106303_String_cm *)useObject(/*te8*/ str3)->classmodel)->asStr(/*te8*/ str3));
  /*st*/ /*fc2 null */ testStrEqual(
      "str1", "17826048", /*te14a1*/ ((c_2106303_String_cm *)useObject(/*te8*/ str1)->classmodel)->asStr(/*te8*/ str1));
  /*st*/ /*fc2 null */ testStrEqual(
      "boxed1", "17826048",
      /*te14a1*/ ((c_2106303_I64_cm *)useObject(/*te8*/ boxed1)->classmodel)->asStr(/*te8*/ boxed1));
  /*st*/ /*fc2 null */ testStrEqual("boxed1.typename", "i64",
                                    /*te141*/ ((c_2106303_I64_cm *)getc_2106303_I64_cm())->typename());
  /*st*/ /*fc2 null */ testi64Equal("boxed1.datatype", 9,
                                    /*te141*/ ((c_2106303_I64_cm *)getc_2106303_I64_cm())->datatype());
  /*st*/ /*fc2 null */ testi64Equal(
      "boxed1.value", 17826048,
      /*te14a*/ ((c_2106303_I64_cm *)useObject(/*te8*/ boxed1)->classmodel)->get_value(/*te8*/ boxed1));
  /*Ax2*/ /*te14b*/ ((c_2106303_I64_cm *)useObject(/*te8*/ boxed1)->classmodel)->set_value(/*te8*/ boxed1, 243L);
  /*st*/ /*fc2 null */ testi64Equal(
      "boxed1.value", 243L,
      /*te14a*/ ((c_2106303_I64_cm *)useObject(/*te8*/ boxed1)->classmodel)->get_value(/*te8*/ boxed1));

  __onExit();
}
