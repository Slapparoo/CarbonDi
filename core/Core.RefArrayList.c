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

u64 entry__ = __onEnter();if (/*te14a*/((c_2106303_RefArrayList_cm*)useObject(this)->classmodel)->get_isInit(this)) {
return __exitReturn_void_un(entry__);
}

/*Ax5*//*te14b*/((c_2106303_RefArrayList_cm*)useObject(this)->classmodel)->set_isInit(this, true);
/*Ax3*//*te14b*/((c_2106303_RefArrayList_cm*)useObject(this)->classmodel)->set_list(this, /*cd1*/ create_c_2106303_RefArray_1(/*te14*/((c_2106303_RefArrayList_cm*)getc_2106303_RefArrayList_cm())->get_growBy()));

return __exitReturn_void_un(entry__);}


/*fd1*/void c_2106303_RefArrayListgrowList(num this){

u64 entry__ = __onEnter();/*va1*/num tempList = /*te14a*/((c_2106303_RefArrayList_cm*)useObject(this)->classmodel)->get_list(this);
/*va1*/num newList = /*cd1*/ create_c_2106303_RefArray_1(/*oxa*//*te14a*/((c_2106303_RefArray_cm*)useObject(tempList)->classmodel)->get_length(tempList) + /*oxb*//*te14*/((c_2106303_RefArrayList_cm*)getc_2106303_RefArrayList_cm())->get_growBy());

for (num a__a = 0; a__a < /*te14a*/((c_2106303_RefArray_cm*)useObject(tempList)->classmodel)->get_length(tempList); a__a++){
/*va1*/i64 ix = a__a;
/*Ax3*/((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->setObject(newList, ix,/*te4*/ *((num *)((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->get(tempList, ix)));
}

/*Ax3*//*te14b*/((c_2106303_RefArrayList_cm*)useObject(this)->classmodel)->set_list(this, newList);

return __exitReturn_void_un(entry__);}


/*fd1*/void c_2106303_RefArrayListadd(num this, num object){

u64 entry__ = __onEnter();/*st*/ /* switch from fc5 to te4*/((c_2106303_RefArrayList_cm*)useObject(this)->classmodel)->startup(this);
/*va1*/num tempList = /*te14a*/((c_2106303_RefArrayList_cm*)useObject(this)->classmodel)->get_list(this);
if (/*oxa*//*te14a*/((c_2106303_RefArray_cm*)useObject(tempList)->classmodel)->get_length(tempList) == /*oxb*//*te14a*/((c_2106303_RefArrayList_cm*)useObject(this)->classmodel)->get_ralsize(this)) {
/*st*/ /*fc3*/((c_2106303_RefArrayList_cm*)useObject(this)->classmodel)->growList(this);
}

/*va1*/num tempList2 = /*te14a*/((c_2106303_RefArrayList_cm*)useObject(this)->classmodel)->get_list(this);
/*Ax3*/((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->setObject(tempList2, /*te14a*/((c_2106303_RefArrayList_cm*)useObject(this)->classmodel)->get_ralsize(this),object);
/*st*/ /*te15a*/((c_2106303_RefArrayList*)useObject(this)->data)->ralsize++;

return __exitReturn_void_un(entry__);}


/*fd1*/num c_2106303_RefArrayListget(num this, u64 index){

u64 entry__ = __onEnter();/*va1*/num tempList = /*te14a*/((c_2106303_RefArrayList_cm*)useObject(this)->classmodel)->get_list(this);
/*va1*/num o = /*te4*/ *((num *)((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->get(tempList, index));
/*rx4*/ return __exitReturn_ref_un(o, entry__);
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
  num this = createObject(_c_2106303_RefArrayList, getc_2106303_RefArrayList_cm(), false);
/*cdv1*/((c_2106303_RefArrayList*)_c_2106303_RefArrayList)->isInit = false;
/*cdv2 Core.ObjectCore.RefArrayList */((c_2106303_RefArrayList*)_c_2106303_RefArrayList)->instanceName = c_2106303_RefArrayListclassName();
  return this;
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
 /*cds2*/ thisClassModel->startup = c_2106303_RefArrayListstartup;
 /*cds2*/ thisClassModel->growList = c_2106303_RefArrayListgrowList;
 /*cds2*/ thisClassModel->add = c_2106303_RefArrayListadd;
 /*cds2*/ thisClassModel->get = c_2106303_RefArrayListget;
 /*cds2*/ thisClassModel->className = c_2106303_RefArrayListclassName;
 /*cds2*/ thisClassModel->classShortName = c_2106303_RefArrayListclassShortName;
 /*cds2*/ thisClassModel->classCName = c_2106303_RefArrayListclassCName;
 /*cds2*/ thisClassModel->classPackage = c_2106303_RefArrayListclassPackage;
 /*cds2*/ thisClassModel->objectDatasize = c_2106303_RefArrayListobjectDatasize;
 /*cds2*/ thisClassModel->get_list = c_2106303_RefArrayListget_list;
 /*cds2*/ thisClassModel->set_list = c_2106303_RefArrayListset_list;
 /*cds2*/ thisClassModel->get_ralsize = c_2106303_RefArrayListget_ralsize;
 /*cds2*/ thisClassModel->set_ralsize = c_2106303_RefArrayListset_ralsize;
 /*cds2*/ thisClassModel->get_isInit = c_2106303_RefArrayListget_isInit;
 /*cds2*/ thisClassModel->set_isInit = c_2106303_RefArrayListset_isInit;
 /*cds2*/ thisClassModel->get_growBy = c_2106303_RefArrayListget_growBy;
 /*cds2*/ thisClassModel->set_growBy = c_2106303_RefArrayListset_growBy;
/*cds1*/thisClassModel->growBy = 256;
  thisClassModel->free = c_2106303_RefArrayList_free;
}

