// Default.MyOtherClass
#include "Default.MyOtherClass.h"
#include "Core.Array.h"
#include "Core.B8.h"
#include "Core.BaseBoxing.h"
#include "Core.Boxing.h"
#include "Core.Core_main.h"
#include "Core.DynamicArray.h"
#include "Core.Exception.h"
#include "Core.F32.h"
#include "Core.F64.h"
#include "Core.I16.h"
#include "Core.I32.h"
#include "Core.I64.h"
#include "Core.I8.h"
#include "Core.Object.h"
#include "Core.Pointer.h"
#include "Core.RefArray.h"
#include "Core.String.h"
#include "Core.U16.h"
#include "Core.U32.h"
#include "Core.U64.h"
#include "Core.U8.h"
#include "Default.MyClass.h"
#include "Default.MySecondClass.h"

pointer c_1085510111_MyOtherClassgetClassName() { return "Default.MyOtherClass"; }

pointer c_1085510111_MyOtherClassgetClassShortName() { return "MyOtherClass"; }

pointer c_1085510111_MyOtherClassgetClassCName() { return "c_1085510111_MyOtherClass"; }

pointer c_1085510111_MyOtherClassgetClassPackage() { return "Default"; }

u64 c_1085510111_MyOtherClassgetObjectDatasize() { return sizeof(c_1085510111_MyOtherClass); }

num c_1085510111_MyOtherClassget_myClass(num this) {
  return ((c_1085510111_MyOtherClass *)useObject(this)->data)->myClass;
}

void c_1085510111_MyOtherClassset_myClass(num this, num a__$a) {
  /*cda2*/ assignObject(&((c_1085510111_MyOtherClass *)useObject(this)->data) /*cda3*/->myClass, a__$a);
}

void c_1085510111_MyOtherClass_free(num this) {
  Object_ref *object_ref = useObject(this);
  returnObject(((c_1085510111_MyOtherClass *)object_ref->data)->myClass);
}

num create_c_1085510111_MyOtherClass() {
  c_1085510111_MyOtherClass *_c_1085510111_MyOtherClass = ec_calloc(sizeof(c_1085510111_MyOtherClass), sizeof(char));
  return createObject(_c_1085510111_MyOtherClass, getc_1085510111_MyOtherClass_cm(), false);
}

c_1085510111_MyOtherClass_cm _c_1085510111_MyOtherClass_cm;
boolean _c_1085510111_MyOtherClass_init = false;
pointer getc_1085510111_MyOtherClass_cm() {
  if (!_c_1085510111_MyOtherClass_init) {
    registerClassModel(&_c_1085510111_MyOtherClass_cm);
    populatec_1085510111_MyOtherClass_cm(&_c_1085510111_MyOtherClass_cm);
    _c_1085510111_MyOtherClass_init = true;
  }
  return &_c_1085510111_MyOtherClass_cm;
}

/* default constructor */
void populatec_1085510111_MyOtherClass_cm(pointer classModel) {
  populatec_2106303_Object_cm(classModel);
  c_1085510111_MyOtherClass_cm *thisClassModel = (c_1085510111_MyOtherClass_cm *)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->getClassName = c_1085510111_MyOtherClassgetClassName;
  thisClassModel->getClassShortName = c_1085510111_MyOtherClassgetClassShortName;
  thisClassModel->getClassCName = c_1085510111_MyOtherClassgetClassCName;
  thisClassModel->getClassPackage = c_1085510111_MyOtherClassgetClassPackage;
  thisClassModel->getObjectDatasize = c_1085510111_MyOtherClassgetObjectDatasize;
  thisClassModel->get_myClass = c_1085510111_MyOtherClassget_myClass;
  thisClassModel->set_myClass = c_1085510111_MyOtherClassset_myClass;
  thisClassModel->free = c_1085510111_MyOtherClass_free;
}
