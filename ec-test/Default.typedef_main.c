#include "Default.typedef_main.h"

void typedef_1351761986_main() {

  __onEnter(); /*va1*/
  num mySimpleObject = /*cd1*/ create_c_3556498_SimpleObject1$1(55, /*se*/ create_c_2106303_String$2("Name", true));
  /*st*/ /*fc2 null */ testStrEqual(
      "mySimpleObject.name 1", "Name",
      /* switch from fc5 to te4*/
      ((c_2106303_String_cm *)useObject(
           /*te14a*/ ((c_3556498_SimpleObject1_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
               ->get_name(/*te8*/ mySimpleObject))
           ->classmodel)
          ->asStr(/*te14a*/ ((c_3556498_SimpleObject1_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
                      ->get_name(/*te8*/ mySimpleObject)));
  /*st*/ /*fc2 null */ testi64Equal("mySimpleObject.number 1", 55,
                                    /*te14a*/
                                    ((c_3556498_SimpleObject1_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
                                        ->get_number(/*te8*/ mySimpleObject));
  /*Ax2*/ /*te14b*/ ((c_3556498_SimpleObject1_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
      ->set_name(/*te8*/ mySimpleObject, /*se*/ create_c_2106303_String$2("mySimpleObject message", true));
  /*Ax2*/ /*te14b*/ ((c_3556498_SimpleObject1_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
      ->set_number(/*te8*/ mySimpleObject, 10);
  /*st*/ /*fc2 null */ testi64Equal("mySimpleObject.number 2", 10,
                                    /*te14a*/
                                    ((c_3556498_SimpleObject1_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
                                        ->get_number(/*te8*/ mySimpleObject));
  /*va1*/ pointer str1 = "yo";
  /*va1*/ num name = /*se*/ create_c_2106303_String$2("ma name", true);
  /*st*/ /*fc2 null */ printf("mySimpleObject.name %s\n", /*te8*/ str1);
  /*st*/ /*fc2 null */ printf(
      "%s %s %s\n", /*te8*/ str1,
      /* switch from fc5 to te4*/
      ((c_2106303_String_cm *)useObject(
           /* switch from fc5 to te4*/ (
               (c_2106303_String_cm *)useObject(
                   /*te14a*/ ((c_3556498_SimpleObject1_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
                       ->get_name(/*te8*/ mySimpleObject))
                   ->classmodel)
               ->asString(/*te14a*/ ((c_3556498_SimpleObject1_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
                              ->get_name(/*te8*/ mySimpleObject)))
           ->classmodel)
          ->asStr(/* switch from fc5 to te4*/ (
                      (c_2106303_String_cm *)useObject(
                          /*te14a*/ ((c_3556498_SimpleObject1_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
                              ->get_name(/*te8*/ mySimpleObject))
                          ->classmodel)
                      ->asString(/*te14a*/ ((c_3556498_SimpleObject1_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
                                     ->get_name(/*te8*/ mySimpleObject))),
      /* switch from fc5 to te4*/ ((c_2106303_String_cm *)useObject(/*te8*/ name)->classmodel)->asStr(/*te8*/ name));
  /*st*/ /*fc2 null */ testStrEqual("str1", "yo", /*te8*/ str1);
  /*st*/ /*fc2 null */ testStrEqual(
      "name", "ma name",
      /* switch from fc5 to te4*/ ((c_2106303_String_cm *)useObject(/*te8*/ name)->classmodel)->asStr(/*te8*/ name));
  /*st*/ /*fc2 null */ testStrEqual(
      "mySimpleObject.name", "mySimpleObject message",
      /* switch from fc5 to te4*/
      ((c_2106303_String_cm *)useObject(
           /*te14a*/ ((c_3556498_SimpleObject1_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
               ->get_name(/*te8*/ mySimpleObject))
           ->classmodel)
          ->asStr(/*te14a*/ ((c_3556498_SimpleObject1_cm *)useObject(/*te8*/ mySimpleObject)->classmodel)
                      ->get_name(/*te8*/ mySimpleObject)));

  __onExit();
}
