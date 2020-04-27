// Default.MyString
#include "Default.MyString.h"
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

pointer c_1085510111_MyStringasStr(num this) {

  u64 entry$ = __onEnter();
  return __exitReturn_pointer_un(
      /*te14a*/ ((c_1085510111_MyString_cm *)useObject(/*te8*/ this)->classmodel)->get_value(/*te8*/ this), entry$);
}

num c_1085510111_MyStringasString(num this) {

  u64 entry$ = __onEnter();
  return __exitReturn_ref_un(/*te8*/ this, entry$);
}

pointer c_1085510111_MyStringgetClassName() { return "Default.MyString"; }

pointer c_1085510111_MyStringgetClassShortName() { return "MyString"; }

pointer c_1085510111_MyStringgetClassCName() { return "c_1085510111_MyString"; }

pointer c_1085510111_MyStringgetClassPackage() { return "Default"; }

u64 c_1085510111_MyStringgetObjectDatasize() { return sizeof(c_1085510111_MyString); }

pointer c_1085510111_MyStringget_value(num this) { return ((c_1085510111_MyString *)useObject(this)->data)->value; }

void c_1085510111_MyStringset_value(num this, pointer value) {
  ((c_1085510111_MyString *)useObject(this)->data)->value = value;
}

void c_1085510111_MyString_free(num this) { Object_ref *object_ref = useObject(this); }

num create_c_1085510111_MyString() {
  c_1085510111_MyString *_c_1085510111_MyString = ec_calloc(sizeof(c_1085510111_MyString), sizeof(char));
  return createObject(_c_1085510111_MyString, getc_1085510111_MyString_cm(), false);
}

c_1085510111_MyString_cm _c_1085510111_MyString_cm;
boolean _c_1085510111_MyString_init = false;
pointer getc_1085510111_MyString_cm() {
  if (!_c_1085510111_MyString_init) {
    registerClassModel(&_c_1085510111_MyString_cm);
    populatec_1085510111_MyString_cm(&_c_1085510111_MyString_cm);
    _c_1085510111_MyString_init = true;
  }
  return &_c_1085510111_MyString_cm;
}

num create_c_1085510111_MyString$1(/* param */ /*va1*/ pointer str1) {
  num this = create_c_1085510111_MyString();

  {

    __onEnter(); /*va1*/
    num len = /*oxa*/ /*fc2 null */ strlen(/*te8*/ str1) + /*oxb*/ 1;
    /*Ax2*/ /*te14b*/ ((c_1085510111_MyString_cm *)useObject(/*te8*/ this)->classmodel)
        ->set_value(/*te8*/ this,
                    /*fc3*/ ((c_1085510111_MyString_cm *)useObject(this)->classmodel)->alloc(this, /*te8*/ len));
    /*st*/ /*fc2 null */ strcpy(
        /*te14a*/ ((c_1085510111_MyString_cm *)useObject(/*te8*/ this)->classmodel)->get_value(/*te8*/ this),
        /*te8*/ str1);

    __onExit();
  }

  return this;
}
num create_c_1085510111_MyString$2(/* param */ /*va1*/ pointer str2, /*va1*/ pointer str3) {
  num this = create_c_1085510111_MyString();

  {

    __onEnter(); /*va1*/
    num len2 =
        /*oxa*/ /*oxa*/ /*fc2 null */ strlen(/*te8*/ str2) + /*oxb*/ /*fc2 null */ strlen(/*te8*/ str3) + /*oxb*/ 1;
    /*Ax5*/ /*te14b*/ ((c_1085510111_MyString_cm *)useObject(/*te8*/ this)->classmodel)
        ->set_value(/*te8*/ this,
                    /*fc3*/ ((c_1085510111_MyString_cm *)useObject(this)->classmodel)->alloc(this, /*te8*/ len2));
    /*st*/ /*fc2 null */ strcpy(
        /*te14a*/ ((c_1085510111_MyString_cm *)useObject(/*te8*/ this)->classmodel)->get_value(/*te8*/ this),
        /*te8*/ str2);
    /*st*/ /*fc2 null */ strcat(
        /*te14a*/ ((c_1085510111_MyString_cm *)useObject(/*te8*/ this)->classmodel)->get_value(/*te8*/ this),
        /*te8*/ str3);

    __onExit();
  }

  return this;
}
void populatec_1085510111_MyString_cm(pointer classModel) {
  populatec_2106303_Object_cm(classModel);
  c_1085510111_MyString_cm *thisClassModel = (c_1085510111_MyString_cm *)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->asStr = c_1085510111_MyStringasStr;
  thisClassModel->asString = c_1085510111_MyStringasString;
  thisClassModel->getClassName = c_1085510111_MyStringgetClassName;
  thisClassModel->getClassShortName = c_1085510111_MyStringgetClassShortName;
  thisClassModel->getClassCName = c_1085510111_MyStringgetClassCName;
  thisClassModel->getClassPackage = c_1085510111_MyStringgetClassPackage;
  thisClassModel->getObjectDatasize = c_1085510111_MyStringgetObjectDatasize;
  thisClassModel->get_value = c_1085510111_MyStringget_value;
  thisClassModel->set_value = c_1085510111_MyStringset_value;
  thisClassModel->free = c_1085510111_MyString_free;
}
