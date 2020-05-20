#include "Default.encapsulation_main.h"

void encapsulation_2089542503_main() {

  __onEnter(); /*va1*/
  num encapsulation = /*cd1*/ create_c_1085510111_Encapsulation$1(100, 100);
  /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Encapsulation_cm *)useObject(/*te8*/ encapsulation)->classmodel)
      ->printMe(/*te8*/ encapsulation);
  /*st*/ /*fc2 null */ testi64Equal("count1", 100,
                                    /*te14a*/
                                    ((c_1085510111_Encapsulation_cm *)useObject(/*te8*/ encapsulation)->classmodel)
                                        ->get_count1(/*te8*/ encapsulation));
  /*st*/ /*fc2 null */ testi64Equal("count2", 205,
                                    /*te14a*/
                                    ((c_1085510111_Encapsulation_cm *)useObject(/*te8*/ encapsulation)->classmodel)
                                        ->get_count2(/*te8*/ encapsulation));
  /*st*/ /*fc2 null */ testi64Equal(
      "count3", 410,
      /*te14a1*/
      ((c_1085510111_Encapsulation_cm *)useObject(/*te8*/ encapsulation)->classmodel)->count3(/*te8*/ encapsulation));

  __onExit();
}
