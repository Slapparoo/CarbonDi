// Core.MapDuo
#include "Core.Core_main.h"
#include "Core.MapDuo.h"
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
#include "Core.MapEntry.h"
#include "Core.Hashmap.h"

/*fd1*/pointer c_2106303_MapDuoclassName(){
  return  "Core.MapDuo";
}


/*fd1*/pointer c_2106303_MapDuoclassShortName(){
  return  "MapDuo";
}


/*fd1*/pointer c_2106303_MapDuoclassCName(){
  return  "c_2106303_MapDuo";
}


/*fd1*/pointer c_2106303_MapDuoclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_MapDuoobjectDatasize(){
  return  sizeof(c_2106303_MapDuo);
}











/*fd1*/num c_2106303_MapDuoget_oneKey(num this){
  return  ((c_2106303_MapDuo*)useObject(this)->data)->oneKey;
}


/*fd1*/void c_2106303_MapDuoset_oneKey(num this, num a__a){
/*cda2*/ assignObject(&((c_2106303_MapDuo*)useObject(this)->data)/*cda3*/->oneKey, a__a);
}


/*fd1*/num c_2106303_MapDuoget_twoKey(num this){
  return  ((c_2106303_MapDuo*)useObject(this)->data)->twoKey;
}


/*fd1*/void c_2106303_MapDuoset_twoKey(num this, num a__a){
/*cda2*/ assignObject(&((c_2106303_MapDuo*)useObject(this)->data)/*cda3*/->twoKey, a__a);
}


/*fd1*/num c_2106303_MapDuoget_oneValue(num this){
  return  ((c_2106303_MapDuo*)useObject(this)->data)->oneValue;
}


/*fd1*/void c_2106303_MapDuoset_oneValue(num this, num a__a){
/*cda2*/ assignObject(&((c_2106303_MapDuo*)useObject(this)->data)/*cda3*/->oneValue, a__a);
}


/*fd1*/num c_2106303_MapDuoget_twoValue(num this){
  return  ((c_2106303_MapDuo*)useObject(this)->data)->twoValue;
}


/*fd1*/void c_2106303_MapDuoset_twoValue(num this, num a__a){
/*cda2*/ assignObject(&((c_2106303_MapDuo*)useObject(this)->data)/*cda3*/->twoValue, a__a);
}


void c_2106303_MapDuo_free(num this) { Object_ref *object_ref = useObject(this);
  returnObject(((c_2106303_MapDuo*)object_ref->data)->oneKey);
  returnObject(((c_2106303_MapDuo*)object_ref->data)->twoKey);
  returnObject(((c_2106303_MapDuo*)object_ref->data)->oneValue);
  returnObject(((c_2106303_MapDuo*)object_ref->data)->twoValue);
}



num create_c_2106303_MapDuo() {
  c_2106303_MapDuo * _c_2106303_MapDuo = ec_calloc(sizeof(c_2106303_MapDuo), sizeof(char));
  num this = createObject(_c_2106303_MapDuo, getc_2106303_MapDuo_cm(), false);
/*cdv2 Core.ObjectCore.MapDuo */((c_2106303_MapDuo*)_c_2106303_MapDuo)->instanceName = c_2106303_MapDuoclassName();
  return this;
}

c_2106303_MapDuo_cm _c_2106303_MapDuo_cm;
boolean _c_2106303_MapDuo_init = false;
pointer getc_2106303_MapDuo_cm() {
  if (!_c_2106303_MapDuo_init) {
    registerClassModel(&_c_2106303_MapDuo_cm);
    populatec_2106303_MapDuo_cm(&_c_2106303_MapDuo_cm);
    _c_2106303_MapDuo_init = true;
  }
  return &_c_2106303_MapDuo_cm;
}


/* default constructor */
void populatec_2106303_MapDuo_cm(pointer classModel) {
 populatec_2106303_Object_cm(classModel);
  c_2106303_MapDuo_cm* thisClassModel = (c_2106303_MapDuo_cm*)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
 /*cds2*/ thisClassModel->className = c_2106303_MapDuoclassName;
 /*cds2*/ thisClassModel->classShortName = c_2106303_MapDuoclassShortName;
 /*cds2*/ thisClassModel->classCName = c_2106303_MapDuoclassCName;
 /*cds2*/ thisClassModel->classPackage = c_2106303_MapDuoclassPackage;
 /*cds2*/ thisClassModel->objectDatasize = c_2106303_MapDuoobjectDatasize;
 /*cds2*/ thisClassModel->get_oneKey = c_2106303_MapDuoget_oneKey;
 /*cds2*/ thisClassModel->set_oneKey = c_2106303_MapDuoset_oneKey;
 /*cds2*/ thisClassModel->get_twoKey = c_2106303_MapDuoget_twoKey;
 /*cds2*/ thisClassModel->set_twoKey = c_2106303_MapDuoset_twoKey;
 /*cds2*/ thisClassModel->get_oneValue = c_2106303_MapDuoget_oneValue;
 /*cds2*/ thisClassModel->set_oneValue = c_2106303_MapDuoset_oneValue;
 /*cds2*/ thisClassModel->get_twoValue = c_2106303_MapDuoget_twoValue;
 /*cds2*/ thisClassModel->set_twoValue = c_2106303_MapDuoset_twoValue;
  thisClassModel->free = c_2106303_MapDuo_free;
}

