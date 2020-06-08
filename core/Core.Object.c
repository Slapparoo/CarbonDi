// Core.Object
#include "Core.Core_main.h"
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
#include "Core.DynamicArray.h"

/*fd1*/pointer c_2106303_ObjectasStr(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */sprintf(/*fc2 null */getTmpBuffer(), "(%s::%s) id=%lu", /*te141*/((c_2106303_Object_cm*)getc_2106303_Object_cm())->classPackage(), /*te141*/((c_2106303_Object_cm*)getc_2106303_Object_cm())->className(), /*te8*/this);
/*rx2*/ return __exitReturn_pointer_un(/*fc2 null */getTmpBuffer(), entry__);
}


/*fd1*/void c_2106303_ObjectprintTo(num this, pointer stream){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */fprintf(/*te8*/stream, "%s", /* switch from fc5 to te4*/((c_2106303_Object_cm*)useObject(this)->classmodel)->asStr(this));

__onExit();}


/*fd1*/pointer c_2106303_ObjectobjectData(num this){

u64 entry__ = __onEnter();/*rx2*/ return __exitReturn_pointer_un(/*fc2 null */Object_data(/*te8*/this), entry__);
}


/*fd1*/i64 c_2106303_ObjecthashCode(num this){

u64 entry__ = __onEnter();return __exitReturn_i64_un(/*oxa*/(/*oxa*//*te8*/this * /*oxb*//* csf */0xff3ff3ff3ff3ff13) >> /*oxb*/3, entry__);
}


/*fd1*/boolean c_2106303_Objectequals(num this, num other){

u64 entry__ = __onEnter();return __exitReturn_i8_un(/*oxa*//*te8*/this == /*oxb*//*te8*/other, entry__);
}


/*fd1*/void c_2106303_Objectfree(num this){

u64 entry__ = __onEnter();
__onExit();}


/*fd1*/void c_2106303_Objectrelease(num this){

u64 entry__ = __onEnter();
__onExit();}


/*fd1*/pointer c_2106303_Objectalloc(num this, u64 size){

u64 entry__ = __onEnter();/*rx2*/ return __exitReturn_pointer_un(/*fc2 null */Object_alloc(/*te8*/this, /*te8*/size), entry__);
}


/*fd1*/pointer c_2106303_Objectrealloc(num this, pointer ptr, u64 size){

u64 entry__ = __onEnter();/*rx2*/ return __exitReturn_pointer_un(/*fc2 null */Object_realloc(/*te8*/this, /*te8*/ptr, /*te8*/size), entry__);
}


/*fd1*/pointer c_2106303_ObjectclassName(){
  return  "Core.Object";
}


/*fd1*/pointer c_2106303_ObjectclassShortName(){
  return  "Object";
}


/*fd1*/pointer c_2106303_ObjectclassCName(){
  return  "c_2106303_Object";
}


/*fd1*/pointer c_2106303_ObjectclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_ObjectobjectDatasize(){
  return  sizeof(c_2106303_Object);
}


void c_2106303_Object_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_Object() {
  c_2106303_Object * _c_2106303_Object = ec_calloc(sizeof(c_2106303_Object), sizeof(char));
  return createObject(_c_2106303_Object, getc_2106303_Object_cm(), false);
}

c_2106303_Object_cm _c_2106303_Object_cm;
boolean _c_2106303_Object_init = false;
pointer getc_2106303_Object_cm() {
  if (!_c_2106303_Object_init) {
    registerClassModel(&_c_2106303_Object_cm);
    populatec_2106303_Object_cm(&_c_2106303_Object_cm);
    _c_2106303_Object_init = true;
  }
  return &_c_2106303_Object_cm;
}


/* default constructor */
void populatec_2106303_Object_cm(pointer classModel) {
 
  c_2106303_Object_cm* thisClassModel = (c_2106303_Object_cm*)classModel;
  thisClassModel->parent = null;
  thisClassModel->asStr = c_2106303_ObjectasStr;
  thisClassModel->printTo = c_2106303_ObjectprintTo;
  thisClassModel->objectData = c_2106303_ObjectobjectData;
  thisClassModel->hashCode = c_2106303_ObjecthashCode;
  thisClassModel->equals = c_2106303_Objectequals;
  thisClassModel->free = c_2106303_Objectfree;
  thisClassModel->release = c_2106303_Objectrelease;
  thisClassModel->alloc = c_2106303_Objectalloc;
  thisClassModel->realloc = c_2106303_Objectrealloc;
  thisClassModel->className = c_2106303_ObjectclassName;
  thisClassModel->classShortName = c_2106303_ObjectclassShortName;
  thisClassModel->classCName = c_2106303_ObjectclassCName;
  thisClassModel->classPackage = c_2106303_ObjectclassPackage;
  thisClassModel->objectDatasize = c_2106303_ObjectobjectDatasize;
  thisClassModel->free = c_2106303_Object_free;
}

