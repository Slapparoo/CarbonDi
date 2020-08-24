// Core.Exception
#include "Core.Core_main.h"
#include "Core.Exception.h"
#include "Core.Object.h"
#include "Core.String.h"
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
#include "Core.FileUtils.h"
#include "Core.Charactor.h"
#include "Core.DynamicArray.h"

/*fd1*/pointer c_2106303_ExceptionclassName(){
  return  "Core.Exception";
}


/*fd1*/pointer c_2106303_ExceptionclassShortName(){
  return  "Exception";
}


/*fd1*/pointer c_2106303_ExceptionclassCName(){
  return  "c_2106303_Exception";
}


/*fd1*/pointer c_2106303_ExceptionclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_ExceptionobjectDatasize(){
  return  sizeof(c_2106303_Exception);
}











/*fd1*/num c_2106303_Exceptionget_message(num this){
  return  ((c_2106303_Exception*)useObject(this)->data)->message;
}


/*fd1*/void c_2106303_Exceptionset_message(num this, num a__a){
/*cda2*/ assignObject(&((c_2106303_Exception*)useObject(this)->data)/*cda3*/->message, a__a);
}


/*fd1*/num c_2106303_Exceptionget_root(num this){
  return  ((c_2106303_Exception*)useObject(this)->data)->root;
}


/*fd1*/void c_2106303_Exceptionset_root(num this, num a__a){
/*cda2*/ assignObject(&((c_2106303_Exception*)useObject(this)->data)/*cda3*/->root, a__a);
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
  thisClassModel->className = c_2106303_ExceptionclassName;
  thisClassModel->classShortName = c_2106303_ExceptionclassShortName;
  thisClassModel->classCName = c_2106303_ExceptionclassCName;
  thisClassModel->classPackage = c_2106303_ExceptionclassPackage;
  thisClassModel->objectDatasize = c_2106303_ExceptionobjectDatasize;
  thisClassModel->get_message = c_2106303_Exceptionget_message;
  thisClassModel->set_message = c_2106303_Exceptionset_message;
  thisClassModel->get_root = c_2106303_Exceptionget_root;
  thisClassModel->set_root = c_2106303_Exceptionset_root;
  thisClassModel->free = c_2106303_Exception_free;
}

