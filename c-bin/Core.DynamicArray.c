// Core.DynamicArray
#include "Core.DynamicArray.h"
#include "Core.Array.h"
#include "Core.B8.h"
#include "Core.BaseBoxing.h"
#include "Core.Boxing.h"
#include "Core.Core_main.h"
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

#define __USE_THIS_CM ((c_2106303_DynamicArray_cm *)useObject(this)->classmodel)
#define __USE_THIS_D ((c_2106303_DynamicArray *)useObject(this)->data)
#define __USE_THIS_S ((c_2106303_DynamicArray_cm *)getc_2106303_DynamicArray_cm())

// u8 size = ay->dataSize;
// u64 offset = size * index;
// pointer res = &ay->values[offset];

pointer c_2106303_DynamicArraygetValue(num this, u64 index) {
  if (index >= __USE_THIS_CM->get_length(this)) {
    throwException("[error] index array out of bounds");
  }

  return __USE_THIS_CM->get(this, __USE_THIS_CM->get_startIndex(this) + index);
}

void c_2106303_DynamicArraysetValue(num this, u64 index, pointer value) {
  if (index >= __USE_THIS_CM->get_length(this)) {
    throwException("[error] index array out of bounds");
  }

  __USE_THIS_CM->set(this, __USE_THIS_CM->get_startIndex(this) + index, value);
}

void c_2106303_DynamicArrayaddTail(num this, pointer value) {
  if (__USE_THIS_CM->get_endIndex(this) == __USE_THIS_CM->get_capacity(this)) {
    if (__USE_THIS_CM->get_startIndex(this) > __USE_THIS_S->get_slideAmount()) {
      __USE_THIS_CM->slideLeft(this);
    } else {
      __USE_THIS_CM->addCapacityTail(this);
    }
  }

  __USE_THIS_D->length++;
  __USE_THIS_CM->set(this, __USE_THIS_D->endIndex++, value);
}

void c_2106303_DynamicArrayaddHead(num this, pointer value) {
  if (__USE_THIS_CM->get_startIndex(this) == 0) {
    if (__USE_THIS_CM->get_endIndex(this) < __USE_THIS_CM->get_capacity(this) - __USE_THIS_S->get_slideAmount()) {
      __USE_THIS_CM->slideRight(this);
    } else {
      __USE_THIS_CM->addCapacityHead(this);
    }
  }

  __USE_THIS_D->length++;
  __USE_THIS_CM->set(this, --__USE_THIS_D->startIndex, value);
}

void c_2106303_DynamicArrayinsert(num this, u64 index, pointer value) {
  if (index > __USE_THIS_CM->get_length(this)) {
    throwException("[error] index array out of bounds");
  }

  if (index == __USE_THIS_CM->get_startIndex(this)) {
    return __USE_THIS_CM->addHead(this, value);
  }

  if (index == __USE_THIS_CM->get_endIndex(this)) {
    return __USE_THIS_CM->addTail(this, value);
  }

  if (index - __USE_THIS_CM->get_startIndex(this) > __USE_THIS_CM->get_endIndex(this) - index) {
    if (__USE_THIS_CM->get_endIndex(this) + 1 == __USE_THIS_CM->get_capacity(this)) {
      __USE_THIS_CM->addCapacityTail(this);
    }

    __USE_THIS_D->endIndex++;
    u64 ix = index + 1;

    // u8 size = ay->dataSize;
    // u64 offset = size * index;
    // pointer res = &ay->values[offset];

    //    __USE_THIS_D->values
    //    __USE_THIS_D->dataSize

    memmove(&__USE_THIS_D->values[ix * __USE_THIS_D->dataSize], &__USE_THIS_D->values[index * __USE_THIS_D->dataSize],
            (__USE_THIS_CM->get_endIndex(this) - index) * __USE_THIS_CM->get_dataSize(this));
  } else {
    if (__USE_THIS_CM->get_startIndex(this) == 0) {
      __USE_THIS_CM->addCapacityHead(this);
    }

    __USE_THIS_D->startIndex--;
    u64 ix = __USE_THIS_CM->get_startIndex(this) + 1;
    memmove(&__USE_THIS_D->values[__USE_THIS_D->startIndex * __USE_THIS_D->dataSize],
            &__USE_THIS_D->values[ix * __USE_THIS_D->dataSize],
            (index - __USE_THIS_CM->get_startIndex(this)) * __USE_THIS_CM->get_dataSize(this));
  }

  __USE_THIS_D->length++;
  __USE_THIS_CM->set(this, index, value);
}

pointer c_2106303_DynamicArrayremoveHead(num this) {
  if (__USE_THIS_CM->get_length(this) == 0) {
    throwException("[error] index array out of bounds");
  }

  pointer res = __USE_THIS_CM->get(this, __USE_THIS_D->startIndex++);
  __USE_THIS_D->length--;
  if (__USE_THIS_CM->get_startIndex(this) > __USE_THIS_S->get_growBy()) {
    __USE_THIS_CM->reduceCapacityHead(this);
  }

  return res;
}

pointer c_2106303_DynamicArrayremoveTail(num this) {
  if (__USE_THIS_CM->get_length(this) == 0) {
    throwException("[error] index array out of bounds");
  }

  pointer res = __USE_THIS_CM->get(this, __USE_THIS_D->endIndex--);
  __USE_THIS_D->length--;
  if (__USE_THIS_CM->get_endIndex(this) + __USE_THIS_S->get_growBy() < __USE_THIS_CM->get_capacity(this)) {
    __USE_THIS_CM->reduceCapacityTail(this);
  }

  return res;
}

pointer c_2106303_DynamicArrayremove(num this, u64 index, pointer value) {
  if (__USE_THIS_CM->get_length(this) == 0 || index < __USE_THIS_CM->get_startIndex(this) ||
      index > __USE_THIS_CM->get_endIndex(this)) {
    throwException("[error] index array out of bounds");
  }

  if (index == __USE_THIS_CM->get_startIndex(this)) {
    return __USE_THIS_CM->removeHead(this);
  }

  if (index == __USE_THIS_CM->get_endIndex(this)) {
    return __USE_THIS_CM->removeTail(this);
  }

  pointer result = __USE_THIS_CM->get(this, index);
  if (index - __USE_THIS_CM->get_startIndex(this) > __USE_THIS_CM->get_endIndex(this) - index) {
    u64 ix = index + 1;
    memmove(&__USE_THIS_D->values[index * __USE_THIS_D->dataSize], &__USE_THIS_D->values[ix * __USE_THIS_D->dataSize],
            (__USE_THIS_CM->get_endIndex(this) - index) * __USE_THIS_CM->get_dataSize(this));
    __USE_THIS_D->endIndex--;
  } else {
    u64 ix = __USE_THIS_CM->get_startIndex(this) + 1;
    memmove(&__USE_THIS_D->values[ix * __USE_THIS_D->dataSize],
            &__USE_THIS_D->values[__USE_THIS_D->startIndex * __USE_THIS_D->dataSize],
            (index - __USE_THIS_CM->get_startIndex(this)) * __USE_THIS_CM->get_dataSize(this));
    __USE_THIS_D->startIndex++;
  }

  __USE_THIS_D->length--;
  return result;
}

pointer c_2106303_DynamicArraypeekTail(num this) {
  if (__USE_THIS_CM->get_length(this) == 0) {
    throwException("[error] index array out of bounds");
  }

  return __USE_THIS_CM->get(this, __USE_THIS_CM->get_endIndex(this));
}

pointer c_2106303_DynamicArraypeekHead(num this) {
  if (__USE_THIS_CM->get_length(this) == 0) {
    throwException("[error] index array out of bounds");
  }

  return __USE_THIS_CM->get(this, __USE_THIS_CM->get_startIndex(this));
}

void c_2106303_DynamicArrayaddCapacityHead(num this) {
  __USE_THIS_CM->set_values(
      this, realloc(__USE_THIS_D->values, (__USE_THIS_CM->get_capacity(this) + __USE_THIS_S->get_growBy()) *
                                              __USE_THIS_CM->get_dataSize(this)));
  if (__USE_THIS_CM->get_values(this) == null) {
    throwException("[error] out of memory exception.");
  }

  __USE_THIS_CM->set_capacity(this, __USE_THIS_S->get_growBy());
  memmove(&__USE_THIS_D->values[__USE_THIS_S->growBy * __USE_THIS_D->dataSize], &__USE_THIS_D->values[0],
          __USE_THIS_CM->get_length(this) * __USE_THIS_CM->get_dataSize(this));
  __USE_THIS_CM->set_startIndex(this, __USE_THIS_S->get_growBy());
  __USE_THIS_CM->set_endIndex(this, __USE_THIS_S->get_growBy());
}

void c_2106303_DynamicArrayaddCapacityTail(num this) {
  __USE_THIS_CM->set_values(
      this, realloc(__USE_THIS_D->values, (__USE_THIS_CM->get_capacity(this) + __USE_THIS_S->get_growBy()) *
                                              __USE_THIS_CM->get_dataSize(this)));
  if (__USE_THIS_CM->get_values(this) == null) {
    throwException("[error] out of memory exception.");
  }

  __USE_THIS_CM->set_capacity(this, __USE_THIS_S->get_growBy());
}

void c_2106303_DynamicArrayreduceCapacityHead(num this) {
  __USE_THIS_CM->realignLeft(this);
  __USE_THIS_CM->set_values(
      this, realloc(__USE_THIS_D->values, (__USE_THIS_CM->get_capacity(this) - __USE_THIS_S->get_growBy()) *
                                              __USE_THIS_CM->get_dataSize(this)));
  if (__USE_THIS_CM->get_values(this) == null) {
    throwException("[error] out of memory exception.");
  }

  __USE_THIS_CM->set_capacity(this, __USE_THIS_S->get_growBy());
}

void c_2106303_DynamicArrayreduceCapacityTail(num this) {
  __USE_THIS_CM->set_values(
      this, realloc(__USE_THIS_D->values, (__USE_THIS_CM->get_capacity(this) - __USE_THIS_S->get_growBy()) *
                                              __USE_THIS_CM->get_dataSize(this)));
  if (__USE_THIS_CM->get_values(this) == null) {
    throwException("[error] out of memory exception.");
  }

  __USE_THIS_CM->set_capacity(this, __USE_THIS_S->get_growBy());
}

void c_2106303_DynamicArrayrealignLeft(num this) {

  memmove(&__USE_THIS_D->values[0], &__USE_THIS_D->values[__USE_THIS_D->startIndex * __USE_THIS_D->dataSize],
          __USE_THIS_CM->get_length(this) * __USE_THIS_CM->get_dataSize(this));
  __USE_THIS_CM->set_startIndex(this, 0);
  __USE_THIS_CM->set_endIndex(this, __USE_THIS_CM->get_length(this));
}

void c_2106303_DynamicArrayslideLeft(num this) {

  u64 newStart = 0;
  if (__USE_THIS_CM->get_startIndex(this) >= __USE_THIS_S->get_slideAmount()) {

    newStart =

        __USE_THIS_CM->get_startIndex(this) -
        ((c_2106303_DynamicArray_cm *)getc_2106303_DynamicArray_cm())->get_slideAmount();
  }

  memmove(&__USE_THIS_D->values[newStart * __USE_THIS_D->dataSize],
          &__USE_THIS_D->values[__USE_THIS_D->startIndex * __USE_THIS_D->dataSize],
          __USE_THIS_CM->get_length(this) * __USE_THIS_CM->get_dataSize(this));
  __USE_THIS_CM->set_startIndex(this, newStart);
  __USE_THIS_CM->set_endIndex(this, __USE_THIS_CM->get_length(this));
}

void c_2106303_DynamicArrayslideRight(num this) {
  u64 newStart =
      __USE_THIS_CM->get_startIndex(this) - (__USE_THIS_CM->get_capacity(this) - __USE_THIS_CM->get_length(this));
  if (__USE_THIS_CM->get_endIndex(this) + __USE_THIS_S->get_slideAmount() <= __USE_THIS_CM->get_capacity(this)) {

    newStart =

        __USE_THIS_CM->get_startIndex(this) +
        ((c_2106303_DynamicArray_cm *)getc_2106303_DynamicArray_cm())->get_slideAmount();
  }

  memmove(&__USE_THIS_D->values[newStart * __USE_THIS_D->dataSize],
          &__USE_THIS_D->values[__USE_THIS_D->startIndex * __USE_THIS_D->dataSize],
          __USE_THIS_CM->get_length(this) * __USE_THIS_CM->get_dataSize(this));
  __USE_THIS_CM->set_startIndex(this, newStart);
  __USE_THIS_CM->set_endIndex(this, newStart + __USE_THIS_CM->get_length(this));
}

pointer c_2106303_DynamicArraygetClassName() { return "Core.DynamicArray"; }

pointer c_2106303_DynamicArraygetClassShortName() { return "DynamicArray"; }

pointer c_2106303_DynamicArraygetClassCName() { return "c_2106303_DynamicArray"; }

pointer c_2106303_DynamicArraygetClassPackage() { return "Core"; }

u64 c_2106303_DynamicArraygetObjectDatasize() { return sizeof(c_2106303_DynamicArray); }

u64 c_2106303_DynamicArrayget_startIndex(num this) { return __USE_THIS_D->startIndex; }

void c_2106303_DynamicArrayset_startIndex(num this, u64 startIndex) { __USE_THIS_D->startIndex = startIndex; }

u64 c_2106303_DynamicArrayget_endIndex(num this) { return __USE_THIS_D->endIndex; }

void c_2106303_DynamicArrayset_endIndex(num this, u64 endIndex) { __USE_THIS_D->endIndex = endIndex; }

u64 c_2106303_DynamicArrayget_initialSize() { return __USE_THIS_S->initialSize; }

void c_2106303_DynamicArrayset_initialSize(u64 initialSize) { __USE_THIS_S->initialSize = initialSize; }

u64 c_2106303_DynamicArrayget_growBy() { return __USE_THIS_S->growBy; }

void c_2106303_DynamicArrayset_growBy(u64 growBy) { __USE_THIS_S->growBy = growBy; }

u64 c_2106303_DynamicArrayget_slideAmount() { return __USE_THIS_S->slideAmount; }

void c_2106303_DynamicArrayset_slideAmount(u64 slideAmount) { __USE_THIS_S->slideAmount = slideAmount; }

void c_2106303_DynamicArray_free(num this) { Object_ref *object_ref = useObject(this); }

num create_c_2106303_DynamicArray() {
  c_2106303_DynamicArray *_c_2106303_DynamicArray = ec_calloc(sizeof(c_2106303_DynamicArray), sizeof(char));
  return createObject(_c_2106303_DynamicArray, getc_2106303_DynamicArray_cm(), false);
}

c_2106303_DynamicArray_cm _c_2106303_DynamicArray_cm;
boolean _c_2106303_DynamicArray_init = false;
pointer getc_2106303_DynamicArray_cm() {
  if (!_c_2106303_DynamicArray_init) {
    registerClassModel(&_c_2106303_DynamicArray_cm);
    populatec_2106303_DynamicArray_cm(&_c_2106303_DynamicArray_cm);
    _c_2106303_DynamicArray_init = true;
  }
  return &_c_2106303_DynamicArray_cm;
}

num create_c_2106303_DynamicArray$1(u64 capacity, int dataType, u64 dataSize) {
  num this = create_c_2106303_DynamicArray();

  return this;
}
num create_c_2106303_DynamicArray$2(u64 capacity, int dataType, u64 dataSize, pointer values) {
  num this = create_c_2106303_DynamicArray();

  return this;
}
void populatec_2106303_DynamicArray_cm(pointer classModel) {
  populatec_2106303_Array_cm(classModel);
  c_2106303_DynamicArray_cm *thisClassModel = (c_2106303_DynamicArray_cm *)classModel;
  thisClassModel->parent = getc_2106303_Array_cm();
  thisClassModel->getValue = c_2106303_DynamicArraygetValue;
  thisClassModel->setValue = c_2106303_DynamicArraysetValue;
  thisClassModel->addTail = c_2106303_DynamicArrayaddTail;
  thisClassModel->addHead = c_2106303_DynamicArrayaddHead;
  thisClassModel->insert = c_2106303_DynamicArrayinsert;
  thisClassModel->removeHead = c_2106303_DynamicArrayremoveHead;
  thisClassModel->removeTail = c_2106303_DynamicArrayremoveTail;
  thisClassModel->remove = c_2106303_DynamicArrayremove;
  thisClassModel->peekTail = c_2106303_DynamicArraypeekTail;
  thisClassModel->peekHead = c_2106303_DynamicArraypeekHead;
  thisClassModel->addCapacityHead = c_2106303_DynamicArrayaddCapacityHead;
  thisClassModel->addCapacityTail = c_2106303_DynamicArrayaddCapacityTail;
  thisClassModel->reduceCapacityHead = c_2106303_DynamicArrayreduceCapacityHead;
  thisClassModel->reduceCapacityTail = c_2106303_DynamicArrayreduceCapacityTail;
  thisClassModel->realignLeft = c_2106303_DynamicArrayrealignLeft;
  thisClassModel->slideLeft = c_2106303_DynamicArrayslideLeft;
  thisClassModel->slideRight = c_2106303_DynamicArrayslideRight;
  thisClassModel->getClassName = c_2106303_DynamicArraygetClassName;
  thisClassModel->getClassShortName = c_2106303_DynamicArraygetClassShortName;
  thisClassModel->getClassCName = c_2106303_DynamicArraygetClassCName;
  thisClassModel->getClassPackage = c_2106303_DynamicArraygetClassPackage;
  thisClassModel->getObjectDatasize = c_2106303_DynamicArraygetObjectDatasize;
  thisClassModel->get_startIndex = c_2106303_DynamicArrayget_startIndex;
  thisClassModel->set_startIndex = c_2106303_DynamicArrayset_startIndex;
  thisClassModel->get_endIndex = c_2106303_DynamicArrayget_endIndex;
  thisClassModel->set_endIndex = c_2106303_DynamicArrayset_endIndex;
  thisClassModel->get_initialSize = c_2106303_DynamicArrayget_initialSize;
  thisClassModel->set_initialSize = c_2106303_DynamicArrayset_initialSize;
  thisClassModel->get_growBy = c_2106303_DynamicArrayget_growBy;
  thisClassModel->set_growBy = c_2106303_DynamicArrayset_growBy;
  thisClassModel->get_slideAmount = c_2106303_DynamicArrayget_slideAmount;
  thisClassModel->set_slideAmount = c_2106303_DynamicArrayset_slideAmount;
  thisClassModel->initialSize = 64;
  thisClassModel->growBy = 64;
  thisClassModel->slideAmount = 8;
  thisClassModel->free = c_2106303_DynamicArray_free;
}
