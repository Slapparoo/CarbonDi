// Core.RefArrayList
#include "Core.Core_main.h"
#include "Core.RefArrayList.h"
#include "Core.Object.h"
#include "Core.HashCode.h"
#include "Core.Array.h"
#include "Core.RefArray.h"
#include "Core.String.h"
#include "Core.Exception.h"
#include "Core.Boxing.h"
#include "Core.BaseBoxing.h"
#include "Core.B8.h"
#include "Core.U8.h"
#include "Core.I8.h"
#include "Core.I16.h"
#include "Core.U16.h"
#include "Core.I32.h"
#include "Core.U32.h"
#include "Core.F32.h"
#include "Core.I64.h"
#include "Core.U64.h"
#include "Core.F64.h"
#include "Core.Pointer.h"
#include "Core.FileUtils.h"
#include "Core.Charactor.h"
#include "Core.DynamicArray.h"
#include "Core.Duo.h"
#include "Core.Hashset.h"
#include "Core.MapDuo.h"
#include "Core.MapEntry.h"
#include "Core.Hashmap.h"

/*fd1*/void c_2106303_RefArrayListstartup(num this){

u64 entry__ = __onEnter();if (/*te14a*/((c_2106303_RefArrayList_cm*)useObject(/*te8*/this)->classmodel)->get_isInit(/*te8*/this)) {

__onEnter();return __exitReturn_void_un(entry__);
}

/*Ax5*//*te14b*/((c_2106303_RefArrayList_cm*)useObject(/*te8*/this)->classmodel)->set_isInit(/*te8*/this, true);
/*Ax3*//*te14b*/((c_2106303_RefArrayList_cm*)useObject(/*te8*/this)->classmodel)->set_list(/*te8*/this, /*cd1*/ create_c_2106303_RefArray_1(/*te14*/((c_2106303_RefArrayList_cm*)getc_2106303_RefArrayList_cm())->get_growBy()));

__onExit();}


/*fd1*/void c_2106303_RefArrayListgrowList(num this){

u64 entry__ = __onEnter();/*va1*/num tempList = /*te14a*/((c_2106303_RefArrayList_cm*)useObject(/*te8*/this)->classmodel)->get_list(/*te8*/this);
/*va1*/num newList = /*cd1*/ create_c_2106303_RefArray_1(/*oxa*//*te14a*/((c_2106303_RefArray_cm*)useObject(/*te8*/tempList)->classmodel)->get_length(/*te8*/tempList) + /*oxb*//*te14*/((c_2106303_RefArrayList_cm*)getc_2106303_RefArrayList_cm())->get_growBy());

for (num a__a = 0; a__a < /*te14a*/((c_2106303_RefArray_cm*)useObject(/*te8*/tempList)->classmodel)->get_length(/*te8*/tempList); a__a++){

__onEnter();/*va1*/i64 ix = /*te8*/a__a;
/*Ax3*/((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->setObject(newList, /*te8*/ix,/*te4*/ *((num *)((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->get(tempList, /*te8*/ix)));

__onExit();}

/*Ax3*//*te14b*/((c_2106303_RefArrayList_cm*)useObject(/*te8*/this)->classmodel)->set_list(/*te8*/this, /*te8*/newList);

__onExit();}


/*fd1*/void c_2106303_RefArrayListadd(num this, num object){

u64 entry__ = __onEnter();/*st*/ /* switch from fc5 to te4*/((c_2106303_RefArrayList_cm*)useObject(this)->classmodel)->startup(this);
/*va1*/num tempList = /*te14a*/((c_2106303_RefArrayList_cm*)useObject(/*te8*/this)->classmodel)->get_list(/*te8*/this);
if (/*oxa*//*te14a*/((c_2106303_RefArray_cm*)useObject(/*te8*/tempList)->classmodel)->get_length(/*te8*/tempList) == /*oxb*//*te14a*/((c_2106303_RefArrayList_cm*)useObject(/*te8*/this)->classmodel)->get_ralsize(/*te8*/this)) {

__onEnter();/*st*/ /*fc3*/((c_2106303_RefArrayList_cm*)useObject(this)->classmodel)->growList(this);

__onExit();}

/*va1*/num tempList2 = /*te14a*/((c_2106303_RefArrayList_cm*)useObject(/*te8*/this)->classmodel)->get_list(/*te8*/this);
/*Ax3*/((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->setObject(tempList2, /*te14a*/((c_2106303_RefArrayList_cm*)useObject(/*te8*/this)->classmodel)->get_ralsize(/*te8*/this),/*te8*/object);
/*st*/ /*te15a*/((c_2106303_RefArrayList*)useObject(/*te8*/this)->data)->ralsize++;

__onExit();}


/*fd1*/num c_2106303_RefArrayListget(num this, u64 index){

u64 entry__ = __onEnter();/*va1*/num tempList = /*te14a*/((c_2106303_RefArrayList_cm*)useObject(/*te8*/this)->classmodel)->get_list(/*te8*/this);
/*va1*/num o = /*te4*/ *((num *)((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->get(tempList, /*te8*/index));
/*rx2*/ return __exitReturn_ref_un(/*te8*/o, entry__);
}


/*fd1*/pointer c_2106303_RefArrayListclassName(){
  return  "Core.RefArrayList";
}


/*fd1*/pointer c_2106303_RefArrayListclassShortName(){
  return  "RefArrayList";
}


/*fd1*/pointer c_2106303_RefArrayListclassCName(){
  return  "c_2106303_RefArrayList";
}


/*fd1*/pointer c_2106303_RefArrayListclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_RefArrayListobjectDatasize(){
  return  sizeof(c_2106303_RefArrayList);
}











/*fd1*/num c_2106303_RefArrayListget_list(num this){
  return  ((c_2106303_RefArrayList*)useObject(this)->data)->list;
}


/*fd1*/void c_2106303_RefArrayListset_list(num this, num a__a){
/*cda2*/ assignObject(&((c_2106303_RefArrayList*)useObject(this)->data)/*cda3*/->list, a__a);
}


/*fd1*/u64 c_2106303_RefArrayListget_ralsize(num this){
  return  ((c_2106303_RefArrayList*)useObject(this)->data)->ralsize;
}


/*fd1*/void c_2106303_RefArrayListset_ralsize(num this, u64 a__a){
/*cda1*/((c_2106303_RefArrayList*)useObject(this)->data)->ralsize = a__a;
}


/*fd1*/boolean c_2106303_RefArrayListget_isInit(num this){
  return  ((c_2106303_RefArrayList*)useObject(this)->data)->isInit;
}


/*fd1*/void c_2106303_RefArrayListset_isInit(num this, boolean a__a){
/*cda1*/((c_2106303_RefArrayList*)useObject(this)->data)->isInit = a__a;
}


/*fd1*/u64 c_2106303_RefArrayListget_growBy(){
  return  ((c_2106303_RefArrayList_cm*)getc_2106303_RefArrayList_cm())->growBy;
}


/*fd1*/void c_2106303_RefArrayListset_growBy(u64 a__a){
/*cda1*/((c_2106303_RefArrayList_cm*)getc_2106303_RefArrayList_cm())->growBy = a__a;
}


void c_2106303_RefArrayList_free(num this) { Object_ref *object_ref = useObject(this);
  returnObject(((c_2106303_RefArrayList*)object_ref->data)->list);
}



num create_c_2106303_RefArrayList() {
  c_2106303_RefArrayList * _c_2106303_RefArrayList = ec_calloc(sizeof(c_2106303_RefArrayList), sizeof(char));
/*cdv1*/((c_2106303_RefArrayList*)_c_2106303_RefArrayList)->isInit = false;
/*cdv1*/((c_2106303_RefArrayList*)_c_2106303_RefArrayList)->instanceName = c_2106303_RefArrayListclassName();
  return createObject(_c_2106303_RefArrayList, getc_2106303_RefArrayList_cm(), false);
}

c_2106303_RefArrayList_cm _c_2106303_RefArrayList_cm;
boolean _c_2106303_RefArrayList_init = false;
pointer getc_2106303_RefArrayList_cm() {
  if (!_c_2106303_RefArrayList_init) {
    registerClassModel(&_c_2106303_RefArrayList_cm);
    populatec_2106303_RefArrayList_cm(&_c_2106303_RefArrayList_cm);
    _c_2106303_RefArrayList_init = true;
  }
  return &_c_2106303_RefArrayList_cm;
}


/* default constructor */
void populatec_2106303_RefArrayList_cm(pointer classModel) {
 populatec_2106303_Object_cm(classModel);
  c_2106303_RefArrayList_cm* thisClassModel = (c_2106303_RefArrayList_cm*)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->startup = c_2106303_RefArrayListstartup;
  thisClassModel->growList = c_2106303_RefArrayListgrowList;
  thisClassModel->add = c_2106303_RefArrayListadd;
  thisClassModel->get = c_2106303_RefArrayListget;
  thisClassModel->className = c_2106303_RefArrayListclassName;
  thisClassModel->classShortName = c_2106303_RefArrayListclassShortName;
  thisClassModel->classCName = c_2106303_RefArrayListclassCName;
  thisClassModel->classPackage = c_2106303_RefArrayListclassPackage;
  thisClassModel->objectDatasize = c_2106303_RefArrayListobjectDatasize;
  thisClassModel->get_list = c_2106303_RefArrayListget_list;
  thisClassModel->set_list = c_2106303_RefArrayListset_list;
  thisClassModel->get_ralsize = c_2106303_RefArrayListget_ralsize;
  thisClassModel->set_ralsize = c_2106303_RefArrayListset_ralsize;
  thisClassModel->get_isInit = c_2106303_RefArrayListget_isInit;
  thisClassModel->set_isInit = c_2106303_RefArrayListset_isInit;
  thisClassModel->get_growBy = c_2106303_RefArrayListget_growBy;
  thisClassModel->set_growBy = c_2106303_RefArrayListset_growBy;
/*cds1*/thisClassModel->growBy = 256;
  thisClassModel->free = c_2106303_RefArrayList_free;
}

