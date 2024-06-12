// Core.B8
#include "Core.Core_main.h"
#include "Core.B8.h"
#include "Core.Object.h"
#include "Core.HashCode.h"
#include "Core.Array.h"
#include "Core.RefArray.h"
#include "Core.String.h"
#include "Core.Exception.h"
#include "Core.Boxing.h"
#include "Core.BaseBoxing.h"
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

/*fd1*/int c_2106303_B8datatype(){

u64 entry__ = __onEnter();return __exitReturn_int_un(/*te14*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->get_b8_(), entry__);
}


/*fd1*/pointer c_2106303_B8typename(){

u64 entry__ = __onEnter();return __exitReturn_pointer_un("b8", entry__);
}


/*fd1*/pointer c_2106303_B8asStr(num this){

u64 entry__ = __onEnter();if (/*te14a*/((c_2106303_B8_cm*)useObject(/*te8*/this)->classmodel)->get_value(/*te8*/this)) {
return __exitReturn_pointer_un("true", entry__);
}

return __exitReturn_pointer_un("false", entry__);
}


/*fd1*/pointer c_2106303_B8className(){
  return  "Core.B8";
}


/*fd1*/pointer c_2106303_B8classShortName(){
  return  "B8";
}


/*fd1*/pointer c_2106303_B8classCName(){
  return  "c_2106303_B8";
}


/*fd1*/pointer c_2106303_B8classPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_B8objectDatasize(){
  return  sizeof(c_2106303_B8);
}










/*fd1*/b8 c_2106303_B8get_value(num this){
  return  ((c_2106303_B8*)useObject(this)->data)->value;
}


/*fd1*/void c_2106303_B8set_value(num this, b8 a__a){
/*cda1*/((c_2106303_B8*)useObject(this)->data)->value = a__a;
}


void c_2106303_B8_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_B8() {
  c_2106303_B8 * _c_2106303_B8 = ec_calloc(sizeof(c_2106303_B8), sizeof(char));
  num this = createObject(_c_2106303_B8, getc_2106303_B8_cm(), false);
/*cdv2 Core.BaseBoxingCore.B8 */((c_2106303_B8*)_c_2106303_B8)->instanceName = c_2106303_B8className();
  return this;
}

c_2106303_B8_cm _c_2106303_B8_cm;
boolean _c_2106303_B8_init = false;
pointer getc_2106303_B8_cm() {
  if (!_c_2106303_B8_init) {
    registerClassModel(&_c_2106303_B8_cm);
    populatec_2106303_B8_cm(&_c_2106303_B8_cm);
    _c_2106303_B8_init = true;
  }
  return &_c_2106303_B8_cm;
}



num create_c_2106303_B8_1(/* param *//*va1*/b8 value) {
num this =  create_c_2106303_B8();

((c_2106303_B8_cm*)useObject(this)->classmodel)->set_value(this, value);

return this;
}
void populatec_2106303_B8_cm(pointer classModel) {
 populatec_2106303_BaseBoxing_cm(classModel);
  c_2106303_B8_cm* thisClassModel = (c_2106303_B8_cm*)classModel;
  thisClassModel->parent = getc_2106303_BaseBoxing_cm();
 /*cds2*/ thisClassModel->datatype = c_2106303_B8datatype;
 /*cds2*/ thisClassModel->typename = c_2106303_B8typename;
 /*cds2*/ thisClassModel->asStr = c_2106303_B8asStr;
 /*cds2*/ thisClassModel->className = c_2106303_B8className;
 /*cds2*/ thisClassModel->classShortName = c_2106303_B8classShortName;
 /*cds2*/ thisClassModel->classCName = c_2106303_B8classCName;
 /*cds2*/ thisClassModel->classPackage = c_2106303_B8classPackage;
 /*cds2*/ thisClassModel->objectDatasize = c_2106303_B8objectDatasize;
 /*cds2*/ thisClassModel->get_value = c_2106303_B8get_value;
 /*cds2*/ thisClassModel->set_value = c_2106303_B8set_value;
  thisClassModel->free = c_2106303_B8_free;
}

