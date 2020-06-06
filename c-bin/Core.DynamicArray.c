// Core.DynamicArray
#include "Core.Core_main.h"
#include "Core.DynamicArray.h"
#include "Core.Object.h"
#include "Core.String.h"
#include "Core.Exception.h"
#include "Core.Array.h"
#include "Core.RefArray.h"
#include "Core.Boxing.h"
#include "Core.BaseBoxing.h"
#include "Core.B8.h"
#include "Core.U8.h"
#include "Core.I8.h"
#include "Core.I16.h"
#include "Core.U16.h"
#include "Core.I32.h"
#include "Core.U32.h"
#include "Core.F32.h"
#include "Core.I64.h"
#include "Core.U64.h"
#include "Core.F64.h"
#include "Core.Pointer.h"

/*fd1*/pointer c_2106303_DynamicArraygetValue(num this, u64 index){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("add %s", "here");
if (/*oxa*//*te8*/index >= /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this)) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] index array out of bounds");

__onExit();}

return __exitReturn_pointer_un(/* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->get(this, /*te8*/index), entry__);
}


/*fd1*/void c_2106303_DynamicArraysetValue(num this, u64 index, pointer value){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("add %lu, %lu", /*te8*/index, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this));
if (/*oxa*//*te8*/index >= /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this)) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] index array out of bounds");

__onExit();}

/*st*/ /* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->set(this, /*te8*/index, /*te8*/value);

__onExit();}


/*fd1*/void c_2106303_DynamicArrayaddTail(num this, pointer value){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("add %s", "here");
if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this) == /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this)) {

__onEnter();if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) > /*oxb*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_slideAmount()) {

__onEnter();/*st*/ /*fc3*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->slideLeft(this);

__onExit();}

/* else? */ else {

__onEnter();/*st*/ /*fc3*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->addCapacityTail(this);

__onExit();}


__onExit();}

/*st*/ /*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->length++;
/*st*/ /* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->setValue(this, /*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->endIndex++, /*te8*/value);

__onExit();}


/*fd1*/void c_2106303_DynamicArrayaddHead(num this, pointer value){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("add %s", "here");
if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) == /*oxb*/0) {

__onEnter();if (/*oxa*//*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this) < /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this) - /*oxb*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_slideAmount()) {

__onEnter();/*st*/ /*fc3*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->slideRight(this);

__onExit();}

/* else? */ else {

__onEnter();/*st*/ /*fc3*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->addCapacityHead(this);

__onExit();}


__onExit();}

/*st*/ /*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->length++;
/*st*/ /* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->setValue(this, --/*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->startIndex, /*te8*/value);

__onExit();}


/*fd1*/void c_2106303_DynamicArrayinsert(num this, u64 index, pointer value){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("insert %lu", /*te8*/index);
if (/*oxa*//*te8*/index > /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this)) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] index array out of bounds");

__onExit();}

if (/*oxa*//*te8*/index == /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this)) {

__onEnter();/*st*/ /*fc3*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->addHead(this, /*te8*/value);
return __exitReturn_void_un(entry__);
}

if (/*oxa*//*te8*/index == /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this)) {

__onEnter();/*st*/ /*fc3*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->addTail(this, /*te8*/value);
return __exitReturn_void_un(entry__);
}

if (/*oxa*//*oxa*//*te8*/index - /*oxb*//*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) > /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this) - /*oxb*//*te8*/index) {

__onEnter();if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this) + /*oxb*//*oxa*/1 == /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this)) {

__onEnter();/*st*/ /*fc3*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->addCapacityTail(this);

__onExit();}

/*st*/ /*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->endIndex++;
/*va1*/u64 ix = /*oxa*//*te8*/index + /*oxb*/1;
/*st*/ /*fc2 null */memmove(/*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te8*/ix, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this))), /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te8*/index, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this))), /*oxa*/(/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this) - /*oxb*//*te8*/index) * /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_dataSize(/*te8*/this));

__onExit();}

/* else? */ else {

__onEnter();if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) == /*oxb*/0) {

__onEnter();/*st*/ /*fc3*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->addCapacityHead(this);

__onExit();}

/*st*/ /*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->startIndex--;
/*va1*/u64 ix = /*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) + /*oxb*/1;
/*st*/ /*fc2 null */memmove(/*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this), /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this))), /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te8*/ix, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this))), /*oxa*/(/*oxa*//*te8*/index - /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this)) * /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_dataSize(/*te8*/this));

__onExit();}

/*st*/ /*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->length++;
/*st*/ /* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->set(this, /*te8*/index, /*te8*/value);

__onExit();}


/*fd1*/pointer c_2106303_DynamicArrayremoveHead(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("remove %lu", /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this));
if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this) == /*oxb*/0) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] index array out of bounds");

__onExit();}

if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) >= /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this)) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] index array out of bounds index overlap.");

__onExit();}

if (/*oxa*//*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this) - /*oxb*//*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this) > /*oxb*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_growBy() + /*oxb*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_slideAmount()) {

__onEnter();/*st*/ /*fc3*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->reduceCapacityHead(this);

__onExit();}

/*st*/ /*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->length--;
return __exitReturn_pointer_un(/* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->get(this, /*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->startIndex++), entry__);
}


/*fd1*/pointer c_2106303_DynamicArrayremoveTail(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("remove endIndex=%lu, length=%lu, capacity=%lu", /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this), /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this), /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this));
if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this) == /*oxb*/0) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] index array out of bounds");

__onExit();}

if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) >= /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this)) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] index array out of bounds index overlap.");

__onExit();}

/*va1*/pointer res1 = /* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->get(this, --/*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->endIndex);
/*st*/ /*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->length--;
if (/*oxa*//*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this) - /*oxb*//*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this) > /*oxb*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_growBy() + /*oxb*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_slideAmount()) {

__onEnter();/*st*/ /*fc3*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->reduceCapacityTail(this);

__onExit();}

return __exitReturn_pointer_un(/*te8*/res1, entry__);
}


/*fd1*/pointer c_2106303_DynamicArrayremove(num this, u64 index, pointer value){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("remove %s", "here");
if (/*oxa*//*oxa*//*oxa*//*oxa*//*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this) == /*oxb*/0 || /*oxb*//*te8*/index < /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) || /*oxb*//*te8*/index > /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this)) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] index array out of bounds");

__onExit();}

if (/*oxa*//*te8*/index == /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this)) {

__onEnter();return __exitReturn_pointer_un(/*fc3*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->removeHead(this), entry__);
}

if (/*oxa*//*te8*/index == /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this)) {

__onEnter();return __exitReturn_pointer_un(/*fc3*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->removeTail(this), entry__);
}

/*va1*/pointer result = /* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->get(this, /*te8*/index);
if (/*oxa*//*oxa*//*te8*/index - /*oxb*//*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) > /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this) - /*oxb*//*te8*/index) {

__onEnter();/*va1*/u64 ix = /*oxa*//*te8*/index + /*oxb*/1;
/*st*/ /*fc2 null */memmove(/*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te8*/index, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this))), /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te8*/ix, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this))), /*oxa*/(/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this) - /*oxb*//*te8*/index) * /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_dataSize(/*te8*/this));
/*st*/ /*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->endIndex--;

__onExit();}

/* else? */ else {

__onEnter();/*va1*/u64 ix = /*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) + /*oxb*/1;
/*st*/ /*fc2 null */memmove(/*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te8*/ix, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this))), /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this), /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this))), /*oxa*/(/*oxa*//*te8*/index - /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this)) * /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_dataSize(/*te8*/this));
/*st*/ /*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->startIndex++;

__onExit();}

/*st*/ /*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->length--;
return __exitReturn_pointer_un(/*te8*/result, entry__);
}


/*fd1*/pointer c_2106303_DynamicArraypeekTail(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("peek %s", "here");
if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this) == /*oxb*/0) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] index array out of bounds");

__onExit();}

return __exitReturn_pointer_un(/* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->get(this, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this)), entry__);
}


/*fd1*/pointer c_2106303_DynamicArraypeekHead(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("peek %s", "here");
if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this) == /*oxb*/0) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] index array out of bounds");

__onExit();}

return __exitReturn_pointer_un(/* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->get(this, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this)), entry__);
}


/*fd1*/void c_2106303_DynamicArrayaddCapacityHead(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("grow %s", "here");
/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_values(/*te8*/this, /* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->realloc(this, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this), /*oxa*/(/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this) + /*oxb*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_growBy()) * /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_dataSize(/*te8*/this)));
if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this) == /*oxb*/null) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] out of memory exception.");

__onExit();}

/*Ax7*//*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->capacity/*te8*/+=/*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_growBy();
/*st*/ /*fc2 null */memmove(/*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_growBy(), /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this))), /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(0, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this))), /*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this) * /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_dataSize(/*te8*/this));
/*Ax7*//*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->startIndex/*te8*/+=/*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_growBy();
/*Ax7*//*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->endIndex/*te8*/+=/*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_growBy();

__onExit();}


/*fd1*/void c_2106303_DynamicArrayaddCapacityTail(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("grow %s", "here");
/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_values(/*te8*/this, /* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->realloc(this, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this), /*oxa*/(/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this) + /*oxb*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_growBy()) * /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_dataSize(/*te8*/this)));
if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this) == /*oxb*/null) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] out of memory exception.");

__onExit();}

/*Ax7*//*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->capacity/*te8*/+=/*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_growBy();

__onExit();}


/*fd1*/void c_2106303_DynamicArrayreduceCapacityHead(num this){

u64 entry__ = __onEnter();if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this) <= /*oxb*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_initialSize()) {

__onEnter();return __exitReturn_void_un(entry__);
}

/*st*/ /* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->realignLeft(this);
/*va1*/u64 oldCapacity = /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this);
/*va1*/u64 requestAmount = /*oxa*/(/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this) - /*oxb*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_growBy()) * /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_dataSize(/*te8*/this);
/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_values(/*te8*/this, /* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->realloc(this, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this), /*te8*/requestAmount));
if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this) == /*oxb*/null) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] out of memory exception.");

__onExit();}

/*Ax7*//*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->capacity/*te8*/-=/*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_growBy();
/*st*/ /*fc2 null */debug_println("shrink length=%lu, requestedAmount=%lu, oldCapacity=%lu, capacity=%lu", /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this), /*te8*/requestAmount, /*te8*/oldCapacity, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this));

__onExit();}


/*fd1*/void c_2106303_DynamicArrayreduceCapacityTail(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("shrink %s", "here");
/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_values(/*te8*/this, /* switch from fc5 to te4*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->realloc(this, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this), /*oxa*/(/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this) - /*oxb*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_growBy()) * /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_dataSize(/*te8*/this)));
if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this) == /*oxb*/null) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] out of memory exception.");

__onExit();}

/*Ax7*//*te15a*/((c_2106303_DynamicArray*)useObject(/*te8*/this)->data)->capacity/*te8*/-=/*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_growBy();

__onExit();}


/*fd1*/void c_2106303_DynamicArrayrealignLeft(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("align %s", "here");
/*va1*/pointer dest = /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(0, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this)));
/*va1*/pointer source = /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this), /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this)));
/*va1*/u64 amount = /*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this) * /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_dataSize(/*te8*/this);
/*st*/ /*fc2 null */debug_println("align %p == %p, %p, amount=%lu, length=%lu, dataSize=%lu, capacity=%lu", /*te8*/dest, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this), /*te8*/source, /*te8*/amount, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this), /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_dataSize(/*te8*/this), /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this));
/*st*/ /*fc2 null */memmove(/*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this), /*te8*/source, /*te8*/amount);
/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_startIndex(/*te8*/this, 0);
/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_endIndex(/*te8*/this, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this));

__onExit();}


/*fd1*/void c_2106303_DynamicArrayslideLeft(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("slide %s", "here");
/*va1*/u64 newStart = 0;
if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) + /*oxb*//*oxa*/1 >= /*oxb*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_slideAmount()) {

__onEnter();/*Ax6*//*te8*/newStart/*te8*/=/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) - /*oxb*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_slideAmount();

__onExit();}

/*st*/ /*fc2 null */memmove(/*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te8*/newStart, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this))), /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this), /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this))), /*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this) * /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_dataSize(/*te8*/this));
/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_startIndex(/*te8*/this, /*te8*/newStart);
/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_endIndex(/*te8*/this, /*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) + /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this));

__onExit();}


/*fd1*/void c_2106303_DynamicArrayslideRight(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */debug_println("slide %s", "here");
/*va1*/u64 newStart = /*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) - /*oxb*/(/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this) - /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this));
if (/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_endIndex(/*te8*/this) + /*oxb*//*oxa*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_slideAmount() <= /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this)) {

__onEnter();/*Ax6*//*te8*/newStart/*te8*/=/*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this) + /*oxb*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_slideAmount();

__onExit();}

/*st*/ /*fc2 null */memmove(/*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te8*/newStart, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this))), /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this), /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_values(/*te8*/this))), /*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this) * /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_dataSize(/*te8*/this));
/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_startIndex(/*te8*/this, /*te8*/newStart);
/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_endIndex(/*te8*/this, /*oxa*//*te8*/newStart + /*oxb*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_length(/*te8*/this));

__onExit();}


/*fd1*/pointer c_2106303_DynamicArraygetClassName(){
  return  "Core.DynamicArray";
}


/*fd1*/pointer c_2106303_DynamicArraygetClassShortName(){
  return  "DynamicArray";
}


/*fd1*/pointer c_2106303_DynamicArraygetClassCName(){
  return  "c_2106303_DynamicArray";
}


/*fd1*/pointer c_2106303_DynamicArraygetClassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_DynamicArraygetObjectDatasize(){
  return  sizeof(c_2106303_DynamicArray);
}
















/*fd1*/u64 c_2106303_DynamicArrayget_startIndex(num this){
  return  ((c_2106303_DynamicArray*)useObject(this)->data)->startIndex;
}


/*fd1*/void c_2106303_DynamicArrayset_startIndex(num this, u64 a__a){
/*cda1*/((c_2106303_DynamicArray*)useObject(this)->data)->startIndex = a__a;
}


/*fd1*/u64 c_2106303_DynamicArrayget_endIndex(num this){
  return  ((c_2106303_DynamicArray*)useObject(this)->data)->endIndex;
}


/*fd1*/void c_2106303_DynamicArrayset_endIndex(num this, u64 a__a){
/*cda1*/((c_2106303_DynamicArray*)useObject(this)->data)->endIndex = a__a;
}


/*fd1*/u64 c_2106303_DynamicArrayget_initialSize(){
  return  ((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->initialSize;
}


/*fd1*/void c_2106303_DynamicArrayset_initialSize(u64 a__a){
/*cda1*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->initialSize = a__a;
}


/*fd1*/u64 c_2106303_DynamicArrayget_growBy(){
  return  ((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->growBy;
}


/*fd1*/void c_2106303_DynamicArrayset_growBy(u64 a__a){
/*cda1*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->growBy = a__a;
}


/*fd1*/u64 c_2106303_DynamicArrayget_slideAmount(){
  return  ((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->slideAmount;
}


/*fd1*/void c_2106303_DynamicArrayset_slideAmount(u64 a__a){
/*cda1*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->slideAmount = a__a;
}


void c_2106303_DynamicArray_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_DynamicArray() {
  c_2106303_DynamicArray * _c_2106303_DynamicArray = ec_calloc(sizeof(c_2106303_DynamicArray), sizeof(char));
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


/* default constructor */
num create_c_2106303_DynamicArray_1(/* param *//*va1*/int dataType, /*va1*/u64 dataSize) {
num this =  create_c_2106303_DynamicArray();

((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->set_dataType(this, dataType);
((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->set_dataSize(this, dataSize);
{

__onEnter();/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_capacity(/*te8*/this, /*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_initialSize());
/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_values(/*te8*/this, /*fc3*/((c_2106303_DynamicArray_cm*)useObject(this)->classmodel)->alloc(this, /*oxa*//*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_capacity(/*te8*/this) * /*oxb*//*te8*/dataSize));
/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_startIndex(/*te8*/this, /*oxa*//*te14*/((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->get_initialSize() / /*oxb*/2);
/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_endIndex(/*te8*/this, /*te14a*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->get_startIndex(/*te8*/this));
/*Ax5*//*te14b*/((c_2106303_DynamicArray_cm*)useObject(/*te8*/this)->classmodel)->set_length(/*te8*/this, 0);

__onExit();}

return this;
}
num create_c_2106303_DynamicArray_2(/* param *//*va1*/u64 capacity, /*va1*/int dataType, /*va1*/u64 dataSize) {
num this =  create_c_2106303_DynamicArray();


return this;
}
num create_c_2106303_DynamicArray_3(/* param *//*va1*/u64 capacity, /*va1*/int dataType, /*va1*/u64 dataSize, /*va1*/pointer values) {
num this =  create_c_2106303_DynamicArray();


return this;
}
void populatec_2106303_DynamicArray_cm(pointer classModel) {
 populatec_2106303_Array_cm(classModel);
  c_2106303_DynamicArray_cm* thisClassModel = (c_2106303_DynamicArray_cm*)classModel;
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
/*cds1*/thisClassModel->initialSize = 8;
/*cds1*/thisClassModel->growBy = 8;
/*cds1*/thisClassModel->slideAmount = 4;
  thisClassModel->free = c_2106303_DynamicArray_free;
}

