// Core.String
#include "Core.Core_main.h"
#include "Core.String.h"
#include "Core.Object.h"
#include "Core.HashCode.h"
#include "Core.Array.h"
#include "Core.RefArray.h"
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
#include "Core.Hashmap.h"

/*fd1*/num c_2106303_StringasString(num this){

u64 entry__ = __onEnter();/*rx2*/ return __exitReturn_ref_un(/*te8*/this, entry__);
}


/*fd1*/u64 c_2106303_Stringlength(num this){

u64 entry__ = __onEnter();/*rx2*/ return __exitReturn_u64_un(/*fc2 null */strlen(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this)), entry__);
}


/*fd1*/void c_2106303_Stringprintln(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */printf("%s\n", /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->asStr(/*te8*/this));

__onExit();}


/*fd1*/num c_2106303_StringappendStr(num this, pointer str){

u64 entry__ = __onEnter();/*va1*/i64 len = /*oxa*//*oxa*//*fc2 null */strlen(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this)) + /*oxb*//*fc2 null */strlen(/*te8*/str) + /*oxb*/1;
/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->set_value(/*te8*/this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->realloc(/*te8*/this, /*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te8*/len));
/*st*/ /*fc2 null */strcat(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te8*/str);
/*rx2*/ return __exitReturn_ref_un(/*te8*/this, entry__);
}


/*fd1*/num c_2106303_Stringappend(num this, num string){

u64 entry__ = __onEnter();/*st*/ /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->appendStr(this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(/*te8*/string)->classmodel)->asStr(/*te8*/string));
/*rx2*/ return __exitReturn_ref_un(/*te8*/this, entry__);
}


/*fd1*/num c_2106303_StringprependStr(num this, pointer str4){

u64 entry__ = __onEnter();/*va1*/i64 len = /*oxa*//*oxa*//*fc2 null */strlen(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this)) + /*oxb*//*fc2 null */strlen(/*te8*/str4) + /*oxb*/1;
/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->set_value(/*te8*/this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->realloc(this, /*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te8*/len));
/*st*/ /*fc2 null */memmove(/*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*fc2 null */strlen(/*te8*/str4))), /*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*oxa*//*fc2 null */strlen(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this)) + /*oxb*/1);
/*st*/ /*fc2 null */memcpy(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te8*/str4, /*fc2 null */strlen(/*te8*/str4));
/*rx2*/ return __exitReturn_ref_un(/*te8*/this, entry__);
}


/*fd1*/num c_2106303_Stringprepend(num this, num string1){

u64 entry__ = __onEnter();/*st*/ /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->prependStr(this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(/*te8*/string1)->classmodel)->asStr(/*te8*/string1));
/*rx2*/ return __exitReturn_ref_un(/*te8*/this, entry__);
}


/*fd1*/i64 c_2106303_StringcompareStr(num this, pointer str5){

u64 entry__ = __onEnter();/*va1*/i64 res = /*fc2 null */strcmp(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te8*/str5);
return __exitReturn_i32_un(/*te8*/res, entry__);
}


/*fd1*/boolean c_2106303_StringcompareSubStr(num this, pointer str6, u64 offset){

u64 entry__ = __onEnter();/*va1*/u64 l = /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->length(this);
/*va1*/pointer str2 = /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te8*/str6, /*te8*/offset));
/*va1*/boolean matched = true;

for (num a__a = 0; a__a < /*te8*/l; a__a++){

__onEnter();if (/*oxa*//*fc2 null */EC_GETVALUE_i8(/*te8*/str2, /*te8*/l) != /*oxb*//*fc2 null */EC_GETVALUE_i8(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te8*/l)) {

__onEnter();/*Ax6*//*te8*/matched/*te8*/=false;

__onExit();}


__onExit();}

return __exitReturn_boolean_un(/*te8*/matched, entry__);
}


/*fd1*/i8 c_2106303_StringgetChar(num this, u64 offset){

u64 entry__ = __onEnter();if (/*oxa*//*te8*/offset > /*oxb*//* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->length(this)) {

__onEnter();/*st*/ /*fc2 null */throwException("[error] String.getChar offset out of bounds.");

__onExit();}

/*rx2*/ return __exitReturn_i8_un(/*fc2 null */EC_GETVALUE_i8(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te8*/offset), entry__);
}


/*fd1*/boolean c_2106303_StringisSubStr(num this, pointer str7, u64 offset){

u64 entry__ = __onEnter();/*va1*/num l = /*fc2 null */strlen(/*te8*/str7);
/*va1*/pointer str2 = /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te8*/offset));

for (num a__a = 0; a__a < /*te8*/l; a__a++){

__onEnter();if (/*oxa*//*fc2 null */EC_GETVALUE_i8(/*te8*/str7, /*te8*/a__a) != /*oxb*//*fc2 null */EC_GETVALUE_i8(/*te8*/str2, /*te8*/a__a)) {

__onEnter();return __exitReturn_boolean_un(false, entry__);
}


__onExit();}

return __exitReturn_boolean_un(true, entry__);
}


/*fd1*/i64 c_2106303_Stringcompare(num this, num string5){

u64 entry__ = __onEnter();/*va1*/i64 res = /*fc2 null */strcmp(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(/*te8*/string5)->classmodel)->asStr(/*te8*/string5));
return __exitReturn_i32_un(/*te8*/res, entry__);
}


/*fd1*/i64 c_2106303_StringfindStr(num this, i64 from, pointer str6){

u64 entry__ = __onEnter();/*va1*/pointer p = /*fc2 null */strstr(/*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te8*/from)), /*te8*/str6);
if (/*oxa*//*te8*/p == /*oxb*/null) {

__onEnter();return __exitReturn_i64_un(-1, entry__);
}

/*va1*/i64 res = /*oxa*//*te8*/p - /*oxb*//*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this);
return __exitReturn_i32_un(/*te8*/res, entry__);
}


/*fd1*/i64 c_2106303_Stringfind(num this, i64 from, num string6){

u64 entry__ = __onEnter();return __exitReturn_i64_un(/* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->findStr(this, /*te8*/from, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(/*te8*/string6)->classmodel)->asStr(/*te8*/string6)), entry__);
}


/*fd1*/boolean c_2106303_Stringequals(num this, num other){

u64 entry__ = __onEnter();if (/*oxa*//*te8*/this == /*oxb*//*te8*/other) {

__onEnter();return __exitReturn_boolean_un(true, entry__);
}

/*rx2*/ return __exitReturn_boolean_un(!/*fc2 null */strcmp(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te14a*/((c_2106303_String_cm*)useObject(/*te8*/other)->classmodel)->get_value(/*te8*/other)), entry__);
}


/*fd1*/void c_2106303_Stringtrunc(num this, i64 start, i64 end){

u64 entry__ = __onEnter();/*va1*/i64 len = /*fc2 null */strlen(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this));
if (/*oxa*//*te8*/start < /*oxb*/0) {

__onEnter();/*st*/ /*fc2 null */throwException("[string trunc] start is less than zero.");

__onExit();}

if (/*oxa*//*te8*/end < /*oxb*//*te8*/start) {

__onEnter();/*st*/ /*fc2 null */throwException("[string trunc] end is less than start.");

__onExit();}

if (/*oxa*//*te8*/start > /*oxb*//*te8*/len) {

__onEnter();/*st*/ /*fc2 null */throwException("[string trunc] start is after length of string.");

__onExit();}

if (/*oxa*//*te8*/end > /*oxb*//*te8*/len) {

__onEnter();/*st*/ /*fc2 null */throwException("[string trunc] end after length of string.");

__onExit();}

/*va1*/i64 newLen = /*oxa*//*te8*/end - /*oxb*//*te8*/start;
/*st*/ /*fc2 null */memmove(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te8*/start)), /*te8*/newLen);
/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->set_value(/*te8*/this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->realloc(this, /*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*oxa*//*te8*/newLen + /*oxb*/1));
/*st*/ /*fc2 null */EC_SETVALUE_i8(/*te8*/newLen, /*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), 0);

__onExit();}


/*fd1*/pointer c_2106303_StringasStr(num this){

u64 entry__ = __onEnter();return __exitReturn_pointer_un(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), entry__);
}


/*fd1*/i32 c_2106303_StringhashCode(num this){

u64 entry__ = __onEnter();if (/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_hash(/*te8*/this)) {

__onEnter();return __exitReturn_i32_un(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_hash(/*te8*/this), entry__);
}

/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->set_hash(/*te8*/this, /*fc4*/ ((c_2106303_HashCode_cm*)getc_2106303_HashCode_cm())->calcFastHash(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te14a1*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->length(/*te8*/this)));
return __exitReturn_i32_un(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_hash(/*te8*/this), entry__);
}


/*fd1*/pointer c_2106303_StringclassName(){
  return  "Core.String";
}


/*fd1*/pointer c_2106303_StringclassShortName(){
  return  "String";
}


/*fd1*/pointer c_2106303_StringclassCName(){
  return  "c_2106303_String";
}


/*fd1*/pointer c_2106303_StringclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_StringobjectDatasize(){
  return  sizeof(c_2106303_String);
}








/*fd1*/pointer c_2106303_Stringget_value(num this){
  return  ((c_2106303_String*)useObject(this)->data)->value;
}


/*fd1*/void c_2106303_Stringset_value(num this, pointer a__a){
/*cda1*/((c_2106303_String*)useObject(this)->data)->value = a__a;
}


/*fd1*/i32 c_2106303_Stringget_hash(num this){
  return  ((c_2106303_String*)useObject(this)->data)->hash;
}


/*fd1*/void c_2106303_Stringset_hash(num this, i32 a__a){
/*cda1*/((c_2106303_String*)useObject(this)->data)->hash = a__a;
}


void c_2106303_String_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_String() {
  c_2106303_String * _c_2106303_String = ec_calloc(sizeof(c_2106303_String), sizeof(char));
/*cdv1*/((c_2106303_String*)_c_2106303_String)->instanceName = c_2106303_StringclassName();
  return createObject(_c_2106303_String, getc_2106303_String_cm(), false);
}

c_2106303_String_cm _c_2106303_String_cm;
boolean _c_2106303_String_init = false;
pointer getc_2106303_String_cm() {
  if (!_c_2106303_String_init) {
    registerClassModel(&_c_2106303_String_cm);
    populatec_2106303_String_cm(&_c_2106303_String_cm);
    _c_2106303_String_init = true;
  }
  return &_c_2106303_String_cm;
}



num create_c_2106303_String_1(/* param *//*va1*/pointer str) {
num this =  create_c_2106303_String();

{

__onEnter();/*va1*/i64 len = /*oxa*//*fc2 null */strlen(/*te8*/str) + /*oxb*/1;
/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->set_value(/*te8*/this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->alloc(/*te8*/this, /*te8*/len));
/*st*/ /*fc2 null */strcpy(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te8*/str);

__onExit();}

return this;
}
num create_c_2106303_String_2(/* param *//*va1*/pointer str, /*va1*/boolean staticAlloc) {
num this =  create_c_2106303_String();

{

__onEnter();if (/*te8*/staticAlloc) {

__onEnter();/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->set_value(/*te8*/this, /*te8*/str);

__onExit();}

/* else? */ else {

__onEnter();/*va1*/i64 len = /*oxa*//*fc2 null */strlen(/*te8*/str) + /*oxb*/1;
/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->set_value(/*te8*/this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->alloc(/*te8*/this, /*te8*/len));
/*st*/ /*fc2 null */strcpy(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te8*/str);

__onExit();}


__onExit();}

return this;
}
num create_c_2106303_String_3(/* param *//*va1*/pointer str, /*va1*/pointer str2) {
num this =  create_c_2106303_String();

{

__onEnter();/*va1*/i64 len = /*oxa*//*oxa*//*fc2 null */strlen(/*te8*/str) + /*oxb*//*fc2 null */strlen(/*te8*/str2) + /*oxb*/1;
/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->set_value(/*te8*/this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->alloc(/*te8*/this, /*te8*/len));
/*st*/ /*fc2 null */strcpy(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te8*/str);
/*st*/ /*fc2 null */strcat(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*te8*/str2);

__onExit();}

return this;
}
num create_c_2106303_String_4(/* param *//*va1*/pointer str, /*va1*/u64 offset, /*va1*/u64 len) {
num this =  create_c_2106303_String();

{

__onEnter();/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->set_value(/*te8*/this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->alloc(/*te8*/this, /*oxa*//*te8*/len + /*oxb*/1));
/*st*/ /*fc2 null */memcpy(/*te14a*/((c_2106303_String_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this), /*oxa*//*te8*/str + /*oxb*//*te8*/offset, /*te8*/len);

__onExit();}

return this;
}
void populatec_2106303_String_cm(pointer classModel) {
 populatec_2106303_Object_cm(classModel);
  c_2106303_String_cm* thisClassModel = (c_2106303_String_cm*)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->asString = c_2106303_StringasString;
  thisClassModel->length = c_2106303_Stringlength;
  thisClassModel->println = c_2106303_Stringprintln;
  thisClassModel->appendStr = c_2106303_StringappendStr;
  thisClassModel->append = c_2106303_Stringappend;
  thisClassModel->prependStr = c_2106303_StringprependStr;
  thisClassModel->prepend = c_2106303_Stringprepend;
  thisClassModel->compareStr = c_2106303_StringcompareStr;
  thisClassModel->compareSubStr = c_2106303_StringcompareSubStr;
  thisClassModel->getChar = c_2106303_StringgetChar;
  thisClassModel->isSubStr = c_2106303_StringisSubStr;
  thisClassModel->compare = c_2106303_Stringcompare;
  thisClassModel->findStr = c_2106303_StringfindStr;
  thisClassModel->find = c_2106303_Stringfind;
  thisClassModel->equals = c_2106303_Stringequals;
  thisClassModel->trunc = c_2106303_Stringtrunc;
  thisClassModel->asStr = c_2106303_StringasStr;
  thisClassModel->hashCode = c_2106303_StringhashCode;
  thisClassModel->className = c_2106303_StringclassName;
  thisClassModel->classShortName = c_2106303_StringclassShortName;
  thisClassModel->classCName = c_2106303_StringclassCName;
  thisClassModel->classPackage = c_2106303_StringclassPackage;
  thisClassModel->objectDatasize = c_2106303_StringobjectDatasize;
  thisClassModel->get_value = c_2106303_Stringget_value;
  thisClassModel->set_value = c_2106303_Stringset_value;
  thisClassModel->get_hash = c_2106303_Stringget_hash;
  thisClassModel->set_hash = c_2106303_Stringset_hash;
  thisClassModel->free = c_2106303_String_free;
}

