// Core.Exception
#include "Core.Core_main.h"
#include "Core.Exception.h"
#include "Core.Object.h"
#include "Core.HashCode.h"
#include "Core.Array.h"
#include "Core.RefArray.h"
#include "Core.String.h"
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
  num this = createObject(_c_2106303_Exception, getc_2106303_Exception_cm(), false);
/*cdv2 Core.ObjectCore.Exception */((c_2106303_Exception*)_c_2106303_Exception)->instanceName = c_2106303_ExceptionclassName();
  return this;
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
 /*cds2*/ thisClassModel->className = c_2106303_ExceptionclassName;
 /*cds2*/ thisClassModel->classShortName = c_2106303_ExceptionclassShortName;
 /*cds2*/ thisClassModel->classCName = c_2106303_ExceptionclassCName;
 /*cds2*/ thisClassModel->classPackage = c_2106303_ExceptionclassPackage;
 /*cds2*/ thisClassModel->objectDatasize = c_2106303_ExceptionobjectDatasize;
 /*cds2*/ thisClassModel->get_message = c_2106303_Exceptionget_message;
 /*cds2*/ thisClassModel->set_message = c_2106303_Exceptionset_message;
 /*cds2*/ thisClassModel->get_root = c_2106303_Exceptionget_root;
 /*cds2*/ thisClassModel->set_root = c_2106303_Exceptionset_root;
  thisClassModel->free = c_2106303_Exception_free;
}

