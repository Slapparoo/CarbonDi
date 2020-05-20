// test.SimpleObject1
#include "test.SimpleObject1.h"
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

i64 c_3556498_SimpleObject1addNumber(num this, i64 number2) {

  u64 entry$ = __onEnter();
  return __exitReturn_i64_un(
      /*oxa*/ /*oxa*/ /*te14a*/ ((c_3556498_SimpleObject1_cm *)useObject(/*te8*/ this)->classmodel)
              ->get_number(/*te8*/ this) +
          /*oxb*/ /*te8*/ number2 +
          /*oxb*/ /*te14a*/
          ((c_3556498_SimpleObject1_cm *)useObject(/*te8*/ this)->classmodel)->get_number(/*te8*/ this),
      entry$);
}

pointer c_3556498_SimpleObject1getClassName() { return "test.SimpleObject1"; }

pointer c_3556498_SimpleObject1getClassShortName() { return "SimpleObject1"; }

pointer c_3556498_SimpleObject1getClassCName() { return "c_3556498_SimpleObject1"; }

pointer c_3556498_SimpleObject1getClassPackage() { return "test"; }

u64 c_3556498_SimpleObject1getObjectDatasize() { return sizeof(c_3556498_SimpleObject1); }

i64 c_3556498_SimpleObject1get_number(num this) { return ((c_3556498_SimpleObject1 *)useObject(this)->data)->number; }

void c_3556498_SimpleObject1set_number(num this, i64 a__$a) {
  /*cda1*/ ((c_3556498_SimpleObject1 *)useObject(this)->data)->number = a__$a;
}

num c_3556498_SimpleObject1get_name(num this) { return ((c_3556498_SimpleObject1 *)useObject(this)->data)->name; }

void c_3556498_SimpleObject1set_name(num this, num a__$a) {
  /*cda2*/ assignObject(&((c_3556498_SimpleObject1 *)useObject(this)->data) /*cda3*/->name, a__$a);
}

void c_3556498_SimpleObject1_free(num this) {
  Object_ref *object_ref = useObject(this);
  returnObject(((c_3556498_SimpleObject1 *)object_ref->data)->name);
}

num create_c_3556498_SimpleObject1() {
  c_3556498_SimpleObject1 *_c_3556498_SimpleObject1 = ec_calloc(sizeof(c_3556498_SimpleObject1), sizeof(char));
  return createObject(_c_3556498_SimpleObject1, getc_3556498_SimpleObject1_cm(), false);
}

c_3556498_SimpleObject1_cm _c_3556498_SimpleObject1_cm;
boolean _c_3556498_SimpleObject1_init = false;
pointer getc_3556498_SimpleObject1_cm() {
  if (!_c_3556498_SimpleObject1_init) {
    registerClassModel(&_c_3556498_SimpleObject1_cm);
    populatec_3556498_SimpleObject1_cm(&_c_3556498_SimpleObject1_cm);
    _c_3556498_SimpleObject1_init = true;
  }
  return &_c_3556498_SimpleObject1_cm;
}

/* default constructor */
num create_c_3556498_SimpleObject1$1(/* param */ /*va1*/ i64 number, /*va1*/ num name) {
  num this = create_c_3556498_SimpleObject1();

  ((c_3556498_SimpleObject1_cm *)useObject(this)->classmodel)->set_number(this, number);
  ((c_3556498_SimpleObject1_cm *)useObject(this)->classmodel)->set_name(this, name);

  return this;
}
void populatec_3556498_SimpleObject1_cm(pointer classModel) {
  populatec_2106303_Object_cm(classModel);
  c_3556498_SimpleObject1_cm *thisClassModel = (c_3556498_SimpleObject1_cm *)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->addNumber = c_3556498_SimpleObject1addNumber;
  thisClassModel->getClassName = c_3556498_SimpleObject1getClassName;
  thisClassModel->getClassShortName = c_3556498_SimpleObject1getClassShortName;
  thisClassModel->getClassCName = c_3556498_SimpleObject1getClassCName;
  thisClassModel->getClassPackage = c_3556498_SimpleObject1getClassPackage;
  thisClassModel->getObjectDatasize = c_3556498_SimpleObject1getObjectDatasize;
  thisClassModel->get_number = c_3556498_SimpleObject1get_number;
  thisClassModel->set_number = c_3556498_SimpleObject1set_number;
  thisClassModel->get_name = c_3556498_SimpleObject1get_name;
  thisClassModel->set_name = c_3556498_SimpleObject1set_name;
  thisClassModel->free = c_3556498_SimpleObject1_free;
}
