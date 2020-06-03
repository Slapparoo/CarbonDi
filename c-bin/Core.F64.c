// Core.F64
#include "eccore.h"

int c_2106303_F64datatype(){

u64 entry_ = __onEnter();return __exitReturn_int_un(/*te14*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->get_f64_(), entry_);
}


pointer c_2106303_F64typename(){

u64 entry_ = __onEnter();return __exitReturn_pointer_un("f64", entry_);
}


pointer c_2106303_F64asStr(num this){

u64 entry_ = __onEnter();/**(Statement)*/ /*fc2 null */sprintf(/*fc2 null */getTmpBuffer(), "%lf", /*te14a*/((c_2106303_F64_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this));
return __exitReturn_pointer_un(/*fc2 null */getTmpBuffer(), entry_);
}


pointer c_2106303_F64getClassName(){
  return  "Core.F64";
}


pointer c_2106303_F64getClassShortName(){
  return  "F64";
}


pointer c_2106303_F64getClassCName(){
  return  "c_2106303_F64";
}


pointer c_2106303_F64getClassPackage(){
  return  "Core";
}


u64 c_2106303_F64getObjectDatasize(){
  return  sizeof(c_2106303_F64);
}










f64 c_2106303_F64get_value(num this){
  return  ((c_2106303_F64*)useObject(this)->data)->value;
}


void c_2106303_F64set_value(num this, f64 value){
((c_2106303_F64*)useObject(this)->data)->value = value;
}


void c_2106303_F64_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_F64() {
  c_2106303_F64 * _c_2106303_F64 = ec_calloc(sizeof(c_2106303_F64), sizeof(char));
  return createObject(_c_2106303_F64, getc_2106303_F64_cm(), false);
}

c_2106303_F64_cm _c_2106303_F64_cm;
boolean _c_2106303_F64_init = false;
pointer getc_2106303_F64_cm() {
  if (!_c_2106303_F64_init) {
    registerClassModel(&_c_2106303_F64_cm);
    populatec_2106303_F64_cm(&_c_2106303_F64_cm);
    _c_2106303_F64_init = true;
  }
  return &_c_2106303_F64_cm;
}


/* default constructor */
num create_c_2106303_F64_1(/* param *//*va1*/f64 value) {
num this =  create_c_2106303_F64();

((c_2106303_F64_cm*)useObject(this)->classmodel)->set_value(this, value);

return this;
}
void populatec_2106303_F64_cm(pointer classModel) {
 populatec_2106303_BaseBoxing_cm(classModel);
  c_2106303_F64_cm* thisClassModel = (c_2106303_F64_cm*)classModel;
  thisClassModel->parent = getc_2106303_BaseBoxing_cm();
  thisClassModel->datatype = c_2106303_F64datatype;
  thisClassModel->typename = c_2106303_F64typename;
  thisClassModel->asStr = c_2106303_F64asStr;
  thisClassModel->getClassName = c_2106303_F64getClassName;
  thisClassModel->getClassShortName = c_2106303_F64getClassShortName;
  thisClassModel->getClassCName = c_2106303_F64getClassCName;
  thisClassModel->getClassPackage = c_2106303_F64getClassPackage;
  thisClassModel->getObjectDatasize = c_2106303_F64getObjectDatasize;
  thisClassModel->get_value = c_2106303_F64get_value;
  thisClassModel->set_value = c_2106303_F64set_value;
  thisClassModel->free = c_2106303_F64_free;
}

