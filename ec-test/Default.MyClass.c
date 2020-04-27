// Default.MyClass
#include "Default.MyClass.h"
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
#include "Default.MyOtherClass.h"
#include "Default.MySecondClass.h"

void c_1085510111_MyClassmyPrint(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  printf(
      "value=%ld, name=%s\n",
      /*te14a*/ ((c_1085510111_MyClass_cm *)useObject(/*te8*/ this)->classmodel)->get_value(/*te8*/ this),
      /* switch from fc5 to te4*/
      ((c_2106303_String_cm *)useObject(
           /*te14a*/ ((c_1085510111_MyClass_cm *)useObject(/*te8*/ this)->classmodel)->get_name(/*te8*/ this))
           ->classmodel)
          ->asStr(/*te14a*/ ((c_1085510111_MyClass_cm *)useObject(/*te8*/ this)->classmodel)->get_name(/*te8*/ this)));

  __onExit();
}

void c_1085510111_MyClassrelease(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  printf("release %s %ld\n", /*fc4*/ ((c_1085510111_MyClass_cm *)getc_1085510111_MyClass_cm())->getClassName(),
         /*te14a*/ ((c_1085510111_MyClass_cm *)useObject(/*te8*/ this)->classmodel)->get_value(/*te8*/ this));

  __onExit();
}

pointer c_1085510111_MyClassgetClassName() { return "Default.MyClass"; }

pointer c_1085510111_MyClassgetClassShortName() { return "MyClass"; }

pointer c_1085510111_MyClassgetClassCName() { return "c_1085510111_MyClass"; }

pointer c_1085510111_MyClassgetClassPackage() { return "Default"; }

u64 c_1085510111_MyClassgetObjectDatasize() { return sizeof(c_1085510111_MyClass); }

num c_1085510111_MyClassget_name(num this) { return ((c_1085510111_MyClass *)useObject(this)->data)->name; }

void c_1085510111_MyClassset_name(num this, num name) {
  assignObject(&((c_1085510111_MyClass *)useObject(this)->data)->name, name);
}

i64 c_1085510111_MyClassget_value(num this) { return ((c_1085510111_MyClass *)useObject(this)->data)->value; }

void c_1085510111_MyClassset_value(num this, i64 value) {
  ((c_1085510111_MyClass *)useObject(this)->data)->value = value;
}

i64 c_1085510111_MyClassget_value2(num this) { return ((c_1085510111_MyClass *)useObject(this)->data)->value2; }

void c_1085510111_MyClassset_value2(num this, i64 value2) {
  ((c_1085510111_MyClass *)useObject(this)->data)->value2 = value2;
}

void c_1085510111_MyClass_free(num this) {
  Object_ref *object_ref = useObject(this);
  returnObject(((c_1085510111_MyClass *)object_ref->data)->name);
}

num create_c_1085510111_MyClass() {
  c_1085510111_MyClass *_c_1085510111_MyClass = ec_calloc(sizeof(c_1085510111_MyClass), sizeof(char));
  /*cdv1*/ ((c_1085510111_MyClass *)_c_1085510111_MyClass)->value = 15L;
  /*cdv1*/ ((c_1085510111_MyClass *)_c_1085510111_MyClass)->value2 = 15L;
  return createObject(_c_1085510111_MyClass, getc_1085510111_MyClass_cm(), false);
}

c_1085510111_MyClass_cm _c_1085510111_MyClass_cm;
boolean _c_1085510111_MyClass_init = false;
pointer getc_1085510111_MyClass_cm() {
  if (!_c_1085510111_MyClass_init) {
    registerClassModel(&_c_1085510111_MyClass_cm);
    populatec_1085510111_MyClass_cm(&_c_1085510111_MyClass_cm);
    _c_1085510111_MyClass_init = true;
  }
  return &_c_1085510111_MyClass_cm;
}

/* default constructor */
num create_c_1085510111_MyClass$1(/* param */ /*va1*/ i64 value) {
  num this = create_c_1085510111_MyClass();

  ((c_1085510111_MyClass_cm *)useObject(this)->classmodel)->set_value(this, value);
  {

    __onEnter(); /*st*/ /*fc2 null */
    printf("create %s %ld\n", /*fc4*/ ((c_1085510111_MyClass_cm *)getc_1085510111_MyClass_cm())->getClassName(),
           /*te8*/ value);

    __onExit();
  }

  return this;
}
void populatec_1085510111_MyClass_cm(pointer classModel) {
  populatec_2106303_Object_cm(classModel);
  c_1085510111_MyClass_cm *thisClassModel = (c_1085510111_MyClass_cm *)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->myPrint = c_1085510111_MyClassmyPrint;
  thisClassModel->release = c_1085510111_MyClassrelease;
  thisClassModel->getClassName = c_1085510111_MyClassgetClassName;
  thisClassModel->getClassShortName = c_1085510111_MyClassgetClassShortName;
  thisClassModel->getClassCName = c_1085510111_MyClassgetClassCName;
  thisClassModel->getClassPackage = c_1085510111_MyClassgetClassPackage;
  thisClassModel->getObjectDatasize = c_1085510111_MyClassgetObjectDatasize;
  thisClassModel->get_name = c_1085510111_MyClassget_name;
  thisClassModel->set_name = c_1085510111_MyClassset_name;
  thisClassModel->get_value = c_1085510111_MyClassget_value;
  thisClassModel->set_value = c_1085510111_MyClassset_value;
  thisClassModel->get_value2 = c_1085510111_MyClassget_value2;
  thisClassModel->set_value2 = c_1085510111_MyClassset_value2;
  thisClassModel->free = c_1085510111_MyClass_free;
}
