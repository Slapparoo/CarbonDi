#include "eccore.h"

int c_2106303_F32datatype(){

u64 entry_ = __onEnter();return __exitReturn_int_un(/*te14*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->get_f32_(), entry_);
}


pointer c_2106303_F32typename(){

u64 entry_ = __onEnter();return __exitReturn_pointer_un("f32", entry_);
}


pointer c_2106303_F32asStr(num this){

u64 entry_ = __onEnter();/**(Statement)*/ /*fc2 null */sprintf(/*fc2 null */getTmpBuffer(), "%f", /*te14a*/((c_2106303_F32_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this));
return __exitReturn_pointer_un(/*fc2 null */getTmpBuffer(), entry_);
}


pointer c_2106303_F32getClassName(){
  return  "Core.F32";
}


pointer c_2106303_F32getClassShortName(){
  return  "F32";
}


pointer c_2106303_F32getClassCName(){
  return  "c_2106303_F32";
}


pointer c_2106303_F32getClassPackage(){
  return  "Core";
}


u64 c_2106303_F32getObjectDatasize(){
  return  sizeof(c_2106303_F32);
}










f32 c_2106303_F32get_value(num this){
  return  ((c_2106303_F32*)useObject(this)->data)->value;
}


void c_2106303_F32set_value(num this, f32 value){
((c_2106303_F32*)useObject(this)->data)->value = value;
}


void c_2106303_F32_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_F32() {
  c_2106303_F32 * _c_2106303_F32 = ec_calloc(sizeof(c_2106303_F32), sizeof(char));
  return createObject(_c_2106303_F32, getc_2106303_F32_cm(), false);
}

c_2106303_F32_cm _c_2106303_F32_cm;
boolean _c_2106303_F32_init = false;
pointer getc_2106303_F32_cm() {
  if (!_c_2106303_F32_init) {
    registerClassModel(&_c_2106303_F32_cm);
    populatec_2106303_F32_cm(&_c_2106303_F32_cm);
    _c_2106303_F32_init = true;
  }
  return &_c_2106303_F32_cm;
}


/* default constructor */
num create_c_2106303_F32_1(/* param *//*va1*/f32 value) {
num this =  create_c_2106303_F32();

((c_2106303_F32_cm*)useObject(this)->classmodel)->set_value(this, value);

return this;
}
void populatec_2106303_F32_cm(pointer classModel) {
 populatec_2106303_BaseBoxing_cm(classModel);
  c_2106303_F32_cm* thisClassModel = (c_2106303_F32_cm*)classModel;
  thisClassModel->parent = getc_2106303_BaseBoxing_cm();
  thisClassModel->datatype = c_2106303_F32datatype;
  thisClassModel->typename = c_2106303_F32typename;
  thisClassModel->asStr = c_2106303_F32asStr;
  thisClassModel->getClassName = c_2106303_F32getClassName;
  thisClassModel->getClassShortName = c_2106303_F32getClassShortName;
  thisClassModel->getClassCName = c_2106303_F32getClassCName;
  thisClassModel->getClassPackage = c_2106303_F32getClassPackage;
  thisClassModel->getObjectDatasize = c_2106303_F32getObjectDatasize;
  thisClassModel->get_value = c_2106303_F32get_value;
  thisClassModel->set_value = c_2106303_F32set_value;
  thisClassModel->free = c_2106303_F32_free;
}

