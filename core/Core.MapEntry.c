// Core.MapEntry
#include "Core.Core_main.h"
#include "Core.MapEntry.h"
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
#include "Core.Hashmap.h"

/*fd1*/pointer c_2106303_MapEntryclassName(){
  return  "Core.MapEntry";
}


/*fd1*/pointer c_2106303_MapEntryclassShortName(){
  return  "MapEntry";
}


/*fd1*/pointer c_2106303_MapEntryclassCName(){
  return  "c_2106303_MapEntry";
}


/*fd1*/pointer c_2106303_MapEntryclassPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_MapEntryobjectDatasize(){
  return  sizeof(c_2106303_MapEntry);
}











/*fd1*/num c_2106303_MapEntryget_key(num this){
  return  ((c_2106303_MapEntry*)useObject(this)->data)->key;
}


/*fd1*/void c_2106303_MapEntryset_key(num this, num a__a){
/*cda2*/ assignObject(&((c_2106303_MapEntry*)useObject(this)->data)/*cda3*/->key, a__a);
}


/*fd1*/num c_2106303_MapEntryget_value(num this){
  return  ((c_2106303_MapEntry*)useObject(this)->data)->value;
}


/*fd1*/void c_2106303_MapEntryset_value(num this, num a__a){
/*cda2*/ assignObject(&((c_2106303_MapEntry*)useObject(this)->data)/*cda3*/->value, a__a);
}


void c_2106303_MapEntry_free(num this) { Object_ref *object_ref = useObject(this);
  returnObject(((c_2106303_MapEntry*)object_ref->data)->key);
  returnObject(((c_2106303_MapEntry*)object_ref->data)->value);
}



num create_c_2106303_MapEntry() {
  c_2106303_MapEntry * _c_2106303_MapEntry = ec_calloc(sizeof(c_2106303_MapEntry), sizeof(char));
/*cdv1*/((c_2106303_MapEntry*)_c_2106303_MapEntry)->instanceName = c_2106303_MapEntryclassName();
  return createObject(_c_2106303_MapEntry, getc_2106303_MapEntry_cm(), false);
}

c_2106303_MapEntry_cm _c_2106303_MapEntry_cm;
boolean _c_2106303_MapEntry_init = false;
pointer getc_2106303_MapEntry_cm() {
  if (!_c_2106303_MapEntry_init) {
    registerClassModel(&_c_2106303_MapEntry_cm);
    populatec_2106303_MapEntry_cm(&_c_2106303_MapEntry_cm);
    _c_2106303_MapEntry_init = true;
  }
  return &_c_2106303_MapEntry_cm;
}


/* default constructor */
num create_c_2106303_MapEntry_1(/* param *//*va1*/num key, /*va1*/num value) {
num this =  create_c_2106303_MapEntry();

((c_2106303_MapEntry_cm*)useObject(this)->classmodel)->set_key(this, key);
((c_2106303_MapEntry_cm*)useObject(this)->classmodel)->set_value(this, value);

return this;
}
void populatec_2106303_MapEntry_cm(pointer classModel) {
 populatec_2106303_Object_cm(classModel);
  c_2106303_MapEntry_cm* thisClassModel = (c_2106303_MapEntry_cm*)classModel;
  thisClassModel->parent = getc_2106303_Object_cm();
  thisClassModel->className = c_2106303_MapEntryclassName;
  thisClassModel->classShortName = c_2106303_MapEntryclassShortName;
  thisClassModel->classCName = c_2106303_MapEntryclassCName;
  thisClassModel->classPackage = c_2106303_MapEntryclassPackage;
  thisClassModel->objectDatasize = c_2106303_MapEntryobjectDatasize;
  thisClassModel->get_key = c_2106303_MapEntryget_key;
  thisClassModel->set_key = c_2106303_MapEntryset_key;
  thisClassModel->get_value = c_2106303_MapEntryget_value;
  thisClassModel->set_value = c_2106303_MapEntryset_value;
  thisClassModel->free = c_2106303_MapEntry_free;
}

