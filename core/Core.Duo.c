// Core.Duo
#include "Core.Core_main.h"
#include "Core.Duo.h"
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
#include "Core.Hashset.h"
#include "Core.MapDuo.h"
#include "Core.MapEntry.h"
#include "Core.Hashmap.h"

/*fd1*/pointer c_2106303_DuoclassName(){
  return  "Core.Duo";
}


/*fd1*/pointer c_2106303_DuoclassShortName(){
  return  "Duo";
}


/*fd1*/pointer c_2106303_DuoclassCName(){
  return  "c_2106303_Duo";
}


/*fd1*/pointer c_2106303_DuoclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_DuoobjectDatasize(){
  return  sizeof(c_2106303_Duo);
}











/*fd1*/num c_2106303_Duoget_one(num this){
  return  ((c_2106303_Duo*)useObject(this)->data)->one;
}


/*fd1*/void c_2106303_Duoset_one(num this, num a__a){
/*cda2*/ assignObject(&((c_2106303_Duo*)useObject(this)->data)/*cda3*/->one, a__a);
}


/*fd1*/num c_2106303_Duoget_two(num this){
  return  ((c_2106303_Duo*)useObject(this)->data)->two;
}


/*fd1*/void c_2106303_Duoset_two(num this, num a__a){
/*cda2*/ assignObject(&((c_2106303_Duo*)useObject(this)->data)/*cda3*/->two, a__a);
}


void c_2106303_Duo_free(num this) { Object_ref *object_ref = useObject(this);
  returnObject(((c_2106303_Duo*)object_ref->data)->one);
  returnObject(((c_2106303_Duo*)object_ref->data)->two);
}



num create_c_2106303_Duo() {
  c_2106303_Duo * _c_2106303_Duo = ec_calloc(sizeof(c_2106303_Duo), sizeof(char));
/*cdv1*/((c_2106303_Duo*)_c_2106303_Duo)->instanceName = c_2106303_DuoclassName();
  return createObject(_c_2106303_Duo, getc_2106303_Duo_cm(), false);
}

c_2106303_Duo_cm _c_2106303_Duo_cm;
boolean _c_2106303_Duo_init = false;
pointer getc_2106303_Duo_cm() {
  if (!_c_2106303_Duo_init) {
    registerClassModel(&_c_2106303_Duo_cm);
    populatec_2106303_Duo_cm(&_c_2106303_Duo_cm);
    _c_2106303_Duo_init = true;
  }
  return &_c_2106303_Duo_cm;
}


/* default constructor */
void populatec_2106303_Duo_cm(pointer classModel) {
 populatec_2106303_Object_cm(classModel);
  c_2106303_Duo_cm* thisClassModel = (c_2106303_Duo_cm*)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->className = c_2106303_DuoclassName;
  thisClassModel->classShortName = c_2106303_DuoclassShortName;
  thisClassModel->classCName = c_2106303_DuoclassCName;
  thisClassModel->classPackage = c_2106303_DuoclassPackage;
  thisClassModel->objectDatasize = c_2106303_DuoobjectDatasize;
  thisClassModel->get_one = c_2106303_Duoget_one;
  thisClassModel->set_one = c_2106303_Duoset_one;
  thisClassModel->get_two = c_2106303_Duoget_two;
  thisClassModel->set_two = c_2106303_Duoset_two;
  thisClassModel->free = c_2106303_Duo_free;
}

