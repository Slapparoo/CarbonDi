// Core.I8
#include "Core.Core_main.h"
#include "Core.I8.h"
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

/*fd1*/int c_2106303_I8datatype(){

u64 entry__ = __onEnter();return __exitReturn_int_un(/*te14*/((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->get_i8_(), entry__);
}


/*fd1*/pointer c_2106303_I8typename(){

u64 entry__ = __onEnter();return __exitReturn_pointer_un("i8", entry__);
}


/*fd1*/pointer c_2106303_I8asStr(num this){

u64 entry__ = __onEnter();/*st*/ /*fc2 null */sprintf(/*fc2 null */getTmpBuffer(), "%i", /*te14a*/((c_2106303_I8_cm*)useObject(this)->classmodel)->get_value(this));
/*rx2*/ return __exitReturn_pointer_un(/*fc2 null */getTmpBuffer(), entry__);
}


/*fd1*/pointer c_2106303_I8className(){
  return  "Core.I8";
}


/*fd1*/pointer c_2106303_I8classShortName(){
  return  "I8";
}


/*fd1*/pointer c_2106303_I8classCName(){
  return  "c_2106303_I8";
}


/*fd1*/pointer c_2106303_I8classPackage(){
  return  "Core";
}


/*fd1*/u64 c_2106303_I8objectDatasize(){
  return  sizeof(c_2106303_I8);
}










/*fd1*/i8 c_2106303_I8get_value(num this){
  return  ((c_2106303_I8*)useObject(this)->data)->value;
}


/*fd1*/void c_2106303_I8set_value(num this, i8 a__a){
/*cda1*/((c_2106303_I8*)useObject(this)->data)->value = a__a;
}


void c_2106303_I8_free(num this) { Object_ref *object_ref = useObject(this);
}



num create_c_2106303_I8() {
  c_2106303_I8 * _c_2106303_I8 = ec_calloc(sizeof(c_2106303_I8), sizeof(char));
  num this = createObject(_c_2106303_I8, getc_2106303_I8_cm(), false);
/*cdv2 Core.BaseBoxingCore.I8 */((c_2106303_I8*)_c_2106303_I8)->instanceName = c_2106303_I8className();
  return this;
}

c_2106303_I8_cm _c_2106303_I8_cm;
boolean _c_2106303_I8_init = false;
pointer getc_2106303_I8_cm() {
  if (!_c_2106303_I8_init) {
    registerClassModel(&_c_2106303_I8_cm);
    populatec_2106303_I8_cm(&_c_2106303_I8_cm);
    _c_2106303_I8_init = true;
  }
  return &_c_2106303_I8_cm;
}


/* default constructor */
num create_c_2106303_I8_1(/* param *//*va1*/i8 value) {
num this =  create_c_2106303_I8();

((c_2106303_I8_cm*)useObject(this)->classmodel)->set_value(this, value);

return this;
}
void populatec_2106303_I8_cm(pointer classModel) {
 populatec_2106303_BaseBoxing_cm(classModel);
  c_2106303_I8_cm* thisClassModel = (c_2106303_I8_cm*)classModel;
  thisClassModel->parent = getc_2106303_BaseBoxing_cm();
 /*cds2*/ thisClassModel->datatype = c_2106303_I8datatype;
 /*cds2*/ thisClassModel->typename = c_2106303_I8typename;
 /*cds2*/ thisClassModel->asStr = c_2106303_I8asStr;
 /*cds2*/ thisClassModel->className = c_2106303_I8className;
 /*cds2*/ thisClassModel->classShortName = c_2106303_I8classShortName;
 /*cds2*/ thisClassModel->classCName = c_2106303_I8classCName;
 /*cds2*/ thisClassModel->classPackage = c_2106303_I8classPackage;
 /*cds2*/ thisClassModel->objectDatasize = c_2106303_I8objectDatasize;
 /*cds2*/ thisClassModel->get_value = c_2106303_I8get_value;
 /*cds2*/ thisClassModel->set_value = c_2106303_I8set_value;
  thisClassModel->free = c_2106303_I8_free;
}

