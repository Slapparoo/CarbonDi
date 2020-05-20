#include "Default.if_main.h"

boolean isTrue() {

  u64 entry$ = __onEnter();
  return __exitReturn_boolean_un(true, entry$);
}

boolean isFalse() {

  u64 entry$ = __onEnter();
  return __exitReturn_boolean_un(false, entry$);
}

void if_1622897654_main() {

  __onEnter(); /*va1*/
  boolean always = true;
  /*va1*/ boolean never = false;
  /*va1*/ i64 sometimes = 10;
  /*va1*/ f64 sometimesfloat = 10.10;
  if (/*te8*/ always) {

    __onEnter(); /*st*/ /*fc2 null */
    printf("always (good)\n");

    __onExit();
  }

  /* else? */ else {

    __onEnter(); /*st*/ /*fc2 null */
    printf("always (bad)\n");

    __onExit();
  }

  if (/*oxa*/ /*te8*/ sometimes || /*oxb*/ /*te8*/ always) {

    __onEnter(); /*st*/ /*fc2 null */
    printf("sometimes (good) \n");

    __onExit();
  }

  /* else? */ else {

    __onEnter(); /*st*/ /*fc2 null */
    printf("sometimes (bad)\n");

    __onExit();
  }

  if (/*te8*/ never) {

    __onEnter(); /*st*/ /*fc2 null */
    printf("never (bad)\n");

    __onExit();
  }

  /* else? */ else {

    __onEnter(); /*st*/ /*fc2 null */
    printf("never (good)\n");

    __onExit();
  }

  if (/*fc2 null */ isTrue()) {

    __onEnter(); /*st*/ /*fc2 null */
    printf("tis true (good)\n");

    __onExit();
  }

  /* else? */ else {

    __onEnter(); /*st*/ /*fc2 null */
    printf("tis true (bad)\n");

    __onExit();
  }

  if (/*fc2 null */ isFalse()) {

    __onEnter(); /*st*/ /*fc2 null */
    printf("tis false (bad)\n");

    __onExit();
  }

  /* else? */ else {

    __onEnter(); /*st*/ /*fc2 null */
    printf("tis false (good)\n");

    __onExit();
  }

  if (/*oxa*/ /*fc2 null */ isTrue() && /*oxb*/ true) {

    __onEnter(); /*st*/ /*fc2 null */
    printf("tis true to (good)\n");

    __onExit();
  }

  /* else? */ else {

    __onEnter(); /*st*/ /*fc2 null */
    printf("tis true to (bad)\n");

    __onExit();
  }

  if (/*oxa*/ /*fc2 null */ isTrue() && /*oxb*/ false) {

    __onEnter(); /*st*/ /*fc2 null */
    printf("tis false to (bad)\n");

    __onExit();
  }

  /* else? */ else {

    __onEnter(); /*st*/ /*fc2 null */
    printf("tis false to (good)\n");

    __onExit();
  }

  if (!/*fc2 null */ isTrue()) {

    __onEnter(); /*st*/ /*fc2 null */
    printf("if else !true (bad)\n");

    __onExit();
  }

  if (/*fc2 null */ isFalse()) {

    __onEnter(); /*st*/ /*fc2 null */
    printf("if else false (bad)\n");

    __onExit();
  }

  /* else? */ else {

    __onEnter(); /*st*/ /*fc2 null */
    printf("if else (good)\n");

    __onExit();
  }

  /*st*/ /*fc2 null */ printf("end\n");

  __onExit();
}
