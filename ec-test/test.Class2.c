// test.Class2
#include "test.Class2.h"
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
#include "test.Class1.h"

i64 c_3556498_Class2length(num this) {

  u64 entry$ = __onEnter();
  return __exitReturn_i64_un(7L, entry$);
}

void c_3556498_Class2myPrint(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  printf("(%s::%s) package=%s, count1=%ld, length=%ld, datasize=%ld\n",
         /*te141*/ ((c_3556498_Class2_cm *)getc_3556498_Class2_cm())->getClassPackage(),
         /*te141*/ ((c_3556498_Class2_cm *)getc_3556498_Class2_cm())->getClassName(),
         /*te14a1*/
         ((c_2106303_String_cm *)useObject(
              /*te14a*/ ((c_3556498_Class2_cm *)useObject(/*te8*/ this)->classmodel)->get_package(/*te8*/ this))
              ->classmodel)
             ->asStr(/*te14a*/ ((c_3556498_Class2_cm *)useObject(/*te8*/ this)->classmodel)->get_package(/*te8*/ this)),
         /*te14a*/ ((c_3556498_Class2_cm *)useObject(/*te8*/ this)->classmodel)->get_count1(/*te8*/ this),
         /*te14a1*/ ((c_3556498_Class2_cm *)useObject(/*te8*/ this)->classmodel)->length(/*te8*/ this),
         /*te141*/ ((c_3556498_Class2_cm *)getc_3556498_Class2_cm())->getObjectDatasize());

  __onExit();
}

i64 c_3556498_Class2addto(num this, i64 amount) {

  u64 entry$ = __onEnter();
  return __exitReturn_i64_un(
      /*oxa*/ /*te8*/ amount +
          /*oxb*/ /*te14a*/ ((c_3556498_Class2_cm *)useObject(/*te8*/ this)->classmodel)->get_count1(/*te8*/ this),
      entry$);
}

pointer c_3556498_Class2getClassName() { return "test.Class2"; }

pointer c_3556498_Class2getClassShortName() { return "Class2"; }

pointer c_3556498_Class2getClassCName() { return "c_3556498_Class2"; }

pointer c_3556498_Class2getClassPackage() { return "test"; }

u64 c_3556498_Class2getObjectDatasize() { return sizeof(c_3556498_Class2); }

num c_3556498_Class2get_package(num this) { return ((c_3556498_Class2 *)useObject(this)->data)->package; }

void c_3556498_Class2set_package(num this, num package) {
  assignObject(&((c_3556498_Class2 *)useObject(this)->data)->package, package);
}

void c_3556498_Class2_free(num this) {
  Object_ref *object_ref = useObject(this);
  returnObject(((c_3556498_Class2 *)object_ref->data)->package);
}

num create_c_3556498_Class2() {
  c_3556498_Class2 *_c_3556498_Class2 = ec_calloc(sizeof(c_3556498_Class2), sizeof(char));
  return createObject(_c_3556498_Class2, getc_3556498_Class2_cm(), false);
}

c_3556498_Class2_cm _c_3556498_Class2_cm;
boolean _c_3556498_Class2_init = false;
pointer getc_3556498_Class2_cm() {
  if (!_c_3556498_Class2_init) {
    registerClassModel(&_c_3556498_Class2_cm);
    populatec_3556498_Class2_cm(&_c_3556498_Class2_cm);
    _c_3556498_Class2_init = true;
  }
  return &_c_3556498_Class2_cm;
}

/* default constructor */
num create_c_3556498_Class2$1(/* param */ /*va1*/ i64 count1) {
  num this = create_c_3556498_Class2();

  ((c_3556498_Class2_cm *)useObject(this)->classmodel)->set_count1(this, count1);

  return this;
}
num create_c_3556498_Class2$2(/* param */ /*va1*/ i64 count1, /*va1*/ num package) {
  num this = create_c_3556498_Class2();

  ((c_3556498_Class2_cm *)useObject(this)->classmodel)->set_count1(this, count1);
  ((c_3556498_Class2_cm *)useObject(this)->classmodel)->set_package(this, package);

  return this;
}
void populatec_3556498_Class2_cm(pointer classModel) {
  populatec_3556498_Class1_cm(classModel);
  c_3556498_Class2_cm *thisClassModel = (c_3556498_Class2_cm *)classModel;
  thisClassModel->parent = getc_3556498_Class1_cm();
  thisClassModel->length = c_3556498_Class2length;
  thisClassModel->myPrint = c_3556498_Class2myPrint;
  thisClassModel->addto = c_3556498_Class2addto;
  thisClassModel->getClassName = c_3556498_Class2getClassName;
  thisClassModel->getClassShortName = c_3556498_Class2getClassShortName;
  thisClassModel->getClassCName = c_3556498_Class2getClassCName;
  thisClassModel->getClassPackage = c_3556498_Class2getClassPackage;
  thisClassModel->getObjectDatasize = c_3556498_Class2getObjectDatasize;
  thisClassModel->get_package = c_3556498_Class2get_package;
  thisClassModel->set_package = c_3556498_Class2set_package;
  thisClassModel->free = c_3556498_Class2_free;
}
