// Core.Hashmap
#include "Core.Core_main.h"
#include "Core.Hashmap.h"
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
#include "Core.RefArrayList.h"
#include "Core.Duo.h"
#include "Core.Hashset.h"
#include "Core.MapDuo.h"
#include "Core.MapEntry.h"

/*fd1*/void c_2106303_HashmapreHash(num this, num key, num value){

u64 entry__ = __onEnter();/*va1*/u64 oldSize = /*te14a*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->get_hmsize(/*te8*/this);
/*va1*/num oldlist = /*te14a*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->get_hmlist(/*te8*/this);
/*Ax7*//*te15a*/((c_2106303_Hashmap*)useObject(/*te8*/this)->data)->hmsize/*te8*/+=512;
/*va1*/num newlist = /*cd1*/ create_c_2106303_RefArray_1(/*te14a*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->get_hmsize(/*te8*/this));
/*Ax5*//*te14b*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->set_hmitems(/*te8*/this, 0);

for (num a__a = 0; a__a < /*te8*/oldSize; a__a++){
/*va1*/i64 ix = /*te8*/a__a;
/*va1*/num item = /*te4*/ *((num *)((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->get(oldlist, /*te8*/ix));
if (/*oxa*//*te8*/item != /*oxb*/0) {
if (/*oxa*//*te14a*/((c_2106303_Object_cm*)useObject(/*te8*/item)->classmodel)->get_instanceName(/*te8*/item) == /*oxb*//*te141*/((c_2106303_MapDuo_cm*)getc_2106303_MapDuo_cm())->className()) {
/*va1*/num d = /*te8*/item;
/*st*/ /*fc3*/((c_2106303_Hashmap_cm*)useObject(this)->classmodel)->internalPut(this, /*te8*/newlist, /*te14a*/((c_2106303_MapDuo_cm*)useObject(/*te8*/d)->classmodel)->get_oneKey(/*te8*/d), /*te14a*/((c_2106303_MapDuo_cm*)useObject(/*te8*/d)->classmodel)->get_oneValue(/*te8*/d));
/*st*/ /*fc3*/((c_2106303_Hashmap_cm*)useObject(this)->classmodel)->internalPut(this, /*te8*/newlist, /*te14a*/((c_2106303_MapDuo_cm*)useObject(/*te8*/d)->classmodel)->get_twoKey(/*te8*/d), /*te14a*/((c_2106303_MapDuo_cm*)useObject(/*te8*/d)->classmodel)->get_twoValue(/*te8*/d));
}

/* else? */ else {
/*va1*/num e = /*te8*/item;
/*st*/ /*fc3*/((c_2106303_Hashmap_cm*)useObject(this)->classmodel)->internalPut(this, /*te8*/newlist, /*te14a*/((c_2106303_MapEntry_cm*)useObject(/*te8*/e)->classmodel)->get_key(/*te8*/e), /*te14a*/((c_2106303_MapEntry_cm*)useObject(/*te8*/e)->classmodel)->get_value(/*te8*/e));
}

}

}

/*st*/ /* switch from fc5 to te4*/((c_2106303_Hashmap_cm*)useObject(this)->classmodel)->internalPut(this, /*te8*/newlist, /*te8*/key, /*te8*/value);
/*Ax2*//*te14b*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->set_hmlist(/*te8*/this, /*te8*/newlist);

return __exitReturn_void_un(entry__);}


/*fd1*/void c_2106303_Hashmapstartuphm(num this){

u64 entry__ = __onEnter();if (/*te14a*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->get_isInitm(/*te8*/this)) {
return __exitReturn_void_un(entry__);
}

if (/*oxa*//*te14a*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->get_hmsize(/*te8*/this) < /*oxb*/256) {
/*Ax5*//*te14b*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->set_hmsize(/*te8*/this, 256);
}

/*Ax2*//*te14b*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->set_hmlist(/*te8*/this, /*cd1*/ create_c_2106303_RefArray_1(/*te14a*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->get_hmsize(/*te8*/this)));
/*Ax2*//*te14b*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->set_isInitm(/*te8*/this, true);

return __exitReturn_void_un(entry__);}


/*fd1*/num c_2106303_Hashmapget(num this, num object){

u64 entry__ = __onEnter();if (!/*te14a*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->get_isInitm(/*te8*/this)) {
return __exitReturn_i64_un(0, entry__);
}

/*va1*/i32 index = /*oxa*//* switch from fc5 to te4*/((c_2106303_Object_cm*)useObject(/*te8*/object)->classmodel)->hashCode(/*te8*/object) % /*oxb*//*te14a*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->get_hmsize(/*te8*/this);
/*va1*/num tempList = /*te14a*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->get_hmlist(/*te8*/this);
/*va1*/num item = /*te4*/ *((num *)((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->get(tempList, /*te8*/index));
if (/*oxa*//*te8*/item == /*oxb*/0) {
return __exitReturn_i64_un(0, entry__);
}

 else if (/*oxa*//*te14a*/((c_2106303_Object_cm*)useObject(/*te8*/item)->classmodel)->get_instanceName(/*te8*/item) == /*oxb*//*te141*/((c_2106303_MapDuo_cm*)getc_2106303_MapDuo_cm())->className()) {
/*va1*/num duo = /*te8*/item;
if (/* switch from fc5 to te4*/((c_2106303_Object_cm*)useObject(/*te14a*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->get_oneKey(/*te8*/duo))->classmodel)->equals(/*te14a*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->get_oneKey(/*te8*/duo), /*te8*/object)) {
/*rx4*/ return __exitReturn_ref_un(/*te14a*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->get_oneValue(/*te8*/duo), entry__);
}

 else if (/* switch from fc5 to te4*/((c_2106303_Object_cm*)useObject(/*te14a*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->get_twoKey(/*te8*/duo))->classmodel)->equals(/*te14a*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->get_twoKey(/*te8*/duo), /*te8*/object)) {
/*rx4*/ return __exitReturn_ref_un(/*te14a*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->get_twoValue(/*te8*/duo), entry__);
}

}

 else if (/*oxa*//*te14a*/((c_2106303_Object_cm*)useObject(/*te8*/item)->classmodel)->get_instanceName(/*te8*/item) == /*oxb*//*te141*/((c_2106303_MapEntry_cm*)getc_2106303_MapEntry_cm())->className()) {
/*va1*/num e = /*te8*/item;
if (/* switch from fc5 to te4*/((c_2106303_Object_cm*)useObject(/*te14a*/((c_2106303_MapEntry_cm*)useObject(/*te8*/e)->classmodel)->get_key(/*te8*/e))->classmodel)->equals(/*te14a*/((c_2106303_MapEntry_cm*)useObject(/*te8*/e)->classmodel)->get_key(/*te8*/e), /*te8*/object)) {
/*rx4*/ return __exitReturn_ref_un(/*te14a*/((c_2106303_MapEntry_cm*)useObject(/*te8*/e)->classmodel)->get_value(/*te8*/e), entry__);
}

}

return __exitReturn_i64_un(0, entry__);
}


/*fd1*/void c_2106303_HashmapinternalPut(num this, num refArray, num key, num value){

u64 entry__ = __onEnter();/*va1*/i32 index = /*oxa*//* switch from fc5 to te4*/((c_2106303_Object_cm*)useObject(/*te8*/key)->classmodel)->hashCode(/*te8*/key) % /*oxb*//*te14a*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->get_hmsize(/*te8*/this);
/*va1*/num tempList = /*te8*/refArray;
/*va1*/num item = /*te4*/ *((num *)((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->get(tempList, /*te8*/index));
if (/*oxa*//*te8*/item == /*oxb*/0) {
/*Ax3*/((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->setObject(tempList, /*te8*/index,/*cd1*/ create_c_2106303_MapEntry_1(/*te8*/key, /*te8*/value));
/*st*/ /*te15a*/((c_2106303_Hashmap*)useObject(/*te8*/this)->data)->hmitems++;
return __exitReturn_void_un(entry__);
}

 else if (/*oxa*//*te14a*/((c_2106303_Object_cm*)useObject(/*te8*/item)->classmodel)->get_instanceName(/*te8*/item) == /*oxb*//*te141*/((c_2106303_MapDuo_cm*)getc_2106303_MapDuo_cm())->className()) {
/*va1*/num duo = /*te8*/item;
if (/* switch from fc5 to te4*/((c_2106303_Object_cm*)useObject(/*te14a*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->get_oneKey(/*te8*/duo))->classmodel)->equals(/*te14a*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->get_oneKey(/*te8*/duo), /*te8*/key)) {
/*Ax2*//*te14b*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->set_oneValue(/*te8*/duo, /*te8*/value);
return __exitReturn_void_un(entry__);
}

 else if (/* switch from fc5 to te4*/((c_2106303_Object_cm*)useObject(/*te14a*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->get_twoKey(/*te8*/duo))->classmodel)->equals(/*te14a*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->get_twoKey(/*te8*/duo), /*te8*/key)) {
/*Ax2*//*te14b*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->set_twoValue(/*te8*/duo, /*te8*/value);
return __exitReturn_void_un(entry__);
}

/*st*/ /*fc3*/((c_2106303_Hashmap_cm*)useObject(this)->classmodel)->reHash(this, /*te8*/key, /*te8*/value);
return __exitReturn_void_un(entry__);
}

 else if (/*oxa*//*te14a*/((c_2106303_Object_cm*)useObject(/*te8*/item)->classmodel)->get_instanceName(/*te8*/item) == /*oxb*//*te141*/((c_2106303_MapEntry_cm*)getc_2106303_MapEntry_cm())->className()) {
/*va1*/num entry = /*te8*/item;
if (/* switch from fc5 to te4*/((c_2106303_Object_cm*)useObject(/*te14a*/((c_2106303_MapEntry_cm*)useObject(/*te8*/entry)->classmodel)->get_key(/*te8*/entry))->classmodel)->equals(/*te14a*/((c_2106303_MapEntry_cm*)useObject(/*te8*/entry)->classmodel)->get_key(/*te8*/entry), /*te8*/key)) {
/*Ax2*//*te14b*/((c_2106303_MapEntry_cm*)useObject(/*te8*/entry)->classmodel)->set_value(/*te8*/entry, /*te8*/value);
return __exitReturn_void_un(entry__);
}

/* else? */ else {
/*va1*/num duo = /*cd1*/ create_c_2106303_MapDuo();
/*Ax2*//*te14b*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->set_oneKey(/*te8*/duo, /*te14a*/((c_2106303_MapEntry_cm*)useObject(/*te8*/entry)->classmodel)->get_key(/*te8*/entry));
/*Ax2*//*te14b*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->set_oneValue(/*te8*/duo, /*te14a*/((c_2106303_MapEntry_cm*)useObject(/*te8*/entry)->classmodel)->get_value(/*te8*/entry));
/*Ax2*//*te14b*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->set_twoKey(/*te8*/duo, /*te8*/key);
/*Ax2*//*te14b*/((c_2106303_MapDuo_cm*)useObject(/*te8*/duo)->classmodel)->set_twoValue(/*te8*/duo, /*te8*/value);
/*Ax3*/((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->setObject(tempList, /*te8*/index,/*te8*/duo);
/*st*/ /*te15a*/((c_2106303_Hashmap*)useObject(/*te8*/this)->data)->hmitems++;
return __exitReturn_void_un(entry__);
}

}

/*st*/ /*fc2 null */throwException("you shouldnt be here.");

return __exitReturn_void_un(entry__);}


/*fd1*/void c_2106303_Hashmapput(num this, num key, num value){

u64 entry__ = __onEnter();if (!/*te14a*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->get_isInitm(/*te8*/this)) {
/*st*/ /*fc3*/((c_2106303_Hashmap_cm*)useObject(this)->classmodel)->startuphm(this);
}

/*st*/ /* switch from fc5 to te4*/((c_2106303_Hashmap_cm*)useObject(this)->classmodel)->internalPut(this, /*te14a*/((c_2106303_Hashmap_cm*)useObject(/*te8*/this)->classmodel)->get_hmlist(/*te8*/this), /*te8*/key, /*te8*/value);

return __exitReturn_void_un(entry__);}


/*fd1*/pointer c_2106303_HashmapclassName(){
  return  "Core.Hashmap";
}


/*fd1*/pointer c_2106303_HashmapclassShortName(){
  return  "Hashmap";
}


/*fd1*/pointer c_2106303_HashmapclassCName(){
  return  "c_2106303_Hashmap";
}


/*fd1*/pointer c_2106303_HashmapclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_HashmapobjectDatasize(){
  return  sizeof(c_2106303_Hashmap);
}











/*fd1*/boolean c_2106303_Hashmapget_isInitm(num this){
  return  ((c_2106303_Hashmap*)useObject(this)->data)->isInitm;
}


/*fd1*/void c_2106303_Hashmapset_isInitm(num this, boolean a__a){
/*cda1*/((c_2106303_Hashmap*)useObject(this)->data)->isInitm = a__a;
}


/*fd1*/u64 c_2106303_Hashmapget_hmitems(num this){
  return  ((c_2106303_Hashmap*)useObject(this)->data)->hmitems;
}


/*fd1*/void c_2106303_Hashmapset_hmitems(num this, u64 a__a){
/*cda1*/((c_2106303_Hashmap*)useObject(this)->data)->hmitems = a__a;
}


/*fd1*/u64 c_2106303_Hashmapget_hmsize(num this){
  return  ((c_2106303_Hashmap*)useObject(this)->data)->hmsize;
}


/*fd1*/void c_2106303_Hashmapset_hmsize(num this, u64 a__a){
/*cda1*/((c_2106303_Hashmap*)useObject(this)->data)->hmsize = a__a;
}


/*fd1*/num c_2106303_Hashmapget_hmlist(num this){
  return  ((c_2106303_Hashmap*)useObject(this)->data)->hmlist;
}


/*fd1*/void c_2106303_Hashmapset_hmlist(num this, num a__a){
/*cda2*/ assignObject(&((c_2106303_Hashmap*)useObject(this)->data)/*cda3*/->hmlist, a__a);
}


void c_2106303_Hashmap_free(num this) { Object_ref *object_ref = useObject(this);
  returnObject(((c_2106303_Hashmap*)object_ref->data)->hmlist);
}



num create_c_2106303_Hashmap() {
  c_2106303_Hashmap * _c_2106303_Hashmap = ec_calloc(sizeof(c_2106303_Hashmap), sizeof(char));
  num this = createObject(_c_2106303_Hashmap, getc_2106303_Hashmap_cm(), false);
/*cdv1*/((c_2106303_Hashmap*)_c_2106303_Hashmap)->isInitm = false;
/*cdv1*/((c_2106303_Hashmap*)_c_2106303_Hashmap)->hmitems = 0;
/*cdv1*/((c_2106303_Hashmap*)_c_2106303_Hashmap)->hmsize = 1024;
/*cdv2 Core.ObjectCore.Hashmap */((c_2106303_Hashmap*)_c_2106303_Hashmap)->instanceName = c_2106303_HashmapclassName();
  return this;
}

c_2106303_Hashmap_cm _c_2106303_Hashmap_cm;
boolean _c_2106303_Hashmap_init = false;
pointer getc_2106303_Hashmap_cm() {
  if (!_c_2106303_Hashmap_init) {
    registerClassModel(&_c_2106303_Hashmap_cm);
    populatec_2106303_Hashmap_cm(&_c_2106303_Hashmap_cm);
    _c_2106303_Hashmap_init = true;
  }
  return &_c_2106303_Hashmap_cm;
}


/* default constructor */
void populatec_2106303_Hashmap_cm(pointer classModel) {
 populatec_2106303_Object_cm(classModel);
  c_2106303_Hashmap_cm* thisClassModel = (c_2106303_Hashmap_cm*)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
 /*cds2*/ thisClassModel->reHash = c_2106303_HashmapreHash;
 /*cds2*/ thisClassModel->startuphm = c_2106303_Hashmapstartuphm;
 /*cds2*/ thisClassModel->get = c_2106303_Hashmapget;
 /*cds2*/ thisClassModel->internalPut = c_2106303_HashmapinternalPut;
 /*cds2*/ thisClassModel->put = c_2106303_Hashmapput;
 /*cds2*/ thisClassModel->className = c_2106303_HashmapclassName;
 /*cds2*/ thisClassModel->classShortName = c_2106303_HashmapclassShortName;
 /*cds2*/ thisClassModel->classCName = c_2106303_HashmapclassCName;
 /*cds2*/ thisClassModel->classPackage = c_2106303_HashmapclassPackage;
 /*cds2*/ thisClassModel->objectDatasize = c_2106303_HashmapobjectDatasize;
 /*cds2*/ thisClassModel->get_isInitm = c_2106303_Hashmapget_isInitm;
 /*cds2*/ thisClassModel->set_isInitm = c_2106303_Hashmapset_isInitm;
 /*cds2*/ thisClassModel->get_hmitems = c_2106303_Hashmapget_hmitems;
 /*cds2*/ thisClassModel->set_hmitems = c_2106303_Hashmapset_hmitems;
 /*cds2*/ thisClassModel->get_hmsize = c_2106303_Hashmapget_hmsize;
 /*cds2*/ thisClassModel->set_hmsize = c_2106303_Hashmapset_hmsize;
 /*cds2*/ thisClassModel->get_hmlist = c_2106303_Hashmapget_hmlist;
 /*cds2*/ thisClassModel->set_hmlist = c_2106303_Hashmapset_hmlist;
  thisClassModel->free = c_2106303_Hashmap_free;
}

