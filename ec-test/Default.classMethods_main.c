#include "Default.classMethods_main.h"

void classMethods_49504825_main() {

  __onEnter(); /*va1*/
  num c1 = /*cd1*/ create_c_1085510111_MyClass();
  /*va1*/ i64 number =
      /* switch from fc5 to te4*/ ((c_1085510111_MyClass_cm *)useObject(/*te8*/ c1)->classmodel)->someValue(/*te8*/ c1);
  /*Ax2*/ /*te14b*/ ((c_1085510111_MyClass_cm *)useObject(/*te8*/ c1)->classmodel)
      ->set_value(/*te8*/ c1, /*te8*/ number);
  /*Ax2*/ /*te14b*/ ((c_1085510111_MyClass_cm *)useObject(/*te8*/ c1)->classmodel)
      ->set_name(/*te8*/ c1, /*se*/ create_c_2106303_String$2("ma_name", true));
  /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_MyClass_cm *)useObject(/*te8*/ c1)->classmodel)
      ->myPrint(/*te8*/ c1);
  /*va1*/ num c2 = /*cd1*/ create_c_1085510111_MySecondClass();
  /*Ax2*/ /*te14b*/ ((c_1085510111_MySecondClass_cm *)useObject(/*te8*/ c2)->classmodel)->set_value(/*te8*/ c2, 2);
  /*Ax2*/ /*te14b*/ ((c_1085510111_MySecondClass_cm *)useObject(/*te8*/ c2)->classmodel)
      ->set_name(/*te8*/ c2, /*se*/ create_c_2106303_String$2("c1_name", true));
  /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_MySecondClass_cm *)useObject(/*te8*/ c2)->classmodel)
      ->myPrint(/*te8*/ c2);

  __onExit();
}
