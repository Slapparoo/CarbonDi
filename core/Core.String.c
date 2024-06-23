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

u64 entry__ = __onEnter();/*rx4*/ return __exitReturn_ref_un(this, entry__);
}


/*fd1*/u64 c_2106303_Stringlength(num this){

u64 entry__ = __onEnter();/*rx2*/ return __exitReturn_u64_un(/*fc2 null */strlen(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this)), entry__);
}


/*fd1*/void c_2106303_Stringprintln(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */printf("%s\n", /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->asStr(this));

return __exitReturn_void_un(entry__);}


/*fd1*/num c_2106303_StringappendStr(num this, pointer str){

u64 entry__ = __onEnter();/*va1*/i64 len = /*oxa*//*oxa*//*fc2 null */strlen(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this)) + /*oxb*//*fc2 null */strlen(str) + /*oxb*/1;
/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(this)->classmodel)->set_value(this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->realloc(this, /*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), len));
/*st*/ /*fc2 null */strcat(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), str);
/*rx4*/ return __exitReturn_ref_un(this, entry__);
}


/*fd1*/num c_2106303_Stringappend(num this, num string){

u64 entry__ = __onEnter();/*st*/ /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->appendStr(this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(string)->classmodel)->asStr(string));
/*rx4*/ return __exitReturn_ref_un(this, entry__);
}


/*fd1*/num c_2106303_StringprependStr(num this, pointer str4){

u64 entry__ = __onEnter();/*va1*/i64 len = /*oxa*//*oxa*//*fc2 null */strlen(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this)) + /*oxb*//*fc2 null */strlen(str4) + /*oxb*/1;
/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(this)->classmodel)->set_value(this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->realloc(this, /*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), len));
/*st*/ /*fc2 null */memmove(/*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), /*fc2 null */strlen(str4))), /*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), /*oxa*//*fc2 null */strlen(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this)) + /*oxb*/1);
/*st*/ /*fc2 null */memcpy(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), str4, /*fc2 null */strlen(str4));
/*rx4*/ return __exitReturn_ref_un(this, entry__);
}


/*fd1*/num c_2106303_Stringprepend(num this, num string1){

u64 entry__ = __onEnter();/*st*/ /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->prependStr(this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(string1)->classmodel)->asStr(string1));
/*rx4*/ return __exitReturn_ref_un(this, entry__);
}


/*fd1*/i64 c_2106303_StringcompareStr(num this, pointer str5){

u64 entry__ = __onEnter();/*va1*/i64 res = /*fc2 null */strcmp(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), str5);
return __exitReturn_i64_un(res, entry__);
}


/*fd1*/boolean c_2106303_StringcompareSubStr(num this, pointer str6, u64 offset){

u64 entry__ = __onEnter();/*va1*/u64 l = /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->length(this);
/*va1*/pointer str2 = /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(str6, offset));
/*va1*/boolean matched = true;

for (num a__a = 0; a__a < l; a__a++){
if (/*oxa*//*fc2 null */EC_GETVALUE_i8(str2, l) != /*oxb*//*fc2 null */EC_GETVALUE_i8(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), l)) {
/*Ax6*/matched=false;
}

}

return __exitReturn_boolean_un(matched, entry__);
}


/*fd1*/i8 c_2106303_StringgetChar(num this, u64 offset){

u64 entry__ = __onEnter();if (/*oxa*/offset > /*oxb*//* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->length(this)) {
/*st*/ /*fc2 null */throwException("[error] String.getChar offset out of bounds.");
}

/*rx2*/ return __exitReturn_i8_un(/*fc2 null */EC_GETVALUE_i8(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), offset), entry__);
}


/*fd1*/boolean c_2106303_StringisSubStr(num this, pointer str7, u64 offset){

u64 entry__ = __onEnter();/*va1*/num l = /*fc2 null */strlen(str7);
/*va1*/pointer str2 = /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), offset));

for (num a__a = 0; a__a < l; a__a++){
if (/*oxa*//*fc2 null */EC_GETVALUE_i8(str7, a__a) != /*oxb*//*fc2 null */EC_GETVALUE_i8(str2, a__a)) {
return __exitReturn_boolean_un(false, entry__);
}

}

return __exitReturn_boolean_un(true, entry__);
}


/*fd1*/i64 c_2106303_Stringcompare(num this, num string5){

u64 entry__ = __onEnter();/*va1*/i64 res = /*fc2 null */strcmp(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(string5)->classmodel)->asStr(string5));
return __exitReturn_i64_un(res, entry__);
}


/*fd1*/i64 c_2106303_StringfindStr(num this, i64 from, pointer str6){

u64 entry__ = __onEnter();/*va1*/pointer p = /*fc2 null */strstr(/*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), from)), str6);
if (/*oxa*/p == /*oxb*/null) {
return __exitReturn_i64_un(-1, entry__);
}

/*va1*/i64 res = /*oxa*/p - /*oxb*//*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this);
return __exitReturn_i64_un(res, entry__);
}


/*fd1*/i64 c_2106303_Stringfind(num this, i64 from, num string6){

u64 entry__ = __onEnter();return __exitReturn_i64_un(/* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->findStr(this, from, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(string6)->classmodel)->asStr(string6)), entry__);
}


/*fd1*/boolean c_2106303_Stringequals(num this, num other){

u64 entry__ = __onEnter();if (/*oxa*/this == /*oxb*/other) {
return __exitReturn_boolean_un(true, entry__);
}

/*rx2*/ return __exitReturn_boolean_un(!/*fc2 null */strcmp(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), /*te14a*/((c_2106303_String_cm*)useObject(other)->classmodel)->get_value(other)), entry__);
}


/*fd1*/void c_2106303_Stringtrunc(num this, i64 start, i64 end){

u64 entry__ = __onEnter();/*va1*/i64 len = /*fc2 null */strlen(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this));
if (/*oxa*/start < /*oxb*/0) {
/*st*/ /*fc2 null */throwException("[string trunc] start is less than zero.");
}

if (/*oxa*/end < /*oxb*/start) {
/*st*/ /*fc2 null */throwException("[string trunc] end is less than start.");
}

if (/*oxa*/start > /*oxb*/len) {
/*st*/ /*fc2 null */throwException("[string trunc] start is after length of string.");
}

if (/*oxa*/end > /*oxb*/len) {
/*st*/ /*fc2 null */throwException("[string trunc] end after length of string.");
}

/*va1*/i64 newLen = /*oxa*/end - /*oxb*/start;
/*st*/ /*fc2 null */memmove(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), /*fc2 null */EC_ADDRESS(/*fc2 null */EC_ARRAY(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), start)), newLen);
/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(this)->classmodel)->set_value(this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->realloc(this, /*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), /*oxa*/newLen + /*oxb*/1));
/*st*/ /*fc2 null */EC_SETVALUE_i8(newLen, /*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), 0);

return __exitReturn_void_un(entry__);}


/*fd1*/pointer c_2106303_StringasStr(num this){

u64 entry__ = __onEnter();return __exitReturn_pointer_un(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), entry__);
}


/*fd1*/i32 c_2106303_StringhashCode(num this){

u64 entry__ = __onEnter();if (/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_hash(this)) {
return __exitReturn_i32_un(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_hash(this), entry__);
}

/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(this)->classmodel)->set_hash(this, /*fc4*/ ((c_2106303_HashCode_cm*)getc_2106303_HashCode_cm())->calcFastHash(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), /*te14a1*/((c_2106303_String_cm*)useObject(this)->classmodel)->length(this)));
return __exitReturn_i32_un(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_hash(this), entry__);
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
  num this = createObject(_c_2106303_String, getc_2106303_String_cm(), false);
/*cdv2 Core.ObjectCore.String */((c_2106303_String*)_c_2106303_String)->instanceName = c_2106303_StringclassName();
  return this;
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
/*va1*/i64 len = /*oxa*//*fc2 null */strlen(str) + /*oxb*/1;
/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(this)->classmodel)->set_value(this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->alloc(this, len));
/*st*/ /*fc2 null */strcpy(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), str);
}

return this;
}
num create_c_2106303_String_2(/* param *//*va1*/pointer str, /*va1*/boolean staticAlloc) {
num this =  create_c_2106303_String();

{
if (staticAlloc) {
/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(this)->classmodel)->set_value(this, str);
}

/* else? */ else {
/*va1*/i64 len = /*oxa*//*fc2 null */strlen(str) + /*oxb*/1;
/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(this)->classmodel)->set_value(this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->alloc(this, len));
/*st*/ /*fc2 null */strcpy(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), str);
}

}

return this;
}
num create_c_2106303_String_3(/* param *//*va1*/pointer str, /*va1*/pointer str2) {
num this =  create_c_2106303_String();

{
/*va1*/i64 len = /*oxa*//*oxa*//*fc2 null */strlen(str) + /*oxb*//*fc2 null */strlen(str2) + /*oxb*/1;
/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(this)->classmodel)->set_value(this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->alloc(this, len));
/*st*/ /*fc2 null */strcpy(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), str);
/*st*/ /*fc2 null */strcat(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), str2);
}

return this;
}
num create_c_2106303_String_4(/* param *//*va1*/pointer str, /*va1*/u64 offset, /*va1*/u64 len) {
num this =  create_c_2106303_String();

{
/*Ax5*//*te14b*/((c_2106303_String_cm*)useObject(this)->classmodel)->set_value(this, /* switch from fc5 to te4*/((c_2106303_String_cm*)useObject(this)->classmodel)->alloc(this, /*oxa*/len + /*oxb*/1));
/*st*/ /*fc2 null */memcpy(/*te14a*/((c_2106303_String_cm*)useObject(this)->classmodel)->get_value(this), /*oxa*/str + /*oxb*/offset, len);
}

return this;
}
void populatec_2106303_String_cm(pointer classModel) {
 populatec_2106303_Object_cm(classModel);
  c_2106303_String_cm* thisClassModel = (c_2106303_String_cm*)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
 /*cds2*/ thisClassModel->asString = c_2106303_StringasString;
 /*cds2*/ thisClassModel->length = c_2106303_Stringlength;
 /*cds2*/ thisClassModel->println = c_2106303_Stringprintln;
 /*cds2*/ thisClassModel->appendStr = c_2106303_StringappendStr;
 /*cds2*/ thisClassModel->append = c_2106303_Stringappend;
 /*cds2*/ thisClassModel->prependStr = c_2106303_StringprependStr;
 /*cds2*/ thisClassModel->prepend = c_2106303_Stringprepend;
 /*cds2*/ thisClassModel->compareStr = c_2106303_StringcompareStr;
 /*cds2*/ thisClassModel->compareSubStr = c_2106303_StringcompareSubStr;
 /*cds2*/ thisClassModel->getChar = c_2106303_StringgetChar;
 /*cds2*/ thisClassModel->isSubStr = c_2106303_StringisSubStr;
 /*cds2*/ thisClassModel->compare = c_2106303_Stringcompare;
 /*cds2*/ thisClassModel->findStr = c_2106303_StringfindStr;
 /*cds2*/ thisClassModel->find = c_2106303_Stringfind;
 /*cds2*/ thisClassModel->equals = c_2106303_Stringequals;
 /*cds2*/ thisClassModel->trunc = c_2106303_Stringtrunc;
 /*cds2*/ thisClassModel->asStr = c_2106303_StringasStr;
 /*cds2*/ thisClassModel->hashCode = c_2106303_StringhashCode;
 /*cds2*/ thisClassModel->className = c_2106303_StringclassName;
 /*cds2*/ thisClassModel->classShortName = c_2106303_StringclassShortName;
 /*cds2*/ thisClassModel->classCName = c_2106303_StringclassCName;
 /*cds2*/ thisClassModel->classPackage = c_2106303_StringclassPackage;
 /*cds2*/ thisClassModel->objectDatasize = c_2106303_StringobjectDatasize;
 /*cds2*/ thisClassModel->get_value = c_2106303_Stringget_value;
 /*cds2*/ thisClassModel->set_value = c_2106303_Stringset_value;
 /*cds2*/ thisClassModel->get_hash = c_2106303_Stringget_hash;
 /*cds2*/ thisClassModel->set_hash = c_2106303_Stringset_hash;
  thisClassModel->free = c_2106303_String_free;
}

