#include "Default.static_main.h"

void static_615452379_main() {

  __onEnter(); /*va1*/
  num simpleObject = /*cd1*/ create_c_1085510111_SimpleObject$1(11);
  /*st*/ /*fc2 null */ printf(
      "count1(11)=%li, count2(51)=%li, count3(27)=%li, constNumber(66)=%li\n",
      /*te14a*/
      ((c_1085510111_SimpleObject_cm *)useObject(/*te8*/ simpleObject)->classmodel)->get_count1(/*te8*/ simpleObject),
      /*te14*/ ((c_1085510111_SimpleObject_cm *)getc_1085510111_SimpleObject_cm())->get_count2(),
      /*te14a*/
      ((c_1085510111_SimpleObject_cm *)useObject(/*te8*/ simpleObject)->classmodel)->get_count3(/*te8*/ simpleObject),
      /*fc4*/ ((c_1085510111_SimpleObject_cm *)getc_1085510111_SimpleObject_cm())->constNumber());
  /*st*/ /*fc2 null */ testi64Equal(
      "simpleObject.count1 1", 11,
      /*te14a*/
      ((c_1085510111_SimpleObject_cm *)useObject(/*te8*/ simpleObject)->classmodel)->get_count1(/*te8*/ simpleObject));
  /*st*/ /*fc2 null */ testi64Equal(
      "simpleObject.count2 1", 51,
      /*te14*/ ((c_1085510111_SimpleObject_cm *)getc_1085510111_SimpleObject_cm())->get_count2());
  /*st*/ /*fc2 null */ testi64Equal(
      "simpleObject.count3 1", 27,
      /*te14a*/
      ((c_1085510111_SimpleObject_cm *)useObject(/*te8*/ simpleObject)->classmodel)->get_count3(/*te8*/ simpleObject));
  /*st*/ /*fc2 null */ testi64Equal(
      "simpleObject.constNumber() 1", 66,
      /*fc4*/ ((c_1085510111_SimpleObject_cm *)getc_1085510111_SimpleObject_cm())->constNumber());
  /*st*/ /*fc2 null */ testi64Equal(
      "simpleObject.constNumber() 1", 66,
      /*fc4*/ ((c_1085510111_SimpleObject_cm *)getc_1085510111_SimpleObject_cm())->constNumber());
  /*Ax2*/ /*te14b*/ ((c_1085510111_SimpleObject_cm *)useObject(/*te8*/ simpleObject)->classmodel)
      ->set_count1(/*te8*/ simpleObject, 99);
  /*Ax2*/ /*te14c*/ ((c_1085510111_SimpleObject_cm *)getc_1085510111_SimpleObject_cm())->set_count2(33);
  /*st*/ /*fc2 null */ printf(
      "count1(99)=%li, count2(33)=%li, count3(33)=%li, constNumber(66)=%li\n",
      /*te14a*/
      ((c_1085510111_SimpleObject_cm *)useObject(/*te8*/ simpleObject)->classmodel)->get_count1(/*te8*/ simpleObject),
      /*te14*/ ((c_1085510111_SimpleObject_cm *)getc_1085510111_SimpleObject_cm())->get_count2(),
      /*te14a*/
      ((c_1085510111_SimpleObject_cm *)useObject(/*te8*/ simpleObject)->classmodel)->get_count3(/*te8*/ simpleObject),
      /*fc4*/ ((c_1085510111_SimpleObject_cm *)getc_1085510111_SimpleObject_cm())->constNumber());
  /*st*/ /*fc2 null */ testi64Equal(
      "simpleObject.count1 2", 99,
      /*te14a*/
      ((c_1085510111_SimpleObject_cm *)useObject(/*te8*/ simpleObject)->classmodel)->get_count1(/*te8*/ simpleObject));
  /*st*/ /*fc2 null */ testi64Equal(
      "simpleObject.count2 2", 33,
      /*te14*/ ((c_1085510111_SimpleObject_cm *)getc_1085510111_SimpleObject_cm())->get_count2());
  /*st*/ /*fc2 null */ testi64Equal(
      "simpleObject.count3 2", 27,
      /*te14a*/
      ((c_1085510111_SimpleObject_cm *)useObject(/*te8*/ simpleObject)->classmodel)->get_count3(/*te8*/ simpleObject));
  /*st*/ /*fc2 null */ testi64Equal(
      "simpleObject.constNumber() 2", 66,
      /*fc4*/ ((c_1085510111_SimpleObject_cm *)getc_1085510111_SimpleObject_cm())->constNumber());
  /*st*/ /*fc2 null */ testi64Equal(
      "SimpleObject.count2 3", 33,
      /*te14*/ ((c_1085510111_SimpleObject_cm *)getc_1085510111_SimpleObject_cm())->get_count2());
  /*st*/ /*fc2 null */ testi64Equal(
      "SimpleObject.constNumber() 3", 66,
      /*fc4*/ ((c_1085510111_SimpleObject_cm *)getc_1085510111_SimpleObject_cm())->constNumber());

  __onExit();
}
