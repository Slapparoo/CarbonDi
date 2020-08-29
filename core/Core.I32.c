// Core.I32
#include "Core.Core_main.h"
#include "Core.I32.h"
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
#include "Core.U32.h"
#include "Core.F32.h"
#include "Core.I64.h"
#include "Core.U64.h"
#include "Core.F64.h"
#include "Core.Pointer.h"
#include "Core.FileUtils.h"
#include "Core.Charactor.h"
#include "Core.DynamicArray.h"
#include "Core.Duo.h"
#include "Core.Hashset.h"
#include "Core.MapDuo.h"
#include "Core.MapEntry.h"
#include "Core.Hashmap.h"

/*fd1*/int c_2106303_I32datatype(){

u64 entry__ = __onEnter();return __exitReturn_int_un(/*te14*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->get_i32_(), entry__);
}


/*fd1*/pointer c_2106303_I32typename(){

u64 entry__ = __onEnter();return __exitReturn_pointer_un("i32", entry__);
}


/*fd1*/pointer c_2106303_I32asStr(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */sprintf(/*fc2 null */getTmpBuffer(), "%i", /*te14a*/((c_2106303_I32_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this));
/*rx2*/ return __exitReturn_pointer_un(/*fc2 null */getTmpBuffer(), entry__);
}


/*fd1*/pointer c_2106303_I32className(){
  return  "Core.I32";
}


/*fd1*/pointer c_2106303_I32classShortName(){
  return  "I32";
}


/*fd1*/pointer c_2106303_I32classCName(){
  return  "c_2106303_I32";
}


/*fd1*/pointer c_2106303_I32classPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_I32objectDatasize(){
  return  sizeof(c_2106303_I32);
}










/*fd1*/i32 c_2106303_I32get_value(num this){
  return  ((c_2106303_I32*)useObject(this)->data)->value;
}


/*fd1*/void c_2106303_I32set_value(num this, i32 a__a){
/*cda1*/((c_2106303_I32*)useObject(this)->data)->value = a__a;
}


void c_2106303_I32_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_I32() {
  c_2106303_I32 * _c_2106303_I32 = ec_calloc(sizeof(c_2106303_I32), sizeof(char));
/*cdv1*/((c_2106303_I32*)_c_2106303_I32)->instanceName = c_2106303_I32className();
  return createObject(_c_2106303_I32, getc_2106303_I32_cm(), false);
}

c_2106303_I32_cm _c_2106303_I32_cm;
boolean _c_2106303_I32_init = false;
pointer getc_2106303_I32_cm() {
  if (!_c_2106303_I32_init) {
    registerClassModel(&_c_2106303_I32_cm);
    populatec_2106303_I32_cm(&_c_2106303_I32_cm);
    _c_2106303_I32_init = true;
  }
  return &_c_2106303_I32_cm;
}


/* default constructor */
num create_c_2106303_I32_1(/* param *//*va1*/i32 value) {
num this =  create_c_2106303_I32();

((c_2106303_I32_cm*)useObject(this)->classmodel)->set_value(this, value);

return this;
}
void populatec_2106303_I32_cm(pointer classModel) {
 populatec_2106303_BaseBoxing_cm(classModel);
  c_2106303_I32_cm* thisClassModel = (c_2106303_I32_cm*)classModel;
  thisClassModel->parent = getc_2106303_BaseBoxing_cm();
  thisClassModel->datatype = c_2106303_I32datatype;
  thisClassModel->typename = c_2106303_I32typename;
  thisClassModel->asStr = c_2106303_I32asStr;
  thisClassModel->className = c_2106303_I32className;
  thisClassModel->classShortName = c_2106303_I32classShortName;
  thisClassModel->classCName = c_2106303_I32classCName;
  thisClassModel->classPackage = c_2106303_I32classPackage;
  thisClassModel->objectDatasize = c_2106303_I32objectDatasize;
  thisClassModel->get_value = c_2106303_I32get_value;
  thisClassModel->set_value = c_2106303_I32set_value;
  thisClassModel->free = c_2106303_I32_free;
}

