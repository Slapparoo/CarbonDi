#include "eccore.h"

pointer c_2106303_ExceptiongetClassName(){
  return  "Core.Exception";
}


pointer c_2106303_ExceptiongetClassShortName(){
  return  "Exception";
}


pointer c_2106303_ExceptiongetClassCName(){
  return  "c_2106303_Exception";
}


pointer c_2106303_ExceptiongetClassPackage(){
  return  "Core";
}


u64 c_2106303_ExceptiongetObjectDatasize(){
  return  sizeof(c_2106303_Exception);
}











num c_2106303_Exceptionget_message(num this){
  return  ((c_2106303_Exception*)useObject(this)->data)->message;
}


void c_2106303_Exceptionset_message(num this, num message){
assignObject(&((c_2106303_Exception*)useObject(this)->data)->message, message);
}


num c_2106303_Exceptionget_root(num this){
  return  ((c_2106303_Exception*)useObject(this)->data)->root;
}


void c_2106303_Exceptionset_root(num this, num root){
assignObject(&((c_2106303_Exception*)useObject(this)->data)->root, root);
}


void c_2106303_Exception_free(num this) { Object_ref *object_ref = useObject(this);
  returnObject(((c_2106303_Exception*)object_ref->data)->message);
  returnObject(((c_2106303_Exception*)object_ref->data)->root);
}



num create_c_2106303_Exception() {
  c_2106303_Exception * _c_2106303_Exception = ec_calloc(sizeof(c_2106303_Exception), sizeof(char));
  return createObject(_c_2106303_Exception, getc_2106303_Exception_cm(), false);
}

c_2106303_Exception_cm _c_2106303_Exception_cm;
boolean _c_2106303_Exception_init = false;
pointer getc_2106303_Exception_cm() {
  if (!_c_2106303_Exception_init) {
    registerClassModel(&_c_2106303_Exception_cm);
    populatec_2106303_Exception_cm(&_c_2106303_Exception_cm);
    _c_2106303_Exception_init = true;
  }
  return &_c_2106303_Exception_cm;
}



num create_c_2106303_Exception_1(/* param *//*va1*/num root, /*va1*/num message) {
num this =  create_c_2106303_Exception();

((c_2106303_Exception_cm*)useObject(this)->classmodel)->set_root(this, root);
((c_2106303_Exception_cm*)useObject(this)->classmodel)->set_message(this, message);

return this;
}
num create_c_2106303_Exception_2(/* param *//*va1*/num message) {
num this =  create_c_2106303_Exception();

((c_2106303_Exception_cm*)useObject(this)->classmodel)->set_message(this, message);

return this;
}
void populatec_2106303_Exception_cm(pointer classModel) {
 populatec_2106303_Object_cm(classModel);
  c_2106303_Exception_cm* thisClassModel = (c_2106303_Exception_cm*)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->getClassName = c_2106303_ExceptiongetClassName;
  thisClassModel->getClassShortName = c_2106303_ExceptiongetClassShortName;
  thisClassModel->getClassCName = c_2106303_ExceptiongetClassCName;
  thisClassModel->getClassPackage = c_2106303_ExceptiongetClassPackage;
  thisClassModel->getObjectDatasize = c_2106303_ExceptiongetObjectDatasize;
  thisClassModel->get_message = c_2106303_Exceptionget_message;
  thisClassModel->set_message = c_2106303_Exceptionset_message;
  thisClassModel->get_root = c_2106303_Exceptionget_root;
  thisClassModel->set_root = c_2106303_Exceptionset_root;
  thisClassModel->free = c_2106303_Exception_free;
}

