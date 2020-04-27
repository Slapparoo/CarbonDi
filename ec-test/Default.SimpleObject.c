// Default.SimpleObject
#include "Default.SimpleObject.h"
#include "Core.Array.h"
#include "Core.B8.h"
#include "Core.BaseBoxing.h"
#include "Core.Boxing.h"
#include "Core.Core_main.h"
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

i64 c_1085510111_SimpleObjectconstNumber() {

  u64 entry$ = __onEnter();
  return __exitReturn_i64_un(66, entry$);
}

pointer c_1085510111_SimpleObjectgetClassName() { return "Default.SimpleObject"; }

pointer c_1085510111_SimpleObjectgetClassShortName() { return "SimpleObject"; }

pointer c_1085510111_SimpleObjectgetClassCName() { return "c_1085510111_SimpleObject"; }

pointer c_1085510111_SimpleObjectgetClassPackage() { return "Default"; }

u64 c_1085510111_SimpleObjectgetObjectDatasize() { return sizeof(c_1085510111_SimpleObject); }

i64 c_1085510111_SimpleObjectget_count1(num this) {
  return ((c_1085510111_SimpleObject *)useObject(this)->data)->count1;
}

void c_1085510111_SimpleObjectset_count1(num this, i64 count1) {
  ((c_1085510111_SimpleObject *)useObject(this)->data)->count1 = count1;
}

i64 c_1085510111_SimpleObjectget_count2() {
  return ((c_1085510111_SimpleObject_cm *)getc_1085510111_SimpleObject_cm())->count2;
}

void c_1085510111_SimpleObjectset_count2(i64 count2) {
  ((c_1085510111_SimpleObject_cm *)getc_1085510111_SimpleObject_cm())->count2 = count2;
}

i64 c_1085510111_SimpleObjectget_count3(num this) {
  return ((c_1085510111_SimpleObject *)useObject(this)->data)->count3;
}

void c_1085510111_SimpleObjectset_count3(num this, i64 count3) {
  ((c_1085510111_SimpleObject *)useObject(this)->data)->count3 = count3;
}

void c_1085510111_SimpleObject_free(num this) { Object_ref *object_ref = useObject(this); }

num create_c_1085510111_SimpleObject() {
  c_1085510111_SimpleObject *_c_1085510111_SimpleObject = ec_calloc(sizeof(c_1085510111_SimpleObject), sizeof(char));
  /*cdv1*/ ((c_1085510111_SimpleObject *)_c_1085510111_SimpleObject)->count1 = 12;
  /*cdv1*/ ((c_1085510111_SimpleObject *)_c_1085510111_SimpleObject)->count3 = 27;
  return createObject(_c_1085510111_SimpleObject, getc_1085510111_SimpleObject_cm(), false);
}

c_1085510111_SimpleObject_cm _c_1085510111_SimpleObject_cm;
boolean _c_1085510111_SimpleObject_init = false;
pointer getc_1085510111_SimpleObject_cm() {
  if (!_c_1085510111_SimpleObject_init) {
    registerClassModel(&_c_1085510111_SimpleObject_cm);
    populatec_1085510111_SimpleObject_cm(&_c_1085510111_SimpleObject_cm);
    _c_1085510111_SimpleObject_init = true;
  }
  return &_c_1085510111_SimpleObject_cm;
}

/* default constructor */
num create_c_1085510111_SimpleObject$1(/* param */ /*va1*/ i64 count1) {
  num this = create_c_1085510111_SimpleObject();

  ((c_1085510111_SimpleObject_cm *)useObject(this)->classmodel)->set_count1(this, count1);

  return this;
}
void populatec_1085510111_SimpleObject_cm(pointer classModel) {
  populatec_2106303_Object_cm(classModel);
  c_1085510111_SimpleObject_cm *thisClassModel = (c_1085510111_SimpleObject_cm *)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->constNumber = c_1085510111_SimpleObjectconstNumber;
  thisClassModel->getClassName = c_1085510111_SimpleObjectgetClassName;
  thisClassModel->getClassShortName = c_1085510111_SimpleObjectgetClassShortName;
  thisClassModel->getClassCName = c_1085510111_SimpleObjectgetClassCName;
  thisClassModel->getClassPackage = c_1085510111_SimpleObjectgetClassPackage;
  thisClassModel->getObjectDatasize = c_1085510111_SimpleObjectgetObjectDatasize;
  thisClassModel->get_count1 = c_1085510111_SimpleObjectget_count1;
  thisClassModel->set_count1 = c_1085510111_SimpleObjectset_count1;
  thisClassModel->get_count2 = c_1085510111_SimpleObjectget_count2;
  thisClassModel->set_count2 = c_1085510111_SimpleObjectset_count2;
  thisClassModel->get_count3 = c_1085510111_SimpleObjectget_count3;
  thisClassModel->set_count3 = c_1085510111_SimpleObjectset_count3;
  /*cds1*/ thisClassModel->count2 = 51;
  thisClassModel->free = c_1085510111_SimpleObject_free;
}
