// Core.I64
#include "Core.Core_main.h"
#include "Core.I64.h"
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
#include "Core.U64.h"
#include "Core.F64.h"
#include "Core.Pointer.h"

int c_2106303_I64datatype(){

u64 entry$ = __onEnter();return __exitReturn_int_un(/*te14*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->get_i64_(), entry$);
}


pointer c_2106303_I64typename(){

u64 entry$ = __onEnter();return __exitReturn_pointer_un("i64", entry$);
}


pointer c_2106303_I64asStr(num this){

u64 entry$ = __onEnter();/**(Statement)*/ /*fc2 null */sprintf(/*fc2 null */getTmpBuffer(), "%li", /*te14a*/((c_2106303_I64_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this));
return __exitReturn_pointer_un(/*fc2 null */getTmpBuffer(), entry$);
}


pointer c_2106303_I64getClassName(){
  return  "Core.I64";
}


pointer c_2106303_I64getClassShortName(){
  return  "I64";
}


pointer c_2106303_I64getClassCName(){
  return  "c_2106303_I64";
}


pointer c_2106303_I64getClassPackage(){
  return  "Core";
}


u64 c_2106303_I64getObjectDatasize(){
  return  sizeof(c_2106303_I64);
}










i64 c_2106303_I64get_value(num this){
  return  ((c_2106303_I64*)useObject(this)->data)->value;
}


void c_2106303_I64set_value(num this, i64 value){
((c_2106303_I64*)useObject(this)->data)->value = value;
}


void c_2106303_I64_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_I64() {
  c_2106303_I64 * _c_2106303_I64 = ec_calloc(sizeof(c_2106303_I64), sizeof(char));
  return createObject(_c_2106303_I64, getc_2106303_I64_cm(), false);
}

c_2106303_I64_cm _c_2106303_I64_cm;
boolean _c_2106303_I64_init = false;
pointer getc_2106303_I64_cm() {
  if (!_c_2106303_I64_init) {
    registerClassModel(&_c_2106303_I64_cm);
    populatec_2106303_I64_cm(&_c_2106303_I64_cm);
    _c_2106303_I64_init = true;
  }
  return &_c_2106303_I64_cm;
}


/* default constructor */
num create_c_2106303_I64$1(/* param *//*va1*/i64 value) {
num this =  create_c_2106303_I64();

((c_2106303_I64_cm*)useObject(this)->classmodel)->set_value(this, value);

return this;
}
void populatec_2106303_I64_cm(pointer classModel) {
 populatec_2106303_BaseBoxing_cm(classModel);
  c_2106303_I64_cm* thisClassModel = (c_2106303_I64_cm*)classModel;
  thisClassModel->parent = getc_2106303_BaseBoxing_cm();
  thisClassModel->datatype = c_2106303_I64datatype;
  thisClassModel->typename = c_2106303_I64typename;
  thisClassModel->asStr = c_2106303_I64asStr;
  thisClassModel->getClassName = c_2106303_I64getClassName;
  thisClassModel->getClassShortName = c_2106303_I64getClassShortName;
  thisClassModel->getClassCName = c_2106303_I64getClassCName;
  thisClassModel->getClassPackage = c_2106303_I64getClassPackage;
  thisClassModel->getObjectDatasize = c_2106303_I64getObjectDatasize;
  thisClassModel->get_value = c_2106303_I64get_value;
  thisClassModel->set_value = c_2106303_I64set_value;
  thisClassModel->free = c_2106303_I64_free;
}

