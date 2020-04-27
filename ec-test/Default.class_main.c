#include "Default.class_main.h"

void class_697575275_main() {

  __onEnter(); /*va1*/
  num mySimpleObject = /*cd1*/ create_c_3556498_Class2$1(55);
  /*Ax2*/ /*te14b*/ ((c_3556498_Class2_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
      ->set_package(/*te8*/ mySimpleObject, /*se*/ create_c_2106303_String$2("mySimpleObject", true));
  /*st*/ /* switch from fc5 to te4*/ ((c_3556498_Class2_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
      ->myPrint(/*te8*/ mySimpleObject);
  /*st*/ /* switch from fc5 to te4*/ (
      (c_2106303_String_cm *)useObject(/*te14a*/ ((c_3556498_Class2_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
                                           ->get_package(/*te8*/ mySimpleObject))
          ->classmodel)
      ->asStr(/*te14a*/ ((c_3556498_Class2_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
                  ->get_package(/*te8*/ mySimpleObject));

  __onExit();
}
