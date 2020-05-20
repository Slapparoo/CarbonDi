#include "Default.classProperties_main.h"

num getAString() {

  u64 entry$ = __onEnter(); /*rx2*/
  return __exitReturn_ref_un(/*se*/ create_c_2106303_String$2("the new name", true), entry$);
}

void classProperties_1828354306_main() {

  __onEnter(); /*va1*/
  num c1 = /*cd1*/ create_c_1085510111_MyClass();
  /*Ax2*/ /*te14b*/ ((c_1085510111_MyClass_cm *)useObject(/*te8*/ c1)->classmodel)
      ->set_name(/*te8*/ c1, /*fc2 null */ getAString());
  /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_MyClass_cm *)useObject(/*te8*/ c1)->classmodel)
      ->myPrint(/*te8*/ c1);
  /*va1*/ num mySecondClass =
      /*cd1*/ create_c_1085510111_MySecondClass$2(100, /*se*/ create_c_2106303_String$2("the name", true));
  /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_MySecondClass_cm *)useObject(/*te8*/ mySecondClass)->classmodel)
      ->myPrint(/*te8*/ mySecondClass);
  /*va1*/ num myOtherClass = /*cd1*/ create_c_1085510111_MyOtherClass();

  for (num a__$a = 0; a__$a < 10; a__$a++) {

    __onEnter(); /*va1*/
    num myClass = /*cd1*/ create_c_1085510111_MyClass();
    /*Ax2*/ /*te14b*/ ((c_1085510111_MyClass_cm *)useObject(/*te8*/ myClass)->classmodel)
        ->set_value(/*te8*/ myClass, /*te8*/ a__$a);
    /*Ax2*/ /*te14b*/ ((c_1085510111_MyOtherClass_cm *)useObject(/*te8*/ myOtherClass)->classmodel)
        ->set_myClass(/*te8*/ myOtherClass, /*te8*/ myClass);
    /*st*/ /*fc2 null */ printf("loop %ld.\n", /*te8*/ a__$a);

    __onExit();
  }

  __onExit();
}
