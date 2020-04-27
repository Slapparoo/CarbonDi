// test.Class1
#include "test.Class1.h"
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
#include "test.Class2.h"

i64 c_3556498_Class1constNumber() {

  u64 entry$ = __onEnter();
  return __exitReturn_i64_un(10, entry$);
}

pointer c_3556498_Class1getClassName() { return "test.Class1"; }

pointer c_3556498_Class1getClassShortName() { return "Class1"; }

pointer c_3556498_Class1getClassCName() { return "c_3556498_Class1"; }

pointer c_3556498_Class1getClassPackage() { return "test"; }

u64 c_3556498_Class1getObjectDatasize() { return sizeof(c_3556498_Class1); }

i64 c_3556498_Class1get_count1(num this) { return ((c_3556498_Class1 *)useObject(this)->data)->count1; }

void c_3556498_Class1set_count1(num this, i64 count1) { ((c_3556498_Class1 *)useObject(this)->data)->count1 = count1; }

i64 c_3556498_Class1get_count2(num this) { return ((c_3556498_Class1 *)useObject(this)->data)->count2; }

void c_3556498_Class1set_count2(num this, i64 count2) { ((c_3556498_Class1 *)useObject(this)->data)->count2 = count2; }

void c_3556498_Class1_free(num this) { Object_ref *object_ref = useObject(this); }

num create_c_3556498_Class1() {
  c_3556498_Class1 *_c_3556498_Class1 = ec_calloc(sizeof(c_3556498_Class1), sizeof(char));
  return createObject(_c_3556498_Class1, getc_3556498_Class1_cm(), false);
}

c_3556498_Class1_cm _c_3556498_Class1_cm;
boolean _c_3556498_Class1_init = false;
pointer getc_3556498_Class1_cm() {
  if (!_c_3556498_Class1_init) {
    registerClassModel(&_c_3556498_Class1_cm);
    populatec_3556498_Class1_cm(&_c_3556498_Class1_cm);
    _c_3556498_Class1_init = true;
  }
  return &_c_3556498_Class1_cm;
}

/* default constructor */
num create_c_3556498_Class1$1(/* param */ /*va1*/ i64 count1) {
  num this = create_c_3556498_Class1();

  ((c_3556498_Class1_cm *)useObject(this)->classmodel)->set_count1(this, count1);

  return this;
}
void populatec_3556498_Class1_cm(pointer classModel) {
  populatec_2106303_Object_cm(classModel);
  c_3556498_Class1_cm *thisClassModel = (c_3556498_Class1_cm *)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->constNumber = c_3556498_Class1constNumber;
  thisClassModel->getClassName = c_3556498_Class1getClassName;
  thisClassModel->getClassShortName = c_3556498_Class1getClassShortName;
  thisClassModel->getClassCName = c_3556498_Class1getClassCName;
  thisClassModel->getClassPackage = c_3556498_Class1getClassPackage;
  thisClassModel->getObjectDatasize = c_3556498_Class1getObjectDatasize;
  thisClassModel->get_count1 = c_3556498_Class1get_count1;
  thisClassModel->set_count1 = c_3556498_Class1set_count1;
  thisClassModel->get_count2 = c_3556498_Class1get_count2;
  thisClassModel->set_count2 = c_3556498_Class1set_count2;
  thisClassModel->free = c_3556498_Class1_free;
}
