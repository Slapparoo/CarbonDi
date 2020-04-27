#include "Default.functionAsProperty_main.h"

void functionAsProperty_1565957364_main() {

  __onEnter(); /*va1*/
  num myFunctionAsProperty = /*cd1*/ create_c_1085510111_MyFunctionAsProperty();
  /*Ax2*/ /*te14b1*/ ((c_1085510111_MyFunctionAsProperty_cm *)useObject(/*te8*/ myFunctionAsProperty)->classmodel)
      ->setName(/*te8*/ myFunctionAsProperty, /*se*/ create_c_2106303_String$2("the name", true));
  /*st*/ /*fc2 null */ printf(
      "MyFunctionAsProperty %s\n",
      /*te14a1*/ (
          (c_2106303_String_cm *)useObject(
              /*te14a1*/ ((c_1085510111_MyFunctionAsProperty_cm *)useObject(/*te8*/ myFunctionAsProperty)->classmodel)
                  ->getName(/*te8*/ myFunctionAsProperty))
              ->classmodel)
          ->asStr(
              /*te14a1*/ ((c_1085510111_MyFunctionAsProperty_cm *)useObject(/*te8*/ myFunctionAsProperty)->classmodel)
                  ->getName(/*te8*/ myFunctionAsProperty)));
  /*st*/ /*fc2 null */ printf(
      "MyFunctionAsProperty classname %s\n",
      /*te141*/ ((c_1085510111_MyFunctionAsProperty_cm *)getc_1085510111_MyFunctionAsProperty_cm())->getClassName());
  /*st*/ /*fc2 null */ print_log(
      3, /*te8*/ myFunctionAsProperty,
      /*te14a*/
      ((c_1085510111_MyFunctionAsProperty_cm *)useObject(/*te8*/ myFunctionAsProperty)->classmodel)
          ->get_name(/*te8*/ myFunctionAsProperty),
      /*te14a1*/
      ((c_1085510111_MyFunctionAsProperty_cm *)useObject(/*te8*/ myFunctionAsProperty)->classmodel)
          ->getName(/*te8*/ myFunctionAsProperty));

  __onExit();
}
