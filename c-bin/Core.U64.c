// Core.U64
#include "eccore.h"

int c_2106303_U64datatype(){

u64 entry_ = __onEnter();return __exitReturn_int_un(/*te14*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->get_u64_(), entry_);
}


pointer c_2106303_U64typename(){

u64 entry_ = __onEnter();return __exitReturn_pointer_un("u64", entry_);
}


pointer c_2106303_U64asStr(num this){

u64 entry_ = __onEnter();/**(Statement)*/ /*fc2 null */sprintf(/*fc2 null */getTmpBuffer(), "%lu", /*te14a*/((c_2106303_U64_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this));
return __exitReturn_pointer_un(/*fc2 null */getTmpBuffer(), entry_);
}


pointer c_2106303_U64getClassName(){
  return  "Core.U64";
}


pointer c_2106303_U64getClassShortName(){
  return  "U64";
}


pointer c_2106303_U64getClassCName(){
  return  "c_2106303_U64";
}


pointer c_2106303_U64getClassPackage(){
  return  "Core";
}


u64 c_2106303_U64getObjectDatasize(){
  return  sizeof(c_2106303_U64);
}










u64 c_2106303_U64get_value(num this){
  return  ((c_2106303_U64*)useObject(this)->data)->value;
}


void c_2106303_U64set_value(num this, u64 value){
((c_2106303_U64*)useObject(this)->data)->value = value;
}


void c_2106303_U64_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_U64() {
  c_2106303_U64 * _c_2106303_U64 = ec_calloc(sizeof(c_2106303_U64), sizeof(char));
  return createObject(_c_2106303_U64, getc_2106303_U64_cm(), false);
}

c_2106303_U64_cm _c_2106303_U64_cm;
boolean _c_2106303_U64_init = false;
pointer getc_2106303_U64_cm() {
  if (!_c_2106303_U64_init) {
    registerClassModel(&_c_2106303_U64_cm);
    populatec_2106303_U64_cm(&_c_2106303_U64_cm);
    _c_2106303_U64_init = true;
  }
  return &_c_2106303_U64_cm;
}


/* default constructor */
num create_c_2106303_U64_1(/* param *//*va1*/u64 value) {
num this =  create_c_2106303_U64();

((c_2106303_U64_cm*)useObject(this)->classmodel)->set_value(this, value);

return this;
}
void populatec_2106303_U64_cm(pointer classModel) {
 populatec_2106303_BaseBoxing_cm(classModel);
  c_2106303_U64_cm* thisClassModel = (c_2106303_U64_cm*)classModel;
  thisClassModel->parent = getc_2106303_BaseBoxing_cm();
  thisClassModel->datatype = c_2106303_U64datatype;
  thisClassModel->typename = c_2106303_U64typename;
  thisClassModel->asStr = c_2106303_U64asStr;
  thisClassModel->getClassName = c_2106303_U64getClassName;
  thisClassModel->getClassShortName = c_2106303_U64getClassShortName;
  thisClassModel->getClassCName = c_2106303_U64getClassCName;
  thisClassModel->getClassPackage = c_2106303_U64getClassPackage;
  thisClassModel->getObjectDatasize = c_2106303_U64getObjectDatasize;
  thisClassModel->get_value = c_2106303_U64get_value;
  thisClassModel->set_value = c_2106303_U64set_value;
  thisClassModel->free = c_2106303_U64_free;
}

