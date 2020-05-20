// Default.MySecondClass
#include "Default.MySecondClass.h"
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
#include "Default.MyOtherClass.h"

void c_1085510111_MySecondClassrelease(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  printf("release (override) %s %ld\n",
         /*fc4*/ ((c_1085510111_MySecondClass_cm *)getc_1085510111_MySecondClass_cm())->getClassName(),
         /*te14a*/ ((c_1085510111_MySecondClass_cm *)useObject(/*te8*/ this)->classmodel)->get_value(/*te8*/ this));

  __onExit();
}

pointer c_1085510111_MySecondClassgetClassName() { return "Default.MySecondClass"; }

pointer c_1085510111_MySecondClassgetClassShortName() { return "MySecondClass"; }

pointer c_1085510111_MySecondClassgetClassCName() { return "c_1085510111_MySecondClass"; }

pointer c_1085510111_MySecondClassgetClassPackage() { return "Default"; }

u64 c_1085510111_MySecondClassgetObjectDatasize() { return sizeof(c_1085510111_MySecondClass); }

void c_1085510111_MySecondClass_free(num this) {
  Object_ref *object_ref = useObject(this);
  returnObject(((c_1085510111_MySecondClass *)object_ref->data)->name);
}

num create_c_1085510111_MySecondClass() {
  c_1085510111_MySecondClass *_c_1085510111_MySecondClass = ec_calloc(sizeof(c_1085510111_MySecondClass), sizeof(char));
  return createObject(_c_1085510111_MySecondClass, getc_1085510111_MySecondClass_cm(), false);
}

c_1085510111_MySecondClass_cm _c_1085510111_MySecondClass_cm;
boolean _c_1085510111_MySecondClass_init = false;
pointer getc_1085510111_MySecondClass_cm() {
  if (!_c_1085510111_MySecondClass_init) {
    registerClassModel(&_c_1085510111_MySecondClass_cm);
    populatec_1085510111_MySecondClass_cm(&_c_1085510111_MySecondClass_cm);
    _c_1085510111_MySecondClass_init = true;
  }
  return &_c_1085510111_MySecondClass_cm;
}

/* default constructor */
num create_c_1085510111_MySecondClass$1(/* param */ /*va1*/ i64 value) {
  num this = create_c_1085510111_MySecondClass();

  ((c_1085510111_MySecondClass_cm *)useObject(this)->classmodel)->set_value(this, value);
  {

    __onEnter(); /*st*/ /*fc2 null */
    printf("create %s %ld\n", /*fc4*/ ((c_1085510111_MyClass_cm *)getc_1085510111_MyClass_cm())->getClassName(),
           /*te8*/ value);

    __onExit();
  }

  return this;
}
num create_c_1085510111_MySecondClass$2(/* param */ /*va1*/ i64 value, /*va1*/ num name) {
  num this = create_c_1085510111_MySecondClass();

  ((c_1085510111_MySecondClass_cm *)useObject(this)->classmodel)->set_value(this, value);
  ((c_1085510111_MySecondClass_cm *)useObject(this)->classmodel)->set_name(this, name);
  {

    __onEnter(); /*st*/ /*fc2 null */
    printf("create %s\n",
           /*fc4*/ ((c_1085510111_MySecondClass_cm *)getc_1085510111_MySecondClass_cm())->getClassName());

    __onExit();
  }

  return this;
}
void populatec_1085510111_MySecondClass_cm(pointer classModel) {
  populatec_1085510111_MyClass_cm(classModel);
  c_1085510111_MySecondClass_cm *thisClassModel = (c_1085510111_MySecondClass_cm *)classModel;
  thisClassModel->parent = getc_1085510111_MyClass_cm();
  thisClassModel->release = c_1085510111_MySecondClassrelease;
  thisClassModel->getClassName = c_1085510111_MySecondClassgetClassName;
  thisClassModel->getClassShortName = c_1085510111_MySecondClassgetClassShortName;
  thisClassModel->getClassCName = c_1085510111_MySecondClassgetClassCName;
  thisClassModel->getClassPackage = c_1085510111_MySecondClassgetClassPackage;
  thisClassModel->getObjectDatasize = c_1085510111_MySecondClassgetObjectDatasize;
  thisClassModel->free = c_1085510111_MySecondClass_free;
}
