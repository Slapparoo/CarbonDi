// Core.U32
#include "Core.Core_main.h"
#include "Core.U32.h"
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

/*fd1*/int c_2106303_U32datatype(){

u64 entry__ = __onEnter();return __exitReturn_int_un(/*te14*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->get_u32_(), entry__);
}


/*fd1*/pointer c_2106303_U32typename(){

u64 entry__ = __onEnter();return __exitReturn_pointer_un("u32", entry__);
}


/*fd1*/pointer c_2106303_U32asStr(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */sprintf(/*fc2 null */getTmpBuffer(), "%u", /*te14a*/((c_2106303_U32_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this));
/*rx2*/ return __exitReturn_pointer_un(/*fc2 null */getTmpBuffer(), entry__);
}


/*fd1*/pointer c_2106303_U32className(){
  return  "Core.U32";
}


/*fd1*/pointer c_2106303_U32classShortName(){
  return  "U32";
}


/*fd1*/pointer c_2106303_U32classCName(){
  return  "c_2106303_U32";
}


/*fd1*/pointer c_2106303_U32classPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_U32objectDatasize(){
  return  sizeof(c_2106303_U32);
}










/*fd1*/u32 c_2106303_U32get_value(num this){
  return  ((c_2106303_U32*)useObject(this)->data)->value;
}


/*fd1*/void c_2106303_U32set_value(num this, u32 a__a){
/*cda1*/((c_2106303_U32*)useObject(this)->data)->value = a__a;
}


void c_2106303_U32_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_U32() {
  c_2106303_U32 * _c_2106303_U32 = ec_calloc(sizeof(c_2106303_U32), sizeof(char));
  num this = createObject(_c_2106303_U32, getc_2106303_U32_cm(), false);
/*cdv2 Core.BaseBoxingCore.U32 */((c_2106303_U32*)_c_2106303_U32)->instanceName = c_2106303_U32className();
  return this;
}

c_2106303_U32_cm _c_2106303_U32_cm;
boolean _c_2106303_U32_init = false;
pointer getc_2106303_U32_cm() {
  if (!_c_2106303_U32_init) {
    registerClassModel(&_c_2106303_U32_cm);
    populatec_2106303_U32_cm(&_c_2106303_U32_cm);
    _c_2106303_U32_init = true;
  }
  return &_c_2106303_U32_cm;
}


/* default constructor */
num create_c_2106303_U32_1(/* param *//*va1*/u32 value) {
num this =  create_c_2106303_U32();

((c_2106303_U32_cm*)useObject(this)->classmodel)->set_value(this, value);

return this;
}
void populatec_2106303_U32_cm(pointer classModel) {
 populatec_2106303_BaseBoxing_cm(classModel);
  c_2106303_U32_cm* thisClassModel = (c_2106303_U32_cm*)classModel;
  thisClassModel->parent = getc_2106303_BaseBoxing_cm();
 /*cds2*/ thisClassModel->datatype = c_2106303_U32datatype;
 /*cds2*/ thisClassModel->typename = c_2106303_U32typename;
 /*cds2*/ thisClassModel->asStr = c_2106303_U32asStr;
 /*cds2*/ thisClassModel->className = c_2106303_U32className;
 /*cds2*/ thisClassModel->classShortName = c_2106303_U32classShortName;
 /*cds2*/ thisClassModel->classCName = c_2106303_U32classCName;
 /*cds2*/ thisClassModel->classPackage = c_2106303_U32classPackage;
 /*cds2*/ thisClassModel->objectDatasize = c_2106303_U32objectDatasize;
 /*cds2*/ thisClassModel->get_value = c_2106303_U32get_value;
 /*cds2*/ thisClassModel->set_value = c_2106303_U32set_value;
  thisClassModel->free = c_2106303_U32_free;
}

