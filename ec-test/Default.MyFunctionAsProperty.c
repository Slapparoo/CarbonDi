// Default.MyFunctionAsProperty
#include "Default.MyFunctionAsProperty.h"
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

void c_1085510111_MyFunctionAsPropertysetName(num this, num name) {

  u64 entry$ = __onEnter(); /*Ax2*/ /*te14b*/
  ((c_1085510111_MyFunctionAsProperty_cm *)useObject(/*te8*/ this)->classmodel)->set_name(/*te8*/ this, /*te8*/ name);

  __onExit();
}

num c_1085510111_MyFunctionAsPropertygetName(num this) {

  u64 entry$ = __onEnter(); /*rx2*/
  return __exitReturn_ref_un(
      /*te14a*/ ((c_1085510111_MyFunctionAsProperty_cm *)useObject(/*te8*/ this)->classmodel)->get_name(/*te8*/ this),
      entry$);
}

pointer c_1085510111_MyFunctionAsPropertygetClassName() { return "Default.MyFunctionAsProperty"; }

pointer c_1085510111_MyFunctionAsPropertygetClassShortName() { return "MyFunctionAsProperty"; }

pointer c_1085510111_MyFunctionAsPropertygetClassCName() { return "c_1085510111_MyFunctionAsProperty"; }

pointer c_1085510111_MyFunctionAsPropertygetClassPackage() { return "Default"; }

u64 c_1085510111_MyFunctionAsPropertygetObjectDatasize() { return sizeof(c_1085510111_MyFunctionAsProperty); }

num c_1085510111_MyFunctionAsPropertyget_name(num this) {
  return ((c_1085510111_MyFunctionAsProperty *)useObject(this)->data)->name;
}

void c_1085510111_MyFunctionAsPropertyset_name(num this, num a__$a) {
  /*cda2*/ assignObject(&((c_1085510111_MyFunctionAsProperty *)useObject(this)->data) /*cda3*/->name, a__$a);
}

void c_1085510111_MyFunctionAsProperty_free(num this) {
  Object_ref *object_ref = useObject(this);
  returnObject(((c_1085510111_MyFunctionAsProperty *)object_ref->data)->name);
}

num create_c_1085510111_MyFunctionAsProperty() {
  c_1085510111_MyFunctionAsProperty *_c_1085510111_MyFunctionAsProperty =
      ec_calloc(sizeof(c_1085510111_MyFunctionAsProperty), sizeof(char));
  return createObject(_c_1085510111_MyFunctionAsProperty, getc_1085510111_MyFunctionAsProperty_cm(), false);
}

c_1085510111_MyFunctionAsProperty_cm _c_1085510111_MyFunctionAsProperty_cm;
boolean _c_1085510111_MyFunctionAsProperty_init = false;
pointer getc_1085510111_MyFunctionAsProperty_cm() {
  if (!_c_1085510111_MyFunctionAsProperty_init) {
    registerClassModel(&_c_1085510111_MyFunctionAsProperty_cm);
    populatec_1085510111_MyFunctionAsProperty_cm(&_c_1085510111_MyFunctionAsProperty_cm);
    _c_1085510111_MyFunctionAsProperty_init = true;
  }
  return &_c_1085510111_MyFunctionAsProperty_cm;
}

/* default constructor */
void populatec_1085510111_MyFunctionAsProperty_cm(pointer classModel) {
  populatec_2106303_Object_cm(classModel);
  c_1085510111_MyFunctionAsProperty_cm *thisClassModel = (c_1085510111_MyFunctionAsProperty_cm *)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->setName = c_1085510111_MyFunctionAsPropertysetName;
  thisClassModel->getName = c_1085510111_MyFunctionAsPropertygetName;
  thisClassModel->getClassName = c_1085510111_MyFunctionAsPropertygetClassName;
  thisClassModel->getClassShortName = c_1085510111_MyFunctionAsPropertygetClassShortName;
  thisClassModel->getClassCName = c_1085510111_MyFunctionAsPropertygetClassCName;
  thisClassModel->getClassPackage = c_1085510111_MyFunctionAsPropertygetClassPackage;
  thisClassModel->getObjectDatasize = c_1085510111_MyFunctionAsPropertygetObjectDatasize;
  thisClassModel->get_name = c_1085510111_MyFunctionAsPropertyget_name;
  thisClassModel->set_name = c_1085510111_MyFunctionAsPropertyset_name;
  thisClassModel->free = c_1085510111_MyFunctionAsProperty_free;
}
