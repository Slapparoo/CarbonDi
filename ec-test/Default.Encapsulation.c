// Default.Encapsulation
#include "Default.Encapsulation.h"
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

i64 c_1085510111_Encapsulationcount3(num this) {

  u64 entry$ = __onEnter();
  return __exitReturn_i64_un(
      /*oxa*/ /*te14a*/ ((c_1085510111_Encapsulation_cm *)useObject(/*te8*/ this)->classmodel)
              ->get_count2(/*te8*/ this) +
          /*oxb*/ /*te14a*/ ((c_1085510111_Encapsulation_cm *)useObject(/*te8*/ this)->classmodel)
              ->get_count2(/*te8*/ this),
      entry$);
}

void c_1085510111_EncapsulationprintMe(num this) {

  u64 entry$ = __onEnter(); /*st*/ /*fc2 null */
  printf("count1=%li, count2=%li, count3=%li",
         /*te14a*/ ((c_1085510111_Encapsulation_cm *)useObject(/*te8*/ this)->classmodel)->get_count1(/*te8*/ this),
         /*te14a*/ ((c_1085510111_Encapsulation_cm *)useObject(/*te8*/ this)->classmodel)->get_count2(/*te8*/ this),
         /*te14a1*/ ((c_1085510111_Encapsulation_cm *)useObject(/*te8*/ this)->classmodel)->count3(/*te8*/ this));

  __onExit();
}

pointer c_1085510111_EncapsulationgetClassName() { return "Default.Encapsulation"; }

pointer c_1085510111_EncapsulationgetClassShortName() { return "Encapsulation"; }

pointer c_1085510111_EncapsulationgetClassCName() { return "c_1085510111_Encapsulation"; }

pointer c_1085510111_EncapsulationgetClassPackage() { return "Default"; }

u64 c_1085510111_EncapsulationgetObjectDatasize() { return sizeof(c_1085510111_Encapsulation); }

i64 c_1085510111_Encapsulationget_count1(num this) {
  return ((c_1085510111_Encapsulation *)useObject(this)->data)->count1;
}

void c_1085510111_Encapsulationset_count1(num this, i64 a__$a) {
  /*cda1*/ ((c_1085510111_Encapsulation *)useObject(this)->data)->count1 = a__$a;
}

i64 c_1085510111_Encapsulationget_count2(num this) {

  u64 entry$ = __onEnter();
  return __exitReturn_i64_un(
      /*oxa*/ /*te15a*/ ((c_1085510111_Encapsulation *)useObject(/*te8*/ this)->data)->count2 + /*oxb*/ 5, entry$);
}

void c_1085510111_Encapsulationset_count2(num this, i64 a__$a) {

  u64 entry$ = __onEnter(); /*Ax4*/ /*te15b*/
  ((c_1085510111_Encapsulation *)useObject(/*te8*/ this)->data)->count2 /*te8*/ =
      /*oxa*/ /*te8*/ a__$a + /*oxb*/ /*te14a*/ ((c_1085510111_Encapsulation_cm *)useObject(/*te8*/ this)->classmodel)
                                  ->get_count1(/*te8*/ this);

  __onExit();
}

void c_1085510111_Encapsulation_free(num this) { Object_ref *object_ref = useObject(this); }

num create_c_1085510111_Encapsulation() {
  c_1085510111_Encapsulation *_c_1085510111_Encapsulation = ec_calloc(sizeof(c_1085510111_Encapsulation), sizeof(char));
  return createObject(_c_1085510111_Encapsulation, getc_1085510111_Encapsulation_cm(), false);
}

c_1085510111_Encapsulation_cm _c_1085510111_Encapsulation_cm;
boolean _c_1085510111_Encapsulation_init = false;
pointer getc_1085510111_Encapsulation_cm() {
  if (!_c_1085510111_Encapsulation_init) {
    registerClassModel(&_c_1085510111_Encapsulation_cm);
    populatec_1085510111_Encapsulation_cm(&_c_1085510111_Encapsulation_cm);
    _c_1085510111_Encapsulation_init = true;
  }
  return &_c_1085510111_Encapsulation_cm;
}

/* default constructor */
num create_c_1085510111_Encapsulation$1(/* param */ /*va1*/ i64 count1, /*va1*/ i64 count2) {
  num this = create_c_1085510111_Encapsulation();

  ((c_1085510111_Encapsulation_cm *)useObject(this)->classmodel)->set_count1(this, count1);
  ((c_1085510111_Encapsulation_cm *)useObject(this)->classmodel)->set_count2(this, count2);

  return this;
}
void populatec_1085510111_Encapsulation_cm(pointer classModel) {
  populatec_2106303_Object_cm(classModel);
  c_1085510111_Encapsulation_cm *thisClassModel = (c_1085510111_Encapsulation_cm *)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->count3 = c_1085510111_Encapsulationcount3;
  thisClassModel->printMe = c_1085510111_EncapsulationprintMe;
  thisClassModel->getClassName = c_1085510111_EncapsulationgetClassName;
  thisClassModel->getClassShortName = c_1085510111_EncapsulationgetClassShortName;
  thisClassModel->getClassCName = c_1085510111_EncapsulationgetClassCName;
  thisClassModel->getClassPackage = c_1085510111_EncapsulationgetClassPackage;
  thisClassModel->getObjectDatasize = c_1085510111_EncapsulationgetObjectDatasize;
  thisClassModel->get_count1 = c_1085510111_Encapsulationget_count1;
  thisClassModel->set_count1 = c_1085510111_Encapsulationset_count1;
  thisClassModel->get_count2 = c_1085510111_Encapsulationget_count2;
  thisClassModel->set_count2 = c_1085510111_Encapsulationset_count2;
  thisClassModel->free = c_1085510111_Encapsulation_free;
}
