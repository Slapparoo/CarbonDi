// Core.Object
#include "Core.Core_main.h"
#include "Core.Object.h"
#include "Core.HashCode.h"
#include "Core.Array.h"
#include "Core.RefArray.h"
#include "Core.String.h"
#include "Core.Exception.h"
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
#include "Core.FileUtils.h"
#include "Core.Charactor.h"
#include "Core.DynamicArray.h"
#include "Core.RefArrayList.h"
#include "Core.Duo.h"
#include "Core.Hashset.h"
#include "Core.MapDuo.h"
#include "Core.MapEntry.h"
#include "Core.Hashmap.h"

/*fd1*/pointer c_2106303_ObjectasStr(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */sprintf(/*fc2 null */getTmpBuffer(), "(%s::%s) id=%lu", /*te141*/((c_2106303_Object_cm*)getc_2106303_Object_cm())->classPackage(), /*te141*/((c_2106303_Object_cm*)getc_2106303_Object_cm())->className(), this);
/*rx2*/ return __exitReturn_pointer_un(/*fc2 null */getTmpBuffer(), entry__);
}


/*fd1*/void c_2106303_ObjectprintTo(num this, pointer stream){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */fprintf(stream, "%s", /* switch from fc5 to te4*/((c_2106303_Object_cm*)useObject(this)->classmodel)->asStr(this));

return __exitReturn_void_un(entry__);}


/*fd1*/pointer c_2106303_ObjectobjectData(num this){

u64 entry__ = __onEnter();/*rx2*/ return __exitReturn_pointer_un(/*fc2 null */Object_data(this), entry__);
}


/*fd1*/i32 c_2106303_ObjecthashCode(num this){

u64 entry__ = __onEnter();/*rx4*/ return __exitReturn_ref_un(this, entry__);
}


/*fd1*/boolean c_2106303_Objectequals(num this, num other){

u64 entry__ = __onEnter();return __exitReturn_i8_un(/*oxa*/this == /*oxb*/other, entry__);
}


/*fd1*/void c_2106303_Objectfree(num this){

u64 entry__ = __onEnter();
return __exitReturn_void_un(entry__);}


/*fd1*/void c_2106303_Objectrelease(num this){

u64 entry__ = __onEnter();
return __exitReturn_void_un(entry__);}


/*fd1*/pointer c_2106303_Objectalloc(num this, u64 size){

u64 entry__ = __onEnter();/*rx2*/ return __exitReturn_pointer_un(/*fc2 null */Object_alloc(this, size), entry__);
}


/*fd1*/pointer c_2106303_Objectrealloc(num this, pointer ptr, u64 size){

u64 entry__ = __onEnter();/*rx2*/ return __exitReturn_pointer_un(/*fc2 null */Object_realloc(this, ptr, size), entry__);
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


/*fd1*/pointer c_2106303_Objectget_instanceName(num this){
  return  ((c_2106303_Object*)useObject(this)->data)->instanceName;
}


/*fd1*/void c_2106303_Objectset_instanceName(num this, pointer a__a){
/*cda1*/((c_2106303_Object*)useObject(this)->data)->instanceName = a__a;
}


void c_2106303_Object_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_Object() {
  c_2106303_Object * _c_2106303_Object = ec_calloc(sizeof(c_2106303_Object), sizeof(char));
  num this = createObject(_c_2106303_Object, getc_2106303_Object_cm(), false);
/*cdv2 nullCore.Object */((c_2106303_Object*)_c_2106303_Object)->instanceName = c_2106303_ObjectclassName();
  return this;
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
 /*cds2*/ thisClassModel->asStr = c_2106303_ObjectasStr;
 /*cds2*/ thisClassModel->printTo = c_2106303_ObjectprintTo;
 /*cds2*/ thisClassModel->objectData = c_2106303_ObjectobjectData;
 /*cds2*/ thisClassModel->hashCode = c_2106303_ObjecthashCode;
 /*cds2*/ thisClassModel->equals = c_2106303_Objectequals;
 /*cds2*/ thisClassModel->free = c_2106303_Objectfree;
 /*cds2*/ thisClassModel->release = c_2106303_Objectrelease;
 /*cds2*/ thisClassModel->alloc = c_2106303_Objectalloc;
 /*cds2*/ thisClassModel->realloc = c_2106303_Objectrealloc;
 /*cds2*/ thisClassModel->className = c_2106303_ObjectclassName;
 /*cds2*/ thisClassModel->classShortName = c_2106303_ObjectclassShortName;
 /*cds2*/ thisClassModel->classCName = c_2106303_ObjectclassCName;
 /*cds2*/ thisClassModel->classPackage = c_2106303_ObjectclassPackage;
 /*cds2*/ thisClassModel->objectDatasize = c_2106303_ObjectobjectDatasize;
 /*cds2*/ thisClassModel->get_instanceName = c_2106303_Objectget_instanceName;
 /*cds2*/ thisClassModel->set_instanceName = c_2106303_Objectset_instanceName;
}

