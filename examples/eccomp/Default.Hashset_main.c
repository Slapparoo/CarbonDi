#include "Default.Hashset_main.h"

/*fd1*/ void printBinary(i32 number) {

  u64 entry__ = __onEnter();
  for (num a__a = 0; a__a < 32; a__a++) {

    __onEnter(); /*Ax6*/ /*te8*/
    number /*te8*/ = (/*oxa*/ /*te8*/ number >> /*oxb*/ 1);
    /*st*/ /*fc2 null */ printf("%u", /*oxa*/ /*te8*/ number & /*oxb*/ 1);

    __onExit();
  }

  __onExit();
}

void Hashset_1863523751_main() {

  __onEnter(); /*va1*/
  num ar = /*cd1*/ create_c_1085510111_Hashset();
  /*va1*/ num str1 = /*se*/ create_c_2106303_String_2("String1", true);
  /*st*/ /*fc2 null */ printf("ar contains %i\n",
                              /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ str1));
  /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ str1);
  /*st*/ /*fc2 null */ printf("ar contains %i\n",
                              /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ str1));
  /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ str1);
  /*va1*/ num String1 = /*se*/ create_c_2106303_String_2("String1", true);
  /*va1*/ num String2 = /*se*/ create_c_2106303_String_2("String2", true);
  /*va1*/ num String3 = /*se*/ create_c_2106303_String_2("String3", true);
  /*va1*/ num String4 = /*se*/ create_c_2106303_String_2("String4", true);
  /*va1*/ num String5 = /*se*/ create_c_2106303_String_2("String5", true);
  /*va1*/ num String6 = /*se*/ create_c_2106303_String_2("String6", true);
  /*va1*/ num String7 = /*se*/ create_c_2106303_String_2("String7", true);
  /*va1*/ num su8 = /*se*/ create_c_2106303_String_2("u8", true);
  /*va1*/ num si8 = /*se*/ create_c_2106303_String_2("i8", true);
  /*va1*/ num su64 = /*se*/ create_c_2106303_String_2("u64", true);
  /*va1*/ num sswitch = /*se*/ create_c_2106303_String_2("switch", true);
  /*va1*/ num scase = /*se*/ create_c_2106303_String_2("case", true);
  /*va1*/ num sreturn = /*se*/ create_c_2106303_String_2("return", true);
  /*va1*/ num svoid = /*se*/ create_c_2106303_String_2("void", true);
  /*va1*/ num sloop = /*se*/ create_c_2106303_String_2("loop", true);
  /*va1*/ num selse = /*se*/ create_c_2106303_String_2("else", true);

  for (num a__a = 0; a__a < 100000; a__a++) {

    __onEnter(); /*st*/ /* switch from fc5 to te4*/
    ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ String1);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ String1);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ String1);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ String1);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ String1);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ String2);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ String2);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ String3);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ String3);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ String4);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ String4);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ String5);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ String5);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ String6);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ String6);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ String7);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ String7);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ su8);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ su8);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ si8);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ si8);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ su64);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ su64);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ sswitch);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ sswitch);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ scase);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ scase);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ sreturn);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ sreturn);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ scase);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ scase);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ svoid);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ svoid);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ sloop);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ sloop);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->add(/*te8*/ ar, /*te8*/ selse);
    /*st*/ /* switch from fc5 to te4*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->contains(/*te8*/ ar, /*te8*/ selse);

    __onExit();
  }

  /*va1*/ num d = /*cd1*/ create_c_1085510111_Duo();
  /*va1*/ num d2 = 2;
  /*st*/ /*fc2 null */ printf("class %s %s",
                              /*te141*/ ((c_1085510111_Duo_cm *)getc_1085510111_Duo_cm())->classCName(),
                              /*te141*/
                              ((c_1085510111_Duo_cm *)getc_1085510111_Duo_cm())->classCName());
  /*st*/ /*fc2 null */ printf("%lu\n",
                              /*te14a*/ ((c_1085510111_Hashset_cm *)useObject(/*te8*/ ar)->classmodel)->get_items(/*te8*/ ar));

  __onExit();
}
