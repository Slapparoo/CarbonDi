// Default.NewDynamicArray
#include "Default.NewDynamicArray.h"
#include "Core.Array.h"
#include "Core.B8.h"
#include "Core.BaseBoxing.h"
#include "Core.Boxing.h"
#include "Core.Core_main.h"
#include "Core.DynamicArray.h"
#include "Core.Exception.h"
#include "Core.F32.h"
#include "Core.F64.h"
#include "Core.I16.h"
#include "Core.I32.h"
#include "Core.I64.h"
#include "Core.I8.h"
#include "Core.Object.h"
#include "Core.Pointer.h"
#include "Core.RefArray.h"
#include "Core.String.h"
#include "Core.U16.h"
#include "Core.U32.h"
#include "Core.U64.h"
#include "Core.U8.h"

pointer c_1085510111_NewDynamicArraygetValue(num this, u64 index) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("add %s", "here");
  if (/*oxa*/ /*te8*/ index >=
      /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[error] index array out of bounds");

    __onExit();
  }

  return __exitReturn_pointer_un(
      /*fc3*/ ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->get(this, /*te8*/ index), entry$);
}

void c_1085510111_NewDynamicArraysetValue(num this, u64 index, pointer value) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("add %lu, %lu", /*te8*/ index,
                /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity);
  if (/*oxa*/ /*te8*/ index >=
      /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[error] index array out of bounds");

    __onExit();
  }

  /*st*/ /*fc3*/ ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)
      ->set(this, /*te8*/ index, /*te8*/ value);

  __onExit();
}

void c_1085510111_NewDynamicArrayaddTail(num this, pointer value) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("add %s", "here");
  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex ==
      /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity) {

    __onEnter();
    if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex >
        /*oxb*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_slideAmount()) {

      __onEnter(); /*st*/ /*fc3*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->slideLeft(this);

      __onExit();
    }

    /* else? */ else {

      __onEnter(); /*st*/ /*fc3*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->addCapacityTail(this);

      __onExit();
    }

    __onExit();
  }

  /*st*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length++;
  /*st*/ /*fc3*/ ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)
      ->setValue(this, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex++,
                 /*te8*/ value);

  __onExit();
}

void c_1085510111_NewDynamicArrayaddHead(num this, pointer value) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("add %s", "here");
  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex == /*oxb*/ 0) {

    __onEnter();
    if (/*oxa*/ /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex <
        /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity -
            /*oxb*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())
                ->get_slideAmount()) {

      __onEnter(); /*st*/ /*fc3*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->slideRight(this);

      __onExit();
    }

    /* else? */ else {

      __onEnter(); /*st*/ /*fc3*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->addCapacityHead(this);

      __onExit();
    }

    __onExit();
  }

  /*st*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length++;
  /*st*/ /*fc3*/ ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)
      ->setValue(this, --/*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex,
                 /*te8*/ value);

  __onExit();
}

void c_1085510111_NewDynamicArrayinsert(num this, u64 index, pointer value) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("insert %lu", /*te8*/ index);
  if (/*oxa*/ /*te8*/ index >
      /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[error] index array out of bounds");

    __onExit();
  }

  if (/*oxa*/ /*te8*/ index ==
      /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex) {

    __onEnter(); /*st*/ /*fc3*/
    ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->addHead(this, /*te8*/ value);
    return __exitReturn_void_un(entry$);
  }

  if (/*oxa*/ /*te8*/ index ==
      /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex) {

    __onEnter(); /*st*/ /*fc3*/
    ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->addTail(this, /*te8*/ value);
    return __exitReturn_void_un(entry$);
  }

  if (/*oxa*/ /*oxa*/ /*te8*/ index -
          /*oxb*/ /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex >
      /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex -
          /*oxb*/ /*te8*/ index) {

    __onEnter();
    if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex +
            /*oxb*/ /*oxa*/ 1 ==
        /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity) {

      __onEnter(); /*st*/ /*fc3*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->addCapacityTail(this);

      __onExit();
    }

    /*st*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex++;
    /*va1*/ u64 ix = /*oxa*/ /*te8*/ index + /*oxb*/ 1;
    /*st*/ /*fc2 null */ memmove(
        /*fc2 null */ EC_ADDRESS(/*fc2 null */ EC_ARRAY(
            /*te8*/ ix, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values)),
        /*fc2 null */
        EC_ADDRESS(/*fc2 null */ EC_ARRAY(
            /*te8*/ index, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values)),
        /*oxa*/
            (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex -
             /*oxb*/ /*te8*/ index) *
            /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->dataSize);

    __onExit();
  }

  /* else? */ else {

    __onEnter();
    if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex == /*oxb*/ 0) {

      __onEnter(); /*st*/ /*fc3*/
      ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->addCapacityHead(this);

      __onExit();
    }

    /*st*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex--;
    /*va1*/ u64 ix =
        /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex + /*oxb*/ 1;
    /*st*/ /*fc2 null */ memmove(
        /*fc2 null */ EC_ADDRESS(/*fc2 null */ EC_ARRAY(
            /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex,
            /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values)),
        /*fc2 null */
        EC_ADDRESS(/*fc2 null */ EC_ARRAY(
            /*te8*/ ix, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values)),
        /*oxa*/
            (/*oxa*/ /*te8*/ index -
             /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex) *
            /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->dataSize);

    __onExit();
  }

  /*st*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length++;
  /*st*/ /*fc3*/ ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)
      ->set(this, /*te8*/ index, /*te8*/ value);

  __onExit();
}

pointer c_1085510111_NewDynamicArrayremoveHead(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("remove %lu", /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex);
  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length == /*oxb*/ 0) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[error] index array out of bounds");

    __onExit();
  }

  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex >=
      /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[error] index array out of bounds index overlap.");

    __onExit();
  }

  if (/*oxa*/ /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity -
          /*oxb*/ /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length >
      /*oxb*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_growBy() +
          /*oxb*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())
              ->get_slideAmount()) {

    __onEnter(); /*st*/ /*fc3*/
    ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->reduceCapacityHead(this);

    __onExit();
  }

  /*st*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length--;
  return __exitReturn_pointer_un(
      /*fc3*/ ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)
          ->get(this, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex++),
      entry$);
}

pointer c_1085510111_NewDynamicArrayremoveTail(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("remove endIndex=%lu, length=%lu, capacity=%lu",
                /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex,
                /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length,
                /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity);
  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length == /*oxb*/ 0) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[error] index array out of bounds");

    __onExit();
  }

  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex >=
      /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[error] index array out of bounds index overlap.");

    __onExit();
  }

  /*va1*/ pointer res =
      /*fc3*/ ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)
          ->get(this, --/*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex);
  /*st*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length--;
  if (/*oxa*/ /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity -
          /*oxb*/ /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length >
      /*oxb*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_growBy() +
          /*oxb*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())
              ->get_slideAmount()) {

    __onEnter(); /*st*/ /*fc3*/
    ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->reduceCapacityTail(this);

    __onExit();
  }

  return __exitReturn_pointer_un(/*te8*/ res, entry$);
}

pointer c_1085510111_NewDynamicArrayremove(num this, u64 index, pointer value) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("remove %s", "here");
  if (/*oxa*/ /*oxa*/ /*oxa*/ /*oxa*/ /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)
              ->length == /*oxb*/ 0 ||
      /*oxb*/ /*te8*/ index <
          /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex ||
      /*oxb*/ /*te8*/ index >
          /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[error] index array out of bounds");

    __onExit();
  }

  if (/*oxa*/ /*te8*/ index ==
      /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex) {

    __onEnter();
    return __exitReturn_pointer_un(
        /*fc3*/ ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->removeHead(this), entry$);
  }

  if (/*oxa*/ /*te8*/ index ==
      /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex) {

    __onEnter();
    return __exitReturn_pointer_un(
        /*fc3*/ ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->removeTail(this), entry$);
  }

  /*va1*/ pointer result =
      /*fc3*/ ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->get(this, /*te8*/ index);
  if (/*oxa*/ /*oxa*/ /*te8*/ index -
          /*oxb*/ /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex >
      /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex -
          /*oxb*/ /*te8*/ index) {

    __onEnter(); /*va1*/
    u64 ix = /*oxa*/ /*te8*/ index + /*oxb*/ 1;
    /*st*/ /*fc2 null */ memmove(
        /*fc2 null */ EC_ADDRESS(/*fc2 null */ EC_ARRAY(
            /*te8*/ index, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values)),
        /*fc2 null */
        EC_ADDRESS(/*fc2 null */ EC_ARRAY(
            /*te8*/ ix, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values)),
        /*oxa*/
            (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex -
             /*oxb*/ /*te8*/ index) *
            /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->dataSize);
    /*st*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex--;

    __onExit();
  }

  /* else? */ else {

    __onEnter(); /*va1*/
    u64 ix = /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex + /*oxb*/ 1;
    /*st*/ /*fc2 null */ memmove(
        /*fc2 null */ EC_ADDRESS(/*fc2 null */ EC_ARRAY(
            /*te8*/ ix, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values)),
        /*fc2 null */
        EC_ADDRESS(/*fc2 null */ EC_ARRAY(
            /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex,
            /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values)),
        /*oxa*/
            (/*oxa*/ /*te8*/ index -
             /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex) *
            /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->dataSize);
    /*st*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex++;

    __onExit();
  }

  /*st*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length--;
  return __exitReturn_pointer_un(/*te8*/ result, entry$);
}

pointer c_1085510111_NewDynamicArraypeekTail(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("peek %s", "here");
  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length == /*oxb*/ 0) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[error] index array out of bounds");

    __onExit();
  }

  return __exitReturn_pointer_un(
      /*fc3*/ ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)
          ->get(this, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex),
      entry$);
}

pointer c_1085510111_NewDynamicArraypeekHead(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("peek %s", "here");
  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length == /*oxb*/ 0) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[error] index array out of bounds");

    __onExit();
  }

  return __exitReturn_pointer_un(
      /*fc3*/ ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)
          ->get(this, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex),
      entry$);
}

void c_1085510111_NewDynamicArrayaddCapacityHead(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("grow %s", "here");
  /*Ax5*/ /*te14b*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
      ->set_values(
          /*te8*/ this, /*fc2 null */ realloc(
              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values,
              /*oxa*/ (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity +
                       /*oxb*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())
                           ->get_growBy()) *
                  /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->dataSize));
  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values == /*oxb*/ null) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[error] out of memory exception.");

    __onExit();
  }

  /*Ax7*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity /*te8*/ +=
      /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_growBy();
  /*st*/ /*fc2 null */ memmove(
      /*fc2 null */ EC_ADDRESS(/*fc2 null */ EC_ARRAY(
          /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_growBy(),
          /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values)),
      /*fc2 null */
      EC_ADDRESS(
          /*fc2 null */ EC_ARRAY(0, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values)),
      /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length *
          /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->dataSize);
  /*Ax7*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex /*te8*/ +=
      /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_growBy();
  /*Ax7*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex /*te8*/ +=
      /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_growBy();

  __onExit();
}

void c_1085510111_NewDynamicArrayaddCapacityTail(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("grow %s", "here");
  /*Ax5*/ /*te14b*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
      ->set_values(
          /*te8*/ this, /*fc2 null */ realloc(
              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values,
              /*oxa*/ (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity +
                       /*oxb*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())
                           ->get_growBy()) *
                  /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->dataSize));
  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values == /*oxb*/ null) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[error] out of memory exception.");

    __onExit();
  }

  /*Ax7*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity /*te8*/ +=
      /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_growBy();

  __onExit();
}

void c_1085510111_NewDynamicArrayreduceCapacityHead(num this) {

  u64 entry$ = __onEnter();
  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity <=
      /*oxb*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_initialSize()) {

    __onEnter();
    return __exitReturn_void_un(entry$);
  }

  /*st*/ /*fc3*/ ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->realignLeft(this);
  /*va1*/ u64 oldCapacity = /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity;
  /*va1*/ u64 requestAmount =
      /*oxa*/ (
          /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity -
          /*oxb*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_growBy()) *
      /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->dataSize;
  /*Ax5*/ /*te14b*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
      ->set_values(/*te8*/ this, /*fc2 null */ realloc(
                       /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values,
                       /*te8*/ requestAmount));
  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values == /*oxb*/ null) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[error] out of memory exception.");

    __onExit();
  }

  /*Ax7*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity /*te8*/ -=
      /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_growBy();
  /*st*/ /*fc2 null */ debug_println(
      "shrink length=%lu, requestedAmount=%lu, oldCapacity=%lu, capacity=%lu",
      /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length, /*te8*/ requestAmount,
      /*te8*/ oldCapacity, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity);

  __onExit();
}

void c_1085510111_NewDynamicArrayreduceCapacityTail(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("shrink %s", "here");
  /*Ax5*/ /*te14b*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
      ->set_values(
          /*te8*/ this, /*fc2 null */ realloc(
              /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values,
              /*oxa*/ (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity -
                       /*oxb*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())
                           ->get_growBy()) *
                  /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->dataSize));
  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values == /*oxb*/ null) {

    __onEnter(); /*st*/ /*fc2 null */
    throwException("[error] out of memory exception.");

    __onExit();
  }

  /*Ax7*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity /*te8*/ -=
      /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_growBy();

  __onExit();
}

void c_1085510111_NewDynamicArrayrealignLeft(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("align %s", "here");
  /*va1*/ pointer dest = /*fc2 null */ EC_ADDRESS(
      /*fc2 null */ EC_ARRAY(0, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values));
  /*va1*/ pointer source = /*fc2 null */ EC_ADDRESS(
      /*fc2 null */ EC_ARRAY(/*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex,
                             /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values));
  /*va1*/ u64 amount = /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length *
                       /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->dataSize;
  /*st*/ /*fc2 null */ debug_println(
      "align %p == %p, %p, amount=%lu, length=%lu, dataSize=%lu, capacity=%lu", /*te8*/ dest,
      /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values, /*te8*/ source, /*te8*/ amount,
      /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length,
      /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->dataSize,
      /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity);
  /*st*/ /*fc2 null */ memmove(/*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values,
                               /*te8*/ source, /*te8*/ amount);
  /*Ax5*/ /*te14b*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
      ->set_startIndex(/*te8*/ this, 0);
  /*Ax5*/ /*te14b*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
      ->set_endIndex(/*te8*/ this, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length);

  __onExit();
}

void c_1085510111_NewDynamicArrayslideLeft(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("slide %s", "here");
  /*va1*/ u64 newStart = 0;
  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex +
          /*oxb*/ /*oxa*/ 1 >=
      /*oxb*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_slideAmount()) {

    __onEnter(); /*Ax6*/ /*te8*/
    newStart /*te8*/ =
        /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex -
        /*oxb*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_slideAmount();

    __onExit();
  }

  /*st*/ /*fc2 null */ memmove(
      /*fc2 null */ EC_ADDRESS(/*fc2 null */ EC_ARRAY(
          /*te8*/ newStart, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values)),
      /*fc2 null */
      EC_ADDRESS(
          /*fc2 null */ EC_ARRAY(/*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex,
                                 /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values)),
      /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length *
          /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->dataSize);
  /*Ax5*/ /*te14b*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
      ->set_startIndex(/*te8*/ this, /*te8*/ newStart);
  /*Ax5*/ /*te14b*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
      ->set_endIndex(/*te8*/ this,
                     /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex +
                         /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length);

  __onExit();
}

void c_1085510111_NewDynamicArrayslideRight(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  debug_println("slide %s", "here");
  /*va1*/ u64 newStart =
      /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex -
      /*oxb*/ (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity -
               /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length);
  if (/*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->endIndex +
          /*oxb*/ /*oxa*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())
              ->get_slideAmount() <=
      /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity) {

    __onEnter(); /*Ax6*/ /*te8*/
    newStart /*te8*/ =
        /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex +
        /*oxb*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_slideAmount();

    __onExit();
  }

  /*st*/ /*fc2 null */ memmove(
      /*fc2 null */ EC_ADDRESS(/*fc2 null */ EC_ARRAY(
          /*te8*/ newStart, /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values)),
      /*fc2 null */
      EC_ADDRESS(
          /*fc2 null */ EC_ARRAY(/*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex,
                                 /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->values)),
      /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length *
          /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->dataSize);
  /*Ax5*/ /*te14b*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
      ->set_startIndex(/*te8*/ this, /*te8*/ newStart);
  /*Ax5*/ /*te14b*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
      ->set_endIndex(/*te8*/ this,
                     /*oxa*/ /*te8*/ newStart +
                         /*oxb*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->length);

  __onExit();
}

pointer c_1085510111_NewDynamicArraygetClassName() { return "Default.NewDynamicArray"; }

pointer c_1085510111_NewDynamicArraygetClassShortName() { return "NewDynamicArray"; }

pointer c_1085510111_NewDynamicArraygetClassCName() { return "c_1085510111_NewDynamicArray"; }

pointer c_1085510111_NewDynamicArraygetClassPackage() { return "Default"; }

u64 c_1085510111_NewDynamicArraygetObjectDatasize() { return sizeof(c_1085510111_NewDynamicArray); }

u64 c_1085510111_NewDynamicArrayget_startIndex(num this) {
  return ((c_1085510111_NewDynamicArray *)useObject(this)->data)->startIndex;
}

void c_1085510111_NewDynamicArrayset_startIndex(num this, u64 startIndex) {
  ((c_1085510111_NewDynamicArray *)useObject(this)->data)->startIndex = startIndex;
}

u64 c_1085510111_NewDynamicArrayget_endIndex(num this) {
  return ((c_1085510111_NewDynamicArray *)useObject(this)->data)->endIndex;
}

void c_1085510111_NewDynamicArrayset_endIndex(num this, u64 endIndex) {
  ((c_1085510111_NewDynamicArray *)useObject(this)->data)->endIndex = endIndex;
}

u64 c_1085510111_NewDynamicArrayget_initialSize() {
  return ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->initialSize;
}

void c_1085510111_NewDynamicArrayset_initialSize(u64 initialSize) {
  ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->initialSize = initialSize;
}

u64 c_1085510111_NewDynamicArrayget_growBy() {
  return ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->growBy;
}

void c_1085510111_NewDynamicArrayset_growBy(u64 growBy) {
  ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->growBy = growBy;
}

u64 c_1085510111_NewDynamicArrayget_slideAmount() {
  return ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->slideAmount;
}

void c_1085510111_NewDynamicArrayset_slideAmount(u64 slideAmount) {
  ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->slideAmount = slideAmount;
}

void c_1085510111_NewDynamicArray_free(num this) { Object_ref *object_ref = useObject(this); }

num create_c_1085510111_NewDynamicArray() {
  c_1085510111_NewDynamicArray *_c_1085510111_NewDynamicArray =
      ec_calloc(sizeof(c_1085510111_NewDynamicArray), sizeof(char));
  return createObject(_c_1085510111_NewDynamicArray, getc_1085510111_NewDynamicArray_cm(), false);
}

c_1085510111_NewDynamicArray_cm _c_1085510111_NewDynamicArray_cm;
boolean _c_1085510111_NewDynamicArray_init = false;
pointer getc_1085510111_NewDynamicArray_cm() {
  if (!_c_1085510111_NewDynamicArray_init) {
    registerClassModel(&_c_1085510111_NewDynamicArray_cm);
    populatec_1085510111_NewDynamicArray_cm(&_c_1085510111_NewDynamicArray_cm);
    _c_1085510111_NewDynamicArray_init = true;
  }
  return &_c_1085510111_NewDynamicArray_cm;
}

/* default constructor */
num create_c_1085510111_NewDynamicArray$1(/* param */ /*va1*/ int dataType, /*va1*/ u64 dataSize) {
  num this = create_c_1085510111_NewDynamicArray();

  ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->set_dataType(this, dataType);
  ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)->set_dataSize(this, dataSize);
  {

    __onEnter(); /*Ax5*/ /*te14b*/
    ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
        ->set_capacity(
            /*te8*/ this,
            /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())->get_initialSize());
    /*Ax5*/ /*te14b*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
        ->set_values(
            /*te8*/ this,
            /*fc3*/ ((c_1085510111_NewDynamicArray_cm *)useObject(this)->classmodel)
                ->alloc(this,
                        /*oxa*/ /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->capacity *
                            /*oxb*/ /*te8*/ dataSize));
    /*Ax5*/ /*te14b*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
        ->set_startIndex(/*te8*/ this,
                         /*oxa*/ /*te14*/ ((c_1085510111_NewDynamicArray_cm *)getc_1085510111_NewDynamicArray_cm())
                                 ->get_initialSize() /
                             /*oxb*/ 2);
    /*Ax5*/ /*te14b*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
        ->set_endIndex(/*te8*/ this,
                       /*te15a*/ ((c_1085510111_NewDynamicArray *)useObject(/*te8*/ this)->data)->startIndex);
    /*Ax5*/ /*te14b*/ ((c_1085510111_NewDynamicArray_cm *)useObject(/*te8*/ this)->classmodel)
        ->set_length(/*te8*/ this, 0);

    __onExit();
  }

  return this;
}
num create_c_1085510111_NewDynamicArray$2(/* param */ /*va1*/ u64 capacity, /*va1*/ int dataType,
                                          /*va1*/ u64 dataSize) {
  num this = create_c_1085510111_NewDynamicArray();

  return this;
}
num create_c_1085510111_NewDynamicArray$3(/* param */ /*va1*/ u64 capacity, /*va1*/ int dataType, /*va1*/ u64 dataSize,
                                          /*va1*/ pointer values) {
  num this = create_c_1085510111_NewDynamicArray();

  return this;
}
void populatec_1085510111_NewDynamicArray_cm(pointer classModel) {
  populatec_2106303_Array_cm(classModel);
  c_1085510111_NewDynamicArray_cm *thisClassModel = (c_1085510111_NewDynamicArray_cm *)classModel;
  thisClassModel->parent = getc_2106303_Array_cm();
  thisClassModel->getValue = c_1085510111_NewDynamicArraygetValue;
  thisClassModel->setValue = c_1085510111_NewDynamicArraysetValue;
  thisClassModel->addTail = c_1085510111_NewDynamicArrayaddTail;
  thisClassModel->addHead = c_1085510111_NewDynamicArrayaddHead;
  thisClassModel->insert = c_1085510111_NewDynamicArrayinsert;
  thisClassModel->removeHead = c_1085510111_NewDynamicArrayremoveHead;
  thisClassModel->removeTail = c_1085510111_NewDynamicArrayremoveTail;
  thisClassModel->remove = c_1085510111_NewDynamicArrayremove;
  thisClassModel->peekTail = c_1085510111_NewDynamicArraypeekTail;
  thisClassModel->peekHead = c_1085510111_NewDynamicArraypeekHead;
  thisClassModel->addCapacityHead = c_1085510111_NewDynamicArrayaddCapacityHead;
  thisClassModel->addCapacityTail = c_1085510111_NewDynamicArrayaddCapacityTail;
  thisClassModel->reduceCapacityHead = c_1085510111_NewDynamicArrayreduceCapacityHead;
  thisClassModel->reduceCapacityTail = c_1085510111_NewDynamicArrayreduceCapacityTail;
  thisClassModel->realignLeft = c_1085510111_NewDynamicArrayrealignLeft;
  thisClassModel->slideLeft = c_1085510111_NewDynamicArrayslideLeft;
  thisClassModel->slideRight = c_1085510111_NewDynamicArrayslideRight;
  thisClassModel->getClassName = c_1085510111_NewDynamicArraygetClassName;
  thisClassModel->getClassShortName = c_1085510111_NewDynamicArraygetClassShortName;
  thisClassModel->getClassCName = c_1085510111_NewDynamicArraygetClassCName;
  thisClassModel->getClassPackage = c_1085510111_NewDynamicArraygetClassPackage;
  thisClassModel->getObjectDatasize = c_1085510111_NewDynamicArraygetObjectDatasize;
  thisClassModel->get_startIndex = c_1085510111_NewDynamicArrayget_startIndex;
  thisClassModel->set_startIndex = c_1085510111_NewDynamicArrayset_startIndex;
  thisClassModel->get_endIndex = c_1085510111_NewDynamicArrayget_endIndex;
  thisClassModel->set_endIndex = c_1085510111_NewDynamicArrayset_endIndex;
  thisClassModel->get_initialSize = c_1085510111_NewDynamicArrayget_initialSize;
  thisClassModel->set_initialSize = c_1085510111_NewDynamicArrayset_initialSize;
  thisClassModel->get_growBy = c_1085510111_NewDynamicArrayget_growBy;
  thisClassModel->set_growBy = c_1085510111_NewDynamicArrayset_growBy;
  thisClassModel->get_slideAmount = c_1085510111_NewDynamicArrayget_slideAmount;
  thisClassModel->set_slideAmount = c_1085510111_NewDynamicArrayset_slideAmount;
  /*cds1*/ thisClassModel->initialSize = 8;
  /*cds1*/ thisClassModel->growBy = 8;
  /*cds1*/ thisClassModel->slideAmount = 4;
  thisClassModel->free = c_1085510111_NewDynamicArray_free;
}
